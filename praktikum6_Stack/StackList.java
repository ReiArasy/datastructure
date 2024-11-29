package praktikum6_Stack;

import java.io.*;
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String d) {
        data = d;
        next = null;
    }
}

public class StackList {
    Node top; // top of stack
    Scanner inp = new Scanner(System.in);

    public void push(String data) {
        Node newNode = new Node(data);
        
        if ( top == null) {
            // Kasus 1. Jika stack empty 
            // maka top diisi dengan node baru 
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("PUSH " + data);
    }

    public void pop() {
        Node node = null;

        if ( top == null) {
            System.out.println("Stack Kosong");;
            return;
        } else {
            node = top;
            top = top.next;
            node.next = null;
        }
        System.out.println("POP " + node.data);
    }

    public void delete(String data) {
        if (top == null) {
            System.out.println("Stack Kosong");;
            return;
        }

        if (top.data.equals(data)) {
            if (top.next == null) {
                top = null;
            } else {
                top = top.next;
            }
            System.out.println("DELETE : " + data);
            return;
        }

        Node current = top;
        Node prev = top;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("DELETE : " + data + " NOT FOUND");
            return;
        }

        if (current.next != null) {
            prev.next = current.next;
        } else {
            prev.next = null;
        }
        System.out.println("DELETE : " + data);
        current = null;
    }

    public void print() {
        if (top == null) {
            System.out.println("Stack Kosong");;
            return;
        } else {
            Node current = top;
            System.out.print("Stack : ");
            while (current != null) {
                System.out.print(current.data + " ");
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
        push("hari");
        push("ini");
        push("kita");
        push("mempelajari");
        push("materi");
        push("struktur");
        push("data");
        push("tentang");
        push("stack");
        print();
        pop();
        print();
        pop();
        print();
        delete("struktur");
        print();
        delete("kita");
        print();
        delete("stack");
        print();
    }
}
