## Log Penggunaan AI [11 November 2026]

**Anggota:** Dwi Susilaningtyas  
**Alat AI:** Gemini  
**Tujuan:** Merancang struktur data `DynamicArray<T>`, model `Putusan`, parser impor CSV, fitur pencarian (*step count*) dan filter multi-kriteria, unit test JUnit 5, serta integrasi menu CLI `MainApp`.  
**Prompt Ringkas:** "Bantu saya membuat struktur data DynamicArray generik menggunakan array mentah Object[] TANPA java.util.ArrayList lengkap dengan auto-resize, parser impor CSV 16 kolom dengan validasi, fitur pencarian ber-stepCount dan filter multi-kriteria, unit test JUnit 5, serta integrasi ke menu utama CLI."  
**Bagian yang Digunakan:** Kerangka operasi `DynamicArray<T>`, logika `splitCsvLine`, `filterKombinasi`, skenario unit test JUnit 5, dan alur menu interaktif `MainApp`.  
**Modifikasi & Verifikasi:** Menambahkan pembersihan karakter BOM UTF-8 (`\uFEFF`) pada header CSV, validasi nilai non-negatif dan batas rentang filter, pencocokan teks *case-insensitive*, serta verifikasi melalui pengujian Maven `test` dan simulasi langsung pada 50 data (`docs/demo/demo-cli.md`).

**Anggota:** Vicka Dewi Anggraini  
**Alat AI:** Gemini  
**Tujuan:** Merancang kelas CustomStack generik, metode agregasi/sorting, serta Unit Test JUnit 5.  
**Prompt Ringkas:** "Bantu saya membuat struktur data Stack generik dalam bahasa Java menggunakan mentah Object[] TANPA java.util.Stack/Queue. Kebutuhan method: push, pop, peek, searchPreserve, restore, validateInvariant. Pastikan search non-destruktif."  
**Bagian yang Digunakan:** Logika `searchPreserve`, `restore`, dan skenario pengujian JUnit 5.  
**Modifikasi & Verifikasi:** Menambahkan pengecekan null pointer pada method `push()` dan memastikan `validateInvariant()` memeriksa null-gap pada array.