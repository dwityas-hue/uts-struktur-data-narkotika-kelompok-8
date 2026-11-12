package fitur;

import model.Putusan;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LayananPutusanB {

    // 1. Fitur Agregasi: Rata-rata vonis pidana penjara (dalam bulan)
    public double hitungRataRataVonis(Putusan[] data, int size) {
        if (size == 0) return 0.0;
        double totalVonis = 0;
        for (int i = 0; i < size; i++) {
            totalVonis += data[i].getVonisBulan();
        }
        return totalVonis / size;
    }

    // Fitur Agregasi: Total pidana denda (dalam Rupiah)[cite: 1, 7]
    public long hitungTotalDenda(Putusan[] data, int size) {
        long totalDenda = 0;
        for (int i = 0; i < size; i++) {
            totalDenda += data[i].getDendaRupiah();
        }
        return totalDenda;
    }

    // 2. Fitur Pengurutan Data (Sorting): Bubble Sort Ascending berdasarkan vonisBulan[cite: 1, 7]
    public void urutkanBerdasarkanVonisAsc(Putusan[] data, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j].getVonisBulan() > data[j + 1].getVonisBulan()) {
                    Putusan temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // 3. Fitur Ekspor Hasil ke CSV[cite: 1, 7]
    public void eksporKeCSV(Putusan[] data, int size, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("caseId,nomorPerkara,pengadilan,tanggalPutusan,terdakwaKode,jenisNarkotika,beratBarangBuktiGram,pasalDakwaan,pasalTerbukti,tuntutanBulan,vonisBulan,dendaRupiah,barangBukti,keadaanMemberatkan,keadaanMeringankan,sourcePages\n");
            for (int i = 0; i < size; i++) {
                writer.write(data[i].toCSV());
                writer.newLine();
            }
        }
    }
}