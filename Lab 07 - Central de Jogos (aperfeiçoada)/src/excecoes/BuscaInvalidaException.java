package excecoes;
/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class BuscaInvalidaException extends Exception{

	/**
	 * Metodo que retorna uma mensagem quando a busca por um objeto for invalida.
	 */
	private static final long serialVersionUID = 1L;

	public BuscaInvalidaException(String mensagem) {
		super(mensagem);
		
	}
}
