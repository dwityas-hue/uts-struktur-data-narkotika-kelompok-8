
### Dwi Susilaningtyas (Anggota A - Core Developer & Integrator)

- **Ekstraksi Data:** Mengisi 25 Record Data putusan (P001–P025) pada `data/putusan-50.csv` dan provenance di `docs/data-provenance.csv`.
- **Implementasi Kode:** Merancang Antarmuka `StrukturData.java`, struktur data utama `DynamicArray.java` generik (`add`, `get`, `set`, `remove`, `size`, `resize`), model `Putusan.java`, serta parser impor dan validasi CSV di `CsvImporter.java`.
- **Fitur Aplikasi & Integrasi:** Mengembangkan metode pencarian ber-*step count* (`cariByIdAtauNomorPerkara`) dan penyaringan multi-kriteria (`filterKombinasi`) di `LayananPutusanA.java`, serta mengintegrasikan seluruh fitur kelompok ke menu CLI `MainApp.java`.
- **Pengujian:** Menulis unit test JUnit 5 untuk struktur data utama, impor CSV, pencarian, filter, dan *edge case* (Skenario 1, 2, 3, dan 7).
- **Dokumentasi:** Menulis `docs/adr/01-pemilihan-struktur-data.md`, panduan pada `README.md`, log eksekusi `docs/demo/demo-cli.md`, serta mencatat aktivitas pada `AI_USAGE.md` dan `CONTRIBUTIONS.md`.

### Vicka Dewi Anggraini (Anggota B - Reviewer & QA)

- **Ekstraksi Data:** Mengisi 25 record data putusan (P026–P050) pada `data/putusan-50.csv` dan provenance di `docs/data-provenance.csv`.
- **Implementasi Kode:** Membuat kelas struktur data sekunder `CustomStack.java` (push, pop, peek, searchPreserve, restore, validateInvariant).
- **Fitur Aplikasi:** Mengembangkan metode agregasi (rata-rata vonis, total denda), pengurutan `urutkanBerdasarkanVonisAsc`, dan fitur ekspor CSV di `LayananPutusanB.java`.
- **Pengujian:** Menulis unit test JUnit 5 untuk Skenario 5, 6, dan 7 di `SecondaryStructureTest.java`.
- **Dokumentasi:** Menulis `docs/adr/02-strategi-pencarian-sorting.md` dan mencatat aktivitas pada `AI_USAGE.md`.
=======
# CONTRIBUTIONS

## Project Overview

**Nama Proyek:** Sistem Pengelolaan Putusan Pengadilan Narkotika

**Repository:**
https://github.com/dwityas-hue/uts-struktur-data-narkotika-kelompok-8

Proyek ini merupakan aplikasi berbasis Java untuk mengelola 50 data
putusan pengadilan terkait kasus narkotika. Aplikasi dikembangkan
sebagai pemenuhan Ujian Tengah Semester (UTS) mata kuliah Struktur Data.

Sistem dirancang untuk melakukan pengelolaan data putusan, mulai dari
impor data CSV, menampilkan data, pencarian, filter, pengurutan,
agregasi statistik, pencatatan riwayat aktivitas, hingga ekspor data.

## Struktur Data yang Digunakan

Program ini menggunakan dua struktur data utama:

1.  **Dynamic Array (Array Dinamis)**

    Digunakan sebagai struktur data utama untuk menyimpan 50 data
    putusan pengadilan. Implementasinya mencakup operasi penambahan,
    penyisipan, pengambilan, perubahan, penghapusan, pencarian, dan
    penyesuaian kapasitas array (*resize*).

2.  **Stack (Audit Stack)**

    Digunakan sebagai struktur data sekunder untuk menyimpan riwayat
    aktivitas pengguna dengan prinsip LIFO (*Last In, First Out*).
    Struktur ini diimplementasikan melalui class `AuditStack<T>` untuk
    mencatat dan menampilkan riwayat operasi pengguna.

Kedua struktur data diimplementasikan secara mandiri tanpa menggunakan
koleksi bawaan Java seperti `ArrayList`, `LinkedList`, atau `Stack`.

## Anggota Kelompok

  ------------------------------------------------------------------------------------------------
No.                     Nama Anggota            GitHub
  ----------------------- ----------------------- ------------------------------------------------
