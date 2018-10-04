package jogos;

/**
 * Esta eh uma subclasse do tipo Jogo.
 * 
 * @author lucascss
 *
 */
public class Plataforma extends Jogo {

	private final int BONUS_POR_ZERACAO;

	/**
	 * Construtor: Inicia-se um objeto RPG de acordou com os atributos da
	 * superclasse.
	 * 
	 * @param nomeJogo
	 * @param precoJogo
	 * @throws Exception
	 */
	public Plataforma(String nomeJogo, double precoJogo) throws Exception {

		super(nomeJogo, precoJogo);
		this.BONUS_POR_ZERACAO = 20;
	}

	/**
	 * Metodo que registra jogada de um Jogo e incrementa a quantidade de vezes
	 * que jogou e/ou zerou um jogo.
	 */
	@Override
	public int registraJogada(int score, boolean zerou) {

		this.setQtdQueJogou();
		if (score > this.maiorScore) {
			this.setMaiorScore(score);
		}
		if (zerou) {
			this.setQtdQueZerou();
		}

		int bonus = this.qtdQueZerou * this.BONUS_POR_ZERACAO;
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
