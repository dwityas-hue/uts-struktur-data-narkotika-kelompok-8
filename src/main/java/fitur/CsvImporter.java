package fitur;

import model.Putusan;
import struktur.DynamicArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CsvImporter {

    public static class HasilImpor {
        private final DynamicArray<Putusan> dataValid;
        private final int jumlahBerhasil;
        private final int jumlahGagal;
        private final DynamicArray<String> logError;

        public HasilImpor(DynamicArray<Putusan> dataValid, int jumlahBerhasil, int jumlahGagal, DynamicArray<String> logError) {
            this.dataValid = dataValid;
            this.jumlahBerhasil = jumlahBerhasil;
            this.jumlahGagal = jumlahGagal;
            this.logError = logError;
        }

        public DynamicArray<Putusan> getDataValid() { return dataValid; }
        public int getJumlahBerhasil() { return jumlahBerhasil; }
        public int getJumlahGagal() { return jumlahGagal; }
        public DynamicArray<String> getLogError() { return logError; }
    }

    public HasilImpor imporDariCsv(String filePath) {
        DynamicArray<Putusan> daftarPutusan = new DynamicArray<>(60);
        DynamicArray<String> logError = new DynamicArray<>(10);
        int berhasil = 0;
        int gagal = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            int nomorBaris = 0;

            while ((line = reader.readLine()) != null) {
                nomorBaris++;
                // Lewati baris header pertama
                if (nomorBaris == 1 && line.toLowerCase().startsWith("caseid,")) {
                    continue;
                }
                // Lewati baris kosong
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    Putusan p = parseDanValidasiBaris(line, nomorBaris);
                    daftarPutusan.add(p);
                    berhasil++;
                } catch (IllegalArgumentException e) {
                    gagal++;
                    logError.add("Baris " + nomorBaris + " ditolak: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            logError.add("Gagal membaca file CSV: " + e.getMessage());
        }

        return new HasilImpor(daftarPutusan, berhasil, gagal, logError);
    }

    private Putusan parseDanValidasiBaris(String line, int nomorBaris) {
        String[] kolom = splitCsvLine(line);
        if (kolom.length != 16) {
            throw new IllegalArgumentException("Jumlah kolom harus 16, ditemukan " + kolom.length);
        }

        String caseId = wajibIsi(kolom[0], "caseId");
        String nomorPerkara = wajibIsi(kolom[1], "nomorPerkara");
        String pengadilan = wajibIsi(kolom[2], "pengadilan");

        LocalDate tanggalPutusan;
        try {
            tanggalPutusan = LocalDate.parse(wajibIsi(kolom[3], "tanggalPutusan"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Format tanggalPutusan tidak valid (harus YYYY-MM-DD): " + kolom[3]);
        }

        String terdakwaKode = wajibIsi(kolom[4], "terdakwaKode");
        String jenisNarkotika = wajibIsi(kolom[5], "jenisNarkotika");

        double beratGram;
        try {
            beratGram = Double.parseDouble(kolom[6].trim());
            if (beratGram < 0) {
                throw new IllegalArgumentException("beratBarangBuktiGram tidak boleh negatif");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format beratBarangBuktiGram bukan angka: " + kolom[6]);
        }

        String pasalDakwaan = wajibIsi(kolom[7], "pasalDakwaan");
        String pasalTerbukti = wajibIsi(kolom[8], "pasalTerbukti");

        int tuntutanBulan = parseNonNegatifInt(kolom[9], "tuntutanBulan");
        int vonisBulan = parseNonNegatifInt(kolom[10], "vonisBulan");
        long dendaRupiah = parseNonNegatifLong(kolom[11], "dendaRupiah");

        String barangBukti = bersihkanKutip(kolom[12]);
        String keadaanMemberatkan = bersihkanKutip(kolom[13]);
        String keadaanMeringankan = bersihkanKutip(kolom[14]);
        String sourcePages = wajibIsi(kolom[15], "sourcePages");

        return new Putusan(
                caseId, nomorPerkara, pengadilan, tanggalPutusan,
                terdakwaKode, jenisNarkotika, beratGram,
                pasalDakwaan, pasalTerbukti, tuntutanBulan, vonisBulan,
                dendaRupiah, barangBukti, keadaanMemberatkan,
                keadaanMeringankan, sourcePages
        );
    }

    private String[] splitCsvLine(String line) {
        DynamicArray<String> tokens = new DynamicArray<>(16);
        StringBuilder current = new StringBuilder();
        boolean dalamKutip = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                dalamKutip = !dalamKutip;
            } else if (c == ',' && !dalamKutip) {
                tokens.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        tokens.add(current.toString());

        String[] hasil = new String[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            hasil[i] = tokens.get(i);
        }
        return hasil;
    }

    private String wajibIsi(String nilai, String namaKolom) {
        String bersih = bersihkanKutip(nilai);
        if (bersih.isEmpty() || bersih.equalsIgnoreCase("null")) {
            throw new IllegalArgumentException("Kolom wajib '" + namaKolom + "' kosong");
        }
        return bersih;
    }

    private int parseNonNegatifInt(String nilai, String namaKolom) {
        try {
            int val = Integer.parseInt(nilai.trim());
            if (val < 0) {
                throw new IllegalArgumentException(namaKolom + " tidak boleh negatif");
            }
            return val;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format " + namaKolom + " bukan bilangan bulat: " + nilai);
        }
    }

    private long parseNonNegatifLong(String nilai, String namaKolom) {
        try {
            long val = Long.parseLong(nilai.trim());
            if (val < 0) {
                throw new IllegalArgumentException(namaKolom + " tidak boleh negatif");
            }
            return val;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format " + namaKolom + " bukan angka valid: " + nilai);
        }
    }

    private String bersihkanKutip(String teks) {
        if (teks == null) return "";
        String t = teks.trim();
        if (t.startsWith("\"") && t.endsWith("\"") && t.length() >= 2) {
            t = t.substring(1, t.length() - 1);
        }
        return t.trim();
    }
}