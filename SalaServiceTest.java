package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.inova.dao.SalaDao;
import br.ufrn.imd.inova.dominio.Sala;
import br.ufrn.imd.inova.services.SalaService;

@RunWith(MockitoJUnitRunner.class)
public class SalaServiceTest 
{

	@InjectMocks
	SalaService salaService;
	
	@Mock
	SalaDao salaDao;
	
	
	@Test
	public void testListar() 
	{
		salaService.listar();
		verify(salaDao).listar();
	}

	@Test
	public void testListarTipoSala() 
	{
		salaService.listarTipoSala();
	}

	@Test
	public void testSalvar() 
	{
		Sala sala = new Sala();
		salaService.salvar(sala);
		verify(salaDao).salvarSala(sala);
	}

}
