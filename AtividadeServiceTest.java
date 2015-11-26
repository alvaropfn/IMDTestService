/**
 * 
 */
package br.ufrn.imd.inova.testServices;

import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.arq.dao.CrudDao;
import br.ufrn.imd.arq.dominio.Arquivo;
import br.ufrn.imd.arq.services.ArquivoService;
import br.ufrn.imd.arq.services.CrudService;
import br.ufrn.imd.inova.dominio.Atividade;
import br.ufrn.imd.inova.services.AtividadeService;
import junit.framework.TestCase;

/**
 * @author Joao
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AtividadeServiceTest extends TestCase {

	@Mock
	ArquivoService arquivoService = new ArquivoService();
	
	SessionFactory sf = mock(SessionFactory.class);
			
	@Mock
	CrudDao crudDao = new CrudDao(sf);

	@InjectMocks
	AtividadeService ativService = new AtividadeService();
	
	@InjectMocks
	CrudService<Arquivo> crudService = new CrudService<Arquivo>();

	Atividade obj = new Atividade();
	Arquivo arquivo = new Arquivo();

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#salvarOuAtualizar(br.ufrn.imd.inova.dominio.Atividade)}
	 * .
	 */
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

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#listar()}.
	 */
	public void testListar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#buscarPorTitulo(java.lang.String)}
	 * .
	 */
	public void testBuscarPorTitulo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#buscarPorNome(java.lang.String)}
	 * .
	 */
	public void testBuscarPorNome() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#logsByAtividade(br.ufrn.imd.inova.dominio.Atividade)}
	 * .
	 */
	public void testLogsByAtividade() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#logByAtividadeId(int)}
	 * .
	 */
	public void testLogByAtividadeId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#atividadesByResponsavel(br.ufrn.imd.arq.dominio.Usuario)}
	 * .
	 */
	public void testAtividadesByResponsavel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#atividadesFazer()}.
	 */
	public void testAtividadesFazer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#atividadesAndamento()}
	 * .
	 */
	public void testAtividadesAndamento() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#atividadesConcluida()}
	 * .
	 */
	public void testAtividadesConcluida() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#categoriaCerneByAtividade(br.ufrn.imd.inova.dominio.Atividade)}
	 * .
	 */
	public void testCategoriaCerneByAtividade() {
		fail("Not yet implemented");
	}

}
