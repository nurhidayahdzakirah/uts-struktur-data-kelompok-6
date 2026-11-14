package main.java;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PutusanServiceTest {
    private final String fileCSV = "data/putusan-50.csv";

    @Test
    void testImportData() {
        PutusanService service = new PutusanService();
        String output = tangkapOutput(() -> service.importData(fileCSV));

        assertTrue(output.contains("Import selesai"));
        assertTrue(output.contains("Data valid:"));
        assertTrue(output.contains("Data invalid:"));
    }

    @Test
    void testCariData() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        String output = tangkapOutput(() -> service.cari("P001"));
        assertTrue(output.contains("Data ditemukan:") || output.contains("Data tidak ditemukan."));
        assertTrue(output.contains("Jumlah langkah:"));
    }

    @Test
    void testFilterJenis() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        String output = tangkapOutput(() -> service.filterJenis("shabu"));
        assertTrue(output.contains("=== HASIL ===") || output.contains("Tidak ada data"));
    }

    @Test
    void testFilterBerat() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        String output = tangkapOutput(() -> service.filterBerat(0, 1000));
        assertTrue(output.contains("=== HASIL ===") || output.contains("Tidak ada data"));
    }

    @Test
    void testFilterPasal() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        String output = tangkapOutput(() -> service.filterPasal("112"));
        assertTrue(output.contains("=== HASIL ===") || output.contains("Tidak ada data"));
    }

    @Test
    void testFilterVonis() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        String output = tangkapOutput(() -> service.filterVonis(1, 200));
        assertTrue(output.contains("=== HASIL ===") || output.contains("Tidak ada data"));
    }

    @Test
    void testUrutkan() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);
        String output = tangkapOutput(service::urutkan);

        assertTrue(output.contains("Data berhasil diurutkan"));
        assertTrue(output.contains("Sebelum : true"));
        assertTrue(output.contains("Sesudah : true"));
    }

    @Test
    void testCekData() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        String output = tangkapOutput(service::cekData);
        assertTrue(output.contains("Data aman") || output.contains("Data bermasalah"));
    }

    @Test
    void testAgregasi() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        String output = tangkapOutput(service::agregasi);
        assertTrue(output.contains("=== AGREGASI ===") || output.contains("Data masih kosong"));
    }

    @Test
    void testEksporData() {
        PutusanService service = new PutusanService();
        service.importData(fileCSV);

        File file = new File("data/test-ekspor.csv");

        if (file.exists()) {
            file.delete();
        }

        String output = tangkapOutput(
                () -> service.ekspor(file.getPath())
        );

        assertTrue(file.exists());
        assertTrue(output.contains("Data berhasil diekspor"));

        file.delete();
    }

    @Test
    void testEksporCari() {
        PutusanService service = new PutusanService();

        service.importData(fileCSV);
        service.cari("P001");

        File file = new File("data/test-ekspor-cari.csv");

        if (file.exists()) {
            file.delete();
        }

        String output = tangkapOutput(() -> service.eksporCari(file.getPath()));

        assertTrue(output.contains("Hasil pencarian berhasil diekspor") || output.contains("Belum ada hasil pencarian"));

        if (file.exists()) {
            file.delete();
        }
    }

    private String tangkapOutput(Runnable aksi) {
        PrintStream outputLama = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream outputBaru = new PrintStream(buffer);
        System.setOut(outputBaru);

        try {
            aksi.run();
        } finally {
            System.setOut(outputLama);
        }

        return buffer.toString();
    }
}
