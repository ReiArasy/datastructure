package jurnalmandiri_week6;

import java.io.*;

class Pasien {
    int noUrut;
    String nama;

    Pasien(int nu, String nama) {
        this.noUrut = nu;
        this.nama = nama;
    }

    String info() {
        return noUrut + " " + nama;
    }

    int getNoUrut() {
        return noUrut;
    }
}

class Node {
    Pasien data;
    Node next;

    Node(Pasien d) {
        data = d;
        next = null;
    }
}

public class QueueListPasien {
    Node head; 
    Node tail;

    /* Tambah antrian */
    public int enqueue(String nama) {
        int noUrut = (tail == null) ? 1 : tail.data.getNoUrut() + 1;
        Pasien pasienBaru = new Pasien(noUrut, nama);
        Node nn = new Node(pasienBaru);

        if (head == null) {
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
        System.out.println("Node Baru " + nama + " dengan no urut " + noUrut + " ditambahkan");
        return noUrut;
    }

    /* Ambil Urutan */
    public int dequeue() {
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        }
        
        int noUrut = head.data.getNoUrut();
        System.out.println("Data diambil: " + head.data.info());

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }

        return noUrut;
    }

    /* Jika no antrian depan tidak ada, maka ambil antrian yang ada */
    public int ambilAntrianTengah(int noUrut) {
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        }
    
        Node current = head;
        Node prev = null;
    
        // Loop hingga menemukan noUrut yang dicari atau mencapai akhir antrian
        while (current != null) {
            if (current.data.getNoUrut() == noUrut) {
                System.out.println("Mengambil no urut: " + current.data.info());
                // Update head ke node setelah current (menghapus semua sebelum dan termasuk current)
                head = current.next;
    
                // Jika current adalah tail, maka tail juga di-update ke null
                if (current == tail) {
                    tail = null;
                }
                return noUrut;
            }
            prev = current;
            current = current.next;
        }
    
        System.out.println("Pasien dengan no urut " + noUrut + " tidak ditemukan");
        return 0;
    }
    

    public void printList() {
        Node current = head;
        System.out.println("Daftar antrian:");
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QueueListPasien sll = new QueueListPasien();
        sll.runThis();
    }

    void runThis() {
        enqueue("Gandalf The Grey");
        enqueue("Aragorn");
        enqueue("Legolas");
        enqueue("Gimli");
        enqueue("Boromir");
        enqueue("Frodo Baggins");
        enqueue("Samwise Gamgee");
        enqueue("Meri");
        enqueue("Pippin");
        printList();

        ambilAntrianTengah(5);
        printList();

        dequeue();
        printList();

        enqueue("Gandalf The White");
        printList();
    }
}
