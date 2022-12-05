package commerce.controller;

import br.com.caelum.vraptor.Result;
import br.com.commerce.controller.LoginController;
import br.com.commerce.controller.LogoutController;
import br.com.commerce.controller.ProdutosController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LogoutControllerTest {
    @InjectMocks
    LogoutController controller;

    @Mock
    LogoutController controllerMockada;

    @Mock
    HttpSession session;

    @Mock
    Result result;

    @Mock
    LoginController loginController;

    @Test
    public void deslogarSucesso(){
        when(result.redirectTo(LoginController.class)).thenReturn(loginController);
        controller.logout();

        verify(session, times(1)).removeAttribute(any());
        verify(result, times(1)).redirectTo(LoginController.class);
    }
}
