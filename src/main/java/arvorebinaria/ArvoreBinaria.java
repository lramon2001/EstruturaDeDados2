package arvorebinaria;




public class ArvoreBinaria <T>{
    private NoArvore<T> raiz;

    public ArvoreBinaria(){
        this.raiz=null;
    }
    public NoArvore<T> getRaiz(){
        return this.raiz;
    }
    public void inserir(NoArvore<T>noReferencia, NoArvore<T> novoNo){
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
}
