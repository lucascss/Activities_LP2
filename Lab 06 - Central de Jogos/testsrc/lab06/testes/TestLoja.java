package lab06.testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import centraldejogos.Loja;
import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.RPG;
import usuarios.*;

public class TestLoja {

	private Loja loja;

	@Before
	public void setUp() {

		this.loja = new Loja();
	}

	// Teste: Vende jogos a um usuario cadastrado na loja.
	@Test
	public void testVendeJogos() throws Exception {

		loja.adicionaUsuario("Amigao Calinfon", "amigao@loja.com", "Noob");
		loja.adicionaUsuario("Insano Bubassalto", "altos_assalto@loja.com", "Veterano");
		loja.adicionaUsuario("Wesley Canibal", "todo_calibalesco@loja.com", "Veterano");
		loja.adicionaUsuario("Porco Voador", "resenhas_del_porco@loja.com", "Noob");

		loja.addDinheiroPraUsuario("amigao@loja.com", 200.00);
		loja.addDinheiroPraUsuario("altos_assalto@loja.com", 100.00);
		loja.addDinheiroPraUsuario("todo_calibalesco@loja.com", 29.75);
		loja.addDinheiroPraUsuario("resenhas_del_porco", 7.00);

		Assert.assertTrue(loja.vendeAoUsuario("amigao@loja.com", "AQWorlds", 16.35, "Plataforma"));
		Assert.assertTrue(loja.vendeAoUsuario("altos_assalto@loja.com", "PokemonGO", 1.00, "RPG"));
		Assert.assertTrue(loja.vendeAoUsuario("todo_calibalesco@loja.com", "DragonBallZ", 25.00, "Luta"));

		Assert.assertFalse(loja.vendeAoUsuario("amigao@loja.com", "Top Gear", 350.00, "Plataforma"));
		Assert.assertFalse(loja.vendeAoUsuario("todo_calibalesco@loja.com", "WatchDogs", 100.00, "RPG"));
		Assert.assertFalse(loja.vendeAoUsuario("resenhas_del_porco", "WatchDogs", 100.00, "RPG"));

	}

	// Teste: Upgrade usuario.
	@Test
	public void testUpgradeUsuario() throws Exception {

		loja.adicionaUsuario("Christon02", "paguei_calculo@loja.com", "Noob");
		loja.getUsuariosCadastrados().get("paguei_calculo@loja.com").setX2p(3780);

		Assert.assertEquals(3780, loja.getUsuariosCadastrados().get("paguei_calculo@loja.com").getX2p());
		loja.upgrade("paguei_calculo@loja.com");
		Assert.assertEquals("Veterano", loja.pesquisaUsuario("paguei_calculo@loja.com").getClass().getSimpleName());

	}

	@Test
	public void testCadastraUsuarioWithException() {

		// Teste: Nome do usuario vazio/null.

		try {
			loja.adicionaUsuario("  ", "aleatoriamente@loja.com", "Noob");
			fail();

		} catch (Exception exception) {
			Assert.assertEquals("Erro: O nome do usuario nao pode ser nulo ou vazio.", exception.getMessage());
		}

		try {
			loja.adicionaUsuario(null, "calinfon_cartola@loja.com", "Noob");
			fail();
		} catch (Exception exception) {
			Assert.assertEquals("Erro: O nome do usuario nao pode ser nulo ou vazio.", exception.getMessage());
		}

		// Teste: Login do usuario vazio/null.

		try {
			loja.adicionaUsuario("Marta Maria", "", "Veterano");
			fail();
		} catch (Exception exception) {
			Assert.assertEquals("Erro: O login do usuario nao pode ser nulo ou vazio.", exception.getMessage());
		}

		try {
			loja.adicionaUsuario("Insaninho JogaTudo", null, "Veterano");
			fail();
		} catch (Exception exception) {
			Assert.assertEquals("Erro: O login do usuario nao pode ser nulo ou vazio.", exception.getMessage());
		}

	}

	@Test
	public void testUpgradeWithException() {

		// Teste: Upgrade do usuario com x2p menor que 1000.

		try {
			loja.adicionaUsuario("Arco Tangente", "omatematico@loja.com", "Noob");
			loja.getUsuariosCadastrados().get("omatematico@loja.com").setX2p(972);

			Assert.assertEquals(972, loja.getUsuariosCadastrados().get("omatematico@loja.com").getX2p());

			loja.upgrade("omatematico@loja.com");

		} catch (Exception exception) {
			Assert.assertEquals("Quantidade de x2p precisa ser maior ou igual a 1000.", exception.getMessage());
		}

		try {
			loja.adicionaUsuario("Cataclism", "rumble_snipper@loja.com", "Noob");
			loja.getUsuariosCadastrados().get("rumble_snipper@loja.com").setX2p(569);

			Assert.assertEquals(569, loja.getUsuariosCadastrados().get("rumble_snipper@loja.com").getX2p());

			loja.upgrade("rumble_snipper@loja.com");

		} catch (Exception exception) {
			Assert.assertEquals("Quantidade de x2p precisa ser maior ou igual a 1000.", exception.getMessage());
		}

		// Teste: Upgrade do usuario com usuario jah veterano.

		try {

			loja.adicionaUsuario("Maria DotA", "20onar@loja.com", "Veterano");
			loja.getUsuariosCadastrados().get("20onar@loja.com").setX2p(2650);

			Assert.assertEquals(3650, loja.getUsuariosCadastrados().get("20onar@loja.com").getX2p());

			loja.upgrade("20onar@loja.com");

		} catch (Exception exception) {
			Assert.assertEquals("O usuario ja eh do tipo veterano!", exception.getMessage());
		}

		try {

			loja.adicionaUsuario("Lugin", "bala_altas_horas@loja.com", "Veterano");
			loja.getUsuariosCadastrados().get("bala_altas_horas@loja.com").setX2p(3968);

			Assert.assertEquals(4968, loja.getUsuariosCadastrados().get("bala_altas_horas@loja.com").getX2p());

			loja.upgrade("bala_altas_horas@loja.com");

		} catch (Exception exception) {
			Assert.assertEquals("O usuario ja eh do tipo veterano!", exception.getMessage());
		}
		
	}

}
