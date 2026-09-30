package menu;

import estruturaDeDados.MeuHashMap.MeuHashMap;
import obtencaoDados.HttpBodiesService;
import obtencaoDados.ParsingJson;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void consultaDados(Scanner sc, MeuHashMap hashMap){
        int opcao;
        String id;

        System.out.print("\n1. Pesquisa por ID\n");
        System.out.print("2. Pesquisa por atributos\n");
        System.out.print("3. Listagem\n");
        System.out.print("4. Voltar\n");

        System.out.print("Escolha sua opcao: ");
        opcao = sc.nextInt();

        switch(opcao){
            case 1:
                System.out.print("Digite ID a ser procurado: ");
                id = sc.next();

                if(hashMap.retonarCorpoCeleste(id) == null){
                    System.out.print("CORPO CELESTE NAO ENCONTRADO!\n");
                }else{
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

    public static void carregamentoDados(Scanner sc, MeuHashMap hashMap) {
        ParsingJson parsingJson = new ParsingJson();

        int opcao;
        String jsonString;

        while(true){
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
                        jsonString = HttpBodiesService.getStar();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,jsonString);

                    System.out.print("\nEstrela carregada com sucesso!\n");

                    break;
                case 2:
                    try {
                        jsonString = HttpBodiesService.getAllPlanets();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,jsonString);

                    System.out.print("\nPlanetas carregados com sucesso!\n");

                    break;
                case 3:
                    try {
                        jsonString = HttpBodiesService.getAllDwarfPlanets();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,jsonString);

                    System.out.print("\nPlanetas anoes carregados com sucesso!\n");

                    break;
                case 4:
                    try {
                        jsonString = HttpBodiesService.getAllAsteroids();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,jsonString);

                    System.out.print("\nAsteroides carregados com sucesso!\n");

                    break;
                case 5:
                    try {
                        jsonString = HttpBodiesService.getAllComets();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,jsonString);

                    System.out.print("\nCometas carregados com sucesso!\n");

                    break;
                case 6:
                    try {
                        jsonString = HttpBodiesService.getAllMoons();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,jsonString);

                    System.out.print("\nLuas carregadas com sucesso!\n");

                    break;
                case 7:
                    try {
                        jsonString = HttpBodiesService.getAllCelestialBodies();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    parsingJson.parsingCorpoCeleste(hashMap,jsonString);

                    System.out.print("\nCorpos Celestes carregados com sucesso!\n");

                    break;
                case 8:
                    return;
            }
        }
    }


}
