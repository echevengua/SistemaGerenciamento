import estruturaDeDados.MeuHashMap.MeuHashMap;
import menu.Menu;
import obtencaoDados.HttpBodiesService;
import obtencaoDados.ParsingJson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        MeuHashMap hashMap = new MeuHashMap();
        ParsingJson parsingJson = new ParsingJson();

        HttpBodiesService.inicializar();

        int opcao;

        System.out.print("BEM VINDO AO SISTEMA DE GERENCIAMENTO E PLANEJAMENTO DE MISSOES ESPACIAIS\n");

        while(true){
            System.out.print("\n1. Obter Dados da API\n");
            System.out.print("2. Carregar Dados Para Tabela Hash\n");
            System.out.print("3. Consulta dos Dados\n");
            System.out.print("4. Imprimir informacoes tabela hash\n");
            System.out.print("5. Planejamento Missao\n");
            System.out.print("6. Sair\n");

            System.out.print("Escolha sua opcao: ");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    Menu.carregaJson(sc);

                    break;
                case 2:
                    Menu.carregaDadosTabelaHash(sc,hashMap);

                    break;
                case 3:
                    Menu.consultaDados(sc,hashMap);

                    break;
                case 4:
                    hashMap.imprimirInformacoes();

                    break;
                case 5:
                    Menu.planejamentoMissao(sc,hashMap);

                    break;
                case 6:
                    sc.close();
                    System.out.print("SAINDO DO SISTEMA...\n");
                    System.exit(0);
            }
        }
    }
}
