package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.inova.dao.MensagemDao;
import br.ufrn.imd.inova.dominio.Socio;
import br.ufrn.imd.inova.services.MensagemService;

/**
 * 
 * @author Alvaro
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class MensagemServiceTest 
{
	@InjectMocks
	MensagemService mst;

	@Mock
	MensagemDao msd;
	
	@Test
	public void testListar() 
	{
		mst.listar();
		verify(msd).listar();
	}
	
	@Test
	public void testGetUsuarios() 
	{
		
		//List<Socio> socios = Mockito.mock(List.class);
		List<Socio> socios = new ArrayList<Socio>();
		mst.getUsuarios(socios);
	}

}
