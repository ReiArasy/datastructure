package praktikum6_Stack.jurnalmandiri_praktikum6;

import java.io.*;
import java.util.Scanner;

class Barang {
    private int id;
    private String nama;
    private int stok;

    public Barang(int id, String nama, int stok) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public String info() {
        return id + " " + nama + " " + stok;
    }
}

class Node {
    Barang data;
    Node next;

    Node(Barang d) {
        data = d;
        next = null;
    }
}

public class StackList {
    Node top; // top of stack
    Scanner inp = new Scanner(System.in);

    public void push(Barang data) {
        Node newNode = new Node(data);

        if (top == null) {
            // Kasus 1. Jika stack empty
            // maka top diisi dengan node baru
            top = newNode;
        } else {
            // Kasus 2. jika stack ada node 
            // New node diletakkan paling, dan top lama menjadi next 
            newNode.next = top;
            top = newNode;
        }
        System.out.println("PUSH:" + data.info());
    }

    public void pop() {
        Node node = null;

         // Kasus 1. Jika stack empty 
        if (top == null) {
            System.out.println("Stack Kosong");
            return;
        } else {
              //Jika stack ada, node baru akan diisi dengan top 
              //next dari top akan menjadi top baru 
              //untuk membersihkan node baru, set next dengan null 
            node = top;
            top = top.next;
            node.next = null;
        }
        System.out.println("POP " + node.data.info());
    }

    public void delete(int id) {
        if (top == null) {
            //jika stack, tampilkan informasi stack kosong
            System.out.println("Stack Kosong");
            ;
            return;
        }

         // Case 1: Delete the top node
        if (top.data.getId() == id) {
            //jika data yang dicari sama dengan data top 
            if (top.next == null) {
                top = null;
            } else {
                top = top.next;
            }
            System.out.println("DELETE : " + id);
            return;
        }

        Node current = top; //data iterasi yang akan dihapus
        Node prev = top;    //node sebelumnya 
        // Traverse untuk menemukan node 
        while (current != null && current.data.getId() != id) {
            prev = current;
            current = current.next;
        }

         // jika node tidak ditemukan, posisi berada paling akhir 
        if (current == null) {
            System.out.println("DELETE : " + id + " NOT FOUND");
            return;
        }

         // jika node ditemukan di pertengahan atau akhir
        if (current.next != null) {
            //jika node bukan bagian paling akhir 
            //gunakan prev untuk menghubungkan node prev dan next node
            prev.next = current.next;
        } else {
            //Jika node paling akhir, set next dari prev dengan null
            prev.next = null;
        }
        System.out.println("DELETE : " + id);
        current = null;
    }

    public void print() {
        if (top == null) {
            //jika stack kosong, tampilkan stack kosong
            System.out.println("Stack Kosong");
            return;
        } else {
            Node current = top;
            System.out.print("Stack : ");
             //Ulang hingga node berada paling akhir 
            while (current != null) {
                System.out.print(current.data.info() + " ");
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        StackList sl = new StackList();
        sl.runThis();
    }

    void runThis() {
        push(new Barang(1, "Buku 1", 50));
        push(new Barang(2, "Buku 2", 52));
        push(new Barang(3, "Buku 3", 54));
        push(new Barang(4, "Buku 4", 56));
        push(new Barang(5, "Buku 5", 58));
        push(new Barang(6, "Buku 6", 60));
        push(new Barang(7, "Buku 7", 62));
        print();  
        pop();  
        print();  
        pop();  
        print();  
        System.out.println("=========");
        System.out.println("delete barang");
        System.out.println("=========");
        delete(2);
        print();
        delete(3);
        print();
        delete(4);
        print();
    }
}
