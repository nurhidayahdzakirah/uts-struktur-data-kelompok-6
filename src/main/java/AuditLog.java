package main.java;

public class AuditLog {

    private Stack<String> riwayat;

    public AuditLog() {
        riwayat = new Stack<>();
    }

    public void catat(String teks) {
        riwayat.push(teks);
    }

    public void tampilkan() {

        if (riwayat.isEmpty()) {
            System.out.println("Belum ada riwayat");
            return;
        }

        System.out.println("\n=== RIWAYAT ===");
        riwayat.tampil();
    }
}