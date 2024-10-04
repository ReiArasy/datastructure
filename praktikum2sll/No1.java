import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int negativeCount = 0;
        int positiveCount = 0;
        int number;

        while (true) {
            System.out.println("==============");
            System.out.print("masukkan angka:");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number == 0) {
                    break;
                } else if (number < 0) {
                    negativeCount++;
                } else {
                    positiveCount++;
                }
            } else {
                scanner.next();
            }
        }

        String comparison;
        if (negativeCount > positiveCount) {
            comparison = "negatif";
        } else if (positiveCount > negativeCount) {
            comparison = "positif";
        } else {
            comparison = "imbang";
        }

        System.out.println(negativeCount + " " + positiveCount + " " + comparison);
        
        scanner.close();
    }
}

