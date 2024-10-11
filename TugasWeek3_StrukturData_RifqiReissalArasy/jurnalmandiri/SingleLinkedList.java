package TugasWeek3_StrukturData_RifqiReissalArasy.jurnalmandiri;

import java.io.*;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class SingleLinkedList {
    Node head; // head of list
    /* Insert last tidak terurut */

    public int insert(int data) {
        Node nn = new Node(data);
        Node current = head;
        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        System.out.println("Node baru " + data + " ditambahkan");
        return 0;
    }

    /* Insert sorted */
    public void insertSorted(int data) {
        Node nn = new Node(data); // node baru
        Node current = head;
        // Jika list kosong atau data lebih kecil dari head
        if (head == null || head.data >= nn.data) {
            nn.next = head;
            head = nn;
        } else {
            // Cari posisi yang tepat untuk menyisipkan node
            while (current.next != null && (current.next.data < nn.data)) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Node baru " + data + " ditambahkan");
    } // eoinsertSorted

    /* Delete */
    public int delete(int data) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            // Cek apakah data yang dicar ada di head
            if (head.data == data) {
                head = head.next;
                System.out.println("Node " + data + " telah dihapus");
                return 0;
            } else {
                // jika data yang dicari bukan di head
                Node current = head;
                Node prec = head;
                boolean found = false;
                while (current != null) {
                    if (current.data == data) {
                        prec.next = current.next;
                        current.next = null;
                        System.out.println("Node " + data + " telah dihapus");
                        return 0;
                    }
                    prec = current;
                    current = current.next;
                }
            }
        }
        System.out.println("Node " + data + " tidak ditemukan");
        return 0;
    } // eodelete

    public void search(int data) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Data " + data + " ditemukan pada urutan ke-" + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Data " + data + " tidak ditemukan");
    }

    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    } // eoprintlist

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.runThis();
    }

    void runThis() {
        System.out.println("=========================");
        System.out.println("Kode deret tidak Terurut");
        System.out.println("=========================");
        insert(5);
        insert(1);
        insert(3);
        insert(2);
        insert(7);
        insert(6);
        insert(9);
        insert(8);
        printList();

        Scanner scanner = new Scanner(System.in); 
        System.out.print("\nMasukkan data yang ingin dicari: ");
        int dataDicari = scanner.nextInt(); 
        search(dataDicari); 

        // System.out.println("\nMenghapus data 5, 1, 9, dan 99:");
        // delete(5);
        // printList();
        // delete(1);
        // printList();
        // delete(9);
        // printList();
        // delete(99);
        // printList();

        System.out.println("");

        System.out.println("=======================");
        System.out.println("Kode Deret Terurut");
        System.out.println("=======================");
        SingleLinkedList sllTerurut = new SingleLinkedList();
        sllTerurut.insertSorted(5);
        sllTerurut.insertSorted(1);
        sllTerurut.insertSorted(3);
        sllTerurut.insertSorted(2);
        sllTerurut.insertSorted(7);
        sllTerurut.insertSorted(6);
        sllTerurut.insertSorted(9);
        sllTerurut.insertSorted(8);
        sllTerurut.printList();

        // System.out.println("\nMenghapus data 5, 1, 9, dan 99:");
        // sllTerurut.delete(5);
        // sllTerurut.printList();
        // sllTerurut.delete(1);
        // sllTerurut.printList();
        // sllTerurut.delete(9);
        // sllTerurut.printList();
        // sllTerurut.delete(99);
        // sllTerurut.printList();

        System.out.print("\nMasukkan data yang ingin dicari pada list terurut: ");
        int dataDicariTerurut = scanner.nextInt(); 
        sllTerurut.search(dataDicariTerurut);  
    
        scanner.close();
    }
}