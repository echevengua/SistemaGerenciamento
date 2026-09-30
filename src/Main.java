import estruturaDeDados.MeuHashMap.MeuHashMap;
import menu.Menu;
import obtencaoDados.ParsingJson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        MeuHashMap hashMap = new MeuHashMap();
        ParsingJson parsingJson = new ParsingJson();

        int opcao;
        boolean flagCarregamentoDados = false;

        System.out.print("BEM VINDO AO SISTEMA DE GERENCIAMENTO E PLANEJAMENTO DE MISSOES ESPACIAIS\n");

        while(true){
            System.out.print("\n1. Carregamento de Dados\n");
            System.out.print("2. Consulta dos Dados\n");
            System.out.print("3. Imprimir informacoes tabela hash\n");
            System.out.print("4. Sair\n");

            System.out.print("Escolha sua opcao: ");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    Menu.carregamentoDados(sc,hashMap);

                    break;
                case 2:
                    Menu.consultaDados(sc,hashMap);

                    break;
                case 3:
                    hashMap.imprimirInformacoes();

                    break;
                case 4:
                    sc.close();
                    System.out.print("SAINDO DO SISTEMA...\n");
                    System.exit(0);
            }
        }
    }
}
