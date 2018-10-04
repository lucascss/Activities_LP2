package usuario;

import excecoes.ValorInvalidoException;
import jogo.Jogo;
/**
 * Esta eh a Interface que possui os comportamentos obrigatorios de um qualquer Usuario idependente de seu tipo.
 * @author Christopher
 *
 */
public interface TipoDeUsuarioIF {

	/**
	 * Metodo no qual o Usuario pode comprar um Jogo.
	 * @param jogo
	 * @return
	 * @throws ValorInvalidoException
	 */
	public double compraJogo(Jogo jogo) throws ValorInvalidoException;

	/**
	 * Metodo que recompensa um Usuario de acordo com o tipo de jogabilidade de seus jogos.
	 * @param jogo
	 * @return
	 */
	public int recompensar(Jogo jogo);

	/**
	 * Metodo que pune um Usuario de acordo com o tipo de jogabilidade de seus jogos.
	 * @param jogo
	 * @return
	 */
	public int punir(Jogo jogo);

	/**
	 * Comportamento que retorna a quantidade de x2p de um Jogo.
	 * @param jogo
	 * @return
	 */
	public int getX2p(Jogo jogo);

}
