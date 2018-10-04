package jogo;

import java.util.HashSet;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
/**
 * Esta eh uma subclasse do tipo Jogo que reflete um Jogo do tipo RPG.
 * @author Christopher
 *
 */
public class Rpg extends Jogo {

	public final int BONUS_POR_JOGADA;
	/**
	 * Construtor: Inicia-se um objeto RPG de acordou com os atributos da superclasse.
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Rpg(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
		this.BONUS_POR_JOGADA = 10;

	}
	/**
	 * Tambem um construtor. Logo, este recebe um parametro a mais, que no caso, eh um conjunto 
	 * de jogabilidades.
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Rpg(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
		this.BONUS_POR_JOGADA = 10;
	}

	/**
	 * Metodo que registra jogada de um Jogo e incrementa a quantidade de vezes que jogou e/ou
	 * zerou um jogo.
	 */
	@Override
	public int registraJogada(int score, boolean venceu) throws ValorInvalidoException {

		this.incrementaJogada();
		if (score > this.getMaiorScore()) {
			this.setMaiorScore(score);
		}
		if (venceu) {
			this.incrementaConclusao();
		}

		/*int bonus = this.getvezesConcluidas() * this.BONUS_POR_JOGADA;
		return bonus;*/
		return this.BONUS_POR_JOGADA;
	}

	/**
	 * Este comportamento eh a representacao do objeto da superclasse Jogo.
	 */
	public String toString() {
		
		String resultado = "+ " + this.getNome() + " - RPG:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
