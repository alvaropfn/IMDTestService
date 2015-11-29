/**
 * 
 */
package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.arq.controllers.FacesUtils;
import br.ufrn.imd.arq.dao.CrudDao;
import br.ufrn.imd.arq.dominio.Arquivo;
import br.ufrn.imd.arq.services.CrudService;
import br.ufrn.imd.inova.dao.LogAtividadeDao;
import br.ufrn.imd.inova.dominio.Atividade;
import br.ufrn.imd.inova.dominio.LogAtividade;
import br.ufrn.imd.inova.dominio.SituacaoAtividade;
import br.ufrn.imd.inova.services.AtividadeService;
import br.ufrn.imd.inova.services.LogAtividadeService;

/**
 * @author Joao Matias
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LogAtividadeServiceTest {

	@InjectMocks
	LogAtividadeService logService;
	@InjectMocks
	CrudService<Arquivo> crudService = new CrudService<Arquivo>();

	SessionFactory sf = mock(SessionFactory.class);

	@Mock
	LogAtividadeDao logDao;
	@Mock
	AtividadeService ativService;
	@Mock
	CrudDao crudDao = new CrudDao(sf);

	LogAtividade logAtiv = new LogAtividade();
	Atividade ativ = new Atividade();

	SituacaoAtividade resultSituacaoAtiv = new SituacaoAtividade();
	SituacaoAtividade resultSituacaoAtivEsperado = new SituacaoAtividade();

	List<LogAtividade> resultLogAtiv = new ArrayList<LogAtividade>();
	List<LogAtividade> resultLogAtivEsperado = new ArrayList<LogAtividade>();

	private void prepararResultSituacaoAtiv() {
		resultSituacaoAtiv = new SituacaoAtividade();
		resultSituacaoAtivEsperado = new SituacaoAtividade();
	}

	private void prepararResultLogAtiv() {
		resultLogAtiv = new ArrayList<LogAtividade>();
		resultLogAtivEsperado = new ArrayList<LogAtividade>();
		resultLogAtivEsperado.add(logAtiv);
	}

	@Test
	public void testSituacaoAtividadeById() {
		// Preparar
		prepararResultSituacaoAtiv();
		int id = 10;
		when(logDao.buscar(id, SituacaoAtividade.class)).thenReturn(resultSituacaoAtivEsperado);

		// Testar
		resultSituacaoAtiv = logService.situacaoAtividadeById(id);

		// Verificar
		verify(logDao).buscar(id, SituacaoAtividade.class);
		assertEquals(resultSituacaoAtivEsperado, resultSituacaoAtiv);
	}

	@Test
	public void testLogsByAtividade() {
		// Preparar
		prepararResultLogAtiv();
		when(logDao.logsByAtividade(ativ)).thenReturn(resultLogAtivEsperado);

		// Testar
		resultLogAtiv = logService.logsByAtividade(ativ);

		// Verificar
		verify(logDao).logsByAtividade(ativ);
		assertEquals(resultLogAtivEsperado, resultLogAtiv);
	}

	@Test
	public void testSalvarOuAtualizarLogAtividade() {
		// Preparar
		logAtiv.setAtividade(ativ);
		String msg = "Operação realizada com sucesso.";

		// Testar
		logService.salvarOuAtualizar(logAtiv);

		// Verificar
		verify(ativService).salvarOuAtualizar(logAtiv.getAtividade());
	}

}
