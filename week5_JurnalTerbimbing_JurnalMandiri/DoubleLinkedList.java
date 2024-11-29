package week5_JurnalTerbimbing_JurnalMandiri;

//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI8
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI
//INI ADALAH JURNAL MANDIRI









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
    Node prev;  
 
    Node(Barang d) {  
        data = d;  
        next = null;  
        prev = null; 
    }  
}  
 
public class DoubleLinkedList {  
    Node head; // head of list 
    Node tail; // tail of list  
    Scanner inp = new Scanner(System.in); 
 
    /* Insert last */ 
    public void insertEnd(Barang data) {  
        Node nn = new Node(data); 
        if (tail == null) { 
            head = tail = nn; 
        }  
        else {  
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }  
        System.out.println("Barang baru "+ data.info() +" diposisi belakang"); 
    }  
 
    /* Insert First */ 
    public void insertFirst(Barang data) {  
        Node nn = new Node(data); 
        if (head == null) { 
            head = tail = nn; 
        }  
        else {  
            head.prev = nn; 
            nn.next = head; 
            head = nn; 
        }  
        System.out.println("Barang baru "+ data.info() +" diposisi depan"); 
    }
 
    /* Insert sorted*/ 
    public void insertSorted(Barang data) { 
        Node newNode = new Node(data); 
 
        // Kasus 1. Jika List kosong 
        if (head == null) { 
            head = tail = newNode; 
            System.out.println("Barang baru "+ data.info() +" paling depan"); 
            return; 
        } 
 
        // Kasus 2. Jika id barang lebih kecil dari head 
        if (data.getId() <= head.data.getId()) { 
            newNode.next = head; 
            head.prev = newNode; 
            head = newNode; 
            System.out.println("Barang baru "+ data.info() +" paling depan"); 
            return; 
        } 
 
        // Kasus 3: jika id barang lebih besar dari tail 
        if (data.getId() >= tail.data.getId()) { 
            newNode.prev = tail; 
            tail.next = newNode; 
            tail = newNode; 
            System.out.println("Barang baru "+ data.info() +" paling belakang"); 
            return; 
        } 
 
        // Kasus 4: di antara head dan tail 
        Node current = head; 
        while (current != null && current.data.getId() < data.getId()) { 
            current = current.next; 
        } 
 
        // Insert the node before the current node 
        newNode.next = current; 
        newNode.prev = current.prev; 
 
        if (current.prev != null) { 
            current.prev.next = newNode; 
        } 
        current.prev = newNode; 
 
        System.out.println("Barang baru "+ data.info() +" di tengah"); 
    }

    // Delete node dengan id tertentu 
    public void delete(int id) { 
        if (head == null) { 
            System.out.println("List is empty."); 
            return; 
        } 
 
        Node current = head; 
 
        // Case 1: Hapus node head 
        if (head.data.getId() == id) { 
            head = head.next; 
            if (head != null) { 
                head.prev = null; 
            } else { 
                tail = null; // Jika list jadi kosong 
            } 
            return; 
        } 
 
        // Traverse untuk menemukan node yang akan dihapus 
        while (current != null && current.data.getId() != id) { 
            current = current.next; 
        } 
 
        // Case 2: Node tidak ditemukan 
        if (current == null) { 
            System.out.println("Barang dengan id " + id + " tidak ditemukan."); 
            return; 
        } 
 
        // Case 3: Hapus node di tengah 
        if (current.next != null) { 
            current.next.prev = current.prev; 
        } else { 
            tail = current.prev; // jika node yang dihapus adalah tail 
        } 
 
        if (current.prev != null) { 
            current.prev.next = current.next; 
        } 
    } 
 
    public void printListBackward() {  
        Node current = head;  
        System.out.println("Double LinkedList Backward: ");  
        while (current != null) {  
            System.out.print(current.data.info() + " ");  
            current = current.next;  
        }  
        System.out.println("");  
    }  
 
    public void printListForward() {  
        Node current = tail;  
        System.out.println("Double LinkedList Forward: ");  
        while (current != null) {  
            System.out.print(current.data.info() + " ");  
            current = current.prev;  
        }  
        System.out.println("");  
    }  
 
    public static void main(String[] args) {  
        DoubleLinkedList dll = new DoubleLinkedList();  
        dll.runThis(); 
    } 
 
    void runThis(){ 
        //INSERT SORTED
        System.out.println("===================");
        System.out.println("Insert Barang:");
        System.out.println("===================");
        insertSorted(new Barang(1, "Pensil", 50));  
        insertSorted(new Barang(5, "Buku", 30));  
        insertSorted(new Barang(3, "Penggaris", 20));  
        insertSorted(new Barang(2, "Pulpen", 40));  
        insertSorted(new Barang(7, "Tas", 15));  
        insertSorted(new Barang(6, "Penghapus", 25));  
        insertSorted(new Barang(9, "Ransel", 10));  
        insertSorted(new Barang(8, "Kertas", 100));  
        printListBackward();  
        printListForward();  
 
        System.out.println("=====================");
        System.out.println("delete barang:");
        System.out.println("=====================");
        delete(6); 
        printListBackward();  
        delete(1); 
        printListForward();  
        delete(9); 
    }
}
