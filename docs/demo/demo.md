Dokumentasi Demo

Tujuan Demo

Demo bertujuan menunjukkan bahwa program dapat membaca, mengelola, mencari, mengurutkan, dan mengolah data putusan perkara narkotika menggunakan Singly Linked List dan main.java.Stack.

Urutan Demo
    
    1. Menjalankan Program
   Program dijalankan melalui class main.java.Main.
   
Menu utama akan ditampilkan:
1. Import CSV
2. Tampilkan data
3. Tambah data
4. Hapus data
5. Cari data
6. Filter
7. Agregasi
8. Urutkan vonis
9. Audit
10. Ekspor
0. Keluar


    2. Import Data
   Pilih menu:

1.Import CSV

   Masukkan lokasi file:
   data/putusan-50.csv
   
Program membaca data menggunakan main.java.CSVReader dan menyimpan data valid ke dalam main.java.SinglyLinkedList.

Output menampilkan jumlah data valid dan invalid.

    3. Menampilkan Data
   Pilih:
2. Tampilkan data
   
Program menampilkan data putusan yang tersimpan di Singly Linked List.

    4. Pencarian Data
   Pilih:
5. Cari data
  
Masukkan caseId atau nomor perkara.

Program melakukan pencarian secara linear melalui data pada Singly Linked List dan menampilkan jumlah langkah pencarian.

    5. Filter Data

Pilih:
6. Filter
   
Filter yang tersedia:
   - Jenis narkotika
   - Berat barang bukti
   - Pasal terbukti
   - Vonis

    6.Agregasi
   Pilih:
7. Agregasi
   
Program menampilkan:
   - jumlah perkara
   - rata-rata vonis
   - total denda
   - distribusi jenis narkotika

    7.Sorting
Pilih:
8. Urutkan vonis

Program mengurutkan data berdasarkan lama vonis menggunakan Selection Sort.
   
Sebelum dan sesudah proses sorting, program memeriksa validateInvariant() untuk memastikan struktur data tetap valid.

    8.Audit
   Pilih:
9. Audit
   
Riwayat aktivitas ditampilkan menggunakan main.java.Stack.
   
Aktivitas terakhir akan ditampilkan terlebih dahulu karena main.java.Stack menerapkan prinsip LIFO.

    9.Ekspor
   Pilih:
10. Ekspor
    
Pengguna dapat memilih:
1. Semua data
2. Hasil pencarian
   
Data kemudian disimpan ke file CSV.
   
Poin yang Ditunjukkan Saat Demo

  - Implementasi Singly Linked List.
  - Implementasi main.java.Stack.
  - Operasi tambah, hapus, cari, dan ambil data.
  - Linear search.
  - Selection Sort.
  - Audit log menggunakan main.java.Stack.
  - Validasi invariant.
  - Import dan ekspor data CSV.
  - Pengolahan data putusan narkotika.
