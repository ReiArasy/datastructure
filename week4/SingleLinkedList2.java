package week4;

import java.io.*;

public class SingleLinkedList2 {
    Node head; // head of list

    public int insert(Barang brg) {
        Node barang = new Node(brg);
        Node current = head;
        if (current == null) {
            barang.next = null;
            head = barang;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = barang;
        }
        System.out.println("Node baru " + barang.data + " ditambahkan");
        return 0;
    }

    /* Insert sorted */
    public void insertSorted(Barang brg) {
        Node nn = new Node(brg); // node baru
        Node current = head;
        if (head == null || head.data.getId() >= brg.getId()) {
            nn.next = head;
            head = nn;
        } else {
            while (current.next != null && current.next.data.getId() < nn.data.getId()) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Node baru " + brg + " ditambahkan");
    }

    /* Delete */
    public int delete(int data) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            if (head.data.getId() == data) {
                head = head.next;
                System.out.println("Node " + data + " telah dihapus");
                return 0;
            } else {
                Node current = head;
                Node prec = head;
                while (current != null) {
                    if (current.data.getId() == data) {
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
    }

    /* Cari Data */
    public int cariData(int id) {
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            int idx = 1;
            if (head.data.getId() == id) {
                System.out.println("Node " + id + " telah ditemukan pada urutan " + idx);
                return 0;
            } else {
                Node current = head;
                boolean found = false;
                while (current != null) {
                    idx++;
                    current = current.next;
                    if (current != null && current.data.getId() == id) {
                        System.out.println("Node " + id + " telah ditemukan pada urutan " + idx);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Node " + id + " tidak ditemukan");
                }
            }
        }
        return 0;
    }

    public Barang searchByNameAndStock(String nama, int stok) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equals(nama) && current.data.stok == stok) {
                System.out.println("Barang ditemukan: " + current.data);
                return current.data;
            }
            current = current.next;
        }
        System.out.println("Barang tidak ditemukan");
        return null;
    }

    public boolean updateStock(int id, int newStock) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                current.data.stok += newStock; 
                System.out.println("Stok barang dengan ID " + id + " telah diupdate menjadi " + current.data.stok);
                return true;
            }
            current = current.next;
        }
        System.out.println("Barang dengan ID " + id + " tidak ditemukan");
        return false;
    }

    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SingleLinkedList2 sll = new SingleLinkedList2();
        sll.runThis();
    }

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

        @Override
        public String toString() {
            return "ID: " + id + ", Nama: " + nama + ", Stok: " + stok;
        }
    }

    class Node {
        Barang data;
        Node next;

        Node(Barang brg) {
            data = brg;
            next = null;
        }
    }

    void runThis() {
        System.out.println("==================");
        System.out.println("insert barang");
        System.out.println("==================");
        insert(new Barang(5, "So So", 55));
        insert(new Barang(2, "Clean", 22));
        insert(new Barang(1, "So", 11));
        insert(new Barang(8, "So So Clean", 88));
        insert(new Barang(3, "So Clean", 33));
        insert(new Barang(6, "Clean Clean", 66));
        insert(new Barang(7, "So Clean So Clean", 77));
        insert(new Barang(10, "Clean So So", 100));
        insert(new Barang(9, "So Clean Clean", 99));
        insert(new Barang(4, "Clean So", 44));
    
        System.out.println("==================");
        System.out.println("insert sorted barang");
        System.out.println("==================");
        SingleLinkedList2 sllTerurut = new SingleLinkedList2();
        sllTerurut.insertSorted(new Barang(5, "So So", 17));
        sllTerurut.insertSorted(new Barang(2, "Clean", 65));
        sllTerurut.insertSorted(new Barang(1, "So", 15));
        sllTerurut.insertSorted(new Barang(8, "So So Clean", 32));
        sllTerurut.insertSorted(new Barang(3, "So Clean", 41));
        sllTerurut.insertSorted(new Barang(6, "Clean Clean", 100));
        sllTerurut.insertSorted(new Barang(7, "So Clean So Clean", 100));
        sllTerurut.insertSorted(new Barang(10, "Clean So So", 30));
        sllTerurut.insertSorted(new Barang(9, "So Clean Clean", 20));
        sllTerurut.insertSorted(new Barang(4, "Clean So", 10));
        
        System.out.println("==================");
        System.out.println("List Terurut: ");
        System.out.println("==================");
        sllTerurut.printList();
    
        System.out.println("==================");
        System.out.println("Mencari barang dengan ID 5:");
        sllTerurut.cariData(5);
        System.out.println("Mencari barang dengan ID 100:");
        sllTerurut.cariData(100);
    }
}    