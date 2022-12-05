package commerce.controller;

import br.com.caelum.vraptor.Result;
import br.com.commerce.controller.CategoriasController;
import br.com.commerce.controller.DeletaCategoriaController;
import br.com.commerce.controller.ProdutosController;
import br.com.commerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeletaCategoriaControllerTest {
    @InjectMocks
    DeletaCategoriaController controller;

    @Mock
    DAO<Categoria> categoriaDao;

    @Mock
    CategoriasController categoriasController;

    @Mock
    Result result;

    @Test
    public void deveDarSucesso(){
        when(result.redirectTo(CategoriasController.class)).thenReturn(categoriasController);
        Categoria categoria = new Categoria();
        categoria.setNome("Bolsa");
        controller.deletacategoria(categoria);
        verify(categoriaDao, times(1)).delete(any());
    }
}
