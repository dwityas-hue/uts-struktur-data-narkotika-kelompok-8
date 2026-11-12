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
     * Mencari putusan berdasarkan caseId atau nomorPerkara (case-insensitive)
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
}