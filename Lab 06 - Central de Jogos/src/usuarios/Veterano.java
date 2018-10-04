package usuarios;

import jogos.Jogo;
import jogos.JogoFactory;

/**
 * Esta eh uma subclasse do tipo Usuario. Um Veterano eh um Usuario mais
 * experiente, um usuario com bom tempo de "pratica".
 * 
 * @author lucascss
 *
 */
public class Veterano extends Usuario {

	private JogoFactory fabricaJogos;
	private final double DESCONTO = 0.20; // 20% DE DESCONTO.

	/**
	 * Construtor: Inicia-se um objeto Veterano de acordou com os atributos
	 * abaixo:
	 * 
	 * @param nomeUsuario
	 * @param nomeLogin
	 * @throws Exception
	 */
	public Veterano(String nomeUsuario, String nomeLogin) throws Exception {

		super(nomeUsuario, nomeLogin);
		super.x2p = 1000;
		this.fabricaJogos = new JogoFactory();
	}

	/*
	 * @Override public void depositaDinheiro(double dinheiro) {
	 * super.depositaDinheiro(dinheiro); }
	 */

	/**
	 * Metodo para efetuar a comprar de jogos, no qual eh sobrescrito da
	 * superclasse.
	 */
	@Override
	public boolean compraJogos(String nomeJogo, double precoJogo, String tipoJogo) throws Exception {

		if (this.dinheiro >= precoJogo) {

			Jogo jogo = fabricaJogos.criaJogo(nomeJogo, precoJogo, tipoJogo);

			this.comprouGanhouXp(precoJogo);
			this.meusJogos.add(jogo);

			return true;
		}
		return false;
	}

	/**
	 * Este comportamento retorna a quantia de x2p ganha pelo Usuario Veterano
	 * atraves da compra de um jogo.
	 * 
	 * @param precoJogo
	 * @return
	 */
	// RECEBE 20% DE DESCONTO.
	public int comprouGanhouXp(double precoJogo) {

		double precoComDesconto = precoJogo * this.DESCONTO;
		double dinheiroPosCompra = this.getDinheiro() - precoComDesconto;
		this.setDinheiro(dinheiroPosCompra);

		int bonus = 15 * (int) precoJogo;
		this.setX2p(bonus);

		return bonus;
	}

	/**
	 * Este comportamento modifica a quantia de x2p ganha pelo Usuario Veterano.
	 * Neste caso, atraves das vezes que ele registrou a jogada de um jogo.
	 */
	// JOGOU, GANHOU XP.
	@Override
	public boolean registraJogada(String nomeDoJogo, int score, boolean zerou) {
		for (Jogo jogo : this.meusJogos) {
			if (jogo.getNome().equalsIgnoreCase(nomeDoJogo)) {
				this.setX2p(jogo.registraJogada(score, zerou));
				return true;
			}
		}
		return false;
	}

	/**
	 * Este comportamento compara se dois objetos sao iguais; no caso em
	 * questao, se dois Usuarios Veteranos sao iguais.
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}