1                       Dwi Susilaningtyas      [@dwityas-hue](https://github.com/dwityas-hue)

2                       Vicka Dewi Anggraini    [@VicKaDeWi](https://github.com/VicKaDeWi)
------------------------------------------------------------------------------------------------

## Contributions

### 1. Dwi Susilaningtyas

**GitHub:** `dwityas-hue`

Kontribusi:

**Pengolahan Data:** - Mengumpulkan dan mengekstrak data putusan
pengadilan nomor 1--25. - Mengisi data sesuai skema 16 kolom CSV. -
Membuat dan melengkapi data provenance untuk data yang dikumpulkan. -
Melakukan review terhadap data putusan nomor 26--50.

**Implementasi Struktur Data:** - Membuat interface `StrukturData<T>`. -
Mengimplementasikan class `DynamicArray<T>`. - Mengembangkan operasi
`add`, `insert`, `get`, `set`, `remove`, `search`, dan `resize`. -
Mengimplementasikan `validateInvariant()` untuk memeriksa konsistensi
struktur data.

**Pengembangan Fitur:** - Membuat class `Putusan` dengan 16 atribut
sesuai skema data. - Mengembangkan fitur impor data melalui CSV beserta
validasi data. - Mengembangkan fitur pencarian putusan berdasarkan nomor
perkara atau `caseId`. - Mengimplementasikan pencarian dengan pencacah
jumlah langkah. - Mengembangkan fitur filter berdasarkan jenis
narkotika, rentang berat, pasal terbukti, dan rentang vonis.

**Pengujian dan Dokumentasi:** - Membuat `DynamicArrayTest`. - Membuat
`ImporterTest`. - Melakukan pengujian skenario 1, 2, 3, dan 7. -
Menyusun dokumentasi `README.md`. - Menyusun `ADR-001` mengenai alasan
pemilihan struktur data Array dan Stack.

### 2. Vicka Dewi Anggraini

**GitHub:** `VicKaDeWi`

Kontribusi:

**Pengolahan Data:** - Mengumpulkan dan mengekstrak data putusan
pengadilan nomor 26--50. - Mengisi data sesuai skema 16 kolom CSV. -
Membuat dan melengkapi data provenance untuk data yang dikumpulkan. -
Melakukan review terhadap data putusan nomor 1--25.

**Implementasi Struktur Data:** - Mengimplementasikan class
`AuditStack<T>`. - Mengembangkan operasi `push`, `pop`, `peek`,
`searchPreserve`, dan `restore`. - Mengimplementasikan
`validateInvariant()` untuk memeriksa konsistensi struktur stack.

**Pengembangan Fitur:** - Mengembangkan fitur agregasi statistik,
meliputi jumlah perkara, rata-rata vonis, total denda, dan distribusi
jenis narkotika. - Mengembangkan fitur pengurutan data putusan
berdasarkan vonis menggunakan algoritma sorting yang dibuat sendiri. -
Mengimplementasikan fitur audit untuk mencatat setiap operasi pengguna
ke dalam stack. - Mengembangkan fitur ekspor data ke CSV atau teks. -
Membuat menu utama aplikasi melalui `Main.java`.

**Pengujian dan Dokumentasi:** - Membuat `AuditStackTest`. - Membuat
`AgregasiTest`. - Melakukan pengujian skenario 4, 5, dan 6. - Menyusun
`ADR-002` mengenai metode pencarian dan pengurutan. - Menyusun
dokumentasi `CONTRIBUTIONS.md`. - Membuat trace manual proses
penghapusan elemen di `docs/trace/`.

## Issues

Pekerjaan proyek dibagi menjadi beberapa tugas menggunakan GitHub Issues
agar setiap anggota memiliki tanggung jawab yang jelas.

Daftar pekerjaan meliputi:

1.  Persiapan repository dan struktur folder proyek Java.
2.  Pengumpulan dataset putusan pengadilan.
3.  Pembuatan data provenance.
4.  Implementasi interface struktur data.
5.  Implementasi Dynamic Array.
6.  Implementasi Audit Stack.
7.  Pembuatan model data `Putusan`.
8.  Implementasi fitur impor CSV dan validasi.
9.  Implementasi fitur tampil dan pengelolaan data putusan.
10. Implementasi fitur pencarian putusan.
11. Implementasi fitur filter putusan.
12. Implementasi fitur agregasi statistik.
13. Implementasi fitur pengurutan vonis.
14. Implementasi fitur audit riwayat aktivitas.
15. Implementasi fitur ekspor data.
16. Pembuatan menu utama aplikasi.
17. Pengujian struktur data dan fitur aplikasi.
18. Penyusunan dokumentasi proyek.
19. Pembuatan `AI_USAGE.md` dan trace manual.
20. Pengujian akhir dan validasi seluruh struktur data.

## Pull Requests

Pengembangan proyek dilakukan menggunakan branch dan Pull Request agar
setiap perubahan dapat ditinjau sebelum digabungkan ke branch utama
(`main`).

Berdasarkan roadmap, pembagian rencana Pull Request adalah sebagai
berikut:

  -----------------------------------------------------------------------
PR                      Pembuat                 Isi Pull Request
  ----------------------- ----------------------- -----------------------
#1                      Dwi Susilaningtyas      Dynamic Array dan
pengujian

#2                      Vicka Dewi Anggraini    Audit Stack dan
pengujian

#3                      Dwi Susilaningtyas      Model Putusan, impor
CSV, pencarian, dan
filter

#4                      Vicka Dewi Anggraini    Agregasi dan pengurutan

#5                      Dwi Susilaningtyas      Data putusan 1--25 dan
provenance

#6                      Vicka Dewi Anggraini    Audit, ekspor, dan menu
utama

#7                      Vicka Dewi Anggraini    Data putusan 26--50 dan
provenance

#8                      Dwi Susilaningtyas      README, ADR-001, dan
pengujian skenario 1,
2, 3, 7

#9                      Vicka Dewi Anggraini    ADR-002, CONTRIBUTIONS,
trace manual, dan
pengujian skenario 4,
5, 6
  -----------------------------------------------------------------------

Setiap Pull Request difokuskan pada satu jenis pekerjaan agar proses
pemeriksaan dan penggabungan kode lebih terstruktur. Nomor dan isi PR di
atas mengikuti rencana pada roadmap; sesuaikan dengan PR yang
benar-benar dibuat di repository.

## Reviews

Setiap anggota bertanggung jawab melakukan review terhadap Pull Request
yang dibuat oleh anggota lainnya.

Pembagian review berdasarkan roadmap:

-   Dwi Susilaningtyas melakukan review terhadap PR #2, #4, dan #7.
-   Vicka Dewi Anggraini melakukan review terhadap PR #1, #3, dan #5.
-   Review juga dilakukan terhadap perubahan dokumentasi dan pengujian
    sesuai kebutuhan.

Proses review mencakup pemeriksaan kode, identifikasi kesalahan,
pemberian saran teknis, serta memastikan perubahan tidak mengganggu
bagian program lainnya.

## Main Commits

Commit dilakukan secara bertahap sesuai dengan pekerjaan masing-masing
anggota. Setiap commit menggunakan pesan yang menjelaskan perubahan yang
dilakukan.

Beberapa kategori perubahan yang dikerjakan meliputi:

-   Implementasi dan pengembangan struktur data Dynamic Array.
-   Implementasi dan pengembangan struktur data Audit Stack.
-   Pengembangan fitur pengelolaan data putusan.
-   Pengolahan dan validasi dataset CSV.
-   Pengembangan fitur pencarian, filter, agregasi, dan pengurutan.
-   Implementasi audit riwayat aktivitas dan ekspor data.
-   Pembuatan serta pengembangan unit test.
-   Penyusunan dokumentasi dan data provenance.
-   Perbaikan bug dan integrasi kode program.

## Collaboration

Seluruh anggota bekerja sama dalam mengembangkan Sistem Pengelolaan
Putusan Pengadilan Narkotika dengan pembagian tugas berdasarkan roadmap
pengerjaan.

Kolaborasi dilakukan melalui beberapa tahapan:

1.  **Pembagian Tugas:** Setiap anggota bertanggung jawab terhadap
    pengumpulan data, implementasi struktur data, pengembangan fitur,
    pengujian, dan dokumentasi sesuai pembagian yang telah disepakati.

2.  **Pengembangan Bersama:** Dwi Susilaningtyas berfokus pada
    implementasi Dynamic Array dan fitur impor, pencarian, serta filter.
    Vicka Dewi Anggraini berfokus pada implementasi Audit Stack,
    agregasi, pengurutan, audit, dan ekspor data.

3.  **Pengelolaan Dataset:** Kedua anggota mengumpulkan masing-masing 25
    data putusan dan saling melakukan review untuk memastikan data
    sesuai dengan sumber serta memiliki provenance yang dapat diperiksa.

4.  **Kolaborasi melalui GitHub:** Setiap anggota mengerjakan perubahan
    melalui branch masing-masing, kemudian mengajukan Pull Request untuk
    ditinjau sebelum digabungkan ke branch utama (`main`).

5.  **Pengujian dan Validasi:** Kedua anggota melakukan pengujian
    terhadap struktur data dan fitur aplikasi sesuai pembagian skenario
    pengujian.

6.  **Penyusunan Dokumentasi:** Dokumentasi proyek disusun bersama,
    meliputi README, ADR, CONTRIBUTIONS, AI_USAGE, data provenance, dan
    trace manual.

Melalui pembagian tugas, proses review, dan pengujian bersama, setiap
anggota memiliki kontribusi yang dapat ditelusuri melalui GitHub serta
bertanggung jawab terhadap bagian yang dikerjakan.

## Final Verification

Sebelum proyek dinyatakan selesai, dilakukan pemeriksaan terhadap
beberapa hal berikut:

-   Dataset berisi tepat 50 record putusan valid dari 50 pengadilan
    negeri berbeda.
-   File `docs/data-provenance.csv` lengkap dan memiliki informasi
    extractor serta reviewer.
-   Implementasi Dynamic Array dan Audit Stack memenuhi invariant
    masing-masing.
-   Seluruh fitur aplikasi berjalan sesuai kebutuhan.
-   Tujuh skenario pengujian berhasil dijalankan.
-   Dokumentasi README, ADR, CONTRIBUTIONS, dan AI_USAGE tersedia.
-   Setiap anggota memenuhi target minimal 3 Pull Request dan 2 review
    dengan komentar teknis.
-   Proyek berhasil di-build, di-test, dan dijalankan dari hasil clone
    repository baru.
-   Tag rilis `uts-v1.0` dibuat dari commit yang akan didemonstrasikan.

