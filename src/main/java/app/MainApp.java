package app;

import fitur.CsvImporter;
import fitur.LayananPutusanA;
import fitur.LayananPutusanB;
import model.Putusan;
import struktur.CustomStack;
import struktur.DynamicArray;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainApp {

    private static DynamicArray<Putusan> daftarPutusan = new DynamicArray<>();
    private static final CustomStack<DynamicArray<Putusan>> riwayatUndo = new CustomStack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CsvImporter csvImporter = new CsvImporter();
        LayananPutusanA layananA = new LayananPutusanA();
        LayananPutusanB layananB = new LayananPutusanB();

        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuUtama();
            System.out.print("Pilih menu (0-9): ");
            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    menuImporCsv(scanner, csvImporter);
                    break;
                case "2":
                    menuCariPutusan(scanner, layananA);
                    break;
                case "3":
                    menuFilterPutusan(scanner, layananA);
                    break;
                case "4":
                    menuTambahPutusan(scanner);
                    break;
                case "5":
                    menuHapusPutusan(scanner);
                    break;
                case "6":
                    menuUndo();
                    break;
                case "7":
                    menuUrutkanVonis(layananB);
                    break;
                case "8":
                    menuStatistik(layananB);
                    break;
                case "9":
                    menuEksporCsv(scanner, layananB);
                    break;
                case "0":
                    berjalan = false;
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("[Peringatan] Pilihan tidak valid. Masukkan angka 0-9.");
            }
        }
        scanner.close();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n=========================================================");
        System.out.println("   SISTEM ANALISIS PUTUSAN NARKOTIKA (KELOMPOK 8)        ");
        System.out.println("   Total Data Aktif di Memori: " + daftarPutusan.size() + " putusan");
        System.out.println("=========================================================");
        System.out.println("[Fitur Anggota A - Impor, Pencarian & Penyaringan]");
        System.out.println("  1. Impor Data Putusan dari CSV");
        System.out.println("  2. Cari Putusan (Case ID / Nomor Perkara + Step Count)");
        System.out.println("  3. Filter Putusan (Jenis / Berat / Pasal / Vonis / Kombinasi)");
        System.out.println("[Manajemen Data & CustomStack]");
        System.out.println("  4. Tambah Putusan Baru");
        System.out.println("  5. Hapus Putusan berdasarkan Case ID");
        System.out.println("  6. Undo Perubahan Terakhir (CustomStack)");
        System.out.println("[Fitur Anggota B - Pengurutan, Statistik & Ekspor]");
        System.out.println("  7. Urutkan Putusan berdasarkan Vonis (Ascending)");
        System.out.println("  8. Tampilkan Statistik (Rata-rata Vonis & Total Denda)");
        System.out.println("  9. Ekspor Data Aktif ke File CSV");
        System.out.println("  0. Keluar");
        System.out.println("=========================================================");
    }

    // --- 1. IMPOR CSV (ANGGOTA A) ---
    private static void menuImporCsv(Scanner scanner, CsvImporter csvImporter) {
        System.out.print("Masukkan path file CSV (Enter untuk default 'data/putusan-50.csv'): ");
        String path = scanner.nextLine().trim();
        if (path.isEmpty()) {
            path = "data/putusan-50.csv";
        }

        simpanSnapshotUndo();
        CsvImporter.HasilImpor hasil = csvImporter.imporDariCsv(path);
        DynamicArray<Putusan> valid = hasil.getDataValid();
        for (int i = 0; i < valid.size(); i++) {
            daftarPutusan.add(valid.get(i));
        }

        System.out.println("\n[Hasil Impor CSV]");
        System.out.println("- Berhasil dimuat : " + hasil.getJumlahBerhasil() + " baris");
        System.out.println("- Gagal/ditolak   : " + hasil.getJumlahGagal() + " baris");
        DynamicArray<String> errors = hasil.getLogError();
        for (int i = 0; i < errors.size(); i++) {
            System.out.println("  * " + errors.get(i));
        }
    }

    // --- 2. CARI PUTUSAN + STEP COUNT (ANGGOTA A) ---
    private static void menuCariPutusan(Scanner scanner, LayananPutusanA layananA) {
        if (daftarPutusan.size() == 0) {
            System.out.println("[Info] Data masih kosong. Silakan impor CSV terlebih dahulu (Menu 1).");
            return;
        }
        System.out.print("Masukkan Case ID (misal P001) atau Nomor Perkara: ");
        String keyword = scanner.nextLine().trim();

        LayananPutusanA.HasilPencarian hasil = layananA.cariByIdAtauNomorPerkara(daftarPutusan, keyword);
        System.out.println("\n[Hasil Pencarian]");
        System.out.println("- Jumlah langkah (Step Count): " + hasil.getStepCount() + " langkah");
        if (hasil.isDitemukan()) {
            System.out.println("- Status: DITEMUKAN");
            cetakRingkasPutusan(hasil.getPutusan());
        } else {
            System.out.println("- Status: TIDAK DITEMUKAN untuk kata kunci '" + keyword + "'");
        }
    }

    // --- 3. FILTER PUTUSAN (ANGGOTA A) ---
    private static void menuFilterPutusan(Scanner scanner, LayananPutusanA layananA) {
        if (daftarPutusan.size() == 0) {
            System.out.println("[Info] Data masih kosong. Silakan impor CSV terlebih dahulu (Menu 1).");
            return;
        }
        System.out.println("\n--- Pilih Mode Filter ---");
        System.out.println("1. Berdasarkan Jenis Narkotika");
        System.out.println("2. Berdasarkan Rentang Berat Barang Bukti (gram)");
        System.out.println("3. Berdasarkan Pasal Terbukti");
        System.out.println("4. Berdasarkan Rentang Vonis Penjara (bulan)");
        System.out.println("5. Filter Kombinasi Multi-Kriteria");
        System.out.print("Pilih (1-5): ");
        String mode = scanner.nextLine().trim();

        try {
            DynamicArray<Putusan> hasil = new DynamicArray<>();
            switch (mode) {
                case "1":
                    System.out.print("Masukkan Jenis Narkotika (misal Sabu / Ganja): ");
                    hasil = layananA.filterByJenisNarkotika(daftarPutusan, scanner.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Berat minimum (gram): ");
                    double minGram = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Berat maksimum (gram): ");
                    double maxGram = Double.parseDouble(scanner.nextLine().trim());
                    hasil = layananA.filterByRentangBerat(daftarPutusan, minGram, maxGram);
                    break;
                case "3":
                    System.out.print("Masukkan kata kunci Pasal Terbukti (misal 112 / 114 / 127): ");
                    hasil = layananA.filterByPasalTerbukti(daftarPutusan, scanner.nextLine().trim());
                    break;
                case "4":
                    System.out.print("Vonis minimum (bulan): ");
                    int minBulan = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Vonis maksimum (bulan): ");
                    int maxBulan = Integer.parseInt(scanner.nextLine().trim());
                    hasil = layananA.filterByRentangVonis(daftarPutusan, minBulan, maxBulan);
                    break;
                case "5":
                    System.out.print("Jenis Narkotika (kosongkan jika diabaikan): ");
                    String jenis = scanner.nextLine().trim();
                    System.out.print("Berat min gram (kosongkan jika diabaikan): ");
                    String sMinB = scanner.nextLine().trim();
                    Double minB = sMinB.isEmpty() ? null : Double.parseDouble(sMinB);
                    System.out.print("Berat max gram (kosongkan jika diabaikan): ");
                    String sMaxB = scanner.nextLine().trim();
                    Double maxB = sMaxB.isEmpty() ? null : Double.parseDouble(sMaxB);
                    System.out.print("Pasal Terbukti (kosongkan jika diabaikan): ");
                    String pasal = scanner.nextLine().trim();
                    System.out.print("Vonis min bulan (kosongkan jika diabaikan): ");
                    String sMinV = scanner.nextLine().trim();
                    Integer minV = sMinV.isEmpty() ? null : Integer.parseInt(sMinV);
                    System.out.print("Vonis max bulan (kosongkan jika diabaikan): ");
                    String sMaxV = scanner.nextLine().trim();
                    Integer maxV = sMaxV.isEmpty() ? null : Integer.parseInt(sMaxV);

                    hasil = layananA.filterKombinasi(daftarPutusan, jenis, minB, maxB, pasal, minV, maxV);
                    break;
                default:
                    System.out.println("[Peringatan] Mode filter tidak valid.");
                    return;
            }

            System.out.println("\n[Hasil Filter: Ditemukan " + hasil.size() + " putusan]");
            for (int i = 0; i < hasil.size(); i++) {
                System.out.print((i + 1) + ". ");
                cetakRingkasPutusan(hasil.get(i));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[Error Input] " + e.getMessage());
        }
    }

    // --- 4. TAMBAH PUTUSAN BARU ---
    private static void menuTambahPutusan(Scanner scanner) {
        try {
            System.out.println("\n--- Tambah Data Putusan Baru ---");
            System.out.print("Case ID (misal P051): ");
            String caseId = scanner.nextLine().trim();
            System.out.print("Nomor Perkara: ");
            String nomorPerkara = scanner.nextLine().trim();
            System.out.print("Pengadilan: ");
            String pengadilan = scanner.nextLine().trim();
            System.out.print("Tanggal Putusan (YYYY-MM-DD): ");
            LocalDate tanggal = LocalDate.parse(scanner.nextLine().trim());
            System.out.print("Kode Terdakwa (misal T-051): ");
            String terdakwa = scanner.nextLine().trim();
            System.out.print("Jenis Narkotika: ");
            String jenis = scanner.nextLine().trim();
            System.out.print("Berat Barang Bukti (gram): ");
            double berat = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Pasal Dakwaan: ");
            String dakwaan = scanner.nextLine().trim();
            System.out.print("Pasal Terbukti: ");
            String terbukti = scanner.nextLine().trim();
            System.out.print("Tuntutan Penjara (bulan): ");
            int tuntutan = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Vonis Penjara (bulan): ");
            int vonis = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Denda (Rupiah): ");
            long denda = Long.parseLong(scanner.nextLine().trim());
            System.out.print("Barang Bukti: ");
            String bb = scanner.nextLine().trim();
            System.out.print("Keadaan Memberatkan: ");
            String memberatkan = scanner.nextLine().trim();
            System.out.print("Keadaan Meringankan: ");
            String meringankan = scanner.nextLine().trim();
            System.out.print("Halaman Sumber PDF (misal 1-15): ");
            String sourcePages = scanner.nextLine().trim();

            Putusan baru = new Putusan(
                    caseId, nomorPerkara, pengadilan, tanggal, terdakwa, jenis,
                    berat, dakwaan, terbukti, tuntutan, vonis, denda,
                    bb, memberatkan, meringankan, sourcePages
            );

            simpanSnapshotUndo();
            daftarPutusan.add(baru);
            System.out.println("[Sukses] Putusan " + caseId + " berhasil ditambahkan.");
        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("[Error] Format tanggal atau angka tidak valid: " + e.getMessage());
        }
    }

    // --- 5. HAPUS PUTUSAN ---
    private static void menuHapusPutusan(Scanner scanner) {
        if (daftarPutusan.size() == 0) {
            System.out.println("[Info] Data kosong, tidak ada yang bisa dihapus.");
            return;
        }
        System.out.print("Masukkan Case ID yang ingin dihapus: ");
        String target = scanner.nextLine().trim();

        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            if (p != null && p.getCaseId() != null && p.getCaseId().equalsIgnoreCase(target)) {
                simpanSnapshotUndo();
                daftarPutusan.remove(i);
                System.out.println("[Sukses] Putusan dengan Case ID '" + target + "' berhasil dihapus.");
                return;
            }
        }
        System.out.println("[Info] Case ID '" + target + "' tidak ditemukan.");
    }

    // --- 6. UNDO MENGGUNAKAN CUSTOM STACK ---
    private static void menuUndo() {
        if (riwayatUndo.isEmpty()) {
            System.out.println("[Info] Tidak ada riwayat perubahan yang dapat di-undo.");
            return;
        }
        daftarPutusan = riwayatUndo.pop();
        System.out.println("[Sukses] Undo berhasil! Total data dikembalikan menjadi " + daftarPutusan.size() + " putusan.");
    }

    // --- 7. URUTKAN PUTUSAN (ANGGOTA B) ---
    private static void menuUrutkanVonis(LayananPutusanB layananB) {
        if (daftarPutusan.size() == 0) {
            System.out.println("[Info] Data masih kosong.");
            return;
        }
        simpanSnapshotUndo();
        Putusan[] arr = konversiKeArray(daftarPutusan);
        layananB.urutkanBerdasarkanVonisAsc(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            daftarPutusan.set(i, arr[i]);
        }

        System.out.println("\n[Sukses] Data berhasil diurutkan berdasarkan Vonis terpendek ke terlama:");
        int batasTampil = Math.min(10, daftarPutusan.size());
        for (int i = 0; i < batasTampil; i++) {
            System.out.print((i + 1) + ". ");
            cetakRingkasPutusan(daftarPutusan.get(i));
        }
        if (daftarPutusan.size() > 10) {
            System.out.println("... (menampilkan 10 data teratas dari total " + daftarPutusan.size() + ")");
        }
    }

    // --- 8. STATISTIK & AGREGASI (ANGGOTA B) ---
    private static void menuStatistik(LayananPutusanB layananB) {
        if (daftarPutusan.size() == 0) {
            System.out.println("[Info] Data masih kosong.");
            return;
        }
        Putusan[] arr = konversiKeArray(daftarPutusan);
        double rataVonis = layananB.hitungRataRataVonis(arr, arr.length);
        long totalDenda = layananB.hitungTotalDenda(arr, arr.length);

        System.out.println("\n[Statistik Putusan Narkotika]");
        System.out.println("- Jumlah Putusan   : " + arr.length + " perkara");
        System.out.printf("- Rata-rata Vonis  : %.2f bulan penjara%n", rataVonis);
        System.out.printf("- Total Pidana Denda: Rp %,d%n", totalDenda);
    }

    // --- 9. EKSPOR CSV (ANGGOTA B) ---
    private static void menuEksporCsv(Scanner scanner, LayananPutusanB layananB) {
        if (daftarPutusan.size() == 0) {
            System.out.println("[Info] Data masih kosong, tidak ada yang diekspor.");
            return;
        }
        System.out.print("Masukkan nama file tujuan (Enter untuk 'data/hasil-ekspor.csv'): ");
        String path = scanner.nextLine().trim();
        if (path.isEmpty()) {
            path = "data/hasil-ekspor.csv";
        }

        Putusan[] arr = konversiKeArray(daftarPutusan);
        try {
            layananB.eksporKeCSV(arr, arr.length, path);
            System.out.println("[Sukses] " + arr.length + " data berhasil diekspor ke: " + path);
        } catch (IOException e) {
            System.out.println("[Error] Gagal mengekspor CSV: " + e.getMessage());
        }
    }

    // --- HELPER INTERNAL ---
    private static Putusan[] konversiKeArray(DynamicArray<Putusan> list) {
        Putusan[] arr = new Putusan[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static void simpanSnapshotUndo() {
        DynamicArray<Putusan> salinan = new DynamicArray<>(daftarPutusan.size() + 5);
        for (int i = 0; i < daftarPutusan.size(); i++) {
            salinan.add(daftarPutusan.get(i));
        }
        riwayatUndo.push(salinan);
    }

    private static void cetakRingkasPutusan(Putusan p) {
        if (p == null) return;
        System.out.println(
                "[" + p.getCaseId() + "] " + p.getNomorPerkara() +
                        " | Jenis: " + p.getJenisNarkotika() +
                        " (" + p.getBeratBarangBuktiGram() + " gr)" +
                        " | Pasal: " + p.getPasalTerbukti() +
                        " | Vonis: " + p.getVonisBulan() + " bln" +
                        " | Denda: Rp " + p.getDendaRupiah()
        );
    }
}