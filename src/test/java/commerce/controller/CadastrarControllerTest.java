package commerce.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.commerce.controller.ProdutosController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.commerce.controller.CadastrarController;
import br.com.commerce.dao.UsuarioDAO;
import br.com.commerce.model.Usuario;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CadastrarControllerTest {
	@InjectMocks
	private CadastrarController controller;

	@Mock
	private CadastrarController controllerMockada;
	
	@Mock
	private UsuarioDAO usuarioDao;

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock
	private HttpSession session;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Result result;
	
	@Mock 
	Validator validator ;

	@Mock
	private SimpleMessage simpleMessage;

	@Mock
	private ProdutosController produtosController;
	
	private Usuario usuario = new Usuario();

	@Before
	public void createMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveDarSucesso() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		when(validator.onErrorRedirectTo(controller)).thenReturn(controllerMockada);
		when(result.redirectTo(ProdutosController.class)).thenReturn(produtosController);
		usuario.setSenha("123456");
		controller.salvaUsuario(usuario, "123456");
		verify(session, times(1)).setAttribute(any(),any());
	}
}
