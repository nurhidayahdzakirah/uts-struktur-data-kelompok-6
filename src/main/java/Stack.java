package main.java;

public class Stack<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> baru = new Node<>(data);
        baru.next = top;
        top = baru;
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }

        T hasil = top.data;
        top = top.next;
        size--;

        return hasil;
    }

    public T peek() {
        if (top == null) {
            return null;
        }

        return top.data;
    }

    public int searchReserve(T value) {
        Stack<T> sementara = new Stack<>();
        int posisi = 0;
        int hasil = -1;

        while (!isEmpty()) {
            T data = pop();

            if (data.equals(value) && hasil == -1) {
                hasil = posisi;
            }

            sementara.push(data);
            posisi++;
        }

        restore(sementara);

        return hasil;
    }

    public void restore(Stack<T> sementara) {
        Stack<T> bantu = new Stack<>();

        while (!sementara.isEmpty()) {
            bantu.push(sementara.pop());
        }

        while (!bantu.isEmpty()) {
            push(bantu.pop());
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void tampil() {
        Node<T> bantu = top;

        while (bantu != null) {
            System.out.println(bantu.data);
            bantu = bantu.next;
        }
    }

    public boolean validateInvariant() {
        int jumlah = 0;
        Node<T> bantu = top;

        while (bantu != null) {
            jumlah++;
            bantu = bantu.next;
        }

        return jumlah == size;
    }
}