package commerce.controller;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.commerce.controller.CategoriasController;
import br.com.commerce.controller.FormProdutoController;
import br.com.commerce.controller.ProdutosController;
import br.com.commerce.dao.ProdutoDAO;
import br.com.commerce.model.Categoria;
import br.com.commerce.model.Produto;
import br.com.olimposistema.aipa.dao.DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FormProdutoControllerTest {
    @InjectMocks
    FormProdutoController controller;

    @Mock
    FormProdutoController controllerMockada;

    @Mock
    Validator validator;

    @Mock
    ProdutoDAO produtoDao;

    @Mock
    DAO<Categoria> categoriaDao;

    @Mock
    ProdutosController produtosController;

    @Mock
    Result result;

    @Test
    public void formprodutoSucesso(){
        controller.formproduto();
        verify(result, times(1)).include(any(), any());
    }

    @Test
    public void salvaProdutoSucesso(){
        when(validator.onErrorRedirectTo(controller)).thenReturn(controllerMockada);
        when(result.redirectTo(ProdutosController.class)).thenReturn(produtosController);
        Produto produto = new Produto();
        produto.setNome("teste");
        controller.salvaProduto(produto);
        verify(produtoDao, times(1)).insertOrUpdate(any());
        verify(result, times(1)).redirectTo(ProdutosController.class);
    }
}
