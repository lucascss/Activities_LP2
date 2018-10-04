package excecoes;
/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class UpgradeInvalidoException extends Exception {

	/**
	 * Comportamento que exibe uma mensagem de erro quando o upgrade de um Usuario eh invalido.
	 */
	private static final long serialVersionUID = 1L;
	
	public UpgradeInvalidoException(String mensagem) {
		super(mensagem); 
	}

}
