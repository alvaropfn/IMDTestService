/**
 * 
 */
package br.ufrn.imd.inova.testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufrn.imd.inova.dominio.Documento;
import br.ufrn.imd.inova.dominio.Empresa;
import br.ufrn.imd.inova.dominio.TipoCategoriaCerne;
import br.ufrn.imd.inova.dao.DocumentoDao;
import br.ufrn.imd.inova.services.DocumentoService;

/**
 * @author Joao Matias
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DocumentoServiceTest {

	// Preparar
	@InjectMocks
	DocumentoService docService = new DocumentoService();

	@Mock
	DocumentoDao docDao = mock(DocumentoDao.class);

	Documento doc = new Documento();

	List<Documento> resultDocEsperado = new ArrayList<Documento>();
	List<Documento> resultDoc = new ArrayList<Documento>();

	private void prepararResultadosDoc() {
		// TODO Auto-generated method stub
		resultDocEsperado = new ArrayList<Documento>();
		resultDocEsperado.add(doc);
		resultDoc = new ArrayList<Documento>();
	}

	@Test
	public void testListar() {
		// Preparar
		prepararResultadosDoc();
		when(docDao.listar()).thenReturn(resultDocEsperado);

		// Testar
		resultDoc = docService.listar();

		// Verificar
		verify(docDao).listar();
		assertEquals(resultDocEsperado, resultDoc);
	}

	@Test
	public void testBuscarPorEmpresa() {
		// Preparar
		prepararResultadosDoc();
		String razaoSocial = "Projeto final";
		when(docDao.buscarPorRazaoSocial(razaoSocial)).thenReturn(resultDocEsperado);

		// Testar
		resultDoc = docService.buscarPorEmpresa(razaoSocial);

		// Verificar
		verify(docDao).buscarPorRazaoSocial(razaoSocial);
		assertEquals(resultDocEsperado, resultDoc);
	}

	@Test
	public void testPesquisaDocumentoEmpresa() {
		// Preparar
		prepararResultadosDoc();
		String pesquisaDocumento = "projeto final";
		when(docDao.pesquisaDocumentoEmpresa(pesquisaDocumento)).thenReturn(resultDocEsperado);

		// Testar
		resultDoc = docService.pesquisaDocumentoEmpresa(pesquisaDocumento);

		// Verificar
		verify(docDao).pesquisaDocumentoEmpresa(pesquisaDocumento);
		assertEquals(resultDocEsperado, resultDoc);
	}

	@Test
	public void testBuscarDocumentosPorEmpresa() {
		// Preparar
		prepararResultadosDoc();
		Empresa empresa = mock(Empresa.class);
		when(docDao.buscarDocumentosPorEmpresa(empresa)).thenReturn(resultDocEsperado);

		// Testar
		resultDoc = docService.buscarDocumentosPorEmpresa(empresa);

		// Verificar
		verify(docDao).buscarDocumentosPorEmpresa(empresa);
		assertEquals(resultDocEsperado, resultDoc);
	}

	@Test
	public void testCategoriaCerneByDocumento() {
		// Preparar
		List<TipoCategoriaCerne> listCategoria = new ArrayList<TipoCategoriaCerne>();
		when(docDao.categoriaCerneByDocumento(doc)).thenReturn(listCategoria);

		// Testar
		docService.categoriaCerneByDocumento(doc);

		// Verificar
		verify(docDao).categoriaCerneByDocumento(doc);
	}

}
