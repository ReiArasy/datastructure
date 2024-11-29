package multilinkedlist_1201230038;

import org.w3c.dom.Node;

class SistemAkademik{   
    /*
        Terdapat 2 buat Single Linked List untuk menyimpan data masing-masing kelas dan mahasiswa
    */
        SLLMahasiswa mahasiswa = null; 
        SLLKelas kelas = null; 
    
        public static void main(String[] args) { 
            SistemAkademik sa = new SistemAkademik();
            sa.runThis();
        }

        void runThis(){
            kelas = new SLLKelas(); 
            mahasiswa = new SLLMahasiswa(); 
        
            prosedurTambahKelas(1, "SE-07-01");
            prosedurTambahKelas(2, "SE-07-02");
            prosedurTambahKelas(3, "SE-07-03");
            prosedurTambahKelas(4, "SE-07-04");
            prosedurShowAllKelas();

            prosedurTambahMahasiswa(1, "Yanto");
            prosedurSetKelas(1, 1);
            prosedurTambahMahasiswa(2, "Rapid");
            prosedurTambahMahasiswa(3, "Seta");
            prosedurTambahMahasiswa(4, "Arasy");
            prosedurShowAllMahasiswa();
            prosedurSetKelas(1, 2);
            prosedurShowAllMahasiswa();
        } 
    
        void prosedurTambahKelas(int id, String nama){
            System.out.println("Prosedur pembuatan kelas baru "+nama);
            kelas.insert(new Kelas(id,nama)); 
        }
        void prosedurTambahMahasiswa(int nim, String nama){
            System.out.println("Prosedur penerimaan mahasiswa baru baru "+nama);
            mahasiswa.insert(new Mahasiswa(nim,nama)); 
        }
        void prosedurShowAllMahasiswa(){
            System.out.println("Prosedur Melihat data seluruh mahasiswa");
            mahasiswa.printList();
        }
        void prosedurShowAllKelas(){
            System.out.println("Prosedur Melihat data seluruh Kelas");
            kelas.printList();
        }

        void prosedurSetKelas(int idMahasiswa, int idKelas){
            System.out.println("Prosedur pemetakan mahasiswa ke kelas");
            NodeKelas k = kelas.search(idKelas);
            int returnValue = mahasiswa.setKelas(idMahasiswa, k);
            switch (returnValue){
            case 0 : System.out.println("List kosong");break;
            case 1 : System.out.println("Data ditemukan dan telah diset");break;
            }
        }
    }

    class Mahasiswa{
        private int id;
        private String nama;
        private NodeKelas kelas;
    
        public Mahasiswa(int id, String nama){
            this.id = id;
            this.nama = nama;
        }
    
        public int getId(){
            return id;
        }
        public String getNama(){
            return nama;
        }
    
        public void setKelas(NodeKelas kelas){
            this.kelas = kelas;
        }
        public NodeKelas getKelas(){
            return kelas;
        }
    
        public String toString(){
            if (kelas == null){
                return id+" "+nama;
            } else{
                return id+" "+nama+" "+kelas.toString();
            }
        }
    }

    class Kelas{
        private int id;
        private String nama;
    
        public Kelas(int id, String nama){
            this.id = id;
            this.nama=nama;
        }
    
        public int getId(){return id;}
        public String getNama(){return nama;}
    
        public String toString(){
            return id+" "+nama;
        }
    }

    class NodeKelas {
        Kelas data; 
        NodeKelas next; 
    
        NodeKelas(Kelas data) { 
            this.data = data; 
            next = null; 
        } 
        public String toString(){
            return data.toString();
        }
    } 

    class NodeMahasiswa {
        Mahasiswa data; 
        NodeMahasiswa next; 
    
        NodeMahasiswa(Mahasiswa data) { 
            this.data = data; 
            next = null; 
        } 
        public String toString(){
            return data.toString();
        }
    
    } 

    class SLLKelas{ 
    NodeKelas head; // head of list 
    public int insert(Kelas data) {
        NodeKelas nn = new NodeKelas(data);
        NodeKelas current = head; 

        if (current == null) { 
            nn.next=null;
            head = nn; 
        } 
        else { 
            while (current.next != null) {
                current = current.next; 
            } 
            current.next = nn; 
        } 
        return 1;
    } 

    public NodeKelas search(int id) {
        NodeKelas current = head;
        if (current == null) {
            return null;
        } else {
            if (current.data.getId() == id){
                return head;
            } else{
                boolean found = false;
                while (current != null) {
                    if (current.data.getId() == id){
                        return current;                        
                    }
                    current = current.next;
                }
            } 
        }
        return null;
    }

    public void printList() { 
        NodeKelas current = head; 
        while (current != null) { 
            System.out.println(current.data.toString()+" "); 
            current = current.next; 
        } 
    } 
}

class SLLMahasiswa{ 
    NodeMahasiswa head; // head of list 
    public int insert(Mahasiswa data) {
		NodeMahasiswa nn = new NodeMahasiswa(data);
        NodeMahasiswa current = head;
    
    if (current == null){
        nn.next = null;
        head = nn;
    }
    else {
        while (current.next != null) {
            current = current.next;
        }
        current.next = nn;
    }
    return 1;
}

    public NodeMahasiswa search(int id) {
        NodeMahasiswa current = head;
        if (current == null) {
            return null;
        } else {
            if (current.data.getId() == id){
                return head;
            } else {
                while (current != null) {
                    if (current.data.getId() == id){
                        return current;
                    }
                    current = current.next;
                }
            }
        }
        return null;
    }

    public int setKelas(int id, NodeKelas kelas){
        NodeMahasiswa current = head;
        if (current == null){
            return 0;
        } else {
            while (current != null) {
                if (((Mahasiswa)current.data).getId() == id){
                    current.data.setKelas(kelas);
                    System.out.println(current.data.getNama() + " dipetakan ke kelas " + kelas.toString());
                    return 1;
                }
                current = current.next;
            }
            return 0;
        }
    }    

    public void printList() { 
    	NodeMahasiswa current = head; 
        while (current != null) { 
        		System.out.println(current.data.toString()+" "); 
              current = current.next; 
        } 
    } 
}




    
    
    