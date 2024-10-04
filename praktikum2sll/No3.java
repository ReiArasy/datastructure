import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=====================");
        System.out.print("Masukkan bilangan bulat positif: ");
        int number = scanner.nextInt();
        
        if (isPrime(number)) {
            System.out.println("prima");
        } else {
            System.out.println("bukan prima");
        }

        scanner.close();
    }

    
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

