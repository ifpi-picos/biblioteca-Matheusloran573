package app;

import servico.BibliotecaService;

public class App {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();
        biblioteca.exibirMenu();
    }
}
