package jogo;

import java.util.HashSet;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
/**
 * Esta eh uma subclasse do tipo Jogo que presenta um Jogo do tipo Luta.
 * @author Christopher
 *
 */
public class Luta extends Jogo {

	//private final int SCORE_MAXIMO;
	private final int BONUS_PARA_PONTUACAO;
	/**
	 * Construtor: Inicia-se um objeto Luta de acordou com os atributos da superclasse.
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Luta(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
		//this.SCORE_MAXIMO = 100000;
		this.BONUS_PARA_PONTUACAO = 1000;
	}

	/**
	 * Tambem um constutor de um Jogo de Luta, porem, este recebe um conjunto de jogabilidades como parametro.
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidades) 
			throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
		//this.SCORE_MAXIMO = 100000;
		this.BONUS_PARA_PONTUACAO = 1000;

	}

	/**
	 * Metodo que registra jogada de um Jogo e incrementa a quantidade de vezes que jogou e/ou
	 * zerou um jogo.
	 */
	@Override
	public int registraJogada(int score, boolean venceu) throws ValorInvalidoException {

		//int bonus = 0;
		this.incrementaJogada();
		//if (score <= this.SCORE_MAXIMO) {

			if (score > this.getMaiorScore()) {
				this.setMaiorScore(score);
			}
			if (venceu) {
				this.incrementaConclusao();
			}

			/*int pontosGanhos = score / BONUS_PARA_PONTUACAO;
			bonus += pontosGanhos;*/
		
		return score / this.BONUS_PARA_PONTUACAO;
		//return bonus;
	}

	/**
	 * Este comportamento eh a representacao do objeto da superclasse Jogo.
	 */
	public String toString() {
		
		String resultado = "+ " + getNome() + " - Luta:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
