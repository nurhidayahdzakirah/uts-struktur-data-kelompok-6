package test;

import main.CSVReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

    @Test
    void testBacaCSV() {
        CSVReader.HasilBaca hasil =
                CSVReader.baca("data/putusan-50.csv");

        assertNotNull(hasil);
        assertNotNull(hasil.getData());

        assertTrue(hasil.getValid() >= 0);
        assertTrue(hasil.getInvalid() >= 0);

        assertEquals(
                hasil.getValid(),
                hasil.getData().size()
        );
    }

    @Test
    void testDataTidakKosong() {
        CSVReader.HasilBaca hasil =
                CSVReader.baca("data/putusan-50.csv");

        assertTrue(hasil.getData().size() > 0);
    }

    @Test
    void testFileTidakDitemukan() {
        CSVReader.HasilBaca hasil =
                CSVReader.baca("data/file-tidak-ada.csv");

        assertNotNull(hasil);
        assertNotNull(hasil.getData());
    }
}