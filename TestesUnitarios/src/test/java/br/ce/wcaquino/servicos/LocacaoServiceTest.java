package br.ce.wcaquino.servicos;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste() {
		
		// 1 - Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Wellington");
		Filme filme = new Filme("Missão Impossível", 2, 15.90);
		
		
		// 2 - Ação
		
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		
		// 3 - Verificação
		
		Assert.assertEquals(15.90, locacao.getValor(), 0.01);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}
