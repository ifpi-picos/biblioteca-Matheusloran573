import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        biblioteca.adicionarLivro(new Livro("Extraordinario", "Raquel J. Palacio", 2012));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", 1949));

        while (true) {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Alugar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Ver Livros Disponíveis");
            System.out.println("6. Listar Livros Emprestados");
            System.out.println("7. Ver Histórico de Empréstimos do Usuário");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o nome do usuário: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o CPF do usuário: ");
                String cpf = scanner.nextLine();
                System.out.print("Digite o e-mail do usuário: ");
                String email = scanner.nextLine();
                System.out.print("Digite o endereço do usuário: ");
                String endereco = scanner.nextLine();
                System.out.print("Digite o telefone do usuário: ");
                String telefone = scanner.nextLine();

                Usuario usuario = new Usuario(nome, cpf, email, endereco, telefone);
                biblioteca.adicionarUsuario(usuario);

            } else if (opcao == 2) {
                System.out.print("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                System.out.print("Digite o autor do livro: ");
                String autor = scanner.nextLine();
                System.out.print("Digite o ano de publicação do livro: ");
                int ano = scanner.nextInt();
                scanner.nextLine();

                Livro livro = new Livro(titulo, autor, ano);
                biblioteca.adicionarLivro(livro);

            } else if (opcao == 3) {
                System.out.print("Digite o nome do usuário: ");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    Livro livro = biblioteca.buscarLivro(tituloLivro);

                    if (livro != null) {
                        usuario.alugarLivro(livro);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o nome do usuário: ");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    usuario.devolverLivro();
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 5) {
                int livrosDisponiveis = biblioteca.contarLivrosDisponiveis();
                System.out.println("Livros disponíveis: " + livrosDisponiveis);

            } else if (opcao == 6) {
                biblioteca.listarLivrosEmprestados();

            } else if (opcao == 7) {
                System.out.print("Digite o nome do usuário: ");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.println("\n--- Histórico de Empréstimos ---");
                    for (String titulo : usuario.getHistoricoEmprestimos()) {
                        System.out.println(titulo);
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 8) {
                System.out.println("Saindo...");
                break;

            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
