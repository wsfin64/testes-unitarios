package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static br.ce.wcaquino.utils.DataUtils.isMesmaData;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	// 1 - Cenário
	LocacaoService service = new LocacaoService();
	Usuario usuario = new Usuario("Wellington");
	Filme filme = new Filme("Missão Impossível", 2, 15.90);

	// 2 - Ação

	Locacao locacao = service.alugarFilme(usuario, filme);

	@Test
	public void testeValorLocacao() {

		// 3 - Verificação

		assertThat(locacao.getValor(), is(equalTo(15.90)));
		

	}
	
	@Test
	public void testeValorDataLocacao() {

		// 3 - Verificação

		assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));

	}
}
