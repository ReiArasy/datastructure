class Jam{
    int h = 0;
    int m = 0;
    int s = 0;

    public Jam(int h, int m, int s){
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public boolean isValid(){
        boolean valid = true;
        if ((h<0) || (h>23)){
            valid = false;
        }
        if ((m<0) || (m>59)){
            valid = false;
        }
        if ((s<0) || (s>59)){
            valid = false;
        }
        return valid;
    }
    
    public void viewJam(){
        System.out.println(h + ':' +m+ ':' +s);
    }
}

class ImplementasiJam{
    public static void main(String[] args) {
        Jam j1 = new Jam(14, 15, 50);
        Jam j2 = new Jam(25, 150, 510);
       
        System.out.println(j1.isValid());
        System.out.println(j2.isValid());
        j1.isValid();
        j2.isValid();
    }
}