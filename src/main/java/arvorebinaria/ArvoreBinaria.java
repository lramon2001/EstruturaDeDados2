package arvorebinaria;




public class ArvoreBinaria <T>{
    private NoArvore<T> raiz;

    public ArvoreBinaria(){
        this.raiz=null;
    }
    public NoArvore<T> getRaiz(){
        return this.raiz;
    }
    private void inserir(NoArvore<T>noReferencia, NoArvore<T> novoNo){
        if(novoNo.peso()>noReferencia.peso()){
            if(noReferencia.getNoDireito()==null){
                noReferencia.setNoDireito(novoNo);
            }
            else{
                inserir(noReferencia.getNoDireito(),novoNo);
            }
        }
        else{
            if(noReferencia.getNoEsquerdo()==null){
                noReferencia.setNoEsquerdo(novoNo);
            }
            else{
                inserir(noReferencia.getNoEsquerdo(),novoNo);
            }
        }
    }

    public void inserir(NoArvore<T> novoNo){
        novoNo.setNoEsquerdo(null);
        novoNo.setNoDireito(null);
        if(this.raiz==null){
            this.raiz=novoNo;
        }
        else{
            this.inserir(this.raiz,novoNo);
        }
    }

}
