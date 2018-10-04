package jogos;

/**
 * Esta eh uma subclasse do tipo Jogo.
 * 
 * @author lucascss
 *
 */
public class Luta extends Jogo {

	private final int SCORE_MAXIMO;
	private final int BONUS_PARA_PONTUACAO;

	/**
	 * Construtor: Inicia-se um objeto RPG de acordou com os atributos da
	 * superclasse.
	 * 
	 * @param nomeJogo
	 * @param precoJogo
	 * @throws Exception
	 */
	public Luta(String nomeJogo, double precoJogo) throws Exception {

		super(nomeJogo, precoJogo);
		this.SCORE_MAXIMO = 100000;
		this.BONUS_PARA_PONTUACAO = 1000;
	}

	/**
	 * Metodo que registra jogada de um Jogo e incrementa a quantidade de vezes
	 * que jogou e/ou zerou um jogo.
	 */
	@Override
	public int registraJogada(int score, boolean zerou) {
		int bonus = 0;

		if (score <= SCORE_MAXIMO) {

			if (score > this.getMaiorScore()) {
				this.setMaiorScore(score);
			}

			int pontosGanhos = score / BONUS_PARA_PONTUACAO;
			bonus += pontosGanhos;

			if (zerou) {
				this.setQtdQueZerou();
			}

			this.setQtdQueJogou();
		}
		return bonus;

	}

	/**
	 * Este comportamento eh a representacao do objeto da superclasse Jogo.
	 */
	@Override
	public String toString() {

		final String FIM_DE_LINHA = System.lineSeparator();

		String mensagem = String.format("+ %s: %s %s", this.getNome(), this.getClass(), FIM_DE_LINHA);
		String mensagemFinal = mensagem + super.toString();

		return mensagemFinal;
	}

}
