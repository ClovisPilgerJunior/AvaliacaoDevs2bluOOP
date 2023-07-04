package model;

import controller.Biblioteca;

public class Emprestimo  {
  private Livro livro;
  private Usuario usuario;
  // outros atributos

  public Emprestimo(Livro livro, Usuario usuario) {
    this.livro = livro;
    this.usuario = usuario;
  }

  public Livro getLivro () {
    return livro;
  }

  public void setLivro (Livro livro) {
    this.livro = livro;
  }

  public Usuario getUsuario () {
    return usuario;
  }

  public void setUsuario (Usuario usuario) {
    this.usuario = usuario;
  }
}
