package arvorebinaria;


import javax.swing.*;

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

    private NoArvore<T> buscar(NoArvore<T> referencia ,NoArvore<T> procurado){
        if(referencia.getElemento().equals(procurado.getElemento())){
            return referencia;
        }
        else{
            if(referencia.peso()<procurado.peso()){
                if(referencia.getNoDireito()==null){
                    JOptionPane.showMessageDialog(null,"O elemento "+procurado.getElemento()+" não foi encontrado");
                    throw new IllegalArgumentException("O elemento "+procurado.getElemento()+" não foi encontrado");

                }
                else{
                    return this.buscar(referencia.getNoDireito(),procurado);
                }
            }
            else{
                if(referencia.getNoEsquerdo()==null){
                    JOptionPane.showMessageDialog(null,"O elemento "+procurado.getElemento()+" não foi encontrado");
                    throw new IllegalArgumentException("O elemento "+procurado.getElemento()+" não foi encontrado");
                }
                else{
                   return this.buscar(referencia.getNoEsquerdo(),procurado);
                }
            }
        }

    }
    public NoArvore<T> buscar(NoArvore<T> procurado){
        return this.buscar(this.raiz,procurado);
    }

    private void emOrdem(NoArvore<T> referencia){
        if(referencia.getNoEsquerdo()!=null){
            emOrdem(referencia.getNoEsquerdo());
            System.out.println(referencia.getElemento().toString());
            if(referencia.getNoDireito()!=null){
                emOrdem(referencia.getNoDireito());
            }
        }
        else{
            System.out.println(referencia.getElemento().toString());
            if(referencia.getNoDireito()!=null){
                emOrdem(referencia.getNoDireito());
            }
        }
    }

    public void emOrdem(){
        this.emOrdem(this.raiz);
    }
    private void preOrdem(NoArvore<T> referencia){
        System.out.println(referencia.getElemento().toString());
        if(referencia.getNoEsquerdo()!= null){
            preOrdem(referencia.getNoEsquerdo());
            if(referencia.getNoDireito()!=null){
                preOrdem(referencia.getNoDireito());
            }
        }
        else{
            if(referencia.getNoDireito()!=null){
                preOrdem(referencia.getNoDireito());
            }
        }

    }
    private void posOrdem(NoArvore<T> referencia){
        if(referencia.getNoEsquerdo()!=null){
            posOrdem(referencia.getNoEsquerdo());
            if(referencia.getNoDireito()!=null){
                posOrdem(referencia.getNoDireito());
            }
            System.out.println(referencia.getElemento().toString());
        }
        else{
            if(referencia.getNoDireito()!=null){
                posOrdem(referencia.getNoDireito());
            }else{
                System.out.println(referencia.getElemento().toString());
            }

        }
    }
    public void posOrdem(){
        this.posOrdem(this.raiz);
    }
    private int altura(NoArvore<T> referencia){
        if(referencia== null){

        }
        int alturaDireita = altura(referencia.getNoDireito());
        int alturaEsquerda = altura(referencia.getNoEsquerdo());
        return alturaDireita>alturaEsquerda ? alturaDireita +1 : alturaEsquerda +1;
    }

    public int altura(){
        return this.altura(this.raiz);
    }

    public void preOrdem (){
        this.preOrdem(this.raiz);
    }
    @Override
    public String toString() {
        return this.raiz==null?"[(X)]":this.raiz.toString();
    }
}
