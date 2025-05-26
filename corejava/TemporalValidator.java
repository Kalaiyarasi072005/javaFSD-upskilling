// TemporalValidator.java
import java.util.Scanner;

public class TemporalValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year to check for temporal anomalies:");
        int year = scanner.nextInt();
        
        boolean isLeap = (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
        
        System.out.println(year + (isLeap ? 
            " is a leap year (time dilation detected)" : 
            " is not a leap year (temporal flow normal)"));
        
        // Extra: Show next 5 leap years
        System.out.print("Upcoming leap years: ");
        int count = 0;
        for (int y = year + 1; count < 5; y++) {
            if ((y % 400 == 0) || (y % 100 != 0 && y % 4 == 0)) {
                System.out.print(y + " ");
                count++;
            }
        }
    }
}