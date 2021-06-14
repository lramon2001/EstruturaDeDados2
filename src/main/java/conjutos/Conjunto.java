package conjutos;

import listasligadas.ListaLigada;

public class Conjunto<T> {
    private ListaLigada<T> listaLigada;

    public Conjunto() {
        this.listaLigada = new ListaLigada<T>();
    }

    public boolean inserir(T elemento) {
        if(elemento!=null && !contem(elemento)){
            this.listaLigada.inserir(elemento);
            return true;
        }
        return false;
    }

    public boolean inserirEm(int posicao, T elemento) {
        if(elemento!=null && !contem(elemento)){
            this.listaLigada.inserirEm(posicao, elemento);
            return true;
        }
          return false;
    }

    public T recuperar(int posicao) {
       return this.listaLigada.recuperar(posicao);
    }

    public boolean estaVazio() {
        return this.listaLigada.estaVazia();
    }

    public int tamanho() {
        return this.listaLigada.tamanho();
    }

    public boolean contem(T elemento) {
        return this.listaLigada.contem(elemento);
    }

    public int indice(T elemento) {
        return this.listaLigada.indice(elemento);
    }

    public void remover(int posicao) {
        this.listaLigada.remover(posicao);
    }

    public void remover(T elemento) {
        this.listaLigada.remover(elemento);
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "listaLigada=" + listaLigada +
                '}';
    }
}
