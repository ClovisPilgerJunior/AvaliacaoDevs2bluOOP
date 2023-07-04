import controller.Biblioteca;
import enums.LivroEnum;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import repository.LivroRepository;

import java.util.List;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    //    Você foi contratado por uma empresa de desenvolvimento de
//    software para criar uma aplicação para gerenciar uma biblioteca.
//    A aplicação deve permitir a realização das seguintes tarefas:
//    Adicionar um novo livro à biblioteca;
//    Excluir um livro da biblioteca;
//    Listar todos os livros da biblioteca;
//    Realizar o empréstimo de um livro para um usuário;
//    Registrar a devolução de um livro.


    Biblioteca biblioteca = new Biblioteca(); // Instancia a biblioteca
    Scanner scanner = new Scanner(System.in);

    int opcao = 0;
    do {
      System.out.println("----- Menu -----");
      System.out.println("1. Adicionar livro");
      System.out.println("2. Excluir livro");
      System.out.println("3. Listar livros");
      System.out.println("4. Realizar empréstimo");
      System.out.println("5. Registrar devolução");
      System.out.println("0. Sair");
      System.out.print("Digite a opção desejada: ");
      opcao = scanner.nextInt();
      scanner.nextLine(); // Limpa o buffer do scanner


      switch (opcao) {
        case 1:
          Livro livro = new Livro();
          System.out.print("Digite o título do livro: ");
          String titulo = scanner.nextLine();
          livro.setTitulo(titulo);
          System.out.print("Digite o autor do livro: ");
          String autor = scanner.nextLine();
          livro.setAutor(autor);
          livro.setStatus(LivroEnum.DISPONIVEL);
          biblioteca.adicionarLivro(livro);
          break;
        case 2:
          System.out.print("Digite o título do livro a ser excluído: ");
          String excluirTitulo = scanner.nextLine();
          Livro buscaExcluir = biblioteca.buscarLivroPorTitulo(excluirTitulo);
          biblioteca.excluirLivro(buscaExcluir);
          break;
        case 3:
          List<Livro> livros = biblioteca.listarLivros();
          System.out.println("----- Livros na Biblioteca -----");
          for (Livro l : livros) {
            System.out.println("Título: " + l.getTitulo() + ", Autor: " + l.getAutor());
          }
          System.out.println("--------------------------------");
          break;
        case 4:
          System.out.print("Digite o título do livro a ser emprestado: ");
          String tituloEmprestimo = scanner.nextLine();
          System.out.print("Digite o nome do usuário: ");
          String nomeUsuario = scanner.nextLine();

          // Verifica se o livro existe na biblioteca
          Livro livroEmprestimo = biblioteca.buscarLivroPorTitulo(tituloEmprestimo);
          if (livroEmprestimo != null) {
            // Verifica se o livro está disponível para empréstimo
            if (livroEmprestimo.getStatus() == LivroEnum.DISPONIVEL) {
              // Cria um novo empréstimo
              Emprestimo emprestimo = new Emprestimo(livroEmprestimo, new Usuario(nomeUsuario));
              livroEmprestimo.emprestar(); // Realiza o empréstimo do livro
              livroEmprestimo.setStatus(LivroEnum.EMPRESTADO);
            } else {
              System.out.println("O livro não está disponível para empréstimo.");
            }
          } else {
            System.out.println("O livro não foi encontrado na biblioteca.");
          }
          break;


        case 5:
          System.out.print("Digite o título do livro a ser devolvido: ");
          String tituloDevolucao = scanner.nextLine();

          // Verifica se o livro existe na biblioteca
          Livro livroDevolucao = biblioteca.buscarLivroPorTitulo(tituloDevolucao);
          if (livroDevolucao != null) {
            // Verifica se o livro está emprestado
            if (livroDevolucao.getStatus() == LivroEnum.EMPRESTADO) {
              livroDevolucao.devolver();
              livroDevolucao.setStatus(LivroEnum.DISPONIVEL);
            } else {
              System.out.println("O livro não está emprestado no momento.");
            }
          } else {
            System.out.println("O livro não foi encontrado na biblioteca.");
          }
          break;
        case 0:
          System.out.println("Saindo do programa...");
          break;
        default:
          System.out.println("Opção inválida. Digite novamente.");
          break;
      }
    } while (opcao != 0);

    scanner.close();
  }
}
