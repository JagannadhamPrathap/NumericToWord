import java.util.Scanner;

public class NumtoWord {
    static final String[] belowTen = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    static final String[] belowTwenty = {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    static final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    static String numberToWords(int num) {
        if (num == 0) return "Zero";

        String result = "";
        int thousandCounter = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000) + thousands[thousandCounter] + " " + result;
            }
            num /= 1000;
            thousandCounter++;
        }

        return result.trim();
    }

    static String helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(belowTen[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            sb.append(tens[num / 10]).append(" ");
            num %= 10;
        } else if (num >= 10) {
            sb.append(belowTwenty[num - 10]).append(" ");
            return sb.toString();
        }

        if (num > 0) {
            sb.append(belowTen[num]).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scan.nextInt();

        if (number < 0) {
            System.out.println("Negative numbers are not supported.");
        } else {
            System.out.println("In words: " + numberToWords(number));
        }

        scan.close();
    }
}
