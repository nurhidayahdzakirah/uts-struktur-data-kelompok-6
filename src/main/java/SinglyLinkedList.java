package main.java;

public class SinglyLinkedList<T> implements StrukturData<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        Node<T> baru = new Node<>(value);
        baru.next = head;
        head = baru;
        size++;
    }

    public void addLast(T value) {
        Node<T> baru = new Node<>(value);

        if (head == null) {
            head = baru;
        } else {
            Node<T> bantu = head;

            while (bantu.next != null) {
                bantu = bantu.next;
            }

            bantu.next = baru;
        }

        size++;
    }

    public void insert(int position, T value) {
        if (position < 0 || position > size) {
            return;
        }

        if (position == 0) {
            addFirst(value);
            return;
        }

        if (position == size) {
            addLast(value);
            return;
        }

        Node<T> baru = new Node<>(value);
        Node<T> bantu = head;

        for (int i = 0; i < position - 1; i++) {
            bantu = bantu.next;
        }

        baru.next = bantu.next;
        bantu.next = baru;
        size++;
    }

    @Override
    public T get(int position) {

        if (position < 0 || position >= size) {
            return null;
        }

        Node<T> bantu = head;

        for (int i = 0; i < position; i++) {
            bantu = bantu.next;
        }

        return bantu.data;
    }

    @Override
    public T remove(int position) {

        if (position < 0 || position >= size) {
            return null;
        }

        if (position == 0) {
            T hasil = head.data;
            head = head.next;
            size--;

            return hasil;
        }

        Node<T> bantu = head;

        for (int i = 0; i < position - 1; i++) {
            bantu = bantu.next;
        }

        T hasil = bantu.next.data;
        bantu.next = bantu.next.next;

        size--;

        return hasil;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {

        Node<T> bantu = head;

        while (bantu != null) {
            if (bantu.data.equals(value)) {
                return true;
            }

            bantu = bantu.next;
        }

        return false;
    }

    public int search(T value) {
        Node<T> bantu = head;
        int posisi = 0;

        while (bantu != null) {
            if (bantu.data.equals(value)) {
                return posisi;
            }

            bantu = bantu.next;
            posisi++;
        }

        return -1;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    public void set(int position, T value) {

        if (position < 0 || position >= size) {
            return;
        }

        Node<T> bantu = head;

        for (int i = 0; i < position; i++) {
            bantu = bantu.next;
        }

        bantu.data = value;
    }

    public void swap(int a, int b) {
        T temp = get(a);
        set(a, get(b));
        set(b, temp);
    }

    public void tampil() {
        Node<T> bantu = head;
        int no = 1;

        while (bantu != null) {
            System.out.println(no + ". " + bantu.data);
            bantu = bantu.next;
            no++;
        }
    }

    public boolean cekData() {
        int jumlah = 0;
        Node<T> bantu = head;

        while (bantu != null) {
            jumlah++;
            bantu = bantu.next;
        }

        return jumlah == size;
    }

    public boolean validateInvariant() {
        if (size == 0 && head != null) {
            return false;
        }

        if (size > 0 && head == null) {
            return false;
        }

        int jumlah = 0;
        Node<T> bantu = head;

        while (bantu != null) {
            jumlah++;
            bantu = bantu.next;
        }

        return jumlah == size;
    }
}