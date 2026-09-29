package menu;

import estruturaDeDados.MeuHashMap.MeuHashMap;

import java.util.Scanner;

public class Menu {
    public static void consultaDados(Scanner sc, MeuHashMap hashMap){
        int opcao;
        String id;

        System.out.printf("1. Pesquisa por ID\n");
        System.out.printf("2. Pesquisa por atributos\n");
        System.out.printf("3. Listagem\n");
        System.out.printf("4. Voltar\n");

        System.out.printf("Escolha sua opcao: ");
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


}
