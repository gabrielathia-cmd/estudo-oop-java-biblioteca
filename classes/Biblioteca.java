package classes;

import classes.abstratas.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private Map<Usuario, Livro> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new HashMap<>();
    }

    //Getters
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Map<Usuario, Livro> getEmprestimos() {
        return emprestimos;
    }

    //Métodos
    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void registrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void emprestarLivros(String titulo, Usuario usuario) {
        boolean usuarioValidado = validarUsuario(usuario);
        if (usuarioValidado) {
            boolean validado = validarEmprestimo(titulo);
            if (!validado) {System.out.println("Livro não registrado na biblioteca");}
            else {
                Livro livro = buscarLivroTitulo(titulo);
                if (livro.isDisponivel()) {
                    int limiteUsuario = usuario.getLimiteEmprestimos();
                    if (limiteUsuario > 0) {
                        usuario.pegarEmprestado(livro);
                        this.emprestimos.put(usuario, livro);
                        System.out.println("Livro " + livro + " emprestado com sucesso!");
                    } else {
                        System.out.println("Limite de empréstimos já atingido pelo usuário " + usuario.getNome());
                    }
                } else {
                    System.out.println("Livro existente na biblioteca, porém indisponível");
                }
            }
        }
        else {System.out.println("Usuário não registrado na biblioteca");}
    }

    public void devolverLivros(String titulo, Usuario usuario) {
        boolean userValidado = validarUsuario(usuario);
        if (userValidado) {
            boolean validado = validarEmprestimo(titulo);
            if (!validado) {System.out.println("Livro não registrado na biblioteca");}
            else{
                Livro livro = buscarLivroTitulo(titulo);
                if (validarEmprestimoUsuario(livro, usuario)) {
                    if (!livro.isDisponivel()) {
                        usuario.devolverEmprestado(livro);
                        this.emprestimos.remove(usuario);
                        System.out.println("Livro " + livro + " devolvido com sucesso!");
                    } else {System.out.println("O livro " + livro.getTitulo() + "não foi emprestado.");}
                } else {System.out.println("O Usuário " + usuario.getNome() + " não pegou esse livro emprestado.");}
            }
        }
        else {System.out.println("Usuário não registrado na biblioteca.");}
    }

    private boolean validarEmprestimo(String titulo) {
        Livro lV = buscarLivroTitulo(titulo);
        if (lV == null) {return false;}
        else {return true;}
    }

    public Livro buscarLivroTitulo(String titulo) {
        for(int i = 0; i < this.livros.size(); i++) {
            if (this.livros.get(i).getTitulo().equals(titulo)) {
                return this.livros.get(i);
            }
        }
        return null;
    }

    private boolean validarEmprestimoUsuario(Livro livro, Usuario usuario) {
        return usuario.livroPego(livro);
    }

    public void listarEmprestimos() {
        for (Usuario usuario : this.emprestimos.keySet()) {
            System.out.println("Usuário: " + usuario.getNome() + " | Livro: " + this.emprestimos.get(usuario));
        }
    }

    public void listarLivros() {
        for (Livro livro : this.livros) {
            System.out.println("Livro: " + livro.getTitulo());
        }
    }

    public void listarUsuarios() {
        for (Usuario usuario : this.usuarios) {
            System.out.println("Usuario: " + usuario.getNome());
        }
    }

    public boolean validarUsuario(Usuario usuario) {
        for (Usuario user : this.usuarios) {
            if (user.getNome().equals(usuario.getNome())) {return true;}
        }
        return false;
    }
}