package classes;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}

    public boolean isDisponivel() {return disponivel;}

    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}

    @Override
    public String toString() {
        return this.titulo;
    }

    public void emprestar() {
        if (this.disponivel) {
            this.disponivel = false;
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }

    }

    public void devolver() {
        if (!this.disponivel) {
            this.disponivel = true;
        } else {
            System.out.println("Livro não disponível para devolver.");
        }

    }
}
