package conjutos;

import espalhamento.TabelaEspalhamento;
import listasligadas.ListaLigada;

public class Conjunto<T> {
    private TabelaEspalhamento<T> elementos;

    public Conjunto() {
        this.elementos = new TabelaEspalhamento<T>();
    }

    public boolean inserir(T elemento) {
        return elementos.inserir(elemento);
    }

    public boolean estaVazio() {
        return this.elementos.tamanho() == 0;
    }

    public int tamanho() {
        return this.elementos.tamanho();
    }

    public boolean contem(T elemento) {
        return this.elementos.contem(elemento);
    }


    public void remover(T elemento) {
        this.elementos.remover(elemento);
    }

   /* private boolean contemMelhorado(T elemento){
        for(int i=0;i<this.tamanho();i++){
            T comparador = this.elementos.recuperar(i);
            if(comparador.hashCode()== elemento.hashCode()){
                return true;
            }
        }
        return false;
    }

    */

    @Override
    public String toString() {
        return "Conjunto{" +
                "listaLigada=" + elementos +
                '}';
    }
}
