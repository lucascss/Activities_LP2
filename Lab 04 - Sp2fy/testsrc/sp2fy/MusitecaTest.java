package sp2fy;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import sp2fy.*;

import sp2fy.Album;
import sp2fy.Musica;
import sp2fy.Musiteca;

public class MusitecaTest {
	
	Musiteca musiteca;

	@Before
	public void setUp() throws Exception {
		musiteca = new Musiteca();
	}

	@Test
	public void testCriaAlbum() {
		Album lemonade;
		try {
			lemonade = new Album("Beyounce", "Lemonade", 2015);
			Musica sorry = new Musica("Sorry", 5, "Pop");
			Musica formation = new Musica("Formation", 4, "Pop");
			lemonade.adicionaMusica(sorry);
			lemonade.adicionaMusica(formation);
			
			// nao pode adicionar albuns repetidos.
			assertTrue(musiteca.adicionaAlbum(lemonade));
			assertFalse(musiteca.adicionaAlbum(lemonade));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testFavoritaAlbum() {

		Album perfilMarilia;
		try {
			perfilMarilia = new Album("Marilia Mendonca", "Perfil", 2015);
			// adicionar na musiteca
			assertTrue(musiteca.adicionaAlbum(perfilMarilia));
			assertTrue(musiteca.contemAlbum(perfilMarilia));
			
			// adicionar aos favoritos.
			assertTrue(musiteca.adicionaAosFavoritos(perfilMarilia));
			assertFalse(musiteca.adicionaAosFavoritos(perfilMarilia));
			
			assertEquals(1, musiteca.getQuantidadeFavoritos());
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testCriaEAddPlaylist() throws Exception {
		// cria uma playlist vazia, mas nao pode
		// criar mais de uma playlist com
		// o mesmo titulo.
		assertTrue(musiteca.criaPlaylist("Pop"));
		assertFalse(musiteca.criaPlaylist("Pop"));
		assertTrue(musiteca.contemPlaylist("Pop"));

	}

	@Test
	public void pesquisaMusica() {

		try {
			Musica sentimentoLouco = new Musica("Sentimento louco", 3, "Sertanejo");
			Album mariliaLive = new Album("Marilia Mendonca", "DVD Ao vivo", 2015);
			mariliaLive.adicionaMusica(sentimentoLouco);
			assertTrue(musiteca.adicionaAlbum(mariliaLive));
			assertTrue(musiteca.criaPlaylist("Sertanejo"));
			// adiciona na playlist de nome sertanejo:
			// a faixa 1 do album 'DVD Ao Vivo';
			// se houver nomes de albuns iguais, utilize o primeiro q encontrar
			assertTrue(musiteca.adicionaNaPlaylist("Sertanejo", "DVD Ao Vivo", 1));
			
			assertEquals(1, musiteca.getTamanhoPlaylist("Sertanejo"));
			// verifica se a playlist Sertanejo tem uma musica com esse nome.
			assertTrue(musiteca.contemNaPlaylist("Sertanejo", "Sentimento Louco"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

	@Test
	public void testExeptionCases() throws Exception {
		//adicao e criacao com valores null
		// sao tratados com retorno de booleanos
		// como consta no enunciado do lab.
		assertFalse(musiteca.adicionaAlbum(null));
		assertFalse(musiteca.criaPlaylist(""));
	}


}
