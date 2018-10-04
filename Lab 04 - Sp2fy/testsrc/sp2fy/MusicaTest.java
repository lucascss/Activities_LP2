package sp2fy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sp2fy.Musica;

public class MusicaTest {
	
	private Musica musica;
	private String tituloMusica = "Formation";
	private int duracaoEsperada = 5;
	private String generoEsperado = "Pop";	
	
	@Before
	public void setup() throws Exception{
		this.musica = new Musica(tituloMusica,5,"Pop");
	}
	
	@Test
	public void testGetTitulo(){
		Assert.assertEquals(tituloMusica, musica.getTitulo());
	}

	@Test
	public void testGetGenero(){
		Assert.assertEquals(generoEsperado, musica.getGenero());
	}
	
	@Test
	public void testGetDuracao(){
		Assert.assertEquals(duracaoEsperada, musica.getDuracao());
	}
	
	//note abaixo como eh o bom uso de exceptions em testes
	@Test(expected = Exception.class)
	public void testTituloVazio() throws Exception{
		musica = new Musica("",5,"Pop");
	}
	
	@Test(expected = Exception.class)
	public void testTituloNull() throws Exception{
		musica = new Musica(null,5,"Pop");
	}
	
	@Test(expected = Exception.class)
	public void testGeneroVazio() throws Exception{
		musica = new Musica("Fly me to the moon.",5,"");
	}
	
	@Test(expected = Exception.class)
	public void testGeneroNull() throws Exception{
		musica = new Musica("Fly me to the moon.",5,null);
	}
	
	@Test(expected = Exception.class)
	public void testDuracaoInvalida() throws Exception{
		musica = new Musica("Fly me to the moon.",-5,"Forro");
	}

	@Test(expected = Exception.class)
	public void testDuracaoZero() throws Exception{
		musica = new Musica("Fly me to the moon.",0,"Forro");
	}

}
