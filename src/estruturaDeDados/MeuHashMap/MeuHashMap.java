package estruturaDeDados.MeuHashMap;

import objetos.corpoCeleste.CorpoCeleste;

public class MeuHashMap {

    int tamanho;
    int numElementos;
    int numColisoes;
    Double fatorDeCarga;
    Celula[] tabela;

    public MeuHashMap(){
        this.tamanho = 10;
        this.numElementos = 0;
        this.numColisoes = 0;
        this.fatorDeCarga = 0.0;
        this.tabela = new Celula[10];
    }

    public int hashFunction(String idCorpoCeleste, int tamTabela){
        int g = 31;
        int hash = 0;

        for(int i = 0;i < idCorpoCeleste.length();i++){
            hash = g * hash + idCorpoCeleste.charAt(i);
        }
        return Math.abs(hash) % tamTabela;
    }

    public void inserir(CorpoCeleste corpoCeleste){
        int indice = hashFunction(corpoCeleste.getId(), this.tamanho);
        this.numElementos++;
        this.fatorDeCarga = (double)numElementos/tamanho;

        if(tabela[indice] == null){
            tabela[indice] = new Celula();
            tabela[indice].conteudo = corpoCeleste;
            tabela[indice].proximo = null;

            if(this.fatorDeCarga >= 0.75){
                reHashing(this.fatorDeCarga);
            }
            return;
        }

        Celula aux = tabela[indice];

        while(aux.proximo != null){
            aux = aux.proximo;
        }

        aux.proximo = new Celula();
        aux.proximo.conteudo = corpoCeleste;
        aux.proximo.proximo = null;
        this.numColisoes++;

        if(this.fatorDeCarga >= 0.75){
            reHashing(this.fatorDeCarga);
        }
    }

    public void remover(String idCorpoCeleste){
        int indice = hashFunction(idCorpoCeleste, this.tamanho);

        if(this.tabela[indice] == null){
            return;
        }

        if(this.tabela[indice].conteudo.getId().equals(idCorpoCeleste)){
            this.tabela[indice] = this.tabela[indice].proximo;
            this.numElementos--;
            this.fatorDeCarga = (double)numElementos/tamanho;

            if(this.fatorDeCarga <= 0.25){
                reHashing(this.fatorDeCarga);
            }
            return;
        }

        Celula aux = this.tabela[indice];

        while(aux.proximo != null){
            if(aux.proximo.conteudo.getId().equals(idCorpoCeleste)){
                aux.proximo = aux.proximo.proximo;
                this.numElementos--;
                this.fatorDeCarga = (double)numElementos/tamanho;

                if(this.fatorDeCarga <= 0.25){
                    reHashing(this.fatorDeCarga);
                }

                return;
            }
            aux = aux.proximo;
        }
    }

    private void reHashing(Double fatorDeCarga){
        int novoTamanho = tamanho;
        this.numColisoes = 0;

        if(fatorDeCarga >= 0.75){
            novoTamanho *= 2;
        }else if(fatorDeCarga <= 0.25 && tamanho > 10){
            novoTamanho /= 2;
        }else{
            return;
        }

        Celula[] novaTabela = new Celula[novoTamanho];

        for(int i = 0;i < this.tamanho;i++){
            Celula aux = this.tabela[i];

            while(aux != null){
                int indice = hashFunction(aux.conteudo.getId(),novoTamanho);

                if(novaTabela[indice] == null){
                    novaTabela[indice] = new Celula();
                    novaTabela[indice].conteudo = aux.conteudo;
                    novaTabela[indice].proximo = null;

                    aux = aux.proximo;
                    continue;
                }

                Celula aux2 = novaTabela[indice];

                while(aux2.proximo != null){
                    aux2 = aux2.proximo;
                }

                aux2.proximo = new Celula();
                aux2.proximo.conteudo = aux.conteudo;
                aux2.proximo.proximo = null;
                this.numColisoes++;
                aux = aux.proximo;
            }
        }

        this.tabela = novaTabela;
        this.tamanho = novoTamanho;
    }

    public CorpoCeleste retonarCorpoCeleste(String idCorpoCeleste){
        int indice = hashFunction(idCorpoCeleste,this.tamanho);

        Celula aux = this.tabela[indice];

        while(aux != null){
            if(aux.conteudo.getId().equals(idCorpoCeleste)){
                return aux.conteudo;
            }
            aux = aux.proximo;
        }

        return null;
    }

    public void imprimirInformacoes(){
        System.out.print("\n=====================\n");
        System.out.print("|INFORMACOES TABELA HASH\n|\n");
        System.out.printf("|Tamanho maximo: %d\n", this.tamanho);
        System.out.printf("|Numero de Elementos: %d\n", this.numElementos);
        System.out.printf("|Numero de Colisoes: %d\n", this.numColisoes);
        System.out.printf("|Fator de Carga: %f\n\n", this.fatorDeCarga);
    }
}