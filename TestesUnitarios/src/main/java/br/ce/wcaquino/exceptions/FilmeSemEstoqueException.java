package br.ce.wcaquino.exceptions;

/**
 * Classe responsavel por lançar mensagem para exception que a instancie
 */
public class FilmeSemEstoqueException extends Exception {
    public FilmeSemEstoqueException(String message) {
        super(message);
    }
}
