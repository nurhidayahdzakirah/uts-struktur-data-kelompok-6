# UTS Struktur Data - Kelompok 6

## Identitas Kelompok

**Mata Kuliah:** Struktur Data  
**Kelompok:** 6

### Anggota
1. Nurhidayah Dzakirah
2. Nuur Syifa Rizqiya Hasanah


## Struktur Data yang Digunakan

Project ini menggunakan dua struktur data utama, yaitu:

- **Singly Linked List** untuk menyimpan dan mengelola data Putusan.
- **Stack** untuk menyimpan riwayat aktivitas pada AuditLog dengan konsep LIFO (Last In, First Out).


## Struktur Project

```text
uts-struktur-data-kelompok-6/
├── data/
│   └── putusan-50.csv
├── docs/
│   ├── adr/
│   │   └── Pilihan Struktur Data.md
│   ├── demo/
│   │   └── demo.md
│   ├── trace/
│   │   └── trace.md
│   └── data-provenance.csv
├── src/
│   ├── main.java/
│   │   ├── AuditLog.java
│   │   ├── CSVReader.java
│   │   ├── Main.java
│   │   ├── Node.java
│   │   ├── Putusan.java
│   │   ├── PutusanService.java
│   │   ├── SinglyLinkedList.java
│   │   ├── Stack.java
│   │   └── StrukturData.java
│   └── test/
│       ├── CSVReaderTest.java
│       ├── PutusanServiceTest.java
│       ├── SinglyLinkedListTest.java
│       └── StackTest.java
├── AI_USAGE.md
├── CONTRIBUTIONS.md
├── pom.xml
└── README.md
```

## Cara Build

Project dibuka menggunakan **IntelliJ IDEA**.

Untuk melakukan build:
1. Buka project di IntelliJ IDEA.
2. Pastikan seluruh source code dapat dikenali oleh IDE.
3. Pilih menu **Build → Build Project**.
4. Pastikan proses build selesai tanpa error.


## Cara Test

Pengujian dilakukan menggunakan **JUnit** melalui IntelliJ IDEA.

Untuk menjalankan seluruh test:
1. Buka folder src/test
2. Klik kanan folder test
3. Pilih **Run All Tests**.

Test yang tersedia:
- CSVReaderTest
- PutusanServiceTest
- SinglyLinkedListTest
- StackTest


## Cara Menjalankan Program

Program utama terdapat pada:

src/main.java


Untuk menjalankan program:
1. Buka Main.java
2. Jalankan method main()
3. Program akan menampilkan menu utama
4. Pilih menu sesuai fitur yang ingin digunakan


## Contoh Perintah

Contoh perintah Git yang digunakan selama pengembangan project:

- git status
- git add
- git commit -m "pesan commit"
- git push origin main


Untuk mengambil perubahan terbaru dari repository:
git pull origin main


## Fitur Program

Program digunakan untuk mengolah data putusan perkara narkotika dari file CSV.

Fitur yang tersedia:
- membaca data dari CSV
- menampilkan data putusan
-  menambah data
- menghapus data
- mencari data
- melakukan filtering
- melakukan sorting
- melakukan agregasi
- melakukan distribusi
- mencatat aktivitas melalui AuditLog
- melakukan restore menggunakan Stack


## Dokumentasi

Dokumentasi project tersedia pada folder docs/:

- docs/adr/ — Architecture Decision Record
- docs/demo/ — dokumentasi demo
- docs/trace/ — dokumentasi data trace
- docs/data-provenance.csv — data provenance

Dokumentasi kontribusi anggota ada di CONTRIBUTIONS.md

Penggunaan AI selama pengerjaan project dicatat di AI_USAGE.md