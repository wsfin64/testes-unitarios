package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
	
	@Test
	public void Teste() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		// Nos casos de Doubles, é necessário incluir um delta
		Assert.assertEquals(1, 1);
		Assert.assertEquals(0.51234, 0.512, 0.001);
		
		// É possível colocar uma string de mensagem para caso aconteça um erro.
		//Assert.assertEquals("Erro de comparacao", 1, 2);
		
		// No casos de comparações entre objetos e tipos primitivos, ambos deve ser convertidos para objetos ou para tipos primitivos
		int i = 5;
		Integer i2 = 5;
		
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		
		// Strings
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		
		// Objetos
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		// Após o equals implementado na classe Usuario
		Assert.assertEquals(u1, u2);
		
		// Mesma instância
		Assert.assertSame(u2, u2);
		
		Assert.assertNull(u3);
		
	}

}
