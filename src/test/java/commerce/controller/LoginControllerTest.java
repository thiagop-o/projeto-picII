package commerce.controller;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.commerce.controller.LoginController;
import br.com.commerce.controller.ProdutosController;
import br.com.commerce.dao.UsuarioDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @InjectMocks
    LoginController controller;

    @Mock
    LoginController controllerMockada;

    @Mock
    Result result;
    @Mock
    Validator validator;
    @Mock
    UsuarioDAO usuarioDao;

    @Mock
    HttpSession session;

    @Mock
    ProdutosController produtosController;

    @Test
    public void autenticarSucesso(){
        when(validator.onErrorRedirectTo(controller)).thenReturn(controllerMockada);
        when(result.redirectTo(ProdutosController.class)).thenReturn(produtosController);
        controller.autenticar("email@teste", "senhaTeste");

        verify(session, times(1)).setAttribute(any(), any());
        verify(result, times(1)).redirectTo(ProdutosController.class);

    }
}
