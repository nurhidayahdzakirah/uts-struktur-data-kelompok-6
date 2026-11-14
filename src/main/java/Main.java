package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PutusanService service = new PutusanService();

        int pilih;

        do {

            System.out.println("\n==============================");
            System.out.println("DATA PUTUSAN NARKOTIKA");
            System.out.println("==============================");
            System.out.println("\n1. Import CSV");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Tambah data");
            System.out.println("4. Hapus data");
            System.out.println("5. Cari data");
            System.out.println("6. Filter");
            System.out.println("7. Agregasi");
            System.out.println("8. Urutkan vonis");
            System.out.println("9. Audit");
            System.out.println("10. Ekspor");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    System.out.print("Nama/lokasi file CSV : ");
                    String file = input.nextLine();
                    service.importData(file);
                    break;

                case 2:
                    service.tampilData();
                    break;

                case 3:
                    tambahData(input, service);
                    break;

                case 4:
                    System.out.print("Nomor data yang dihapus : ");
                    int no = input.nextInt();
                    input.nextLine();

                    service.hapus(no - 1);
                    break;

                case 5:
                    System.out.print("Masukkan case ID/nomor perkara : ");
                    String cari = input.nextLine();
                    service.cari(cari);
                    break;

                case 6:
                    menuFilter(input, service);
                    break;

                case 7:
                    service.agregasi();
                    break;

                case 8:
                    service.urutkan();
                    break;

                case 9:
                    service.tampilAudit();
                    break;

                case 10:
                    System.out.println("1. Semua data");
                    System.out.println("2. Hasil pencarian");
                    System.out.print("Pilih : ");

                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama file : ");
                    String nama = input.nextLine();

                    if (jenis == 1) {
                        service.ekspor(nama);

                    } else if (jenis == 2) {
                        service.eksporCari(nama);

                    } else {
                        System.out.println("Pilihan salah.");
                    }

                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak ada.");
            }

        } while (pilih != 0);

        input.close();
    }

    private static void menuFilter(Scanner input, PutusanService service) {

        System.out.println("\n=== FILTER ===");
        System.out.println("1. Jenis narkotika");
        System.out.println("2. Berat barang bukti");
        System.out.println("3. Pasal terbukti");
        System.out.println("4. Vonis");
        System.out.print("Pilih : ");

        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {

            case 1:
                System.out.print("Jenis narkotika : ");
                String jenis = input.nextLine();

                service.filterJenis(jenis);
                break;

            case 2:
                System.out.print("Berat minimum : ");
                String minInput = input.nextLine();

                System.out.print("Berat maksimum : ");
                String maxInput = input.nextLine();

                double min = 0;
                double max = 0;

                if (!minInput.trim().isEmpty()) {
                    min = Double.parseDouble(minInput.replace(",", "."));
                }

                if (!maxInput.trim().isEmpty()) {
                    max = Double.parseDouble(maxInput.replace(",", "."));
                }

                service.filterBerat(min, max);
                break;

            case 3:
                System.out.print("Pasal terbukti : ");
                String pasal = input.nextLine();
                service.filterPasal(pasal);
                break;

            case 4:
                System.out.print("Vonis minimum : ");
                String minVonisInput = input.nextLine();
                System.out.print("Vonis maksimum : ");
                String maxVonisInput = input.nextLine();

                int minVonis = 0;
                int maxVonis = 0;

                if (!minVonisInput.trim().isEmpty()) {
                    minVonis = Integer.parseInt(minVonisInput);
                }

                if (!maxVonisInput.trim().isEmpty()) {
                    maxVonis = Integer.parseInt(maxVonisInput);
                }

                service.filterVonis(minVonis, maxVonis);
                break;

            default:
                System.out.println("Pilihan tidak ada.");
        }
    }

    private static void tambahData(Scanner input, PutusanService service) {

        System.out.println("\n=== TAMBAH DATA ===");
        System.out.print("Case ID: ");
        String caseId = input.nextLine();
        System.out.print("Nomor perkara: ");
        String nomor = input.nextLine();
        System.out.print("Pengadilan: ");
        String pengadilan = input.nextLine();
        System.out.print("Tanggal (dd-MMM-yy): ");
        String tanggal = input.nextLine();
        System.out.print("Kode terdakwa: ");
        String terdakwa = input.nextLine();
        System.out.print("Jenis narkotika: ");
        String narkotika = input.nextLine();
        System.out.print("Berat barang bukti: ");
        String beratInput = input.nextLine();

        double berat = 0;

        if (!beratInput.trim().isEmpty()) {
            berat = Double.parseDouble(beratInput.replace(",", "."));
        }

        System.out.print("Pasal dakwaan: ");
        String dakwaan = input.nextLine();
        System.out.print("Pasal terbukti: ");
        String terbukti = input.nextLine();
        System.out.print("Tuntutan bulan: ");
        String tuntutanInput = input.nextLine();

        int tuntutan = 0;

        if (!tuntutanInput.trim().isEmpty()) {
            tuntutan = Integer.parseInt(tuntutanInput);
        }

        System.out.print("Vonis bulan: ");
        String vonisInput = input.nextLine();

        int vonis = 0;

        if (!vonisInput.trim().isEmpty()) {
            vonis = Integer.parseInt(vonisInput);
        }

        System.out.print("Denda: ");
        String dendaInput = input.nextLine();

        long denda = 0;

        if (!dendaInput.trim().isEmpty()) {
            denda = Long.parseLong(dendaInput);
        }

        System.out.print("Barang bukti: ");
        String barang = input.nextLine();
        System.out.print("Keadaan memberatkan: ");
        String memberatkan = input.nextLine();
        System.out.print("Keadaan meringankan: ");
        String meringankan = input.nextLine();
        System.out.print("Source pages: ");
        String source = input.nextLine();

        java.time.LocalDate tanggalDate = null;

        try {

            if (!tanggal.isEmpty()) {
                java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MMM-yy", java.util.Locale.ENGLISH);
                tanggalDate = java.time.LocalDate.parse(tanggal, format);
            }

        } catch (Exception e) {
            System.out.println("Format tanggal salah");
            return;
        }

        Putusan p = new Putusan(caseId, nomor, pengadilan, tanggalDate, terdakwa, narkotika, berat, dakwaan, terbukti,
                tuntutan, vonis, denda, barang, memberatkan, meringankan, source);

        service.tambah(p);
    }
}