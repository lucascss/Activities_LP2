package excecoes;

/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class MudancaInvalidaException extends Exception {

	/**
	 * Compotamento que exibe uma mensagem de erro quando a mudanca de tipo de um Usuario eh invalida.
	 */
	private static final long serialVersionUID = 1L;
	
	public MudancaInvalidaException(String msg) {
		super(msg); 
	}

}
