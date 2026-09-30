package obtencaoDados;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpBodiesService {
    private static final String TOKEN = "1af10ef8-ef25-4e4d-94b7-8228d55d1dce";

    public static String getAllPlanets() throws IOException, InterruptedException{
        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue%" +
                          "2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2CsideralRo" +
                          "tation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CPlanet";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String getStar() throws IOException, InterruptedException{
        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValu" +
                          "e%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Cside" +
                          "ralRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CStar";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String getAllDwarfPlanets() throws IOException, InterruptedException{
        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue" +
                          "%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Csidera" +
                          "lRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CDwarf%20Planet";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String getAllAsteroids() throws IOException, InterruptedException{
        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValu" +
                          "e%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Cside" +
                          "ralRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2Casteroid";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String getAllComets() throws IOException, InterruptedException{
        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue" +
                          "%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Csidera" +
                          "lRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2Ccomet";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String getAllMoons() throws IOException, InterruptedException{
        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue" +
                          "%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Csidera" +
                          "lRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CMoon";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String getAllCelestialBodies() throws IOException, InterruptedException{
        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue" +
                          "%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Csidera" +
                          "lRotation%2CavgTemp%2CbodyType";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }



}