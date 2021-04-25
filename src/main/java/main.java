import com.codetest.Bundle;

import lombok.extern.java.Log;

import java.util.Scanner;

@Log
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        String format = scanner.next();

        Bundle bundle = new Bundle(quantity, format);

        log.info(quantity + " " + format + " $" + bundle.totalPriceCalculator());
    }
}
