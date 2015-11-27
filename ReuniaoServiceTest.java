package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.inova.dao.ReuniaoDao;
import br.ufrn.imd.inova.dominio.Reuniao;
import br.ufrn.imd.inova.services.ReuniaoService;
import br.ufrn.imd.monitoramento.dominio.Monitoramento;

/**
 * 
 * @author Alvaro
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class ReuniaoServiceTest {

	@InjectMocks
	ReuniaoService reuniaoService;
	
	@Mock //@InjectMocks
	ReuniaoDao reuniaoDao;
	
	@Mock
	Monitoramento monitoramento;
	
	@Mock
	Reuniao reuniao;
	
	 
	@Test
	public void testIsMonitoramentoFalse() 
	{
		Boolean condition = reuniaoService.isMonitoramento(reuniao);
		assertFalse(condition);
		verify(reuniaoDao).isMonitoramento(reuniao);
		
	}

}
