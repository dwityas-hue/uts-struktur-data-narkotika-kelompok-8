## Log Penggunaan AI [11 November 2026]
**Anggota:** Vicka Dewi Anggraini  
**Alat AI:** Gemini  
**Tujuan:** Merancang kelas CustomStack generik, metode agregasi/sorting, serta Unit Test JUnit 5.  
**Prompt Ringkas:** "Bantu saya membuat struktur data Stack generik dalam bahasa Java menggunakan mentah Object[] TANPA java.util.Stack/Queue. Kebutuhan method: push, pop, peek, searchPreserve, restore, validateInvariant. Pastikan search non-destruktif."  
**Bagian yang Digunakan:** Logika `searchPreserve`, `restore`, dan skenario pengujian JUnit 5.  
**Modifikasi & Verifikasi:** Menambahkan pengecekan null pointer pada method `push()` dan memastikan `validateInvariant()` memeriksa null-gap pada array.