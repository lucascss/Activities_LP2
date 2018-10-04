package lab06.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jogos.*;

public class TestJogo {

	private Jogo rpg;
	private Jogo luta;
	private Jogo plataforma;

	@Before
	public void criaJogo() throws Exception {
		
		this.luta = new Luta("Mortal Kombat", 2.99);
		this.rpg = new RPG("DotA", 16.50);
		this.plataforma = new Plataforma("Cacadores de Insanos", 1.00);

	}

	// Teste: Nome do jogo de Luta - Mortal Kombat.
	@Test
	public void testGetNomeJogo() {
		Assert.assertEquals("Mortal Kombat", luta.getNome());
		Assert.assertEquals("DotA", rpg.getNome());
		Assert.assertEquals("Cacadores de Insanos", plataforma.getNome());

		Assert.assertNotEquals("Cacadores de Insanos", rpg.getNome());
		Assert.assertNotEquals("Top Gear", plataforma.getNome());
		Assert.assertNotEquals("King of Boxe", luta.getNome());

	}

	// Teste: Comparar dois objeto.
	@Test
	public void testEquals() {

		Assert.assertEquals(Luta.class, this.luta.getClass());
		Assert.assertEquals(RPG.class, rpg.getClass());
		Assert.assertNotEquals(Luta.class, rpg.getClass());
		Assert.assertNotEquals(Plataforma.class, luta.getClass());

	}

	// Teste de quantidade de vezes que jogou e zerou um jogo.
	@Test
	public void testRegistraJogada() {

		Assert.assertEquals(0, rpg.getQtdQueJogou());
		Assert.assertEquals(0, luta.getQtdQueZerou());
		Assert.assertEquals(0, plataforma.getQtdQueJogou());
		Assert.assertNotEquals(12, luta.getQtdQueJogou());
		Assert.assertNotEquals(1, rpg.getQtdQueZerou());

		rpg.registraJogada(16000, false);
		rpg.registraJogada(35000, false);

		luta.registraJogada(26000, false);
		luta.registraJogada(100000, true);
		luta.registraJogada(100100, true); // NAO CONTABILIZA A JOGADA, LIMITE
		// DE SCORE INFRINGIDO.

		plataforma.registraJogada(20630, false);
		plataforma.registraJogada(20630, false);
		plataforma.registraJogada(20630, false);
		plataforma.registraJogada(245630, true);
		plataforma.registraJogada(230000, true);

		Assert.assertEquals(2, rpg.getQtdQueJogou());
		Assert.assertEquals(5, plataforma.getQtdQueJogou());
		Assert.assertEquals(2, luta.getQtdQueJogou());
		Assert.assertNotEquals(12, luta.getQtdQueJogou());
		Assert.assertNotEquals(2, plataforma.getQtdQueJogou());

		Assert.assertEquals(1, luta.getQtdQueZerou());
		Assert.assertEquals(0, rpg.getQtdQueZerou());
		Assert.assertEquals(2, plataforma.getQtdQueZerou());

		Assert.assertNotEquals(1, rpg.getQtdQueZerou());
		Assert.assertNotEquals(1, plataforma.getQtdQueZerou());
		Assert.assertNotEquals(0, luta.getQtdQueZerou());

	}

	// Teste de maior score.
	@Test
	public void testMaiorScore() {

		rpg.registraJogada(16000, false);
		rpg.registraJogada(35000, false);

		luta.registraJogada(26000, false);
		luta.registraJogada(100000, true);
		luta.registraJogada(100100, true); // NAO CONTABILIZA A JOGADA, LIMITE
		// DE SCORE INFRINGIDO.

		plataforma.registraJogada(20630, false);
		plataforma.registraJogada(20630, false);
		plataforma.registraJogada(20630, false);
		plataforma.registraJogada(245630, true);
		plataforma.registraJogada(230000, true);

		Assert.assertEquals(100000, luta.getMaiorScore());
		Assert.assertEquals(35000, rpg.getMaiorScore());
		Assert.assertEquals(245630, plataforma.getMaiorScore());

		Assert.assertNotEquals(230000, rpg.getMaiorScore());
		Assert.assertNotEquals(20630, plataforma.getMaiorScore());
		Assert.assertNotEquals(0, luta.getMaiorScore());

	}

	@Test
	public void testNomeJogoWithException() {

		// Teste: Nome do jogo (LUTA) vazio/null.
		try {
			Luta luta = new Luta("  ", 20.0);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio.", exception.getMessage());
		}

		try {
			Luta luta = new Luta(null, 5.02);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio.", exception.getMessage());
		}

		// Teste: Nome do jogo (PLATAFORMA) vazio/null.
		try {
			Plataforma plataforma = new Plataforma("  ", 20.0);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio.", exception.getMessage());
		}

		try {
			Plataforma plataforma = new Plataforma(null, 5.02);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio.", exception.getMessage());
		}

		// Teste: Nome do jogo (RPG) vazio/null.
		try {
			RPG rpg = new RPG("  ", 20.0);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio.", exception.getMessage());
		}

		try {
			RPG rpg = new RPG(null, 5.02);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio.", exception.getMessage());
		}
	}

	@Test
	public void testPrecoJogoWithException() {
		// Teste: Preco do jogo (LUTA) menor ou igual a zero.
		try {
			Luta luta = new Luta("Cacete Altas Horas", -20.0);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O preco do jogo nao pode ser nulo ou negativo.", exception.getMessage());
		}

		try {
			Luta luta = new Luta("Cacete Altas Horas", 0.0);
			Assert.fail("Lancamento de Exception com nome vazio.");

		} catch (Exception exception) {
			Assert.assertEquals("O preco do jogo nao pode ser nulo ou negativo.", exception.getMessage());
		}

		// Teste: Preco do jogo (PLATAFORMA) vazio/null.
		try {
			Plataforma plataforma = new Plataforma("Angry Birds", -5.0);
			Assert.fail("Lancamento de Exception com preco menor ou igual a zero.");

		} catch (Exception exception) {
			Assert.assertEquals("O preco do jogo nao pode ser nulo ou negativo.", exception.getMessage());
		}

		try {
			Plataforma plataforma = new Plataforma("Aika", 0.0);
			Assert.fail("Lancamento de Exception com preco menor ou igual a zero.");

		} catch (Exception exception) {
			Assert.assertEquals("O preco do jogo nao pode ser nulo ou negativo.", exception.getMessage());
		}

		// Teste: Preco do jogo (RPG) vazio/null.
		try {
			RPG rpg = new RPG("Robin Hood", -52.6);
			Assert.fail("Lancamento de Exception com preco menor ou igual a zero.");

		} catch (Exception exception) {
			Assert.assertEquals("O preco do jogo nao pode ser nulo ou negativo.", exception.getMessage());
		}

		try {
			RPG rpg = new RPG("Dark Souls", 0.0);
			Assert.fail("Lancamento de Exception com preco menor ou igual a zero.");

		} catch (Exception exception) {
			Assert.assertEquals("O preco do jogo nao pode ser nulo ou negativo.", exception.getMessage());
		}
	}

}
