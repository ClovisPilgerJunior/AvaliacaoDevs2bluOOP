package controller;

import model.Emprestimo;
import model.ItemBiblioteca;
import model.Livro;
import repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca extends ItemBiblioteca implements LivroRepository {
  private List<Livro> livros;

  public Biblioteca() {
    livros = new ArrayList<>();
  }

  @Override
  public void adicionarLivro(Livro livro) {
    livros.add(livro);
    System.out.println("Livro adicionado à biblioteca.");
  }

  @Override
  public void excluirLivro(Livro livro) {
    String titulo = livro.getTitulo();
    Livro livroExcluir = buscarLivroPorTitulo(titulo);
    if (livro.getTitulo() != null) {
      livros.remove(livroExcluir);
      System.out.println("Livro excluído com sucesso!");
    } else {
      System.out.println("O livro não foi encontrado na biblioteca.");
    }
  }

  @Override
  public List<Livro> listarLivros() {
    return livros;
  }

  public Livro buscarLivroPorTitulo (String tituloEmprestimo) {
    Livro livroBuscado = null;
    for (Livro livros : livros) {
      if(livros.getTitulo().equals(tituloEmprestimo))
        livroBuscado = livros;
    }
    return livroBuscado;
  }
}