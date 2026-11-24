
package estruturaDeDados.minhaArvoreB;

public class MinhaArvoreB {

    Pagina raiz;
    int ordem;
    int numSplit;

    public MinhaArvoreB(int ordem) {
        this.ordem = ordem;
        this.raiz = null;
        this.numSplit = 0;
    }

    public void inserir(int chave){
        if(raiz == null){
            raiz = new Pagina(true, ordem);
            raiz.chaves[0] = chave;
            raiz.numChaves = 1;
        }else{
            if(raiz.numChaves == ordem - 1){
                Pagina novaRaiz = new Pagina(false, ordem);
                novaRaiz.filho[0] = raiz;

                novaRaiz.split(novaRaiz, 0);
                this.numSplit++;
                raiz = novaRaiz;
            }
            raiz.inserirNaoCheio(raiz, chave,this);
        }
    }

    public void imprimirInformacoes(){
        System.out.print("\n╔═══════════════════════\n");
        System.out.print("║INFORMACOES ARVORE B\n║\n");
//        System.out.printf("║Altura: %d\n", this.tamanho);
        System.out.printf("║Numero de Splits: %d\n", this.numSplit);
    }
}
