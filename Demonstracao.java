package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.arq.dao.CrudDao;
import br.ufrn.imd.arq.dominio.Arquivo;
import br.ufrn.imd.arq.services.ArquivoService;
import br.ufrn.imd.arq.services.CrudService;
import br.ufrn.imd.inova.dominio.Atividade;
import br.ufrn.imd.inova.services.AtividadeService;

@RunWith(MockitoJUnitRunner.class)
public class Demonstracao {
	
	
	@Mock
	ArquivoService arq;
	
	
	Atividade atividade = new Atividade();
	
	SessionFactory sf = Mockito.mock(SessionFactory.class);
	
	
	@InjectMocks
	CrudService<Arquivo> cruds = new CrudService<Arquivo>();
	

	@InjectMocks
	AtividadeService ativService = new AtividadeService();
	
	@Mock
	CrudDao dao;

	/**
	 * Test method for
	 * {@link br.ufrn.imd.inova.services.AtividadeService#salvarOuAtualizar(br.ufrn.imd.inova.dominio.Atividade)}
	 * .
	 */
	@Test
	public void testSalvarOuAtualizarAtividade() {
		ativService.salvarOuAtualizar(atividade);
	}
}
