package commerce.controller;

import br.com.caelum.vraptor.Result;
import br.com.commerce.controller.CategoriasController;
import br.com.commerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoriasControllerTest {
    @InjectMocks
    CategoriasController categoriasController;

    @Mock
    HttpSession session;
    @Mock
    Result result;
    @Mock
    DAO<Categoria> categoriaDao;

    @Test
    public void deveDarSucesso(){
        categoriasController.categorias();
        verify(result, times(1)).include(any(),any());
    }
}
