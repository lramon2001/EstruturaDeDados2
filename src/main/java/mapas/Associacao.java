package mapas;

public class Associacao <K,V> {
    private K chave;
    private V valor;

    public Associacao(K chave, V value){
        this.chave=chave;
        this.valor=value;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }
}
