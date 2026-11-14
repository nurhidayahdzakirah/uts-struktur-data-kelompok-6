package main.java;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PutusanService {
    private SinglyLinkedList<Putusan> data;
    private AuditLog audit;
    private SinglyLinkedList<Putusan> hasilCari;

    public PutusanService() {
        data = new SinglyLinkedList<>();
        audit = new AuditLog();
        hasilCari = new SinglyLinkedList<>();
    }

    public void importData(String file) {
        CSVReader.HasilBaca hasil = CSVReader.baca(file);
        data = hasil.data;

        audit.catat("Import CSV");

        System.out.println("\nImport selesai");
        System.out.println("Data valid: " + hasil.valid);
        System.out.println("Data invalid: " + hasil.invalid);
    }

    public void tampilData() {
        if (data.isEmpty()) {
            System.out.println("Data masih kosong");
            return;
        }

        System.out.println("\n=== DATA PUTUSAN ===");
        data.tampil();
    }

    public void tambah(Putusan p) {
        data.add(p);

        audit.catat("Tambah " + p.getCaseId());

        System.out.println("Data berhasil ditambah");
    }

    public void hapus(int posisi) {
        Putusan p = data.remove(posisi);

        if (p == null) {
            System.out.println("Data tidak ditemukan");
            return;
        }

        audit.catat("Hapus " + p.getCaseId());

        System.out.println("Data berhasil dihapus");
    }

    public void cari(String keyword) {
        hasilCari.clear();

        int langkah = 0;

        for (int i = 0; i < data.size(); i++) {
            langkah++;

            Putusan p = data.get(i);

            if (p.getCaseId().toLowerCase().contains(keyword.toLowerCase()) || p.getNomorPerkara().toLowerCase().contains(keyword.toLowerCase())) {
                hasilCari.add(p);
            }
        }

        if (hasilCari.isEmpty()) {
            System.out.println("Data tidak ditemukan.");
        } else {
            System.out.println("\nData ditemukan:");
            hasilCari.tampil();
            System.out.println("Jumlah data ditemukan: " + hasilCari.size());
        }

        System.out.println("Jumlah langkah: " + langkah);

        audit.catat("Cari " + keyword);
    }

    public void filterJenis(String jenis) {
        SinglyLinkedList<Putusan> hasil = new SinglyLinkedList<>();

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);

            if (p.getJenisNarkotika().toLowerCase().contains(jenis.toLowerCase())) {
                hasil.add(p);
            }
        }

        tampilHasil(hasil);

        audit.catat("Filter jenis " + jenis);
    }

    public void filterBerat(double min, double max) {
        SinglyLinkedList<Putusan> hasil = new SinglyLinkedList<>();

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);
            double berat = p.getBeratBarangBuktiGram();

            if (berat >= min && berat <= max) {
                hasil.add(p);
            }
        }

        tampilHasil(hasil);

        audit.catat("Filter berat");
    }

    public void filterPasal(String pasal) {
        SinglyLinkedList<Putusan> hasil = new SinglyLinkedList<>();

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);

            if (p.getPasalTerbukti().toLowerCase().contains(pasal.toLowerCase())) {
                hasil.add(p);
            }
        }

        tampilHasil(hasil);

        audit.catat("Filter pasal " + pasal);
    }

    public void filterVonis(int min, int max) {
        SinglyLinkedList<Putusan> hasil = new SinglyLinkedList<>();

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);
            int vonis = p.getVonisBulan();

            if (vonis >= min && vonis <= max) {
                hasil.add(p);
            }
        }

        tampilHasil(hasil);

        audit.catat("Filter vonis");
    }

    private void tampilHasil(SinglyLinkedList<Putusan> hasil) {
        if (hasil.isEmpty()) {
            System.out.println("Tidak ada data");
            return;
        }

        System.out.println("\n=== HASIL ===");
        hasil.tampil();
    }

    public void agregasi() {
        if (data.isEmpty()) {
            System.out.println("Data masih kosong");
            return;
        }

        int jumlah = data.size();
        int totalVonis = 0;
        long totalDenda = 0;

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);

            totalVonis += p.getVonisBulan();
            totalDenda += p.getDendaRupiah();
        }

        double rata = (double) totalVonis / jumlah;

        System.out.println("\n=== AGREGASI ===");
        System.out.println("Jumlah perkara: " + jumlah);
        System.out.println("Rata-rata vonis: " + rata + " bulan");
        System.out.println("Total denda: Rp " + totalDenda);

        distribusi();

        audit.catat("Lihat agregasi");
    }

    private void distribusi() {
        String[] jenis = new String[data.size()];
        int[] jumlah = new int[data.size()];
        int banyak = 0;

        for (int i = 0; i < data.size(); i++) {
            String nama = data.get(i).getJenisNarkotika();
            int posisi = -1;

            for (int j = 0; j < banyak; j++) {
                if (jenis[j].equalsIgnoreCase(nama)) {
                    posisi = j;
                    break;
                }
            }

            if (posisi == -1) {
                jenis[banyak] = nama;
                jumlah[banyak] = 1;
                banyak++;
            } else {
                jumlah[posisi]++;
            }
        }

        System.out.println("\nDistribusi narkotika:");

        for (int i = 0; i < banyak; i++) {
            System.out.println("- " + jenis[i] + " : " + jumlah[i]);
        }
    }

    public void urutkan() {
        boolean sebelum = data.validateInvariant();

        for (int i = 0; i < data.size() - 1; i++) {
            int min = i;

            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).getVonisBulan() < data.get(min).getVonisBulan()) {
                    min = j;
                }
            }

            if (min != i) {
                data.swap(i, min);
            }
        }

        boolean sesudah = data.validateInvariant();

        System.out.println("Data berhasil diurutkan");
        System.out.println("Sebelum : " + sebelum);
        System.out.println("Sesudah : " + sesudah);

        audit.catat("Urutkan berdasarkan vonis");
    }

    public void tampilAudit() {
        audit.tampilkan();
    }

    public void cekData() {
        if (data.validateInvariant()) {
            System.out.println("Data aman");
        } else {
            System.out.println("Data bermasalah");
        }
    }

    public void ekspor(String file) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file));

            for (int i = 0; i < data.size(); i++) {
                Putusan p = data.get(i);

                out.println(p.getCaseId() + "," + p.getNomorPerkara() + "," + p.getPengadilan() + "," + p.getTanggalPutusan() + ","
                        + p.getTerdakwaKode() + "," + p.getJenisNarkotika() + "," + p.getBeratBarangBuktiGram() + ","
                        + p.getPasalDakwaan() + "," + p.getPasalTerbukti() + "," + p.getTuntutanBulan() + ","
                        + p.getVonisBulan() + "," + p.getDendaRupiah() + "," + p.getBarangBukti() + ","
                        + p.getKeadaanMemberatkan() + "," + p.getKeadaanMeringankan() + "," + p.getSourcePages());
            }

            out.close();

            audit.catat("Ekspor data");
            System.out.println("Data berhasil diekspor");

        } catch (Exception e) {
            System.out.println("Gagal mengekspor data");
        }
    }

    public void eksporCari(String file) {
        if (hasilCari.isEmpty()) {
            System.out.println("Belum ada hasil pencarian");
            return;
        }

        try {
            PrintWriter out = new PrintWriter(new FileWriter(file));

            for (int i = 0; i < hasilCari.size(); i++) {
                Putusan p = hasilCari.get(i);

                out.println(
                        p.getCaseId() + "," + p.getNomorPerkara() + "," + p.getPengadilan() + "," + p.getTanggalPutusan() + ","
                                + p.getTerdakwaKode() + "," + p.getJenisNarkotika() + "," + p.getBeratBarangBuktiGram() + ","
                                + p.getPasalDakwaan() + "," + p.getPasalTerbukti() + "," + p.getTuntutanBulan() + ","
                                + p.getVonisBulan() + "," + p.getDendaRupiah() + "," + p.getBarangBukti() + ","
                                + p.getKeadaanMemberatkan() + "," + p.getKeadaanMeringankan() + "," + p.getSourcePages());
            }

            out.close();

            System.out.println("Hasil pencarian berhasil diekspor");

        } catch (Exception e) {
            System.out.println("File gagal di ekspor");
        }
    }
}