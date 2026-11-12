# ADR 02: Strategi Pengurutan (Sorting) Data Putusan Narkotika

## Status
Diterima (Accepted)

## Konteks
Aplikasi membutuhkan fitur pengurutan data berdasarkan vonis pidana penjara (`vonisBulan`) untuk menyajikan analisis data putusan.

## Keputusan
Kami memilih menggunakan algoritma **Bubble Sort** yang diimplementasikan secara in-place langsung di atas struktur data internal (array mentah / node) tanpa menggunakan koleksi bawaan `java.util.Arrays` atau `java.util.Collections`.

## Konsekuensi & Kompleksitas
- **Kompleksitas Waktu:** Best Case O(n), Average & Worst Case O(n^2).
- **Kompleksitas Ruang:** O(1) karena bersifat in-place.
- **Alasan:** Ukuran dataset fixed 50 record, sehingga overhead algoritma sederhana seperti Bubble Sort sangat minimal dan mudah diverifikasi kebenaran invariant-nya.