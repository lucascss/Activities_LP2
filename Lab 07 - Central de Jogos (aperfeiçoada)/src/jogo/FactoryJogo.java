package jogo;

import java.util.HashMap;
import java.util.HashSet;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
/**
 * Esta classe apenas cria referencias do tipo jogo. Eh a fabrica, ou seja, factory do tipo Jogo.
 * @author Christopher
 *
 */
public class FactoryJogo {

	private HashMap<String, Jogabilidade> mapJogabildades;

	/**
	 * Inializacao do construtor.
	 */
	public FactoryJogo() {
		this.initializeMap();
	}

	/**
	 * Metodo no qual cria uma referencia Jogo do tipo RPG, Luta ou Plataforma.
	 * @param nomeJogo
	 * @param precoJogo
	 * @param jogabilidades
	 * @param estiloJogo
	 * @return
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Jogo criaJogo(String nomeJogo, double precoJogo, String jogabilidades, String estiloJogo)
			throws StringInvalidaException, PrecoInvalidoException {

		if (estiloJogo.equalsIgnoreCase("rpg")) {
			return this.criaRPG(nomeJogo, precoJogo, jogabilidades);
		} else if (estiloJogo.equalsIgnoreCase("plataforma")) {
			return this.criaPlataforma(nomeJogo, precoJogo, jogabilidades);
		} else if (estiloJogo.equalsIgnoreCase("luta")) {
			return this.criaLuta(nomeJogo, precoJogo, jogabilidades);
		} else {
			throw new StringInvalidaException("O estilo de jogo eh inexistente.");
		}
	}
	
	/**
	 * Comportamento qur cria um Jogo RPG.
	 * @param nome
	 * @param preco
	 * @param tiposJogabilidade
	 * @return
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	private Jogo criaRPG(String nome, double preco, String tiposJogabilidade)
			throws StringInvalidaException, PrecoInvalidoException {
		Jogo jogo = new Rpg(nome, preco, createJogabilidades(tiposJogabilidade));
		return jogo;
	}

	/**
	 * Comportamento que cria um Jogo de Plataforma.
	 * @param nome
	 * @param preco
	 * @param tipoJogabilidade
	 * @return
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	private Jogo criaPlataforma(String nome, double preco, String tipoJogabilidade)
			throws StringInvalidaException, PrecoInvalidoException {
		Jogo jogo = new Plataforma(nome, preco, createJogabilidades(tipoJogabilidade));
		return jogo;
	}

	/**
	 * Comportamento no qual cria um Jogo de Luta.
	 * @param nome
	 * @param preco
	 * @param tiposJogabilidade
	 * @return
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	private Jogo criaLuta(String nome, double preco, String tiposJogabilidade)
			throws StringInvalidaException, PrecoInvalidoException {
		Jogo jogo = new Luta(nome, preco, createJogabilidades(tiposJogabilidade));
		return jogo;
	}

	/**
	 * O metodo abaixo cria um conjunto de jogabilidades a partir de uma string dada como parametro.
	 * @param nomeJogabilidade
	 * @return
	 */
	private HashSet<Jogabilidade> createJogabilidades(String nomeJogabilidade) {
		HashSet<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

		String[] listaNomesJogabilidades = nomeJogabilidade.split(" ");

		for (int i = 0; i < listaNomesJogabilidades.length; i++) {
			String elementoEnum = listaNomesJogabilidades[i].toUpperCase();
			if (elementoEnum != null) {
				Jogabilidade tipojogabilidade = mapJogabildades.get(elementoEnum);
				jogabilidades.add(tipojogabilidade);
			}
		}
		return jogabilidades;
	}

	/**
	 * Inicializacao do mapa de jogabilidades.
	 */
	private void initializeMap() {
		this.mapJogabildades = new HashMap<String, Jogabilidade>();
		mapJogabildades.put("ONLINE", Jogabilidade.ONLINE);
		mapJogabildades.put("OFFLINE", Jogabilidade.OFFLINE);
		mapJogabildades.put("COMPETITIVO", Jogabilidade.COMPETITIVO);
		mapJogabildades.put("COOPERATIVO", Jogabilidade.COOPERATIVO);
		mapJogabildades.put("MULTIPLAYER", Jogabilidade.MULTIPLAYER);

	}

}