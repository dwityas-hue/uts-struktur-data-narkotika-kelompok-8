# Bukti Demonstrasi Aplikasi CLI (`MainApp`)

Berikut adalah log eksekusi langsung fitur impor CSV, pencarian dengan *step count*, penyaringan (*filter*), pengurutan (*sorting*), *undo* (`CustomStack`), dan statistik pada dataset 50 putusan narkotika:

```text
=========================================================
   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        
   Total Data Aktif di Memori: 0 putusan
=========================================================
[Fitur Anggota A - Impor, Pencarian & Penyaringan]
  1. Impor Data Putusan dari CSV
  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)
  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)
[Manajemen Data & CustomStack]
  4. Tambah Putusan Baru
  5. Hapus Putusan berdasarkan Case ID
  6. Undo Perubahan Terakhir (CustomStack)
[Fitur Anggota B - Pengurutan, Statistik & Ekspor]
  7. Urutkan Putusan berdasarkan Vonis (Ascending)
  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)
  9. Ekspor Data Aktif ke File CSV
  0. Keluar
=========================================================
Pilih menu (0-9): 1
Masukkan path file CSV (Enter untuk default 'data/putusan-50.csv'): 

[Hasil Impor CSV]
- Berhasil dimuat : 50 baris
- Gagal/ditolak   : 0 baris

=========================================================
   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        
   Total Data Aktif di Memori: 50 putusan
=========================================================
[Fitur Anggota A - Impor, Pencarian & Penyaringan]
  1. Impor Data Putusan dari CSV
  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)
  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)
[Manajemen Data & CustomStack]
  4. Tambah Putusan Baru
  5. Hapus Putusan berdasarkan Case ID
  6. Undo Perubahan Terakhir (CustomStack)
[Fitur Anggota B - Pengurutan, Statistik & Ekspor]
  7. Urutkan Putusan berdasarkan Vonis (Ascending)
  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)
  9. Ekspor Data Aktif ke File CSV
  0. Keluar
=========================================================
Pilih menu (0-9): 2
Masukkan Case ID (misal P001) atau Nomor Perkara: P010

[Hasil Pencarian]
- Jumlah langkah (Step Count): 10 langkah
- Status: DITEMUKAN
[P010] 391/Pid.Sus/2021/PN Bks | Jenis: Sabu (0.4 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000

=========================================================
   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        
   Total Data Aktif di Memori: 50 putusan
=========================================================
[Fitur Anggota A - Impor, Pencarian & Penyaringan]
  1. Impor Data Putusan dari CSV
  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)
  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)
[Manajemen Data & CustomStack]
  4. Tambah Putusan Baru
  5. Hapus Putusan berdasarkan Case ID
  6. Undo Perubahan Terakhir (CustomStack)
[Fitur Anggota B - Pengurutan, Statistik & Ekspor]
  7. Urutkan Putusan berdasarkan Vonis (Ascending)
  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)
  9. Ekspor Data Aktif ke File CSV
  0. Keluar
=========================================================
Pilih menu (0-9): 3

--- Pilih Mode Filter ---
1. Berdasarkan Jenis Narkotika
2. Berdasarkan Rentang Berat Barang Bukti (gram)
3. Berdasarkan Pasal Terbukti
4. Berdasarkan Rentang Vonis Penjara (bulan)
5. Filter Kombinasi Multi-Kriteria
Pilih (1-5): 1
Masukkan Jenis Narkotika (misal Sabu / Ganja): Sabu

[Hasil Filter: Ditemukan 34 putusan]
1. [P001] 796/Pid.Sus/2019/PN Bks | Jenis: Sabu (1.99 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 60 bln | Denda: Rp 1000000000
2. [P002] 469/Pid.Sus/2022/PN Bks | Jenis: Sabu (0.5 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 72 bln | Denda: Rp 1000000000
3. [P003] 475/Pid.Sus/2022/PN Bks | Jenis: Sabu (0.3 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
4. [P004] 401/Pid.Sus/2022/PN Bks | Jenis: Sabu (5.2 gr) | Pasal: Pasal 112 Ayat (2) | Vonis: 84 bln | Denda: Rp 1000000000
5. [P005] 446/Pid.Sus/2022/PN Bks | Jenis: Sabu (0.25 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 54 bln | Denda: Rp 800000000
6. [P006] 561/Pid.Sus/2025/PN Bks | Jenis: Sabu (0.45 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 60 bln | Denda: Rp 1000000000
7. [P007] 555/Pid.Sus/2018/PN Bks | Jenis: Sabu (0.1 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 60 bln | Denda: Rp 1000000000
8. [P008] 84/Pid.Sus/2018/PN Bks | Jenis: Sabu (0.35 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 54 bln | Denda: Rp 800000000
9. [P009] 121/Pid.Sus/2021/PN Bks | Jenis: Sabu (0.6 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 60 bln | Denda: Rp 1000000000
10. [P010] 391/Pid.Sus/2021/PN Bks | Jenis: Sabu (0.4 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
11. [P013] 340/Pid.Sus/2023/PN Bks | Jenis: Sabu (1.1 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 72 bln | Denda: Rp 1000000000
12. [P014] 412/Pid.Sus/2023/PN Bks | Jenis: Sabu (0.28 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
13. [P016] 134/Pid.Sus/2024/PN Bks | Jenis: Sabu (0.85 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 60 bln | Denda: Rp 1000000000
14. [P017] 245/Pid.Sus/2024/PN Bks | Jenis: Sabu (2.3 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 84 bln | Denda: Rp 1000000000
15. [P019] 510/Pid.Sus/2024/PN Bks | Jenis: Sabu (0.18 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
16. [P021] 89/Pid.Sus/2020/PN Bks | Jenis: Sabu (0.7 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 60 bln | Denda: Rp 800000000
17. [P022] 190/Pid.Sus/2020/PN Bks | Jenis: Sabu (0.42 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
18. [P024] 415/Pid.Sus/2020/PN Bks | Jenis: Sabu (1.5 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 72 bln | Denda: Rp 1000000000
19. [P025] 520/Pid.Sus/2020/PN Bks | Jenis: Sabu (0.33 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 54 bln | Denda: Rp 800000000
20. [P026] 123/Pid.Sus/2024/PN Bgl | Jenis: Sabu (1.25 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 60 bln | Denda: Rp 800000000
21. [P029] 145/Pid.Sus/2024/PN Bgl | Jenis: Sabu (0.95 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 60 bln | Denda: Rp 800000000
22. [P030] 201/Pid.Sus/2024/PN Bgl | Jenis: Sabu (3.1 gr) | Pasal: Pasal 114 Ayat (2) | Vonis: 96 bln | Denda: Rp 1000000000
23. [P031] 15/Pid.Sus/2021/PN Sby | Jenis: Sabu (0.55 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 54 bln | Denda: Rp 800000000
24. [P033] 230/Pid.Sus/2021/PN Sby | Jenis: Sabu (1.8 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 72 bln | Denda: Rp 1000000000
25. [P035] 480/Pid.Sus/2021/PN Sby | Jenis: Sabu (0.22 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
26. [P036] 40/Pid.Sus/2022/PN Sby | Jenis: Sabu (0.65 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 60 bln | Denda: Rp 800000000
27. [P038] 290/Pid.Sus/2022/PN Sby | Jenis: Sabu (0.38 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
28. [P039] 410/Pid.Sus/2022/PN Sby | Jenis: Sabu (2.1 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 84 bln | Denda: Rp 1000000000
29. [P041] 33/Pid.Sus/2023/PN Mlg | Jenis: Sabu (0.48 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
30. [P043] 210/Pid.Sus/2023/PN Mlg | Jenis: Sabu (1.05 gr) | Pasal: Pasal 114 Ayat (1) | Vonis: 72 bln | Denda: Rp 1000000000
31. [P044] 320/Pid.Sus/2023/PN Mlg | Jenis: Sabu (0.29 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
32. [P046] 52/Pid.Sus/2024/PN Mlg | Jenis: Sabu (0.77 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 60 bln | Denda: Rp 800000000
33. [P048] 275/Pid.Sus/2024/PN Mlg | Jenis: Sabu (4.5 gr) | Pasal: Pasal 112 Ayat (2) | Vonis: 96 bln | Denda: Rp 1000000000
34. [P049] 380/Pid.Sus/2024/PN Mlg | Jenis: Sabu (0.31 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000

=========================================================
   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        
   Total Data Aktif di Memori: 50 putusan
=========================================================
[Fitur Anggota A - Impor, Pencarian & Penyaringan]
  1. Impor Data Putusan dari CSV
  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)
  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)
[Manajemen Data & CustomStack]
  4. Tambah Putusan Baru
  5. Hapus Putusan berdasarkan Case ID
  6. Undo Perubahan Terakhir (CustomStack)
[Fitur Anggota B - Pengurutan, Statistik & Ekspor]
  7. Urutkan Putusan berdasarkan Vonis (Ascending)
  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)
  9. Ekspor Data Aktif ke File CSV
  0. Keluar
=========================================================
Pilih menu (0-9): 7

[Sukses] Data berhasil diurutkan berdasarkan Vonis terpendek ke terlama:
1. [P011] 102/Pid.Sus/2023/PN Bks | Jenis: Ganja (12.5 gr) | Pasal: Pasal 111 Ayat (1) | Vonis: 36 bln | Denda: Rp 600000000
2. [P020] 22/Pid.Sus/2025/PN Bks | Jenis: Ganja (5.4 gr) | Pasal: Pasal 111 Ayat (1) | Vonis: 36 bln | Denda: Rp 600000000
3. [P027] 45/Pid.Sus/2024/PN Bgl | Jenis: Ganja (15.5 gr) | Pasal: Pasal 111 Ayat (1) | Vonis: 36 bln | Denda: Rp 600000000
4. [P032] 112/Pid.Sus/2021/PN Sby | Jenis: Ganja (8.2 gr) | Pasal: Pasal 111 Ayat (1) | Vonis: 36 bln | Denda: Rp 600000000
5. [P042] 105/Pid.Sus/2023/PN Mlg | Jenis: Ganja (11.2 gr) | Pasal: Pasal 111 Ayat (1) | Vonis: 36 bln | Denda: Rp 600000000
6. [P047] 160/Pid.Sus/2024/PN Mlg | Jenis: Ganja (6.8 gr) | Pasal: Pasal 111 Ayat (1) | Vonis: 36 bln | Denda: Rp 600000000
7. [P003] 475/Pid.Sus/2022/PN Bks | Jenis: Sabu (0.3 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
8. [P010] 391/Pid.Sus/2021/PN Bks | Jenis: Sabu (0.4 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
9. [P012] 215/Pid.Sus/2023/PN Bks | Jenis: Ekstasi (0.75 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
10. [P014] 412/Pid.Sus/2023/PN Bks | Jenis: Sabu (0.28 gr) | Pasal: Pasal 112 Ayat (1) | Vonis: 48 bln | Denda: Rp 800000000
... (menampilkan 10 data teratas dari total 50)

=========================================================
   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        
   Total Data Aktif di Memori: 50 putusan
=========================================================
[Fitur Anggota A - Impor, Pencarian & Penyaringan]
  1. Impor Data Putusan dari CSV
  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)
  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)
[Manajemen Data & CustomStack]
  4. Tambah Putusan Baru
  5. Hapus Putusan berdasarkan Case ID
  6. Undo Perubahan Terakhir (CustomStack)
[Fitur Anggota B - Pengurutan, Statistik & Ekspor]
  7. Urutkan Putusan berdasarkan Vonis (Ascending)
  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)
  9. Ekspor Data Aktif ke File CSV
  0. Keluar
=========================================================
Pilih menu (0-9): 6
[Sukses] Undo berhasil! Total data dikembalikan menjadi 50 putusan.

=========================================================
   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        
   Total Data Aktif di Memori: 50 putusan
=========================================================
[Fitur Anggota A - Impor, Pencarian & Penyaringan]
  1. Impor Data Putusan dari CSV
  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)
  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)
[Manajemen Data & CustomStack]
  4. Tambah Putusan Baru
  5. Hapus Putusan berdasarkan Case ID
  6. Undo Perubahan Terakhir (CustomStack)
[Fitur Anggota B - Pengurutan, Statistik & Ekspor]
  7. Urutkan Putusan berdasarkan Vonis (Ascending)
  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)
  9. Ekspor Data Aktif ke File CSV
  0. Keluar
=========================================================
Pilih menu (0-9): 8

[Statistik Putusan Narkotika]
- Jumlah Putusan   : 50 perkara
- Rata-rata Vonis  : 57,00 bulan penjara
- Total Pidana Denda: Rp 41.800.000.000

=========================================================
   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        
   Total Data Aktif di Memori: 50 putusan
=========================================================
[Fitur Anggota A - Impor, Pencarian & Penyaringan]
  1. Impor Data Putusan dari CSV
  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)
  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)
[Manajemen Data & CustomStack]
  4. Tambah Putusan Baru
  5. Hapus Putusan berdasarkan Case ID
  6. Undo Perubahan Terakhir (CustomStack)
[Fitur Anggota B - Pengurutan, Statistik & Ekspor]
  7. Urutkan Putusan berdasarkan Vonis (Ascending)
  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)
  9. Ekspor Data Aktif ke File CSV
  0. Keluar
=========================================================
Pilih menu (0-9): 0
Program selesai. Terima kasih!

Process finished with exit code 0