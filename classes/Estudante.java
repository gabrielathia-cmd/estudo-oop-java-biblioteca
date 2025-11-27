package classes;

import classes.abstratas.Usuario;

public class Estudante extends Usuario {

    public Estudante(String nome, String id) {
        super(nome, id);
        setLimiteEmprestimos(3);
    }

    @Override
    public void pegarEmprestado(Livro livro) {
        setLimiteEmprestimos(getLimiteEmprestimos() - 1);
        addLivro(livro);
        livro.emprestar();
    }

    @Override
    public void devolverEmprestado(Livro livro) {
        setLimiteEmprestimos(getLimiteEmprestimos() + 1);
        removeLivro(livro);
        livro.devolver();
    }

    @Override
    public String toString() {return "Nome: " + getNome() + " ID: " + getId();}
}
