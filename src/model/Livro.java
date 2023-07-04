package model;

import enums.LivroEnum;

public class Livro extends ItemBiblioteca {
  private String titulo;
  private String autor;
  private LivroEnum status;

  public Livro () {
  }


  public String getTitulo () {
    return titulo;
  }

  public void setTitulo (String titulo) {
    this.titulo = titulo;
  }

  public String getAutor () {
    return autor;
  }

  public void setAutor (String autor) {
    this.autor = autor;
  }

  public LivroEnum getStatus () {
    return status;
  }

  public void setStatus (LivroEnum status) {
    this.status = status;
  }


  public void emprestar () {
    super.emprestar();
  }

  public void devolver () {
    super.devolver();
  }
}

