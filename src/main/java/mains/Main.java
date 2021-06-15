package mains;


import conjutos.Conjunto;
import filas.Fila;
import listasligadas.ListaDuplamenteLigada;
import listasligadas.ListaLigada;
import modelos.Pessoa;
import pilhas.Pilha;
import vetores.Vetor;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        menu();
    }
    private static void menu() throws IllegalAccessException {
        int x;
        do{
            String menu =
                    "1-Fazer gerenciamento de memória;\n" +
                            "2-Estudo de vetores\n"+
                            "3-Estudo de listas encadeadas\n"+
                            "4-Estudo de listas duplamente encadeadas\n"+
                            "5-Estudo de pilhas\n"+
                            "6-Estudo de filas\n"+
                            "7-Estudo de conjuntos\n"+
                            "0-Sair";

            String strx = JOptionPane.showInputDialog(null,menu);
            x=Integer.parseInt(strx);
            switch(x){
                case 1:
                    gerenciamentoDeMemoria();
                    break;
                case 2:

                    vetor();
                    break;
                case 3:
                    listaLigada();
                    break;
                case 4:
                    listaDuplamenteLigada();
                    break;
                case 5:
                    pilha();
                    break;
                case 6:
                    fila();
                    break;
                case 7:
                    conjunto();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Obrigado por testar meu software! " +
                            "\n\n     MIT License © Lucas Ramon ");
            }
        }
        while(x!=0);
    }

    private static void conjunto() {
        Conjunto<Pessoa> conjuntoPessoas = new Conjunto<Pessoa>();
        JOptionPane.showMessageDialog(null,"O conjunto está vazio?\n" +
                "R: "+conjuntoPessoas.estaVazio());
        Pessoa raul = new Pessoa(36,"Raul Seixas");
        JOptionPane.showMessageDialog(null,"Inserindo uma pessoa chamada Raul Seixas e id=36" +
                "\n Foi possível adicioná-lo ao set? \n" +
                "R:"+conjuntoPessoas.inserir(raul));
        JOptionPane.showMessageDialog(null,conjuntoPessoas.toString());
        Pessoa raul2 = new Pessoa(36,"Raul Seixas");
        JOptionPane.showMessageDialog(null,"Tentando adicionar o Raul ao set novamente...\n" +
                "Foi possível adicioná-lo ao set?" +
                "\nR:"+conjuntoPessoas.inserir(raul2));
        JOptionPane.showMessageDialog(null,conjuntoPessoas.toString());

    }

    private static void gerenciamentoDeMemoria(){
        JOptionPane.showMessageDialog(null,"Fazendo o gerenciamento usando variáveis int");
        int a =Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de a:"));
        JOptionPane.showMessageDialog(null,"Valor de a: "+a);
        int b=a;
        JOptionPane.showMessageDialog(null,"Agora o software criou a variável b e a ela foi atribuida o valor de a");
        JOptionPane.showMessageDialog(null,"O valor de a é: "+a+"\nO valor de b é: "+b);
        b = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um novo valor para b"));
        JOptionPane.showMessageDialog(null,"O valor de a é: "+a+"\nO valor de b é: "+b);
        JOptionPane.showMessageDialog(null,"A é igual a B? \n"+"R: "+(a==b));
        JOptionPane.showMessageDialog(null,"Até aqui tudo bem, nada fora do que já haviamos previsto.");
        JOptionPane.showMessageDialog(null,"Fazendo o gerenciamento usando variáveis do Tipo Pessoa");
        String nome=JOptionPane.showInputDialog(null,"Digite o nome para a pessoa 1");
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um id para a pessoa 1"));
        Pessoa p1 = new Pessoa(id,nome);
        JOptionPane.showMessageDialog(null,"Pessoa 1:\n"+p1.toString());
        Pessoa p2 = p1;
        JOptionPane.showMessageDialog(null,"Agora o software criou um objeto pessoa 2 idêntico ao pessoa 1.");
        JOptionPane.showMessageDialog(null,"Pessoa 1:\n"+p1.toString()+"\nPessoa 2:\n"+p2.toString());
        JOptionPane.showMessageDialog(null,"Agora vamos mudar o nome da pessoa 2 para fazermos um teste.");
        String nome2 = JOptionPane.showInputDialog(null,"Digite um novo nome para pessoa 2");
        p2.setNome(nome2);
        JOptionPane.showMessageDialog(null,"Pessoa 1:\n"+p1.toString()+"\nPessoa 2:\n"+p2.toString());
        JOptionPane.showMessageDialog(null,"p1 é igual p2?\n"+"R: "+(p1==p2));
        JOptionPane.showMessageDialog(null,"Doideiraaaa! O nome dos dois objetos mudaram!!!\nFreud Explica isso???");
        JOptionPane.showMessageDialog(null,
                "A explicação é simples. Ao fazer Pessoa p2=p1, na verdade estamos copiando a referência para acessar o objeto.\n" +
                        " Ou seja,estamos copiando o ponteiro que nos leva ao conteúdo do objeto p1. E como o ponteiro é o mesmo ele nos\n" +
                        " leva ao mesmo objeto (p1).");
        JOptionPane.showMessageDialog(null,
                "Vale explicitar o motivo do mesmo não ocorrer com os tipos inteiros" +
                        "\nA explicação também é simples!. Há duas regiões de memória em que a" +
                        "\nJVM pode alocar os dados: a stack e a heap. Ambas são capazes de ar-" +
                        "\nmazenar dados, a diferença é justamente o tipo de dado que elas guar-" +
                        "\ndam. A stack é uma região de memória muito pequena, porém muito organi-" +
                        "\nzada e é usada para guardar os valueTypes, ou seja, os tipos primitivos." +
                        "\nA região heap é muito maior e muito mais desergonizada e é utilizada pela" +
                        "\nJVM para alocar os dados mais complexos: referenceTypes.");
        JOptionPane.showMessageDialog(null,
                "Os ponteiros ficam alocados na stack, como os ponteiros são variáveis que " +
                        "\nguardam o endereço de memória dos referenceTypes, a JVM os utiliza para en-" +
                        "\ncontrar na caótica região heap e os encontram rapidinho. Sim, esta foi uma" +
                        "\nsacada genial da engenharia de software. Imagina se a JVM tivesse que acessar" +
                        "\ntoda a memória para encontrar um dado?? Com certeza os programas seriam muito" +
                        "\nlentos. Os tipos inteiros não sofreram a mudança ao mesmo tempo pois a JVM cria" +
                        "\nespaços separados na memória para todo tipo primitivo. ");



    }

    private static void vetor( ) throws IllegalAccessException {
        Vetor<Pessoa> vetor = new Vetor<Pessoa>();
        JOptionPane.showMessageDialog(null,"Seja bem vindo ao estudo de vetores. Preciso que você \n" +
                "Cadastre 3 pessoas para contuarmos o estudo");
        for(int i=0;i<vetor.tamanho();i++){
            Pessoa pessoa = new Pessoa();
            String nome = JOptionPane.showInputDialog(null,"Digite o nome da pessoa "+(i+1));
            int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o id da pessoa "+(i+1)));
            pessoa.setNome(nome);
            pessoa.setId(id);
            vetor.inserir(pessoa);
        }
        Pessoa renato = new Pessoa(29,"Renato Russo");
        vetor.inserirEm(1,renato);
        JOptionPane.showMessageDialog(null,
                "Você nem percebeu, mas o software adicionou uma pessoa ao vetor na posição 1 \n" +
                        "O nome dele é Renato Russo e o id dele é 29 ");
        StringBuilder lista = new StringBuilder();
        lista.append("Lista de pessoas\n");
        for(int i=0;i<vetor.tamanho();i++){
            lista.append("posição-> "+i+" nome: "+vetor.recuperar(i).getNome()+" id: "+vetor.recuperar(i).getId());
            lista.append("\n");
        }
        JOptionPane.showMessageDialog(null,lista.toString());

        Pessoa x = vetor.recuperar(1);
        Pessoa humberto = new Pessoa(160,"Humberto Gessinger");

        JOptionPane.showMessageDialog(null,"Agora o software criou dois novos objetos" +
                "\n Um  é idêntico a pessoa 2 que vc cadastrou e outro é o Humberto Gessinger, id: 160" +
                "\n Fizemos isto para testar as funções contem(),indice() e remover.");
        JOptionPane.showMessageDialog(null,"Software, objeto que o usuário cadastrou como pessoa 2 está na vetor?\n"+"Resposta: "+
                vetor.contem(x));
        JOptionPane.showMessageDialog(null,"Software, o Humberto Gessinger que não foi cadastrado está no vetor?\n"+"Resposta: "+
                vetor.contem(humberto));
        lista.delete(0,lista.length());
        JOptionPane.showMessageDialog(null,"Agora vamos testar a função indice()");
        JOptionPane.showMessageDialog(null ,"A posição do Renato Russo "+vetor.indice(renato));

        for(int i=0;i<vetor.tamanho();i++){
            lista.append("posição-> "+i+" nome: "+vetor.recuperar(i).getNome()+" id: "+vetor.recuperar(i).getId());
            lista.append("\n");
        }
        JOptionPane.showMessageDialog(null,"Agora vamos remover a primeira pessoa do vetor.");
        vetor.remover(0);
        JOptionPane.showMessageDialog(null,"Agora vamos remover o Renato Russo do vetor\n" +
                "mas Legião Urbana é muito bom !!!");
        vetor.remover(renato);
        lista.delete(0,lista.length());
        for(int i=0;i< vetor.tamanho();i++){
            lista.append("posição-> "+i+" nome: "+vetor.recuperar(i).getNome()+" id: "+vetor.recuperar(i).getId());
            lista.append("\n");
        }
        JOptionPane.showMessageDialog(null,lista.toString());
        JOptionPane.showMessageDialog(null,"Juntos fizemos uma estrutura de Dados muito famosa: o Vetor\n" +
                "Obrigado pela ajuda,camarada!!!");
    }

    private static void listaLigada(){
        ListaLigada<Pessoa> pessoas = new ListaLigada<Pessoa>();
        JOptionPane.showMessageDialog(null,"Seja bem vindo ao estudo das listas ligadas \n" +
                "Agora preciso que casdastre 4 pessoas para testarmos a nossa lista encadeada.");
        for(int i=0;i<4;i++){
            Pessoa pessoa = new Pessoa();
            String nome =JOptionPane.showInputDialog(null,"Digite o nome da pessoa "+(i+1));
            int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o id da pessoa "+(i+1)));
            pessoa.setNome(nome);
            pessoa.setId(id);
            pessoas.inserir(pessoa);
        }
        Pessoa aleatoria = new Pessoa(1111,"Michael Jackson");
        JOptionPane.showMessageDialog(null,pessoas.toString());
        JOptionPane.showMessageDialog(null,"Agora veremos se os métodos contem() e indice estão funcionado.");
        JOptionPane.showMessageDialog(null,"Software, a segunda pessoa que o usuário cadastrou está no vetor?\n"+pessoas.contem(pessoas.recuperar(1)));
        JOptionPane.showMessageDialog(null,"Você nem percebeu, mas o software criou uma pessoa chamada Michael Jackson.\n" +
                "Mas ele não foi adcionado à lista");
        JOptionPane.showMessageDialog(null,"Software, o Michael Jackson está na lista?\n"+pessoas.contem(aleatoria));


    }
    private static void listaDuplamenteLigada(){
        ListaDuplamenteLigada<Pessoa> pessoas = new ListaDuplamenteLigada<>();
        JOptionPane.showMessageDialog(null,"Seja bem vindo ao estudo das listas duplamente ligadas \n" +
                "Agora preciso que casdastre 4 pessoas para testarmos a nossa lista duplamente encadeada.");
        for(int i=0;i<4;i++){
            Pessoa pessoa = new Pessoa();
            String nome =JOptionPane.showInputDialog(null,"Digite o nome da pessoa "+(i+1));
            int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o id da pessoa "+(i+1)));
            pessoa.setNome(nome);
            pessoa.setId(id);
            pessoas.inserir(pessoa);
        }
        Pessoa aleatoria = new Pessoa(1111,"Michael Jackson");
        JOptionPane.showMessageDialog(null,pessoas.toString());
        JOptionPane.showMessageDialog(null,"Agora veremos se os métodos contem() e indice estão funcionado.");
        JOptionPane.showMessageDialog(null,"Software, a segunda pessoa que o usuário cadastrou está no vetor?\n"+pessoas.contem(pessoas.recuperar(1)));
        JOptionPane.showMessageDialog(null,"Você nem percebeu, mas o software criou uma pessoa chamada Michael Jackson.\n" +
                "Mas ele não foi adcionado à lista");
        JOptionPane.showMessageDialog(null,"Software, o Michael Jackson está na lista?\n"+pessoas.contem(aleatoria));

    }
    private static void pilha(){
        Pilha<Pessoa> pilha = new Pilha<Pessoa>();
        JOptionPane.showMessageDialog(null,"Seja bem vindo ao estudo das pilhas\n" +
                "Agora preciso que cadaste três pessoas para testarmos a nossa pilha.");
        JOptionPane.showMessageDialog(null , "Testando o método estaVazia() antes de você cadastrar as pessoas\n" +
                "Software, a pilha está vazia?\n" +
                "R="+pilha.estaVazia());

        for(int i=0;i<4;i++){
            Pessoa pessoa = new Pessoa();
            String nome =JOptionPane.showInputDialog(null,"Digite o nome da pessoa "+(i+1));
            int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o id da pessoa "+(i+1)));
            pessoa.setNome(nome);
            pessoa.setId(id);
            pilha.empilhar(pessoa);
        }
        JOptionPane.showMessageDialog(null , "Testando o método estaVazia() agora que já temos pessoas cadastradas\n" +
                "Software, a pilha está vazia?\n" +
                "R="+pilha.estaVazia());
        JOptionPane.showMessageDialog(null,"Testando o método desempilhar\n");

        JOptionPane.showMessageDialog(null,"Se a nossa implementação estiver correta o software exibirá o nome da última pessoa cadastrada\n" +
                "Pessoa:\n"+ pilha.desempilhar().getNome());
    }
    private static void fila(){
        Fila<Pessoa> fila = new Fila<Pessoa>();
        JOptionPane.showMessageDialog(null,"Seja bem vindo ao estudo de Filas.");
        JOptionPane.showMessageDialog(null,"Já que você ainda não cadastrou nenhuma pessoa, vamos  testar o método estaVazia().\n" +
                "Software, a fila está vazia?\n"+fila.estaVazia());
        JOptionPane.showMessageDialog(null,"Agora preciso que você cadastre 4 pessoas para testar nossa fila.");
        for(int i=0;i<4;i++){
            Pessoa pessoa = new Pessoa();
            String nome =JOptionPane.showInputDialog(null,"Digite o nome da pessoa "+(i+1));
            int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o id da pessoa "+(i+1)));
            pessoa.setNome(nome);
            pessoa.setId(id);
            fila.enfileirar(pessoa);
        }
        JOptionPane.showMessageDialog(null,"Testando o método desenfileirar\n");

        JOptionPane.showMessageDialog(null,"Se a nossa implementação estiver correta o software exibirá o nome da primeira pessoa cadastrada\n" +
                "Pessoa:\n"+ fila.desenfileirar().getNome());

    }

}