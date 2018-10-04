package usuarios;

import jogos.Jogo;
import jogos.JogoFactory;

/**
 * Esta eh uma subclasse do tipo Usuario. Um Noob eh um Usuario menos
 * experiente, um iniciante. Possui os mesmo membros de sua superclasse.
 * 
 * @author lucascss
 *
 */
public class Noob extends Usuario {

	private JogoFactory fabricaJogos;
	private final double DESCONTO = 0.10; // 10% DE DESCONTO.

	/**
	 * Construtor: Inicia-se um objeto Noob de acordou com os atributos abaixo:
	 * 
	 * @param nomeUsuario
	 * @param nomeLogin
	 * @throws Exception
	 */
	public Noob(String nomeUsuario, String nomeLogin) throws Exception {

		super(nomeUsuario, nomeLogin);
		this.fabricaJogos = new JogoFactory();
		// super.x2p = 0;
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
	 * Este comportamento retorna a quantia de x2p ganha pelo Usuario Noob
	 * atraves da compra de um jogo.
	 * 
	 * @param precoJogo
	 * @return
	 */
	// RECEBE 10% DE DESCONTO.
	public int comprouGanhouXp(double precoJogo) {

		double precoComDesconto = precoJogo * this.DESCONTO;
		double dinheiroPosCompra = this.dinheiro - precoComDesconto;
		this.setDinheiro(dinheiroPosCompra);

		int bonus = 10 * (int) precoJogo;
		this.setX2p(bonus);

		return bonus;
	}

	/**
	 * Este comportamento modifica a quantia de x2p ganha pelo Usuario Noob.
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
	 * questao, se dois Usuarios Noob sao iguais.
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
