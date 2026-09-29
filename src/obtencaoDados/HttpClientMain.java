package obtencaoDados;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientMain {
//https://api.le-systeme-solaire.net/rest/bodies?order=bodyType&filter%5B%5D=string
//"https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2Cvol%2Cdensity%2Cgravity%2CsideralOrbit%2CsideralRotation%2CavgTemp%2CbodyType";
    private static final String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2Cvol%2Cdensity%2Cgravity%2CsideralOrbit%2CsideralRotation%2CavgTemp%2CbodyType";
    private static final String TOKEN = "1af10ef8-ef25-4e4d-94b7-8228d55d1dce";

    public static String execute() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization", "Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
