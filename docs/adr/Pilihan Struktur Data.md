## ADR-001: Pemilihan Struktur Data

### Context

Project ini digunakan untuk mengolah data putusan perkara narkotika yang disimpan dalam file CSV. Data tersebut perlu bisa ditambah, dihapus, dicari, ditampilkan, dan diolah sesuai kebutuhan program.
Untuk pengelolaan data, kami menggunakan Singly Linked List dan Stack.

### Decision

Kami memilih Singly Linked List untuk menyimpan data Putusan. Struktur ini digunakan karena data putusan perlu ditambah, dihapus, dicari, dan diakses selama program berjalan.

Untuk AuditLog, kami menggunakan Stack. Stack dipilih karena menggunakan konsep LIFO (Last In, First Out), sehingga aktivitas yang terakhir dicatat dapat diambil terlebih dahulu.

### Consequences

#### Positif

- Data Putusan dapat dikelola menggunakan struktur data yang dipelajari pada mata kuliah.
- Singly Linked List dapat digunakan untuk operasi addFirst, addLast, insert, get, set, remove, dan search.
- Stack dapat digunakan untuk operasi push, pop, dan peek pada AuditLog.
- Implementasi struktur data dapat diuji menggunakan unit test.

#### Negatif

- Singly Linked List perlu melakukan traversal dari node awal ketika ingin mengakses data pada posisi tertentu.
- Pencarian data menggunakan linear search, sehingga semakin jauh posisi data yang dicari, semakin banyak node yang perlu diperiksa.
- Stack hanya dapat mengakses data yang berada pada bagian top.