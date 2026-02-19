import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoedas {

    public double buscaTaxa(String moedaBase, String moedaAlvo, String apiKey) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaBase + "/" + moedaAlvo;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement elemento = JsonParser.parseString(response.body());
            JsonObject objectRoot = elemento.getAsJsonObject();

            if (objectRoot.get("result").getAsString().equals("success")) {
                return objectRoot.get("conversion_rate").getAsDouble();
            } else {
                System.out.println("Erro na API. Verifique a chave.");
                return 0;
            }

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter a cotação: " + e.getMessage());
        }
    }
}