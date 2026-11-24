package estruturaDeDados.minhaArvoreB;

public class Pagina {
    int ordem;
    int numChaves;
    int[] chaves;
    Pagina[] filho;
    boolean folha;

    public Pagina(boolean folha, int ordem){
        this.ordem = ordem;
        this.numChaves = 0;
        this.folha = folha;

        chaves = new int[ordem - 1];
        filho = new Pagina[ordem];
    }

    public void split(Pagina pai, int index){
        Pagina filho = pai.filho[index];
        Pagina novaPagina = new Pagina(filho.folha, ordem);

        novaPagina.numChaves = ordem / 2 - 1;

        for(int i = 0; i < ordem / 2 - 1; i++){
            novaPagina.chaves[i] = filho.chaves[i + ordem / 2];
        }

        if(!filho.folha){
            for(int i = 0; i < ordem / 2; i++){
                novaPagina.filho[i] = filho.filho[i + ordem / 2];
            }
        }
        filho.numChaves = ordem / 2 - 1;

        for(int i = pai.numChaves; i > index; i--){
            pai.filho[i + 1] = pai.filho[i];
        }
        pai.filho[index + 1] = novaPagina;

        for(int i = pai.numChaves - 1; i >= index; i--){
            pai.chaves[i + 1] = pai.chaves[i];
        }

        pai.chaves[index] = filho.chaves[ordem / 2 - 1];
        pai.numChaves++;
    }

    public void inserirNaoCheio(Pagina pagina, int chave, MinhaArvoreB arvoreB){
        int i = pagina.numChaves - 1;

        if(pagina.folha){
            while(i >= 0 && pagina.chaves[i] > chave){
                pagina.chaves[i + 1] = pagina.chaves[i];
                i--;
            }

            pagina.chaves[i + 1] = chave;
            pagina.numChaves++;
        }else{
            while(i >= 0 && pagina.chaves[i] > chave){
                i--;
            }
            i++;

            if(pagina.filho[i].numChaves == ordem - 1){
                split(pagina, i);
                arvoreB.numSplit++;

                if(pagina.chaves[i] < chave){
                    i++;
                }
            }

            inserirNaoCheio(pagina.filho[i], chave,arvoreB);
        }
    }
}
