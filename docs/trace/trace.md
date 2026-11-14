Trace Operasi Struktur Data
Dokumen ini menunjukkan contoh proses operasi struktur data yang digunakan dalam project.
1. Trace Singly Linked List

Data awal: P001 → P002 → P003

    Add First

Operasi: addFirst(P000)

Proses: P000 → P001 → P002 → P003

Elemen P000 menjadi node pertama atau head.

    Add Last

Operasi: addLast(P004)

Hasil: P000 → P001 → P002 → P003 → P004

Elemen baru ditambahkan pada bagian akhir list.

    Search

Pencarian: search(P003)
Proses linear search:
P000 → P001 → P002 → P003
0      1      2      3

P003 ditemukan pada posisi

2. Trace main.java.Stack

Data awal main.java.Stack:
TOP
↓
P003
P002
P001

    Push
Operasi: push(P004)
Hasil:
TOP
↓
P004
P003
P002
P001

P004 menjadi elemen paling atas.

    Pop
Operasi: pop()

Elemen yang diambil:P004

main.java.Stack kembali menjadi:
TOP
↓
P003
P002
P001

Hal ini menunjukkan prinsip LIFO (Last In, First Out).

    Search Reserve
Pada operasi searchReserve, main.java.Stack digunakan sementara untuk mencari data tanpa mengubah urutan akhir main.java.Stack.

Contoh:
main.java.Stack awal:

TOP
↓
P003
P002
P001
Mencari P002.

Data dikeluarkan sementara sampai P002 ditemukan, kemudian data dikembalikan menggunakan proses restore.

Hasil akhir:
TOP
↓
P003
P002
P001

Urutan main.java.Stack tetap sama seperti sebelum pencarian.

3. Invariant

   Setelah operasi struktur data dilakukan, program menjalankan validateInvariant().

   Pada Singly Linked List, jumlah node yang ditelusuri harus sama dengan nilai size.

   Pada main.java.Stack, jumlah node dari top sampai akhir juga harus sama dengan nilai size.

   Jika kondisi terpenuhi, struktur data dinyatakan valid.
