# Sistem Analisis Putusan Pengadilan Narkotika

## Deskripsi Proyek

Sistem Analisis Putusan Pengadilan Narkotika merupakan aplikasi berbasis Java (antarmuka menu konsol) yang digunakan untuk mengelola dan menganalisis data putusan perkara narkotika.
Proyek ini dibuat sebagai tugas Ujian Tengah Semester (UTS) mata kuliah Struktur Data, Fakultas Teknik, Universitas Muhammadiyah Malang, Semester Ganjil 2026/2027.
Seluruh data disimpan menggunakan struktur data buatan sendiri, tanpa koleksi bawaan `java.util` seperti `ArrayList`, `LinkedList`, atau `Stack`.

## Teknologi yang Digunakan

* Bahasa pemrograman: Java
* Java Development Kit (JDK): 17
* IDE: IntelliJ IDEA
* Build tool: Maven
* Pengujian: JUnit 5 (5.10.2)
* Version Control: Git dan GitHub

## Struktur Data dan Komponen

Struktur data yang dipakai:

| Peran | Struktur | Kelas |
|---|---|---|
| Penyimpan utama (50 putusan) | Array dinamis (array yang dibesarkan otomatis saat penuh) | `DynamicArray<T>` |
| Penyimpan sekunder (riwayat undo) | Stack (LIFO) | `CustomStack<T>` |

Komponen yang terdapat dalam proyek:

1. `StrukturData` - Interface umum untuk struktur data utama (`add`, `get`, `remove`, `size`, `isEmpty`, `contains`, `clear`).
2. `DynamicArray` - Implementasi array dinamis berbasis `Object[]` dengan `resize`, `insert`, `set`, `search`, dan `validateInvariant()`.
3. `CustomStack` - Implementasi stack berbasis array dengan `push`, `pop`, `peek`, `searchPreserve` (pencarian yang tidak mengubah urutan), `restore`, dan `validateInvariant()`. Dipakai untuk fitur Undo.
4. `Putusan` - Model yang menyimpan 16 atribut data putusan.
5. `CsvImporter` - Membaca dan mengimpor data putusan dari file CSV, melakukan validasi tiap baris, serta mencatat baris yang ditolak tanpa menghentikan program.
6. `LayananPutusanA` - Pencarian berdasarkan Case ID atau nomor perkara (dengan penghitung langkah) dan berbagai filter (jenis narkotika, rentang berat, pasal terbukti, rentang vonis, dan kombinasi).
7. `LayananPutusanB` - Agregasi (rata-rata vonis dan total denda), pengurutan berdasarkan vonis (Bubble Sort), dan ekspor ke CSV.
8. `MainApp` - Menu utama yang menghubungkan seluruh fitur.

## Fitur Aplikasi

| Menu | Fitur |
|---|---|
| 1 | Impor data putusan dari CSV (dengan validasi dan log error) |
| 2 | Cari putusan berdasarkan Case ID / Nomor Perkara + jumlah langkah |
| 3 | Filter putusan (jenis, berat, pasal, vonis, kombinasi) |
| 4 | Tambah putusan baru |
| 5 | Hapus putusan berdasarkan Case ID |
| 6 | Undo perubahan terakhir (memakai `CustomStack`) |
| 7 | Urutkan putusan berdasarkan vonis (ascending) |
| 8 | Statistik (jumlah perkara, rata-rata vonis, total denda) |
| 9 | Ekspor data aktif ke file CSV |

## Dataset

File `data/putusan-50.csv` berisi 50 putusan perkara narkotika dengan 16 kolom:

```
caseId, nomorPerkara, pengadilan, tanggalPutusan, terdakwaKode, jenisNarkotika,
beratBarangBuktiGram, pasalDakwaan, pasalTerbukti, tuntutanBulan, vonisBulan,
dendaRupiah, barangBukti, keadaanMemberatkan, keadaanMeringankan, sourcePages
```

