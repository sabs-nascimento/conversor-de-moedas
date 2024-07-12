import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AcessarAPI {
    private String baseCurrency;
    private String targetCurrency;
    private double amount;

    public Conversao FazerConversao(String baseCurrency, String targetCurrency, double amount) throws IOException,
            InterruptedException {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;

        URI address =
                URI.create(
                        "https://v6.exchangerate-api.com/v6/00f24f5b9458f661be826087/pair/" + baseCurrency + '/' + targetCurrency + '/' + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), Conversao.class);
    }
}
