package dominio;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(int id, String titulo, String autor, boolean emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isEmprestado() { return emprestado; }
    public void setEmprestado(boolean emprestado) { this.emprestado = emprestado; }
}
