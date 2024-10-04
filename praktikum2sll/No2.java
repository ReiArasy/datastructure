import java.util.Scanner;

public class No2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positiveCount = 0;
        int maxEven = Integer.MIN_VALUE;
        int number;
        

        while(true){
            System.out.println("==============");
            System.out.print("masukkan angka:");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number == 0){
                    break;
                } else if (number %2 == 0) {
                    positiveCount++;
                    if ((number > maxEven)) {
                        maxEven = number;
                    }
                } 
            }
        }

        
        if (positiveCount > 0) {
            System.out.println("===============");
            System.out.println("total bilangan Genap:" + positiveCount);
            System.out.println("Bilangan genap terbesar:" + maxEven);
        } else {
            System.out.println("tidak ada bilangan genap yang dimasukkan.");
        }

        scanner.close();
    }
}