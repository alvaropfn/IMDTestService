package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.arq.dao.CrudDao;
import br.ufrn.imd.arq.services.CrudService;
import br.ufrn.imd.inova.dao.EmpresaDao;
import br.ufrn.imd.inova.dominio.Empresa;
import br.ufrn.imd.inova.services.EmpresaService;

/**
 * 
 * @author Alvaro
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class EmpresaServiceTest 
{
	@InjectMocks
	EmpresaService empresaService;

	@InjectMocks
	CrudService crudService;
	
	@Mock 
	EmpresaDao empresaDao;// = new EmpresaDao(sf);
	
	@Mock
	Empresa empresa;// = Mockito.mock(Empresa.class);
	
	@Mock
	CrudDao crudDao;
	
	@Test
	public void testListar()
	{
		empresaService.listar();
		verify(empresaDao).listar();
	}

	@Test
	public void testListarOrdenadoByTipo() 
	{
		empresaService.listarOrdenadoByTipo();
		verify(empresaDao).listar();
	}

	@Test
	public void testBuscarPorNome()
	{
		String nome = "nome";
		empresaService.buscarPorNome(nome);
		verify(empresaDao).buscarPorNome(nome);
	}

	@Test
	public void testBuscarPorCnpj() 
	{
		String cnpj = "cnpj"; 
		
		//when(empresaDao.buscarPorCnpj(cnpj));
		empresaService.buscarPorCnpj(cnpj);
		verify(empresaDao).buscarPorCnpj(cnpj); 
	}

	@Test
	public void testExisteCnpjTrue() 
	{
		String cnpj = "cnpj"; 
		List<Empresa> empresas = Mockito.mock(List.class);
		
		when(empresas.isEmpty()).thenReturn(false);
		when(empresaDao.getCnpj(cnpj)).thenReturn(empresas);
		
		empresaService.existeCnpj(cnpj);
		verify(empresaDao).getCnpj(cnpj);
		

	}
	
	@Test
	public void testExisteCnpjFalse() 
	{
		String cnpj = "cnpj"; 
		
		empresaService.existeCnpj(cnpj);
		verify(empresaDao).getCnpj(cnpj);
		
	}
	@Test //TODO
	public void testRemoverEmpresa() 
	{
		/*
		CrudService crudService = Mockito.mock(CrudService.class);
		empresaService.remover(empresa);
		verify(empresa).setAtivo(false);
		verify(crudService).salvarOuAtualizar(empresa);
		*/
		empresaService.remover(empresa);
	}
 
	@Test
	public void testSociosByEmpresa() 
	{	
		empresaService.sociosByEmpresa(empresa);
		verify(empresaDao).sociosByEmpresa(empresa);
	}

	@Test
	public void testListarDadosContrato() 
	{
		empresaService.listarDadosContrato(empresa);
		verify(empresaDao).listarDadosContrato(empresa);
	}

	@Test
	public void testSalvarOuAtualizarEmpresa() 
	{
		empresaService.salvarOuAtualizar(empresa);
		verify(empresaDao).salvarOuAtualizar(empresa);
	}

	@Test
	public void testFindArquivoByEmpresa() 
	{
		empresaService.findArquivoByEmpresa(empresa);
		verify(empresaDao).findArquivoByEmpresa(empresa);
	}

}
