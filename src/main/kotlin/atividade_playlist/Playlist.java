package atividade_playlist;

public class Playlist {
    private Musica primeira;
    private Musica ultima;

    public Playlist() {
        this.primeira = null;
        this.ultima = null;
    }

    // Adiciona uma nova música ao final da playlist
    public void adicionarMusica(String titulo, String artista, int duracao) {
        Musica novaMusica = new Musica(titulo, artista, duracao);

        if (primeira == null) {
            primeira = novaMusica;
            ultima = novaMusica;
        } else {
            ultima.proxima = novaMusica;
            novaMusica.anterior = ultima;
            ultima = novaMusica;
        }
        System.out.println("Adicionada: " + novaMusica);
    }

    // Remove uma música pelo título informado
    public void removerMusica(String titulo) {
        Musica atual = primeira;

        while (atual != null) {
            if (atual.titulo.equals(titulo)) {
                if (atual.anterior != null) {
                    atual.anterior.proxima = atual.proxima;
                } else {
                    primeira = atual.proxima;
                }

                if (atual.proxima != null) {
                    atual.proxima.anterior = atual.anterior;
                } else {
                    ultima = atual.anterior;
                }

                System.out.println("Removida: " + atual);
                return;
            }
            atual = atual.proxima;
        }
        System.out.println("Não encontrada: " + titulo);
    }

    // Altera informações de uma música pelo título
    public void alterarMusica(String titulo, String novoTitulo, String novoArtista, int novaDuracao) {
        Musica atual = primeira;

        while (atual != null) {
            if (atual.titulo.equals(titulo)) {
                atual.titulo = novoTitulo;
                atual.artista = novoArtista;
                atual.duracao = novaDuracao;
                System.out.println("Alterada: " + atual);
                return;
            }
            atual = atual.proxima;
        }
        System.out.println("Música não encontrada: " + titulo);
    }

    // Avança para a próxima música
    public void navegarProxima(Musica atual) {
        if (atual != null && atual.proxima != null) {
            System.out.println("Próxima: " + atual.proxima);
        } else {
            System.out.println("Fim da playlist.");
        }
    }

    // Retorna para a música anterior
    public void navegarAnterior(Musica atual) {
        if (atual != null && atual.anterior != null) {
            System.out.println("Anterior: " + atual.anterior);
        } else {
            System.out.println("Início da playlist.");
        }
    }

    // Exibe todas as músicas na playlist
    public void exibirPlaylist() {
        Musica atual = primeira;
        System.out.println("Playlist:");
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proxima;
        }
    }

    // Retorna a primeira música
    public Musica getPrimeiraMusica() {
        return primeira;
    }
}


