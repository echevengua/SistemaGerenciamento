package obtencaoDados;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpBodiesService {
    private static final String TOKEN = "1af10ef8-ef25-4e4d-94b7-8228d55d1dce";
    private static final Path DATA_DIR = Paths.get("data");

    public static void getPlanets() throws IOException, InterruptedException{
        Path destino = DATA_DIR.resolve("planets.json");

        if(Files.exists(destino)){
            System.out.print("\nPlanetas já carregados!\n");

            return;
        }

        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue%" +
                          "2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2CsideralRo" +
                          "tation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CPlanet";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Files.writeString(destino, response.body());
        System.out.println("Planetas carregados com sucesso!");
    }

    public static void getStar() throws IOException, InterruptedException{
        Path destino = DATA_DIR.resolve("star.json");

        if(Files.exists(destino)){
            System.out.print("\nEstrela já carregada!\n");

            return;
        }

        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValu" +
                          "e%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Cside" +
                          "ralRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CStar";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Files.writeString(destino, response.body());
        System.out.println("Estrela carregada com sucesso!");
    }

    public static void getDwarfPlanets() throws IOException, InterruptedException{
        Path destino = DATA_DIR.resolve("dwarfPlanets.json");

        if(Files.exists(destino)){
            System.out.print("\nPlanetas Anoes já carregados!\n");

            return;
        }

        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue" +
                          "%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Csidera" +
                          "lRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CDwarf%20Planet";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Files.writeString(destino, response.body());
        System.out.println("Planetas Anoes carregados com sucesso!");
    }

    public static void getAsteroids() throws IOException, InterruptedException{
        Path destino = DATA_DIR.resolve("asteroids.json");

        if(Files.exists(destino)){
            System.out.print("\nAsteroides já carregados!\n");

            return;
        }

        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValu" +
                          "e%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Cside" +
                          "ralRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2Casteroid";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Files.writeString(destino, response.body());
        System.out.println("Asteroides carregados com sucesso!");
    }

    public static void getComets() throws IOException, InterruptedException{
        Path destino = DATA_DIR.resolve("comets.json");

        if(Files.exists(destino)){
            System.out.print("\nCometas já carregados!\n");

            return;
        }

        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue" +
                          "%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Csidera" +
                          "lRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2Ccomet";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Files.writeString(destino, response.body());
        System.out.println("Cometas carregados com sucesso!");
    }

    public static void getMoons() throws IOException, InterruptedException{
        Path destino = DATA_DIR.resolve("moons.json");

        if(Files.exists(destino)){
            System.out.print("\nLuas já carregadas!\n");

            return;
        }

        String URL_PATH = "https://api.le-systeme-solaire.net/rest/bodies?data=id%2Cname%2CisPlanet%2Cmass%2CmassValue" +
                          "%2CmassExponent%2Cvol%2CvolValue%2CvolExponent%2Cdensity%2Cgravity%2CsideralOrbit%2Csidera" +
                          "lRotation%2CavgTemp%2CbodyType&filter%5B%5D=bodyType%2Ceq%2CMoon";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL_PATH)).
                header("Authorization","Bearer " + TOKEN).
                GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Files.writeString(destino, response.body());
        System.out.println("Luas carregadas com sucesso!");
    }

    public static void getAllCelestialBodies() throws IOException, InterruptedException{
        getPlanets();
        getAsteroids();
        getComets();
        getDwarfPlanets();
        getMoons();
        getStar();
    }




}