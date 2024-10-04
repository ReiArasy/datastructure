package praktikum3sll;

import java.io.*;  

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
        // Buat proses pengisian data
    } // eoRunThis
} // eoSingleLinkList