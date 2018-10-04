package centraldejogos;

import java.util.HashMap;
import usuarios.Usuario;
import usuarios.UsuarioFactory;
import usuarios.Veterano;

/**
 * A presente classe representa a Loja de nossa central de games, P2-CG. Esta
 * classe possui comportamentos nos quais podem cadastrar usuario(metodo
 * adicionaUsuario), efetuar depositos para um usuario (metodo
 * addDinheiroPraUsuario), vender jogos a um usuario (metodo vendeAoUsuario),
 * verificar se um tal usuario jah estah cadastrado na loja (metodo
 * pesquisaUsuario) e ainda, upar um usuario (metodo upgrade).
 * 
 * @author lucascss
 *
 */

public class Loja {

	private UsuarioFactory criaUsuario;
	private HashMap<String, Usuario> usuariosCadastrados;

	/**
	 * Construtor: Inicia-se o objeto Loja.
	 */
	public Loja() {

		this.usuariosCadastrados = new HashMap<>();
		this.criaUsuario = new UsuarioFactory();

	}

	/**
	 * Este comportamento retorna a colecao de usuarios cadastrados na Loja.
	 * 
	 * @return
	 */
	public HashMap<String, Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	/**
	 * Este comportamento altera a colecao de usuarios cadastrados na Loja.
	 * 
	 * @param usuariosCadastrados
	 */
	public void setUsuariosCadastrados(HashMap<String, Usuario> usuariosCadastrados) {
		this.usuariosCadastrados = usuariosCadastrados;
	}

	/**
	 * O metodo abaixo cadastra um usuario na loja com os seguintes parametros,
	 * lancando exceptions:
	 * 
	 * @param nomeUsuario
	 * @param username
	 * @param tipoUsuario
	 * @throws Exception
	 * 
	 */
	// ADICIONANDO USUARIOS NA LOJA.
	public void adicionaUsuario(String nomeUsuario, String username, String tipoUsuario) throws Exception {

		Usuario usuario = null;

		if (usuariosCadastrados.containsKey(username)) {
			throw new Exception("Usuario ja cadastrado!");
		}

		try {
			usuario = criaUsuario.criaUsuario(nomeUsuario, username, tipoUsuario);
			usuariosCadastrados.put(username, usuario);

		} catch (Exception exception) {
			throw new Exception("Erro: " + exception.getMessage());
		}

	}

	/**
	 * O metodo abaixo deposita mais dinheiro a um usuario na loja. Para isso,
	 * verifica-se se o usuario jah possui cadastro na Loja (se o login
	 * encontra-se na colecao de usuarios) e isso com os seguintes parametros,
	 * lancando exceptions:
	 * 
	 * @param loginUsuario
	 * @param dinheiro
	 * @return
	 * @throws Exception
	 */
	// DEPOSITANDO DINHEIRO PARA O USUARIO.
	public boolean addDinheiroPraUsuario(String loginUsuario, double dinheiro) throws Exception {

		try {
			if (usuariosCadastrados.containsKey(loginUsuario)) {
				double deposito = usuariosCadastrados.get(loginUsuario).getDinheiro() + dinheiro;
				usuariosCadastrados.get(loginUsuario).setDinheiro(deposito);
				return true;
			}
			return false;

		} catch (Exception exception) {
			throw new Exception("Erro: " + exception.getMessage());
		}
	}

	/**
	 * O metodo abaixo vende um jogo a um usuario cadastrado na loja. Para isso,
	 * verifica-se o cadastro do usuario na Loja (se o login encontra-se na
	 * colecao de usuarios) e isso com os seguintes parametros, lancando
	 * exceptions:
	 * 
	 * @param loginUsuario
	 * @param nomeJogo
	 * @param precoJogo
	 * @param tipoJogo
	 * @return
	 * @throws Exception
	 */
	// VENDENDO JOGO AO USUARIO.
	public boolean vendeAoUsuario(String loginUsuario, String nomeJogo, double precoJogo, String tipoJogo)
			throws Exception {

		if (usuariosCadastrados.containsKey(loginUsuario)) {
			if (usuariosCadastrados.get(loginUsuario).getDinheiro() >= precoJogo) {
				usuariosCadastrados.get(loginUsuario).compraJogos(nomeJogo, precoJogo, tipoJogo);
				return true;
			}
		}
		return false;
	}

	/**
	 * Este comportamento verifica se um usuario estah cadastrado na loja
	 * pesquisando seu possivel login.
	 * 
	 * @param loginUsuario
	 * @return
	 */
	// VERIFICANDO SE O USUARIO ESTAH CADASTRADO.
	public Usuario pesquisaUsuario(String loginUsuario) {

		if (usuariosCadastrados.containsKey(loginUsuario)) {
			return usuariosCadastrados.get(loginUsuario);
		}
		return null;
	}

	/**
	 * Este comportamento upa o usuario jah cadastrado na loja, de Noob para
	 * Veterano. Detalhe: Upgrade SOMENTE se o usuario eh Noob.
	 * 
	 * @param loginUsuario
	 * @throws Exception
	 */
	public void upgrade(String loginUsuario) throws Exception {

		Usuario usuario = pesquisaUsuario(loginUsuario);

		if (usuario.getX2p() < 1000) {
			throw new Exception("Quantidade de x2p precisa ser maior ou igual a 1000.");
		}

		if (usuario.getClass().equals(Veterano.class)) {
			throw new Exception("O usuario ja eh do tipo veterano!");
		}
		if (usuario.getX2p() > 1000) {
			Veterano veterano = new Veterano(usuario.getNome(), usuario.getUsername());
			veterano.setDinheiro(usuario.getDinheiro());
			veterano.setMeusJogos(usuario.getMeusJogos());
			veterano.setX2p(usuario.getX2p());

			usuariosCadastrados.remove(loginUsuario);
			usuariosCadastrados.put(loginUsuario, veterano);
		}
	}

	/**
	 * Este comportamento eh a representacao de um "ID" do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuariosCadastrados == null) ? 0 : usuariosCadastrados.hashCode());
		return result;
	}

	/**
	 * Este comportamento compara se duas lojas são iguais; no caso em questao,
	 * se duas lojas tem o mesmo conjunto de jogos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (usuariosCadastrados == null) {
			if (other.usuariosCadastrados != null)
				return false;
		} else if (!usuariosCadastrados.equals(other.usuariosCadastrados))
			return false;
		return true;
	}
}
