package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.inova.dao.ContratoDao;
import br.ufrn.imd.inova.dominio.Empresa;
import br.ufrn.imd.inova.services.ContratoService;

/**
 * 
 * @author Alvaro
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class ContratoServiceTest 
{
	
	@InjectMocks
	ContratoService contratoService;
	
	@Mock
	ContratoDao contratoDao;
	
	@Mock Empresa empresa;
	
	@Test
	public void testListar() 
	{
		contratoService.listar();
		verify(contratoDao).listar();
	}

	@Test
	public void testBuscarPorEmpresa()
	{
		contratoService.buscarPorEmpresa(empresa);
		contratoService.buscarPorEmpresa(null); 
	}

	@Test
	public void testSociosByEmpresa() 
	{
		contratoService.sociosByEmpresa(empresa);
		contratoService.sociosByEmpresa(null); 
	}

}
