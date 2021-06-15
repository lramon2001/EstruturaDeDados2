package mapas;

import listasligadas.ListaLigada;


public class Mapa <K,V>{
    private ListaLigada<ListaLigada<Associacao<K,V>>> elementos;
    private int quantidadeCategorias;

    public Mapa(){
        this.elementos= new ListaLigada<ListaLigada<Associacao<K,V>>>();
        for(int i=0;i<this.quantidadeCategorias;i++){
            this.elementos.inserir(new ListaLigada<Associacao<K,V>>());
        }
    }
  private int gerarNumeroEspalhamento(K chave){
        return Math.abs(chave.hashCode()%this.quantidadeCategorias);
  }
  public boolean contemChave(K chave){
        int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
        ListaLigada<Associacao<K,V>> categoria = this.elementos.recuperar(numeroEspalhamento);
        for (int i=0;i< categoria.tamanho();i++){
            Associacao<K,V> associacao = categoria.recuperar(i);
            if(associacao.getChave().equals(chave)){
                return true;
            }
        }
        return false;
  }
  public void remover (K chave){
        int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
        ListaLigada<Associacao<K,V>> categoria = this.elementos.recuperar(numeroEspalhamento);
        for(int i=0;i<categoria.tamanho();i++){
            Associacao<K,V> associacao= categoria.recuperar(i);
            if(associacao.getChave().equals(chave)){
                categoria.remover(associacao);
                return;
            }
        }
        throw new IllegalArgumentException(String.format("A chave %s não existe",chave));
  }
  public void adicionar (K chave, V value){
        if(this.contemChave(chave)){
            this.remover(chave);
        }
        int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
        ListaLigada<Associacao<K,V>> categoria = this.elementos.recuperar(numeroEspalhamento);
        categoria.inserir(new Associacao<K,V>(chave,value));
  }
}