Ketentuan data:

* Nilai kosong untuk angka ditulis `0`, sedangkan untuk teks dikosongkan atau `null`.
* Identitas terdakwa dianonimkan memakai kode (contoh: `T-84-2018`), tanpa nama asli.
* Asal setiap data dapat ditelusuri melalui kolom `sourcePages` dan berkas `docs/data-provenance.csv`.
* PDF sumber putusan tidak disertakan dalam repositori.

## Struktur Folder

```
uts-struktur-data-narkotika-kelompok-8/
|
+-- src/
|   +-- main/
|   |   +-- java/
|   |       +-- app/          (MainApp)
|   |       +-- fitur/        (CsvImporter, LayananPutusanA, LayananPutusanB)
|   |       +-- model/        (Putusan)
|   |       +-- struktur/     (StrukturData, DynamicArray, CustomStack)
|   +-- test/
|       +-- java/
|           +-- fitur/        (LayananPutusanATest)
|           +-- struktur/     (DynamicArrayTest, SecondaryStructureTest)
|
+-- data/
|   +-- putusan-50.csv
|
+-- docs/
|   +-- adr/
|   +-- trace/
|   +-- demo/
|   +-- data-provenance.csv
|
+-- AI_USAGE.md
+-- CONTRIBUTIONS.md
+-- README.md
+-- pom.xml
```

## Cara Menjalankan Program

Jalankan seluruh perintah dari folder utama proyek (agar path `data/putusan-50.csv` terbaca).

### Opsi 1: Melalui IntelliJ IDEA

1. Buka proyek sebagai proyek Maven, lalu klik Maven Reload.
2. Jalankan kelas `app.MainApp` (`Shift+F10`).
3. Pilih menu `1` lalu tekan Enter untuk memuat `data/putusan-50.csv`.

### Opsi 2: Melalui PowerShell

1. Kompilasi seluruh file Java:

```
& "C:\Program Files\Eclipse Adoptium\jdk-17.0.21.9-hotspot\bin\javac.exe" -encoding UTF-8 -d out (Get-ChildItem src/main/java -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

2. Menjalankan aplikasi:

```
& "C:\Program Files\Eclipse Adoptium\jdk-17.0.21.9-hotspot\bin\java.exe" -cp out app.MainApp
```

## Cara Menjalankan Pengujian

Pengujian memakai JUnit 5 melalui Maven:

```
mvn test
```

Menjalankan satu kelas test saja:

```
mvn -Dtest=DynamicArrayTest test
mvn -Dtest=SecondaryStructureTest test
mvn -Dtest=LayananPutusanATest test
```

Cakupan pengujian:

| Kelas Test | Yang Diuji |
|---|---|
| `DynamicArrayTest` | add, resize, insert, set, remove, search, clear, kasus batas, dan invariant |
| `SecondaryStructureTest` | push/pop/peek, pencarian stack yang tidak mengubah urutan, input `null`, dan invariant |
| `LayananPutusanATest` | impor CSV dan validasi baris rusak, pencarian dan step count, filter, serta kasus batas |

## Dokumentasi

* Keputusan desain: `docs/adr/`
* Jejak asal data: `docs/data-provenance.csv`
* Trace manual dan bukti demo: `docs/trace/` dan `docs/demo/`
* Pembagian kerja: `CONTRIBUTIONS.md`
* Penggunaan AI: `AI_USAGE.md`

## Kontributor

| Peran | Nama | Tanggung Jawab |
|---|---|---|
| Anggota A | Dwi Susilaningtyas | `StrukturData`, `DynamicArray`, `Putusan`, `CsvImporter`, `LayananPutusanA` (cari dan filter), data putusan 1-25, serta pengujian terkait |
| Anggota B | Vicka Dewi Anggraini | `CustomStack`, `LayananPutusanB` (agregasi, urutan, ekspor), `MainApp`, data putusan 26-50, serta pengujian terkait |
