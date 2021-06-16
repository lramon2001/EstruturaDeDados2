package arvorebinaria;

public abstract class NoArvore<T>{
    protected T elemento;
    private NoArvore<T> noEsquerdo;
    private NoArvore<T> noDireito;

    public NoArvore(T elemento){
        this.elemento=elemento;
        this.noDireito=null;
        this.noEsquerdo=null;
    }

    public T getElemento() {
        return elemento;
    }

    public NoArvore<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NoArvore<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public NoArvore<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(NoArvore<T> noDireito) {
        this.noDireito = noDireito;
    }

    public abstract int peso();
}
