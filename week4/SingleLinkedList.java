package week4;


// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1
// JURNAL MANDIRI 1



import java.io.*;

// class Node {
//     int data;
//     Node next;

//     Node(int d) {
//         data = d;
//         next = null;
//     }
// }

public class SingleLinkedList {
    Node head; // head of list
    /* Insert last tidak terurut */

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
        // Jika list kosong atau data lebih kecil dari head
        if (head == null || head.data.getId() >= brg.getId()) {
            nn.next = head;
            head = nn;
        } else {
            // Cari posisi yang tepat untuk menyisipkan node
            while (current.next != null && current.next.data.getId() < nn.data.getId()) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Node baru " + brg + " ditambahkan");
    } // eoinsertSorted

    /* Delete */
    public int delete(int data) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            // Cek apakah data yang dicar ada di head
            if (head.data.getId() == data) {
                head = head.next;
                System.out.println("Node " + data + " telah dihapus");
                return 0;
            } else {
                // jika data yang dicari bukan di head
                Node current = head;
                Node prec = head;
                // boolean found = false;
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
        // System.out.println("=========================");
        // System.out.println("Kode deret tidak Terurut");
        // System.out.println("=========================");
        // insert(5);
        // insert(1);
        // insert(3);
        // insert(2);
        // insert(7);
        // insert(6);
        // insert(9);
        // insert(8);
        // printList();

        // System.out.println("\nMenghapus data 5, 1, 9, dan 99:");
        // delete(5);
        // printList();
        // delete(1);
        // printList();
        // delete(9);
        // printList();
        // delete(99);
        // printList();

        // System.out.println("");

        // System.out.println("=======================");
        // System.out.println("Kode Deret Terurut");
        // System.out.println("=======================");
        // SingleLinkedList sllTerurut = new SingleLinkedList();
        // sllTerurut.insertSorted(5);
        // sllTerurut.insertSorted(1);
        // sllTerurut.insertSorted(3);
        // sllTerurut.insertSorted(2);
        // sllTerurut.insertSorted(7);
        // sllTerurut.insertSorted(6);
        // sllTerurut.insertSorted(9);
        // sllTerurut.insertSorted(8);
        // sllTerurut.printList();

        // System.out.println("\nMenghapus data 5, 1, 9, dan 99:");
        // sllTerurut.delete(5);
        // sllTerurut.printList();
        // sllTerurut.delete(1);
        // sllTerurut.printList();
        // sllTerurut.delete(9);
        // sllTerurut.printList();
        // sllTerurut.delete(99);
        // sllTerurut.printList();

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
        System.out.println("insert shorted barang");
        System.out.println("==================");
        SingleLinkedList sllTerurut = new SingleLinkedList();
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
        
       
        // delete(4);
        // delete(1);
        // delete(10);
        // delete(99);
        // printList();

    }
}