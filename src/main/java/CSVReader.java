package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CSVReader {
    public static class HasilBaca {
        SinglyLinkedList<Putusan> data;
        int valid;
        int invalid;

        public HasilBaca(SinglyLinkedList<Putusan> data, int valid, int invalid) {
            this.data = data;
            this.valid = valid;
            this.invalid = invalid;
        }
    }

    public static HasilBaca baca(String namaFile) {
        SinglyLinkedList<Putusan> data = new SinglyLinkedList<>();
        int valid = 0;
        int invalid = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(namaFile));
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] kolom = pecahCSV(line);

                    if (kolom.length != 16) {
                        invalid++;
                        continue;
                    }

                    Putusan p = buatPutusan(kolom);

                    if (p != null) {
                        data.add(p);
                        valid++;

                    } else {
                        invalid++;
                    }

                } catch (Exception e) {
                    invalid++;
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("File tidak bisa dibaca");
        }

        return new HasilBaca(data, valid, invalid);
    }

    private static String[] pecahCSV(String line) {
        String[] hasil = new String[20];
        String temp = "";
        boolean kutip = false;
        int jumlah = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                kutip = !kutip;

            } else if (c == ',' && !kutip) {
                hasil[jumlah] = temp.trim();
                jumlah++;
                temp = "";

            } else {
                temp += c;
            }
        }

        hasil[jumlah] = temp.trim();
        jumlah++;

        String[] dataAkhir = new String[jumlah];

        for (int i = 0; i < jumlah; i++) {
            dataAkhir[i] = hasil[i];
        }

        return dataAkhir;
    }

    private static Putusan buatPutusan(String[] k) {

        if (k[0].isEmpty() || k[1].isEmpty() || k[2].isEmpty()) {
            return null;
        }

        String caseId = k[0];
        String nomor = k[1];
        String pengadilan = k[2];

        LocalDate tanggal = null;

        if (!k[3].isEmpty()) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH);
            tanggal = LocalDate.parse(k[3], format);
        }

        String terdakwa = k[4];
        String narkotika = k[5];

        double berat = 0;

        if (!k[6].isEmpty()) {
            berat = Double.parseDouble(k[6].replace(",", "."));
        }

        String pasalDakwaan = k[7];
        String pasalTerbukti = k[8];

        int tuntutan = parseInt(k[9]);
        int vonis = parseInt(k[10]);
        long denda = parseLong(k[11]);

        String barangBukti = k[12];
        String memberatkan = k[13];
        String meringankan = k[14];
        String sourcePages = k[15];

        return new Putusan(caseId, nomor, pengadilan, tanggal, terdakwa, narkotika, berat, pasalDakwaan, pasalTerbukti,
                tuntutan, vonis, denda, barangBukti, memberatkan, meringankan, sourcePages);
    }

    private static int parseInt(String teks) {

        if (teks == null || teks.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(teks);
    }

    private static long parseLong(String teks) {

        if (teks == null || teks.isEmpty()) {
            return 0;
        }

        return Long.parseLong(teks);
    }
}