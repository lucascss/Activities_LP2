package usuarios;

/**
 * Esta classe apenas cria referencias do tipo Usuario. Eh a factory do tipo
 * Usuario.
 * 
 * @author lucascss
 *
 */
public class UsuarioFactory {

	/**
	 * Construtor: Inicia-se um objeto Noob ou Veterano (as subclasses) com uma
	 * referencia do tipo Usuario.
	 * 
	 * @param nomeUsuario
	 * @param username
	 * @param tipoUsuario
	 * @return
	 * @throws Exception
	 */
	public Usuario criaUsuario(String nomeUsuario, String username, String tipoUsuario) throws Exception {

		Usuario usuario = null;

		if (tipoUsuario.equalsIgnoreCase("Noob")) {
			usuario = new Noob(nomeUsuario, username);
		}

		else if (tipoUsuario.equalsIgnoreCase("Veterano")) {
			usuario = new Veterano(nomeUsuario, username);
		}

		return usuario;
	}

}
