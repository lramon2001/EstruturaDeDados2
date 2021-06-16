package arvorebinaria;

import modelos.Pessoa;

public class NoArvorePessoa extends NoArvore<Pessoa>{


    public NoArvorePessoa(Pessoa elemento) {
        super(elemento);
    }

    @Override
    public int peso() {
        return this.elemento.getId();
    }
}
