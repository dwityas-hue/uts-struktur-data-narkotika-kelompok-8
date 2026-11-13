package fitur;

import model.Putusan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import struktur.DynamicArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LayananPutusanATest {

    private DynamicArray<Putusan> dataset;
    private LayananPutusanA layanan;
    private CsvImporter importer;

    @BeforeEach
    void setUp() {
        layanan = new LayananPutusanA();
        importer = new CsvImporter();
        dataset = new DynamicArray<>();

        dataset.add(new Putusan("P001", "796/Pid.Sus/2019/PN Bks", "Pengadilan Negeri Bekasi",
                LocalDate.of(2019, 12, 9), "TDK-001", "Sabu", 1.99,
                "Pasal 114 Ayat (1)", "Pasal 112 Ayat (1)", 84, 60, 1000000000L,
                "1 bungkus plastik bening", "Merusak program pemerintah", "Sopan", "hal 1;2"));

        dataset.add(new Putusan("P011", "102/Pid.Sus/2023/PN Bks", "Pengadilan Negeri Bekasi",
                LocalDate.of(2023, 3, 15), "TDK-011", "Ganja", 12.5,
                "Pasal 111 Ayat (1)", "Pasal 111 Ayat (1)", 48, 36, 600000000L,
                "1 bungkus ganja kering", "Merusak generasi muda", "Belum pernah dihukum", "hal 1;3"));

        dataset.add(new Putusan("P012", "215/Pid.Sus/2023/PN Bks", "Pengadilan Negeri Bekasi",
                LocalDate.of(2023, 6, 22), "TDK-012", "Ekstasi", 0.75,
                "Pasal 114 Ayat (1)", "Pasal 114 Ayat (1)", 60, 72, 800000000L,
                "2 butir pil ekstasi", "Meresahkan masyarakat", "Mengaku bersalah", "hal 2;4"));
    }

    // --- SKENARIO 1: Impor CSV & Validasi Data ---
    @Test
    void testSkenario1_ImporCsvDatasetUtama() {
        CsvImporter.HasilImpor hasil = importer.imporDariCsv("data/putusan-50.csv");

        assertEquals(50, hasil.getJumlahBerhasil(), "Harus berhasil mengimpor 50 data putusan valid.");
        assertEquals(0, hasil.getJumlahGagal(), "Dataset utama tidak boleh memiliki baris rusak.");
        assertEquals(50, hasil.getDataValid().size());
        assertEquals("P001", hasil.getDataValid().get(0).getCaseId());
        assertEquals("P050", hasil.getDataValid().get(49).getCaseId());
    }

    @Test
    void testSkenario1_ValidasiBarisRusakTidakMenghentikanProgram(@TempDir Path tempDir) throws IOException {
        Path csvCampuran = tempDir.resolve("uji-validasi.csv");
        String konten = String.join("\n",
                "caseId,nomorPerkara,pengadilan,tanggalPutusan,terdakwaKode,jenisNarkotika,beratBarangBuktiGram,pasalDakwaan,pasalTerbukti,tuntutanBulan,vonisBulan,dendaRupiah,barangBukti,keadaanMemberatkan,keadaanMeringankan,sourcePages",
                "P001,796/Pid.Sus/2019/PN Bks,PN Bekasi,2019-12-09,TDK-001,Sabu,1.99,Pasal 114,Pasal 112,84,60,1000000000,\"Klip sabu, HP\",Memberatkan,Meringankan,hal 1",
                "P002,KOLOM_KURANG,PN Bekasi,2020-01-01",
                "P003,123/Pid.Sus/2020,PN Bekasi,TANGGAL_SALAH,TDK-003,Ganja,5.0,Pasal 111,Pasal 111,48,36,500000000,Ganja,Memberatkan,Meringankan,hal 2",
                "P004,124/Pid.Sus/2020,PN Bekasi,2020-05-10,TDK-004,Sabu,-2.5,Pasal 112,Pasal 112,48,36,500000000,Sabu,Memberatkan,Meringankan,hal 3"
        );
        Files.writeString(csvCampuran, konten);

        CsvImporter.HasilImpor hasil = importer.imporDariCsv(csvCampuran.toString());

        assertEquals(1, hasil.getJumlahBerhasil(), "Hanya 1 baris valid yang boleh masuk.");
        assertEquals(3, hasil.getJumlahGagal(), "3 baris tidak valid harus ditolak dan dicatat.");
        assertEquals(3, hasil.getLogError().size());
    }

    // --- SKENARIO 2: Pencarian & Step Count ---
    @Test
    void testSkenario2_CariDitemukanDanStepCount() {
        LayananPutusanA.HasilPencarian hasil = layanan.cariByIdAtauNomorPerkara(dataset, "102/pid.sus/2023/pn bks");

        assertTrue(hasil.isDitemukan());
        assertNotNull(hasil.getPutusan());
        assertEquals("P011", hasil.getPutusan().getCaseId());
        assertEquals(2, hasil.getStepCount(), "P011 berada di indeks ke-1 sehingga membutuhkan 2 langkah.");
    }

    @Test
    void testSkenario2_CariTidakDitemukan() {
        LayananPutusanA.HasilPencarian hasil = layanan.cariByIdAtauNomorPerkara(dataset, "P999");

        assertFalse(hasil.isDitemukan());
        assertNull(hasil.getPutusan());
        assertEquals(3, hasil.getStepCount(), "Harus memeriksa seluruh 3 elemen sebelum menyatakan tidak ditemukan.");
    }

    // --- SKENARIO 3: Filter Multi-Kriteria ---
    @Test
    void testSkenario3_FilterKriteria() {
        DynamicArray<Putusan> hasilJenis = layanan.filterByJenisNarkotika(dataset, "Sabu");
        assertEquals(1, hasilJenis.size());
        assertEquals("P001", hasilJenis.get(0).getCaseId());

        DynamicArray<Putusan> hasilBerat = layanan.filterByRentangBerat(dataset, 1.0, 15.0);
        assertEquals(2, hasilBerat.size());

        DynamicArray<Putusan> hasilPasal = layanan.filterByPasalTerbukti(dataset, "Pasal 114");
        assertEquals(1, hasilPasal.size());
        assertEquals("P012", hasilPasal.get(0).getCaseId());

        DynamicArray<Putusan> hasilVonis = layanan.filterByRentangVonis(dataset, 48, 72);
        assertEquals(2, hasilVonis.size());
    }

    // --- SKENARIO 7: Kasus Batas (Edge Cases) ---
    @Test
    void testSkenario7_KasusBatasKosongDanRentangInvalid() {
        DynamicArray<Putusan> kosong = new DynamicArray<>();

        LayananPutusanA.HasilPencarian cariKosong = layanan.cariByIdAtauNomorPerkara(kosong, "P001");
        assertFalse(cariKosong.isDitemukan());
        assertEquals(0, cariKosong.getStepCount());

        assertEquals(0, layanan.filterByJenisNarkotika(kosong, "Sabu").size());
        assertEquals(0, layanan.filterByPasalTerbukti(dataset, "").size());

        assertThrows(IllegalArgumentException.class, () ->
                layanan.filterByRentangBerat(dataset, 10.0, 2.0), "minGram > maxGram harus melempar exception.");

        assertThrows(IllegalArgumentException.class, () ->
                layanan.filterByRentangVonis(dataset, -5, 60), "minBulan negatif harus melempar exception.");
    }
}