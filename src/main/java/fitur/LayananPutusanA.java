package fitur;

import model.Putusan;
import struktur.DynamicArray;

public class LayananPutusanA {

    public static class HasilPencarian {
        private final Putusan putusan;
        private final int stepCount;
        private final boolean ditemukan;

        public HasilPencarian(Putusan putusan, int stepCount, boolean ditemukan) {
            this.putusan = putusan;
            this.stepCount = stepCount;
            this.ditemukan = ditemukan;
        }

        public Putusan getPutusan() {
            return putusan;
        }

        public int getStepCount() {
            return stepCount;
        }

        public boolean isDitemukan() {
            return ditemukan;
        }
    }

    /**
     * Issue #3: Mencari putusan berdasarkan caseId atau nomorPerkara (case-insensitive)
     * menggunakan struktur data utama DynamicArray dan mencatat step count.
     */
    public HasilPencarian cariByIdAtauNomorPerkara(DynamicArray<Putusan> daftarPutusan, String kataKunci) {
        if (daftarPutusan == null || kataKunci == null || kataKunci.trim().isEmpty()) {
            return new HasilPencarian(null, 0, false);
        }

        String target = kataKunci.trim();
        int stepCount = 0;

        for (int i = 0; i < daftarPutusan.size(); i++) {
            stepCount++;
            Putusan p = daftarPutusan.get(i);
            if (p == null) {
                continue;
            }

            boolean cocokCaseId = p.getCaseId() != null && p.getCaseId().equalsIgnoreCase(target);
            boolean cocokNomorPerkara = p.getNomorPerkara() != null && p.getNomorPerkara().equalsIgnoreCase(target);

            if (cocokCaseId || cocokNomorPerkara) {
                return new HasilPencarian(p, stepCount, true);
            }
        }

        return new HasilPencarian(null, stepCount, false);
    }

    /**
     * Issue #4.1: Filter berdasarkan jenis narkotika (misal: "Sabu", "Ganja", "Ekstasi").
     */
    public DynamicArray<Putusan> filterByJenisNarkotika(DynamicArray<Putusan> daftarPutusan, String jenis) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();
        if (daftarPutusan == null || jenis == null || jenis.trim().isEmpty()) {
            return hasil;
        }

        String target = jenis.trim();
        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            if (p != null && p.getJenisNarkotika() != null && p.getJenisNarkotika().equalsIgnoreCase(target)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    /**
     * Issue #4.2: Filter berdasarkan rentang berat barang bukti (dalam gram, inklusif).
     */
    public DynamicArray<Putusan> filterByRentangBerat(DynamicArray<Putusan> daftarPutusan, double minGram, double maxGram) {
        if (minGram < 0 || maxGram < 0 || minGram > maxGram) {
            throw new IllegalArgumentException("Rentang berat barang bukti tidak valid (minGram harus <= maxGram dan >= 0).");
        }

        DynamicArray<Putusan> hasil = new DynamicArray<>();
        if (daftarPutusan == null) {
            return hasil;
        }

        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            if (p != null) {
                double berat = p.getBeratBarangBuktiGram();
                if (berat >= minGram && berat <= maxGram) {
                    hasil.add(p);
                }
            }
        }
        return hasil;
    }

    /**
     * Issue #4.3: Filter berdasarkan pasal terbukti (mendukung pencocokan sebagian/substring, misal "Pasal 114").
     */
    public DynamicArray<Putusan> filterByPasalTerbukti(DynamicArray<Putusan> daftarPutusan, String pasal) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();
        if (daftarPutusan == null || pasal == null || pasal.trim().isEmpty()) {
            return hasil;
        }

        String target = pasal.trim().toLowerCase();
        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            if (p != null && p.getPasalTerbukti() != null && p.getPasalTerbukti().toLowerCase().contains(target)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    /**
     * Issue #4.4: Filter berdasarkan rentang lama vonis pidana penjara (dalam bulan, inklusif).
     */
    public DynamicArray<Putusan> filterByRentangVonis(DynamicArray<Putusan> daftarPutusan, int minBulan, int maxBulan) {
        if (minBulan < 0 || maxBulan < 0 || minBulan > maxBulan) {
            throw new IllegalArgumentException("Rentang vonis bulan tidak valid (minBulan harus <= maxBulan dan >= 0).");
        }

        DynamicArray<Putusan> hasil = new DynamicArray<>();
        if (daftarPutusan == null) {
            return hasil;
        }

        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            if (p != null) {
                int vonis = p.getVonisBulan();
                if (vonis >= minBulan && vonis <= maxBulan) {
                    hasil.add(p);
                }
            }
        }
        return hasil;
    }

    /**
     * Issue #4.5: Filter multi-kriteria (opsional: parameter null atau < 0 akan diabaikan).
     */
    public DynamicArray<Putusan> filterKombinasi(
            DynamicArray<Putusan> daftarPutusan,
            String jenisNarkotika,
            Double minBeratGram,
            Double maxBeratGram,
            String pasalTerbukti,
            Integer minVonisBulan,
            Integer maxVonisBulan) {

        DynamicArray<Putusan> hasil = new DynamicArray<>();
        if (daftarPutusan == null) {
            return hasil;
        }

        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            if (p == null) {
                continue;
            }

            if (jenisNarkotika != null && !jenisNarkotika.trim().isEmpty()) {
                if (p.getJenisNarkotika() == null || !p.getJenisNarkotika().equalsIgnoreCase(jenisNarkotika.trim())) {
                    continue;
                }
            }

            if (minBeratGram != null && p.getBeratBarangBuktiGram() < minBeratGram) {
                continue;
            }
            if (maxBeratGram != null && p.getBeratBarangBuktiGram() > maxBeratGram) {
                continue;
            }

            if (pasalTerbukti != null && !pasalTerbukti.trim().isEmpty()) {
                if (p.getPasalTerbukti() == null || !p.getPasalTerbukti().toLowerCase().contains(pasalTerbukti.trim().toLowerCase())) {
                    continue;
                }
            }

            if (minVonisBulan != null && p.getVonisBulan() < minVonisBulan) {
                continue;
            }
            if (maxVonisBulan != null && p.getVonisBulan() > maxVonisBulan) {
                continue;
            }

            hasil.add(p);
        }
        return hasil;
    }
}