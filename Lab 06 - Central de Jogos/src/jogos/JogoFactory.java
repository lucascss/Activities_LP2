package jogos;

/**
 * Esta classe apenas cria referencias do tipo jogo. Eh a factory do tipo Jogo.
 * 
 * @author lucascss
 *
 */
public class JogoFactory {

	/**
	 * Construtor: Inicia-se um objeto RPG, Luta ou Plataforma (as subclasses)
	 * com uma referencia do tipo Jogo.
	 * 
	 * @param nomeJogo
	 * @param precoJogo
	 * @param tipoJogo
	 * @return
	 * @throws Exception
	 */
	public Jogo criaJogo(String nomeJogo, double precoJogo, String tipoJogo) throws Exception {

		Jogo jogo = null;

		if (tipoJogo.equalsIgnoreCase("RPG")) {
			jogo = new RPG(nomeJogo, precoJogo);
		}

		else if (tipoJogo.equalsIgnoreCase("Plataforma")) {
			jogo = new Plataforma(nomeJogo, precoJogo);
		}

		else if (tipoJogo.equalsIgnoreCase("Luta")) {
			jogo = new Luta(nomeJogo, precoJogo);
		}

		return jogo;
	}

}
