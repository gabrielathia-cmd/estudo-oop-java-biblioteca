package classes.abstratas;
import java.util.ArrayList;
import classes.Livro;

public abstract class Usuario {
    private String nome;
    private String id;
    private int limiteEmprestimos;
    private ArrayList<Livro> livros;

    public Usuario(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.limiteEmprestimos = 0;
        this.livros = new ArrayList<>();
    }

    public String getNome() {return this.nome;}

    public String getId() {return this.id;}

    public void setNome(String nome) {this.nome = nome;}

    public void setId(String id) {this.id = id;}

    public void setLimiteEmprestimos(int l) {this.limiteEmprestimos = l;}

    public int getLimiteEmprestimos() {return this.limiteEmprestimos;};

    public ArrayList<Livro> getLivros() {return this.livros;}

    public void addLivro(Livro livro) {this.livros.add(livro);}

    public void removeLivro(Livro livro) {this.livros.remove(livro);}

    public boolean livroPego(Livro livro) {
        for (Livro i : this.livros) {
            if (i.getTitulo().equals(livro.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    public abstract void pegarEmprestado(Livro livro);
    public abstract void devolverEmprestado(Livro livro);
}
