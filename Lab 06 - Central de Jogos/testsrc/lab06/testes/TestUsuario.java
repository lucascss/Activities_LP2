package lab06.testes;

import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.RPG;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usuarios.Noob;
import usuarios.Usuario;
import usuarios.Veterano;

public class TestUsuario {

	private Noob usuarioNoob;
	private Veterano usuarioVeterano;

	@Before
	public void setup() throws Exception {
		this.usuarioNoob = new Noob("Kinton Insano", "LuginInsano@loja.com");
		this.usuarioVeterano = new Veterano("Ceehfi", "PasseiLahMantega@loja.com");

	}
	
	@Test
	public void testGetTitulo() {
		Assert.assertEquals("Kinton Insano", usuarioNoob.getNome());
		Assert.assertEquals("Ceehfi", usuarioVeterano.getNome());
	}

	@Test
	public void testGetLogin() {
		Assert.assertEquals("LuginInsano@loja.com", usuarioNoob.getUsername());
		Assert.assertEquals("PasseiLahMantega@loja.com", usuarioVeterano.getUsername());
	}
	
	// Teste: Comparar dois objeto.
	@Test
	public void testEquals(){
		
		Assert.assertEquals(Noob.class, usuarioNoob.getClass());
		Assert.assertEquals(Veterano.class, usuarioVeterano.getClass());
		Assert.assertNotEquals(Veterano.class, usuarioNoob.getClass());
		Assert.assertNotEquals(Noob.class, usuarioVeterano.getClass());
		Assert.assertNotEquals(Usuario.class, usuarioNoob.getClass());
		Assert.assertNotEquals(Usuario.class, usuarioVeterano.getClass());

	}

	@Test
	public void testCompraJogo() {

		this.usuarioNoob.depositaDinheiro(30.00);
		this.usuarioVeterano.depositaDinheiro(200.00);

		try {
			Assert.assertTrue(usuarioNoob.compraJogos("LOL", 0.50, "rpg"));
			Assert.assertTrue(usuarioNoob.compraJogos("Mucha lucha", 5.0, "luta"));
			Assert.assertTrue(usuarioVeterano.compraJogos("Dark Souls", 39.50, "rpg"));
			Assert.assertTrue(usuarioVeterano.compraJogos("Top gear", 100.00, "plataforma"));

		} catch (Exception exception) {
			exception.getMessage();
		}

		try {
			Assert.assertFalse(usuarioVeterano.compraJogos("  ", 0.0, "luta"));
			Assert.assertFalse(usuarioVeterano.compraJogos("Point Blanck", 21.59, ""));
			Assert.assertFalse(usuarioNoob.compraJogos("  ", 1.50, "luta"));
			Assert.assertFalse(usuarioNoob.compraJogos("Mucha lucha", 30.00, "luta")); // Dinheiro insuficiente.
			Assert.assertFalse(usuarioNoob.compraJogos("Sonic World", 69.65, "plataforma")); // Dinheiro insuficiente.

		} catch (Exception exception) {
			exception.getMessage();
		}
	}

	// Teste: Comprou, ganhou x2p.
	@Test
	public void testComprouGanhouX2p() {

		this.usuarioNoob.depositaDinheiro(50.00);
		this.usuarioVeterano.depositaDinheiro(300.00);

		Assert.assertEquals(0, usuarioNoob.comprouGanhouXp(0));
		Assert.assertNotEquals(1510, usuarioVeterano.comprouGanhouXp(100.50));

		this.usuarioVeterano.comprouGanhouXp(230.30);
		this.usuarioVeterano.comprouGanhouXp(19.30);

		Assert.assertEquals(230, usuarioNoob.comprouGanhouXp(23.30));
		Assert.assertEquals(20, usuarioNoob.comprouGanhouXp(2.50));
		Assert.assertEquals(3450, usuarioVeterano.comprouGanhouXp(230.30));
		Assert.assertEquals(855, usuarioVeterano.comprouGanhouXp(57.00));

		Assert.assertNotEquals(210, usuarioNoob.comprouGanhouXp(23.30));
		Assert.assertNotEquals(5, usuarioNoob.comprouGanhouXp(2.50));
		Assert.assertNotEquals(3550, usuarioVeterano.comprouGanhouXp(230.30));
		Assert.assertNotEquals(955, usuarioVeterano.comprouGanhouXp(57.00));

	}

	// Teste: Jogou, ganhou x2p.
	@Test
	public void testJogouGanhouX2p() {

		this.usuarioNoob.depositaDinheiro(29.90);
		this.usuarioVeterano.depositaDinheiro(247.75);

		try {
			Assert.assertTrue(usuarioNoob.compraJogos("Cacadores de Insanos", 1.00, "luta"));
			Assert.assertFalse(usuarioNoob.compraJogos("Shadow of the Lixoso", 39.50, "rpg"));
			Assert.assertTrue(usuarioVeterano.compraJogos("Cacadores de Insanos", 1.00, "luta"));
			Assert.assertTrue(usuarioVeterano.compraJogos("Shadow of the Lixoso", 39.50, "rpg"));

		} catch (Exception exception) {
			exception.getMessage();
		}

		Assert.assertTrue(usuarioNoob.registraJogada("Cacadores de Insanos", 5900, false));
		Assert.assertTrue(usuarioVeterano.registraJogada("Cacadores de Insanos", 9800, false));

		Assert.assertFalse(usuarioNoob.registraJogada("Shadow of the Lixoso", 486000, true));
		Assert.assertTrue(usuarioVeterano.registraJogada("Shadow of the Lixoso", 598000, true));

	}

	@Test
	public void testConstrutorWithException() {

		// Teste: Nome de usuario vazio/null
		try {
			Noob usuarioNoob = new Noob("  ", "InvisibleGame@loja.com");
			Assert.fail("Lancamento de Exception com Nome de Usuario vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do usuario nao pode ser nulo ou vazio.", exception.getMessage());
		}

		try {
			Noob usuarioNoob = new Noob(null, "InvisibleGame@loja.com");
			Assert.fail("Lancamento de Exception com Nome de Usuario vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do usuario nao pode ser nulo ou vazio.", exception.getMessage());
		}

		// Teste: Login de usuario vazio/null
		try {
			Noob usuarioNoob = new Noob("Tiberuis CS", "");
			Assert.fail("Lancamento de Exception com Login vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O login do usuario nao pode ser nulo ou vazio.", exception.getMessage());
		}

		try {
			Noob usuarioNoob = new Noob("Tiberuis CS", null);
			Assert.fail("Lancamento de Exception com Login vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O login do usuario nao pode ser nulo ou vazio.", exception.getMessage());

		}
	}

}