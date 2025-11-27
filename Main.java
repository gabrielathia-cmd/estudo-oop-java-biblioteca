import classes.*;
import classes.abstratas.Usuario;

public class Main{
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Usuario e1 = new Estudante("Glauber1", "aaaaa");
        Usuario e2 = new Estudante("Glauber2", "bbbbb");
        Usuario p1 = new Professor("Mr. Glauber", "ccccc");
        Livro l1 = new Livro("Contos de Glauber I", "Glauber");
        Livro l2 = new Livro("Contos de Glauber II", "Glauber");
        Livro l3 = new Livro("Contos de Glauber III", "Glauber");
        Livro l4 = new Livro("Contos de Glauber IV", "Glauber");

        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);
        biblioteca.adicionarLivro(l3);
        biblioteca.adicionarLivro(l4);

        biblioteca.registrarUsuario(e1);
        biblioteca.registrarUsuario(e2);
        biblioteca.registrarUsuario(p1);

        biblioteca.emprestarLivros(l1.getTitulo(), e1);
        biblioteca.emprestarLivros(l2.getTitulo(), e1);
        biblioteca.emprestarLivros(l3.getTitulo(), e1);
        biblioteca.listarEmprestimos();
        biblioteca.emprestarLivros(l4.getTitulo(), e1);
        biblioteca.devolverLivros(l1.getTitulo(), e1);
        biblioteca.emprestarLivros(l4.getTitulo(), e1);
        biblioteca.emprestarLivros(l4.getTitulo(), e2);
        biblioteca.devolverLivros(l2.getTitulo(), e1);
        biblioteca.devolverLivros(l3.getTitulo(), e1);
        biblioteca.devolverLivros(l4.getTitulo(), e1);
        biblioteca.emprestarLivros(l4.getTitulo(), e2);
        biblioteca.emprestarLivros(l1.getTitulo(), p1);
        biblioteca.emprestarLivros(l2.getTitulo(), p1);
        biblioteca.emprestarLivros(l3.getTitulo(), p1);
        biblioteca.listarEmprestimos();
    }
}