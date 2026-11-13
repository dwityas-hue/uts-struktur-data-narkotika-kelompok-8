# ADR-001: Pemilihan Struktur Data Utama & Sekunder serta Aturan Normalisasi Dataset

## Status
Accepted

## Konteks
Aplikasi CLI Sistem Analisis Putusan Narkotika perlu mengelola 50 data putusan pengadilan hasil ekstraksi PDF secara efisien di memori tanpa menggunakan koleksi bawaan Java (`java.util.ArrayList`, `LinkedList`, `Stack`, `HashMap`, maupun `TreeMap`). Sistem harus mendukung pembacaan cepat berdasarkan indeks, pencarian serta penyaringan multi-kriteria, dan pembatalan perubahan (*undo*) pada operasi manipulasi data.

## Keputusan
1. **Struktur Data Utama — `DynamicArray<T>` (`struktur.DynamicArray`)**
    - Diimplementasikan dari nol menggunakan array primitif `Object[]` yang mengimplementasikan kontrak generik `StrukturData<T>`.
    - Kapasitas awal ditetapkan sebesar 10 elemen dan diperbesar otomatis dua kali lipat (`capacity * 2`) saat kapasitas penuh melalui metode `resize()`.
    - Dipilih karena menyediakan akses acak berbasis indeks dalam waktu konstan $O(1)$ yang sangat efisien untuk iterasi filter multi-kriteria dan pencarian linear, sekaligus menjaga urutan data tanpa batas ukuran statis.

2. **Struktur Data Sekunder — `CustomStack<T>` (`struktur.CustomStack`)**
    - Diimplementasikan dari nol dengan prinsip *Last-In, First-Out* (LIFO) untuk menyimpan riwayat status (*snapshot*/aksi) perubahan data.
    - Dipilih karena operasi `push` dan `pop` berjalan dalam kompleksitas $O(1)$, sehingga ideal untuk fitur *undo* transaksi CRUD terakhir.

3. **Aturan Normalisasi & Anonimisasi Dataset (`data/putusan-50.csv`)**
    - Identitas terdakwa disamarkan menggunakan kode anonim (`T-001` s.d. `T-050`) demi menjaga privasi data publik.
    - Atribut numerik yang tidak tercantum pada amar putusan diisi `0`, sedangkan atribut teks kosong diisi `null`.
    - Proses impor CSV (`fitur.CsvImporter`) dirancang toleran terhadap kesalahan: baris dengan format kolom tidak valid atau tipe data rusak akan dicatat sebagai gagal tanpa menghentikan pemrosesan baris valid lainnya.

## Konsekuensi
- **Positif:** Seluruh operasi pengelolaan memori, perluasan kapasitas array, dan riwayat *undo* terkontrol penuh dengan kompleksitas waktu yang terukur serta bebas ketergantungan pustaka koleksi eksternal.
- **Negatif:** Operasi penghapusan elemen di tengah `DynamicArray` memerlukan pergeseran elemen (*shifting*) dengan kompleksitas $O(n)$, namun tetap sangat memadai untuk skala dataset puluhan hingga ribuan putusan.