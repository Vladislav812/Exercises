package JetBrains;

import java.time.LocalDate;
import java.util.Scanner;

public class YearOffset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();
        int currentYear = date.getYear();
        while (date.getYear() == currentYear) {
            System.out.println(date);
            date = date.plusDays(offset);
        }
    }
}
