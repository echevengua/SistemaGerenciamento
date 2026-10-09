package menu;

import estruturaDeDados.MeuHashMap.MeuHashMap;
import objetos.corpoCeleste.CorpoCeleste;
import obtencaoDados.HttpBodiesService;
import obtencaoDados.ParsingJson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void consultaDados(Scanner sc, MeuHashMap hashMap) {
        int opcao;
        String id;

        System.out.print("\n1. Pesquisa por ID\n");
        System.out.print("2. Pesquisa por atributos\n");
        System.out.print("3. Filtragem\n");
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
                pesquisaAtributos(sc,hashMap);

                break;

            case 3:
                filtragem(sc,hashMap);

                break;

            case 4:
                return;
        }
    }

    private static void pesquisaAtributos(Scanner sc, MeuHashMap hashMap){
        int opcao;
        String categoria;

        System.out.print("\n1. Categoria do Corpo Celeste\n");
        System.out.println("2. Voltar\n");

        System.out.print("Escolha sua opcao: ");
        opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao){
            case 1:
                System.out.print("Digite categoria do corpo celeste(Asteroid, Star, Planet, Comet, Dwarf Planet, Moon): ");
                categoria = sc.nextLine();

                List<CorpoCeleste> lista = hashMap.retornarTodosCorpoCeleste();

                for(int i = 0; i < lista.size();i++){
                    if(lista.get(i).getBodyType().equals(categoria)){
                        lista.get(i).imprimirDados();
                    }
                }
                break;
            case 2:
                return;
        }
    }

    private static void filtragem(Scanner sc, MeuHashMap hashMap){
        int opcao;
        double min, max;
        List<CorpoCeleste> lista = hashMap.retornarTodosCorpoCeleste();
        boolean existeUm = false;

        System.out.print("\n1. Densidade\n");
        System.out.print("2. Gravidade\n");
        System.out.print("3. Orbita Sideral\n");
        System.out.print("4. Rotacao Sideral\n");
        System.out.print("5. Temperatura Media\n");
        System.out.println("6. Voltar\n");

        System.out.print("Escolha sua opcao: ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite densidade minima: ");
                min = sc.nextDouble();

                System.out.print("Digite densidade maxima: ");
                max = sc.nextDouble();

                for(int i = 0; i < lista.size();i++){
                    if(lista.get(i).getDensity() >= min && lista.get(i).getDensity() <= max){
                        lista.get(i).imprimirDados();
                        existeUm = true;
                    }
                }

                if(existeUm == false){
                    System.out.println("Não foi encontrado um corpo celeste com esses dados!");
                }

                break;
            case 2:
                System.out.print("Digite gravidade minima: ");
                min = sc.nextDouble();

                System.out.print("Digite gravidade maxima: ");
                max = sc.nextDouble();

                for(int i = 0; i < lista.size();i++){
                    if(lista.get(i).getGravity() >= min && lista.get(i).getGravity() <= max){
                        lista.get(i).imprimirDados();
                        existeUm = true;
                    }
                }

                if(existeUm == false){
                    System.out.println("Não foi encontrado um corpo celeste com esses dados!");
                }

                break;
            case 3:
                System.out.print("Digite orbita sideral minima: ");
                min = sc.nextDouble();

                System.out.print("Digite orbita sideral maxima: ");
                max = sc.nextDouble();

                for(int i = 0; i < lista.size();i++){
                    if(lista.get(i).getSideralOrbit() >= min && lista.get(i).getSideralOrbit() <= max){
                        lista.get(i).imprimirDados();
                        existeUm = true;
                    }
                }

                if(existeUm == false){
                    System.out.println("Não foi encontrado um corpo celeste com esses dados!");
                }

                break;
            case 4:
                System.out.print("Digite rotacao sideral minima: ");
                min = sc.nextDouble();

                System.out.print("Digite rotacao sideral maxima: ");
                max = sc.nextDouble();

                for(int i = 0; i < lista.size();i++){
                    if(lista.get(i).getSideralRotation() >= min && lista.get(i).getSideralRotation() <= max){
                        lista.get(i).imprimirDados();
                        existeUm = true;
                    }
                }

                if(existeUm == false){
                    System.out.println("Não foi encontrado um corpo celeste com esses dados!");
                }

                break;
            case 5:
                System.out.print("Digite temperatura media minima: ");
                min = sc.nextDouble();

                System.out.print("Digite temperatura media maxima: ");
                max = sc.nextDouble();

                for(int i = 0; i < lista.size();i++){
                    if(lista.get(i).getAvgTemp() >= min && lista.get(i).getAvgTemp() <= max){
                        lista.get(i).imprimirDados();
                        existeUm = true;
                    }
                }

                if(existeUm == false){
                    System.out.println("Não foi encontrado um corpo celeste com esses dados!");
                }
                break;
            case 6:
                return;
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

    public static void planejamentoMissao(Scanner sc, MeuHashMap hashMap){
        List<CorpoCeleste> lista = hashMap.retornarTodosCorpoCeleste();
        List<CorpoCeleste> listaCorpoValidos = new ArrayList<>();

        for(int i = 0; i < lista.size();i++){
            if(lista.get(i).getDensity() > 1 && lista.get(i).getSideralOrbit() > 0){
                listaCorpoValidos.add(lista.get(i));
            }
        }

        double alvo;
        int quantidadeParadas = 0;
        double retornoAtual = 0;

        System.out.print("BEM VINDO AO PLANEJAMENTO DA MISSAO\n\n");

        System.out.print("Digite retorno maximo desejado(Max: 227): ");
        alvo = sc.nextDouble();

        listaCorpoValidos.sort((a, b) -> {
            double razaoA = a.getDensity() / a.getSideralOrbit();
            double razaoB = b.getDensity() / b.getSideralOrbit();
            return Double.compare(razaoB, razaoA);
        });

        for(int i = 0; i < listaCorpoValidos.size();i++){
            if(listaCorpoValidos.get(i).getId().equals("aton")){
                continue;
            }

            if(retornoAtual >= alvo){
                break;
            }

            quantidadeParadas++;
            retornoAtual += listaCorpoValidos.get(i).getDensity();
        }

        System.out.print("\nRESULTADO MISSAO\n\n");
        System.out.printf("Retorno desejado: %f\n", alvo);
        System.out.printf("Retorno obtido: %f\n", retornoAtual);
        System.out.printf("Numero de paradas: %d\n", quantidadeParadas);
    }
}