import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================");
        System.out.print("Masukkan bilangan bulat positif: ");
        int number = scanner.nextInt();

        if (isPerfect(number)) {
            System.out.println("====================");
            System.out.println("Bilangan sempurna!");
            System.out.println("====================");
        } else {
            System.out.println("====================");
            System.out.println("bukan sempurna");
            System.out.println("====================");
        }
        scanner.close();
    }

    public static boolean isPerfect(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}

