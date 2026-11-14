import main.java.CSVReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

    @Test
    void testBacaFileCSV() {
        String file = "data/putusan-50.csv";

        CSVReader.HasilBaca hasil = CSVReader.baca(file);

        assertNotNull(hasil);
        assertNotNull(hasil.getData());
        assertTrue(hasil.getValid() >= 0);
        assertTrue(hasil.getInvalid() >= 0);
    }

    @Test
    void testJumlahDataValidDanInvalid() {
        String file = "data/putusan-50.csv";

        CSVReader.HasilBaca hasil = CSVReader.baca(file);

        int total = hasil.getValid() + hasil.getInvalid();

        assertEquals(50, total);
    }

    @Test
    void testDataBerhasilDibaca() {
        String file = "data/putusan-50.csv";

        CSVReader.HasilBaca hasil = CSVReader.baca(file);

        assertTrue(hasil.getValid() > 0);
        assertFalse(hasil.getData().isEmpty());
    }

    @Test
    void testFileTidakAda() {
        String file = "data/file-tidak-ada.csv";

        CSVReader.HasilBaca hasil = CSVReader.baca(file);

        assertNotNull(hasil);
        assertNotNull(hasil.getData());
    }
}