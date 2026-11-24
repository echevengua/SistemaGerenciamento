package estruturaDeDados.minhaTrie;

public class MinhaTrie {
    Nodo raiz;

    public MinhaTrie(){
        this.raiz = new Nodo();
    }

    public void inserir(String conteudo){
        if(conteudo.isEmpty()){

            return;
        }

        Nodo aux = this.raiz;
        int caracter = Character.toLowerCase(conteudo.charAt(0));
        int indice = caracter - 'a';

        for(int i = 0;i < conteudo.length();i++){
            caracter = Character.toLowerCase(conteudo.charAt(i));
            indice = caracter - 'a';

            if(indice < 0 || indice > 25){
                if(caracter == '/'){
                    indice = 26;
                }else if(caracter == '('){
                    indice = 27;
                }else if(caracter == ')'){
                    indice = 28;
                }else if(caracter == ' '){
                    indice = 29;
                }else{
                    caracter = '#';
                    indice = 30;
                }
            }

            if(aux.proximo[indice] == null) {
                aux.proximo[indice] = new Nodo();
                aux.proximo[indice].conteudo = (char)caracter;
                aux.proximo[indice].fimDePalavra = 0;

                aux = aux.proximo[indice];
            }else{
                aux = aux.proximo[indice];
            }
        }

        aux.fimDePalavra++;
    }

    public void buscar(String conteudo){
        Nodo aux = this.raiz;
        char caracter;
        int indice;
        int nosVisitados = 0;

        for(int i = 0;i < conteudo.length();i++){
            caracter = Character.toLowerCase(conteudo.charAt(i));
            indice = Character.toLowerCase(conteudo.charAt(i)) - 'a';

            if(indice < 0 || indice > 25){
                if(caracter == '/'){
                    indice = 26;
                }else if(caracter == '('){
                    indice = 27;
                }else if(caracter == ')'){
                    indice = 28;
                }else if(caracter == ' '){
                    indice = 29;
                }else{
                    caracter = '#';
                    indice = 30;
                }
            }

            if(aux.proximo[indice] == null){
                System.out.printf("Corpo celeste denominado \"%s\" não está presente no sistema!\n", conteudo);

                return;
            }else{
                nosVisitados++;
                aux = aux.proximo[indice];
            }
        }

        if(aux.fimDePalavra > 0){
            System.out.printf("Corpo celeste denominado \"%s\" está presente no sistema!\n", conteudo);
            System.out.printf("Total nos visitados: %d\n", nosVisitados);
        }else{
            System.out.printf("Corpo celeste denominado \"%s\" não está presente no sistema!\n", conteudo);
        }
    }

    private int percorrer(Nodo atual, String palavra, int nosVisitados) {
        if (atual.fimDePalavra > 0) {
            System.out.print(palavra + " Nos Visitados: " + nosVisitados + "\n");
        }

        for (int i = 0; i < atual.proximo.length; i++) {

            if (atual.proximo[i] != null) {
                nosVisitados++;
                nosVisitados = percorrer(atual.proximo[i],palavra + atual.proximo[i].conteudo,nosVisitados);
            }
        }

        return nosVisitados;
    }

    public void buscarPrefixo(String prefixo) {
        Nodo aux = this.raiz;
        char caracter;
        int indice;
        int nosVisitados = 0;

        for (int i = 0; i < prefixo.length(); i++) {
            caracter = Character.toLowerCase(prefixo.charAt(i));
            indice = caracter - 'a';

            if(indice < 0 || indice > 25){
                if(caracter == '/'){
                    indice = 26;
                }else if(caracter == '('){
                    indice = 27;
                }else if(caracter == ')'){
                    indice = 28;
                }else if(caracter == ' '){
                    indice = 29;
                }else{
                    caracter = '#';
                    indice = 30;
                }
            }

            if(aux.proximo[indice] == null){
                System.out.print("Nenhum corpo celeste encontrado!\n");
                return;
            }else{
                nosVisitados++;
                aux = aux.proximo[indice];
            }
        }

        System.out.print("Corpo celeste(s) encontrado(s):\n");

        nosVisitados = percorrer(aux,prefixo.toLowerCase(),nosVisitados);
    }

}
