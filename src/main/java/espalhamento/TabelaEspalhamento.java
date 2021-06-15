package espalhamento;

import listasligadas.ListaLigada;

public class TabelaEspalhamento<T> {
    private ListaLigada<ListaLigada<T>> elementos;
    private int numeroCategorias=16;
    public TabelaEspalhamento(){
        elementos=new ListaLigada<ListaLigada<T>>();
        for(int i=0;i<this.numeroCategorias;i++){
            elementos.inserir(new ListaLigada<T>());
        }
    }
    private int gerarNumeroEspalhamento(T elemento){
        return elemento.hashCode() % this.numeroCategorias;
    }
    public boolean inserir(T elemento){
        int numeroEspalahamento = gerarNumeroEspalhamento(elemento);
        ListaLigada<T> categoria = elementos.recuperar(numeroEspalahamento);
        if(categoria.contem(elemento)){
            return false;
        }
        categoria.inserir(elemento);
        return true;
    }

}
