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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sun.source.tree.CatchTree;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testeLocacao() throws Exception {

		// 1 - Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Wellington");
		Filme filme = new Filme("Missão Impossível", 2, 15.90);

		// 2 - Ação

		Locacao locacao = service.alugarFilme(usuario, filme);

		// 3 - Verificação
		assertThat(locacao.getValor(), is(equalTo(15.90)));
		assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));

	}
	
	// Neste cenario é esperado que uma exceção ocorra
	@Test(expected = Exception.class)
	public void testLocacaoFilmeSemEstoque() throws Exception {

		// 1 - Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Wellington");
		Filme filme = new Filme("Missão Impossível", 0, 15.90);

		// 2 - Ação

		service.alugarFilme(usuario, filme);

	}
	
	// Neste cenario é esperado que uma exceção ocorra, é verificado a mensagem esperada
		@Test
		public void testLocacaoFilmeSemEstoque2(){

			// 1 - Cenário
			LocacaoService service = new LocacaoService();
			Usuario usuario = new Usuario("Wellington");
			Filme filme = new Filme("Missão Impossível", 0, 15.90);

			// 2 - Ação

			try {
				service.alugarFilme(usuario, filme);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertThat(e.getMessage(), is("Filme sem estoque"));
			}

		}
		
		@Test
		public void testLocacaoFilmeSemEstoque3() throws Exception {

			// 1 - Cenário
			LocacaoService service = new LocacaoService();
			Usuario usuario = new Usuario("Wellington");
			Filme filme = new Filme("Missão Impossível", 0, 15.90);

			// 2 - Ação

			exception.expect(Exception.class);
			exception.expectMessage("Filme sem estoque");
			service.alugarFilme(usuario, filme);
			

		}

}
