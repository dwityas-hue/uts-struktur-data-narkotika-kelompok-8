# Sistem Analisis Putusan Narkotika (UTS Struktur Data)

Aplikasi berbasis Command-Line Interface (CLI) menggunakan Java dan Maven untuk mengimpor, mencari, menyaring, mengelola, mengurutkan, serta menganalisis statistik 50 putusan tindak pidana narkotika menggunakan implementasi struktur data kustom dari nol (`DynamicArray<T>` dan `CustomStack<T>`).

## Identitas Kelompok 8
- **Anggota A:** [Dwi Susilaningtyas] — [202510370110076]
    - Implementasi `StrukturData<T>` dan `DynamicArray<T>` beserta unit test.
    - Implementasi model `Putusan`, `CsvImporter` (impor & validasi CSV), pencarian (*step count*), dan filter multi-kriteria (`LayananPutusanA`).
    - Ekstraksi dataset putusan 1–25 & `docs/data-provenance.csv`, unit test Skenario 1, 2, 3, 7, integrasi `MainApp`, serta `ADR-001` & `README.md`.
- **Anggota B:** [Vicka Dewi Anggraini] — [202510370110065]
    - Implementasi `CustomStack<T>` (mekanisme *undo*), CRUD putusan, pengurutan (*sorting* & Top-N), agregasi statistik, dan ekspor laporan (`LayananPutusanB`).
    - Ekstraksi dataset putusan 26–50 & `docs/data-provenance.csv`, unit test Skenario 5, 6, 7, serta `ADR-002`.

## Struktur Direktori
```text
├── data/
│   └── putusan-50.csv              # Dataset 50 putusan narkotika teranonimisasi
├── docs/
│   ├── adr/                        # Architecture Decision Records (ADR-001 & ADR-002)
│   ├── demo/                       # Bukti demonstrasi eksekusi aplikasi CLI
│   ├── trace/                      # Bukti trace langkah pencarian & operasi struktur data
│   └── data-provenance.csv         # Referensi nomor halaman PDF per atribut
├── src/
│   ├── main/java/
│   │   ├── app/MainApp.java        # Titik masuk utama menu CLI
│   │   ├── fitur/                  # CsvImporter, LayananPutusanA, LayananPutusanB
│   │   ├── model/Putusan.java      # Model entitas 16 atribut putusan
│   │   └── struktur/               # StrukturData, DynamicArray, CustomStack
│   └── test/java/                  # Pengujian otomatis JUnit 5
├── AI_USAGE.md                     # Catatan penggunaan AI selama pengembangan
├── CONTRIBUTIONS.md                # Rincian kontribusi tiap anggota
└── pom.xml                         # Konfigurasi proyek Maven & JUnit 5