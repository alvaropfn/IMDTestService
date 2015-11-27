package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.inova.dao.TipoSalaDao;
import br.ufrn.imd.inova.dominio.TipoSala;
import br.ufrn.imd.inova.services.TipoSalaService;

/**
 * 
 * @author Alvaro
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class TipoSalaServiceTest 
{

	@InjectMocks
	TipoSalaService tss;
	
	@Mock
	TipoSalaDao tsd;
	
	@Test
	public void testListar() 
	{
		tss.listar();
		verify(tsd).listar();
	}

	@Test
	public void testSalvar() 
	{
		TipoSala ts = new TipoSala();
		tss.salvar(ts);
		verify(tsd).salvarTipoSala(ts);
	}

}
