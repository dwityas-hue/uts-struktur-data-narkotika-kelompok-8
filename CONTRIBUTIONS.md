### Dwi Susilaningtyas (Anggota A - Core Developer & Integrator)

- **Ekstraksi Data:** Mengisi 25 record data putusan (P001–P025) pada `data/putusan-50.csv` dan provenance di `docs/data-provenance.csv`.
- **Implementasi Kode:** Merancang antarmuka `StrukturData.java`, struktur data utama `DynamicArray.java` generik (`add`, `get`, `set`, `remove`, `size`, `resize`), model `Putusan.java`, serta parser impor dan validasi CSV di `CsvImporter.java`.
- **Fitur Aplikasi & Integrasi:** Mengembangkan metode pencarian ber-*step count* (`cariByIdAtauNomorPerkara`) dan penyaringan multi-kriteria (`filterKombinasi`) di `LayananPutusanA.java`, serta mengintegrasikan seluruh fitur kelompok ke menu CLI `MainApp.java`.
- **Pengujian:** Menulis unit test JUnit 5 untuk struktur data utama, impor CSV, pencarian, filter, dan *edge case* (Skenario 1, 2, 3, dan 7).
- **Dokumentasi:** Menulis `docs/adr/01-pemilihan-struktur-data.md`, panduan `README.md`, log eksekusi `docs/demo/demo-cli.md`, serta mencatat aktivitas pada `AI_USAGE.md` dan `CONTRIBUTIONS.md`.

### Vicka Dewi Anggraini (Anggota B - Reviewer & QA)

- **Ekstraksi Data:** Mengisi 25 record data putusan (P026–P050) pada `data/putusan-50.csv` dan provenance di `docs/data-provenance.csv`.
- **Implementasi Kode:** Membuat kelas struktur data sekunder `CustomStack.java` (push, pop, peek, searchPreserve, restore, validateInvariant).
- **Fitur Aplikasi:** Mengembangkan metode agregasi (rata-rata vonis, total denda), pengurutan `urutkanBerdasarkanVonisAsc`, dan fitur ekspor CSV di `LayananPutusanB.java`.
- **Pengujian:** Menulis unit test JUnit 5 untuk Skenario 5, 6, dan 7 di `SecondaryStructureTest.java`.
- **Dokumentasi:** Menulis `docs/adr/02-strategi-pencarian-sorting.md` dan mencatat aktivitas pada `AI_USAGE.md`.