package classes;

import classes.abstratas.Usuario;

public class Professor extends Usuario {
    public Professor(String nome, String id) {
        super(nome, id);
        setLimiteEmprestimos(5);
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

