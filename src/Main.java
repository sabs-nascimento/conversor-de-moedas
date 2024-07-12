import br.com.sabs.currencyconversion.Conversion;
import br.com.sabs.currencyconversion.ConversionInfo;
import br.com.sabs.currencyconversion.RequestConversion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> currencySet = new HashMap<Integer, String>();
        currencySet.put(1, "BRL");
        currencySet.put(2, "USD");
        currencySet.put(3, "CHF");
        currencySet.put(4, "GBP");
        currencySet.put(5, "JPY");
        currencySet.put(6, "EGP");
        Scanner readerString = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);
        RequestConversion request = new RequestConversion();

        while(true) {
            System.out.println("========================================");
            System.out.println("          Conversor de Moedas          ");
            System.out.println("""
                    Moedas Suportadas
                      1 - BRL - Real Brasileiro
                      2 - USD - Dólar Americano
                      3 - CHF - Franco Suíço
                      4 - GBP - Libra Esterlina
                      5 - JPY - Iene Japonês
                      6 - EGP - Libra Egípcia
                      
                    Operações
                      a - Fazer conversão
                      b - Finalizar
                      """);
            System.out.println("Digite a letra da operação desejada:");
            String op = readerString.nextLine();
            System.out.println();
            if (op.equals("a")) {
                System.out.println("Digite o número da moeda atual que se quer converter:");
                int baseCurrency = reader.nextInt();
                System.out.println("Digite o número da moeda para qual se quer converter:");
                int targetCurrency = reader.nextInt();
                System.out.println("Digite o valor que se quer converter:");
                double amount = reader.nextDouble();
                try {
                    Conversion finalAmount = request.Convert(currencySet.get(baseCurrency),
                            currencySet.get(targetCurrency), amount);
                    ConversionInfo result = new ConversionInfo(currencySet.get(baseCurrency),
                            currencySet.get(targetCurrency), amount, finalAmount.conversion_result());
                    System.out.println(result);
                } catch (IOException | InterruptedException e) {
                    System.out.println("Valores inválidos");
                }

            } else if (op.equals("b")) {
                System.out.println("Programa finalizado");
                break;
            } else {
                System.out.println("Operação inválida");
            }
        }
    }
}
