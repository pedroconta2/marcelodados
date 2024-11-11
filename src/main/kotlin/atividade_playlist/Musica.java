package atividade_playlist;

public class Musica {
    String titulo;
    String artista;
    Musica anterior;
    Musica proxima;
    Integer duracao;

    public Musica(String titulo, String artista, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.anterior = null;
        this.proxima = null;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Artista: " + artista + ", Duração: " + duracao + " minutos";
    }
}