
package estruturaDeDados.minhaArvoreB;

import objetos.corpoCeleste.CorpoCeleste;

public class MinhaArvoreB {

    Pagina raiz;
    int ordem;
    int numSplit;
    int altura;

    public MinhaArvoreB(int ordem) {
        this.ordem = ordem;
        this.raiz = null;
        this.numSplit = 0;
        this.altura = 0;
    }

    public Pagina getRaiz(){
        return this.raiz;
    }

    public void inserir(CorpoCeleste corpoCeleste){
        if(raiz == null){
            raiz = new Pagina(true, ordem);
            this.altura = 1;

            Chave chave = new Chave();
            chave.chave = corpoCeleste.getSideralOrbit();
            chave.corpoCeleste = corpoCeleste;

            raiz.chaves[0] = chave;
            raiz.numChaves = 1;
        }else{
            if(raiz.numChaves == ordem - 1){
                Pagina novaRaiz = new Pagina(false, ordem);
                novaRaiz.filho[0] = raiz;

                novaRaiz.split(novaRaiz, 0);
                this.numSplit++;
                raiz = novaRaiz;
                this.altura++;
            }
            raiz.inserirNaoCheio(raiz,corpoCeleste,this);
        }
    }

    public void listarCorposCelestes(Pagina raiz){
        if(raiz != null){
            int i;
            for(i = 0;i < raiz.numChaves;i++){
                listarCorposCelestes(raiz.filho[i]);
                raiz.chaves[i].corpoCeleste.imprimirDados();
            }
            listarCorposCelestes(raiz.filho[i]);
        }
    }

    public void imprimirInformacoes(){
        System.out.print("\n╔═══════════════════════\n");
        System.out.print("║INFORMACOES ARVORE B\n║\n");
        System.out.printf("║Altura: %d\n", this.altura);
        System.out.printf("║Numero de Splits: %d\n", this.numSplit);
    }
}
