
import java.util.Scanner;

public class GCD {

    public static void main(String[] args) {
        long number1, number2;
        try (Scanner reader = new Scanner(System.in)) {
            number1 = reader.nextInt();
            number2 = reader.nextInt();
            long gcd = GetGcd(number1, number2);
            System.out.println(gcd);
        }
    }

    public static long GetGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
