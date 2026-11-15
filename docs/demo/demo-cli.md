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
Pilih menu (0-9): 3

--- Pilih Mode Filter ---
1. Berdasarkan Jenis Narkotika
2. Berdasarkan Rentang Berat Barang Bukti (gram)
3. Berdasarkan Pasal Terbukti
4. Berdasarkan Rentang Vonis Penjara (bulan)
5. Filter Kombinasi Multi-Kriteria
Pilih (1-5): 1
Masukkan Jenis Narkotika (misal Shabu / Ganja): Metamfetamina (shabu) Golongan I

[Hasil Filter: Ditemukan 37 putusan]
1. [BKS-555-2018] 555/Pid.Sus/2018/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0998 gr) | Pasal: Pasal 114 ayat (1) UU 35/2009 | Vonis: 60 bln | Denda: Rp 1000000000
2. [BKS-718-2018] 718/Pid.Sus/2018/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.2682 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 66 bln | Denda: Rp 1000000000
3. [BKS-35-2022] 35/Pid.Sus/2022/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (1.6817 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 800000000
4. [BKS-401-2022] 401/Pid.Sus/2022/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (190.0 gr) | Pasal: Pasal 115 ayat (2) UU 35/2009 | Vonis: 144 bln | Denda: Rp 1200000000
5. [BKS-446-2022] 446/Pid.Sus/2022/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0756 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 48 bln | Denda: Rp 1000000000
6. [BKS-469-2022] 469/Pid.Sus/2022/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (3.6231 gr) | Pasal: Pasal 114 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
7. [BKS-475-2022] 475/Pid.Sus/2022/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.6059 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 66 bln | Denda: Rp 800000000
8. [BKS-427-2019] 427/Pid.Sus/2019/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.7121 gr) | Pasal: Pasal 127 ayat (1) huruf a UU 35/2009 | Vonis: 12 bln | Denda: Rp 0
9. [BKS-301-2019] 301/Pid.Sus/2019/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.2927 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 78 bln | Denda: Rp 1000000000
10. [BKS-152-2019] 152/Pid.Sus/2019/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (4.3723 gr) | Pasal: Pasal 114 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 1000000000
11. [BKS-796-2019] 796/Pid.Sus/2019/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (2.084 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
12. [BKS-83-2021] 83/Pid.Sus/2021/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.546 gr) | Pasal: Pasal 114 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 1000000000
13. [BKS-391-2021] 391/Pid.Sus/2021/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.669 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
14. [BKS-121-2021] 121/Pid.Sus/2021/PN.Bks | Jenis: Metamfetamina (shabu) Golongan I (2.22751 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 66 bln | Denda: Rp 800000000
15. [BKS-377-2021] 377/Pid.Sus/2021/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.095 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 66 bln | Denda: Rp 1000000000
16. [BKS-201-2021] 201/Pid.Sus/2021/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0859 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 60 bln | Denda: Rp 1000000000
17. [BKS-266-2021] 266/Pid.Sus/2021/PN.Bks | Jenis: Metamfetamina (shabu) Golongan I (0.4 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
18. [BKS-751-2020] 751/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0723 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 78 bln | Denda: Rp 1000000000
19. [BKS-638-2020] 638/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.1271 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 1000000000
20. [BKS-539-2020] 539/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (78.6616 gr) | Pasal: Pasal 114 ayat (2) jo. Pasal 132 ayat (1) UU 35/2009 | Vonis: 120 bln | Denda: Rp 1000000000
21. [BKS-263-2020] 263/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.4968 gr) | Pasal: Pasal 114 ayat (1) UU 35/2009 | Vonis: 60 bln | Denda: Rp 1000000000
22. [BKS-491-2020] 491/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.3736 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
23. [BKS-642-2020] 642/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.1622 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
24. [BKS-754-2020] 754/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.1113 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 66 bln | Denda: Rp 800000000
25. [BKS-460-2020] 460/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.1271 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 54 bln | Denda: Rp 1000000000
26. [BKS-731-2020] 731/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.44 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 1000000000
27. [BKS-641-2020] 641/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.3686 gr) | Pasal: Pasal 112 ayat (1) jo. Pasal 132 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
28. [BKS-647-2020] 647/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (93.7103 gr) | Pasal: Pasal 112 ayat (2) UU 35/2009 | Vonis: 132 bln | Denda: Rp 1000000000
29. [BKS-692-2020] 692/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.2826 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 54 bln | Denda: Rp 1000000000
30. [BKS-697-2020] 697/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0456 gr) | Pasal: Pasal 112 ayat (1) jo. Pasal 132 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
31. [BKS-364-2020] 364/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.3877 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 1000000000
32. [BKS-851-2020] 851/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0323 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000
33. [BKS-696-2020] 696/Pid.Sus/2020/PN.Bks | Jenis: Metamfetamina (shabu) Golongan I (0.2067 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 1000000000
34. [BKS-740-2020] 740/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0694 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 84 bln | Denda: Rp 1000000000
35. [BKS-1341-2018] 1341/Pid.Sus/2018/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.1336 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 54 bln | Denda: Rp 1000000000
36. [BKS-818-2020] 818/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0798 gr) | Pasal: Tidak dicantumkan secara eksplisit dalam petikan     rumusan perbuatan: memiliki, menyimpan, menguasai atau menyediakan Narkotika Golongan I bukan tanaman | Vonis: 84 bln | Denda: Rp 1000000000
37. [BKS-571-2019] 571/Pid.Sus/2019/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.5 gr) | Pasal: Pasal 114 ayat (1) UU 35/2009 | Vonis: 72 bln | Denda: Rp 1000000000

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
1. [BKS-427-2019] 427/Pid.Sus/2019/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.7121 gr) | Pasal: Pasal 127 ayat (1) huruf a UU 35/2009 | Vonis: 12 bln | Denda: Rp 0
2. [BKS-84-2018] 84/Pid.Sus/2018/PN Bks | Jenis: Ganja (THC) Golongan I (1.9229 gr) | Pasal: Pasal 111 ayat (1) UU 35/2009 | Vonis: 48 bln | Denda: Rp 800000000
3. [BKS-1367-2018] 1367/Pid.Sus/2018/PN Bks | Jenis: Ganja (THC) Golongan I (0.8906 gr) | Pasal: Pasal 111 ayat (1) UU 35/2009 | Vonis: 48 bln | Denda: Rp 1000000000
4. [BKS-446-2022] 446/Pid.Sus/2022/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.0756 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 48 bln | Denda: Rp 1000000000
5. [BKS-68-2019] 68/Pid.Sus/2019/PN Bks | Jenis: Ganja (THC) Golongan I (0.779 gr) | Pasal: Pasal 111 ayat (1) UU 35/2009 | Vonis: 48 bln | Denda: Rp 800000000
6. [BKS-879-2020] 879/Pid.Sus/2020/PN Bks | Jenis: Ganja (THC) Golongan I (42.71 gr) | Pasal: Pasal 111 ayat (1) jo. Pasal 132 ayat (1) UU 35/2009 | Vonis: 48 bln | Denda: Rp 1000000000
7. [BKS-682-2020] 682/Pid.Sus/2020/PN Bks | Jenis: Ganja (THC) Golongan I (1.8826 gr) | Pasal: Pasal 111 ayat (1) UU 35/2009 | Vonis: 54 bln | Denda: Rp 1000000000
8. [BKS-460-2020] 460/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.1271 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 54 bln | Denda: Rp 1000000000
9. [BKS-692-2020] 692/Pid.Sus/2020/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.2826 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 54 bln | Denda: Rp 1000000000
10. [BKS-1341-2018] 1341/Pid.Sus/2018/PN Bks | Jenis: Metamfetamina (shabu) Golongan I (0.1336 gr) | Pasal: Pasal 112 ayat (1) UU 35/2009 | Vonis: 54 bln | Denda: Rp 1000000000
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
Pilih menu (0-9): 8

[Statistik Putusan Narkotika]
- Jumlah Putusan   : 50 perkara
- Rata-rata Vonis  : 72,00 bulan penjara
- Total Pidana Denda: Rp 48.000.000.000

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
