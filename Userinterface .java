import java.util.Scanner;

@FunctionalInterface interface NumberCategory { boolean checkNumberCategory(int number1, int number2); }

public class UserInterface { public static NumberCategory checkAmicable() { return (number1, number2) -> { int sumDivisors1 = sumDivisors(number1); int sumDivisors2 = sumDivisors(number2); return sumDivisors1 == number2 && sumDivisors2 == number1; }; }

public static NumberCategory checkPalindrome() {
    return (number1, number2) -> {
        int product = number1 * number2;
        String productString = String.valueOf(product);
        return isPalindrome(productString);
    };
}

private static int sumDivisors(int number) {
    int sum = 1; // Start with 1 as 1 is always a divisor
    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            sum += i;
            if (i != number / i) { // Check for non-square divisors
                sum += number / i;
            }
        }
    }
    return sum;
}

private static boolean isPalindrome(String str) {
    int i = 0;
    int j = str.length() - 1;
    while (i < j) {
        if (str.charAt(i) != str.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first number:");
    int number1 = scanner.nextInt();

    System.out.println("Enter the second number:");
    int number2 = scanner.nextInt();

    NumberCategory amicableChecker = checkAmicable();
    NumberCategory palindromeChecker = checkPalindrome();

    boolean areAmicable = amicableChecker.checkNumberCategory(number1, number2);
    boolean isPalindromeProduct = palindromeChecker.checkNumberCategory(number1, number2);

    if (areAmicable) {
        System.out.println(number1 + " and " + number2 + " are amicable numbers");
    } else {
        System.out.println(number1 + " and " + number2 + " are not amicable numbers");
    }

    if (isPalindromeProduct) {
        System.out.println("Their Product " + number1 * number2 + " does produce a Palindrome");
    } else {
        System.out.println("Their Product " + number1 * number2 + " does not produce a Palindrome");
    }
}
}
