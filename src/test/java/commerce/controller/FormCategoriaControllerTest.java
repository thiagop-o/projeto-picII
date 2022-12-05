package commerce.controller;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.commerce.controller.CategoriasController;
import br.com.commerce.controller.FormCategoriaController;
import br.com.commerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FormCategoriaControllerTest {
    @InjectMocks
    FormCategoriaController controller;

    @Mock
    Validator validator;

    @Mock
    DAO<Categoria> categoriaDao;

    @Mock
    FormCategoriaController controllerMockada;

    @Mock
    CategoriasController categoriasController;

    @Mock
    Result result;

    @Test
    public void formCategoriaSucesso(){
        Categoria categoria = new Categoria();
        categoria.setNome("teste");
        categoria.setId(1);
        controller.formcategoria(categoria);
        verify(result, times(1)).include(any(), any());

    }

    @Test
    public void salvarCategoraSucesso(){
        when(validator.onErrorRedirectTo(controller)).thenReturn(controllerMockada);
        when(result.redirectTo(CategoriasController.class)).thenReturn(categoriasController);
        Categoria categoria = new Categoria();
        categoria.setNome("teste");
        categoria.setId(1);
        controller.salvaCategoria(categoria);
        verify(categoriaDao, times(1)).insertOrUpdate(any());
        verify(result, times(1)).redirectTo(CategoriasController.class);


    }
}
