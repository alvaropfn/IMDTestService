/**
 * 
 */
package br.ufrn.imd.inova.testServices;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.directory.api.ldap.extras.extended.ads_impl.whoAmI.WhoAmIResponseStatesEnum;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import br.ufrn.imd.arq.dao.CrudDao;
import br.ufrn.imd.arq.dominio.Arquivo;
import br.ufrn.imd.arq.dominio.Usuario;
import br.ufrn.imd.arq.services.ArquivoService;
import br.ufrn.imd.arq.services.CrudService;
import br.ufrn.imd.inova.dao.AtividadeDao;
import br.ufrn.imd.inova.dominio.Atividade;
import br.ufrn.imd.inova.dominio.Documento;
import br.ufrn.imd.inova.dominio.LogAtividade;
import br.ufrn.imd.inova.dominio.TipoCategoriaCerne;
import br.ufrn.imd.inova.services.AtividadeService;
import junit.framework.TestCase;

/**
 * @author Joao Matias
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AtividadeServiceTest extends TestCase {

	@InjectMocks
	AtividadeService ativService = new AtividadeService();
	@InjectMocks
	CrudService<Arquivo> crudService = new CrudService<Arquivo>();

	SessionFactory sf = mock(SessionFactory.class);

	Atividade obj = new Atividade();
	Arquivo arquivo = new Arquivo();
	LogAtividade logAtiv = new LogAtividade();

	@Mock
	ArquivoService arquivoService;
	@Mock
	CrudDao crudDao = new CrudDao(sf);
	@Mock
	AtividadeDao ativDao;

	List<Atividade> resultAtiv = new ArrayList<Atividade>();
	List<Atividade> resultAtivEsperado = new ArrayList<Atividade>();

	List<LogAtividade> resultLog = new ArrayList<LogAtividade>();
	List<LogAtividade> resultLogEsperado = new ArrayList<LogAtividade>();

	private void prepararResultadosAtiv() {
		// TODO Auto-generated method stub
		resultAtivEsperado = new ArrayList<Atividade>();
		resultAtivEsperado.add(obj);
		resultAtiv = new ArrayList<Atividade>();
	}

	private void prepararResultadosLog() {
		resultLogEsperado = new ArrayList<LogAtividade>();
		resultLogEsperado.add(logAtiv);
		resultLog = new ArrayList<LogAtividade>();
	}

	@Test
	public void testSalvarOuAtualizarAtividade() {
		// Preparar
		Arquivo arq1 = new Arquivo("Arquivo1", "Para testes", "C://testes.inova.ufrn.br", "Arquivo");
		List<Arquivo> arquivos = new ArrayList<Arquivo>();
		arquivos.add(arq1);
		obj.setArquivos(arquivos);

		// Testar
		ativService.salvarOuAtualizar(obj);

		// Verificar
		verify(arquivoService).salvarOuAtualizar(arq1);
		verify(crudDao).salvarOuAtualizar(obj);
	}

	@Test
	public void testListar() {
		// Preparar
		prepararResultadosAtiv();
		when(ativDao.listar()).thenReturn(resultAtivEsperado);

		// Testar
		resultAtiv = ativService.listar();

		// Verificar
		verify(ativDao).listar();
		assertEquals(resultAtivEsperado, resultAtiv);
	}

	@Test
	public void testBuscarPorTitulo() {
		// Preparar
		prepararResultadosAtiv();
		String titulo = "discente";

		when(ativDao.buscarPorTitulo(titulo)).thenReturn(resultAtivEsperado);

		// Testar
		resultAtiv = ativService.buscarPorTitulo(titulo);

		// Verificar
		verify(ativDao).buscarPorTitulo(titulo);
		assertEquals(resultAtivEsperado, resultAtiv);
	}

	@Test
	public void testBuscarPorNome() {
		// Preparar
		prepararResultadosAtiv();
		String nome = "João Matias";
		when(ativDao.buscarPorNome(nome)).thenReturn(resultAtivEsperado);

		// Testar
		resultAtiv = ativService.buscarPorNome(nome);

		// Verificar
		verify(ativDao).buscarPorNome(nome);
		assertEquals(resultAtivEsperado, resultAtiv);
	}

	@Test
	public void testLogsByAtividade() {
		// Preparar
		prepararResultadosLog();
		when(ativDao.logsByAtividade(obj)).thenReturn(resultLogEsperado);

		// Testar
		resultLog = ativService.logsByAtividade(obj);

		// Verificar
		verify(ativDao).logsByAtividade(obj);
		assertEquals(resultLogEsperado, resultLog);
	}

	@Test
	public void testLogByAtividadeId() {
		// Preparar
		int atividadeId = 0;
		Atividade resultAtiv = new Atividade();
		when(ativDao.logsByAtividadeId(atividadeId)).thenReturn(obj);

		// Testar
		resultAtiv = ativService.logByAtividadeId(atividadeId);

		// Verificar
		verify(ativDao).logsByAtividadeId(atividadeId);
		assertEquals(obj, resultAtiv);
	}

	@Test
	public void testAtividadesByResponsavel() {
		// Preparar
		prepararResultadosAtiv();
		Usuario responsavel = mock(Usuario.class);
		when(ativDao.atividadesByResponsavel(responsavel)).thenReturn(resultAtivEsperado);

		// Testar
		resultAtiv = ativService.atividadesByResponsavel(responsavel);

		// Verificar
		verify(ativDao).atividadesByResponsavel(responsavel);
		assertEquals(resultAtivEsperado, resultAtiv);
	}

	@Test
	public void testAtividadesFazer() {
		// Preparar
		prepararResultadosAtiv();
		when(ativDao.atividadesFazer()).thenReturn(resultAtivEsperado);

		// Testar
		resultAtiv = ativService.atividadesFazer();

		// Verificar
		verify(ativDao).atividadesFazer();
		assertEquals(resultAtivEsperado, resultAtiv);
	}

	@Test
	public void testAtividadesAndamento() {
		// Preparar
		prepararResultadosAtiv();
		when(ativDao.atividadesAndamento()).thenReturn(resultAtivEsperado);

		// Testar
		resultAtiv = ativService.atividadesAndamento();

		// Verificar
		verify(ativDao).atividadesAndamento();
		assertEquals(resultAtivEsperado, resultAtiv);
	}

	@Test
	public void testAtividadesConcluida() {
		// Preparar
		prepararResultadosAtiv();
		when(ativDao.atividadesConcluida()).thenReturn(resultAtivEsperado);

		// Testar
		resultAtiv = ativService.atividadesConcluida();

		// Verificar
		verify(ativDao).atividadesConcluida();
		assertEquals(resultAtivEsperado, resultAtiv);
	}

	@Test
	public void testCategoriaCerneByAtividade() {
		// Preparar
		List<TipoCategoriaCerne> listCategoria = new ArrayList<TipoCategoriaCerne>();
		when(ativDao.categoriaCerneByAtividade(obj)).thenReturn(listCategoria);

		// Testar
		ativService.categoriaCerneByAtividade(obj);

		// Verificar
		verify(ativDao).categoriaCerneByAtividade(obj);
	}

}
