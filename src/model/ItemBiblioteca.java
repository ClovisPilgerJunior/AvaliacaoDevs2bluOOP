package model;

public abstract class ItemBiblioteca {
  private boolean emprestado;

  public void emprestar() {
    if (emprestado) {
      System.out.println("O item já está emprestado.");
    } else {
      emprestado = true;
      System.out.println("Item emprestado com sucesso.");
    }
  }

  public void devolver() {
    if (!emprestado) {
      System.out.println("O item já está disponível.");
    } else {
      emprestado = false;
      System.out.println("Item devolvido com sucesso.");
    }
  }
}
