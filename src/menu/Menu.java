package menu;

import estruturaDeDados.MeuHashMap.MeuHashMap;
import obtencaoDados.HttpBodiesService;
import obtencaoDados.ParsingJson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
    public static void consultaDados(Scanner sc, MeuHashMap hashMap) {
        int opcao;
        String id;

        System.out.print("\n1. Pesquisa por ID\n");
        System.out.print("2. Pesquisa por atributos\n");
        System.out.print("3. Listagem\n");
        System.out.print("4. Voltar\n");

        System.out.print("Escolha sua opcao: ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite ID a ser procurado: ");
                id = sc.next();

                if (hashMap.retonarCorpoCeleste(id) == null) {
                    System.out.print("CORPO CELESTE NAO ENCONTRADO!\n");
                } else {
                    hashMap.retonarCorpoCeleste(id).imprimirDados();
                }
                break;
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;
        }
    }

    public static void carregaJson(Scanner sc) {
        int opcao;

        while (true) {
            System.out.print("\n1. Carregar Estrelas\n");
            System.out.print("2. Carregar Planetas\n");
            System.out.print("3. Carregar Planetas Anoes\n");
            System.out.print("4. Carregar Asteroides\n");
            System.out.print("5. Carregar Cometas\n");
            System.out.print("6. Carregar Luas\n");
            System.out.print("7. Carregar Todos Corpo Celestes\n");
            System.out.print("8. Voltar\n");

            System.out.print("Escolha sua opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    try {
                        HttpBodiesService.getStar();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 2:
                    try {
                        HttpBodiesService.getPlanets();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 3:
                    try {
                        HttpBodiesService.getDwarfPlanets();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 4:
                    try {
                        HttpBodiesService.getAsteroids();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 5:
                    try {
                        HttpBodiesService.getComets();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 6:
                    try {
                        HttpBodiesService.getMoons();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 7:
                    try {
                        HttpBodiesService.getAllCelestialBodies();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 8:
                    return;
            }
        }
    }

    public static void carregaDadosTabelaHash(Scanner sc, MeuHashMap hashMap) {
        ParsingJson parsingJson = new ParsingJson();
        String json = null;

        int opcao;

        while (true) {
            System.out.print("\n1. Carregar Estrelas Para Tabela Hash\n");
            System.out.print("2. Carregar Planetas Para Tabela Hash\n");
            System.out.print("3. Carregar Planetas Anoes Para Tabela Hash\n");
            System.out.print("4. Carregar Asteroides Para Tabela Hash\n");
            System.out.print("5. Carregar Cometas Para Tabela Hash\n");
            System.out.print("6. Carregar Luas Para Tabela Hash\n");
            System.out.print("7. Carregar Todos Corpo Celestes Para Tabela Hash\n");
            System.out.print("8. Voltar\n");

            System.out.print("Escolha sua opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    try {
                        json = Files.readString(Paths.get("data", "star.json"));
                    } catch (NoSuchFileException e) {
                        System.out.println("Arquivo data/star.json nao existe. Carregue os dados primeiro!");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,json);
                    System.out.print("\nEstrela Carregada com Sucesso Para Tabela Hash!\n");

                    break;
                case 2:
                    try {
                        json = Files.readString(Paths.get("data", "planets.json"));
                    } catch (NoSuchFileException e) {
                        System.out.println("Arquivo data/planets.json nao existe. Carregue os dados primeiro!");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,json);
                    System.out.print("\nPLanetas Carregados com Sucesso Para Tabela Hash!\n");

                    break;
                case 3:
                    try {
                        json = Files.readString(Paths.get("data", "dwarfPlanets.json"));
                    } catch (NoSuchFileException e) {
                        System.out.println("Arquivo data/dwarfPlanets.json nao existe. Carregue os dados primeiro!");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,json);
                    System.out.print("\nPLanetas Anoes Carregados com Sucesso Para Tabela Hash!\n");

                    break;
                case 4:
                    try {
                        json = Files.readString(Paths.get("data", "asteroids.json"));
                    } catch (NoSuchFileException e) {
                        System.out.println("Arquivo data/asteroids.json nao existe. Carregue os dados primeiro!");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,json);
                    System.out.print("\nAsteroides Carregados com Sucesso Para Tabela Hash!\n");

                    break;
                case 5:
                    try {
                        json = Files.readString(Paths.get("data", "comets.json"));
                    } catch (NoSuchFileException e) {
                        System.out.println("Arquivo data/comets.json nao existe. Carregue os dados primeiro!");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,json);
                    System.out.print("\nCometas Carregados com Sucesso Para Tabela Hash!\n");

                    break;
                case 6:
                    try {
                        json = Files.readString(Paths.get("data", "moons.json"));
                    } catch (NoSuchFileException e) {
                        System.out.println("Arquivo data/moons.json nao existe. Carregue os dados primeiro!");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,json);
                    System.out.print("\nLuas Carregadas com Sucesso Para Tabela Hash!\n");

                    break;
                case 7:
                    String[] arquivos = {"star.json", "planets.json", "dwarfPlanets.json",
                            "asteroids.json", "comets.json", "moons.json"};

                    for(String nome : arquivos){
                        try {
                            json = Files.readString(Paths.get("data", nome));
                        } catch (NoSuchFileException e) {
                            System.out.println("Arquivo data/" + nome + " nao existe. Carregue os dados primeiro!");
                            continue;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        parsingJson.parsingCorpoCeleste(hashMap,json);
                    }
                    System.out.print("\nCorpos Celeste Carregados com Sucesso Para Tabela Hash!\n");
                    break;
                case 8:
                    return;
            }
        }
    }
}