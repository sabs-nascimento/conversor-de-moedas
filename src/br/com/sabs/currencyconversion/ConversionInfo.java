package br.com.sabs.currencyconversion;

import java.util.Locale;

import static java.lang.String.format;

public class ConversionInfo {
    private final String baseCurrency;
    private final String targetCurrency;
    private final double amount;
    private final double finalAmount;

    public ConversionInfo(String baseCurrency, String targetCurrency, double amount, double finalAmount) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.finalAmount = finalAmount;
    }

    @Override
    public String toString() {
        return format(Locale.US,"A conversão do valor %.2f [%s] para [%s] é %.2f", amount, baseCurrency,
                targetCurrency, finalAmount);
    }
}
