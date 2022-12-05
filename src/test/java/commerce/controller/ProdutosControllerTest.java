package commerce.controller;

import br.com.caelum.vraptor.Result;
import br.com.commerce.controller.ProdutosController;
import br.com.commerce.dao.ProdutoDAO;
import br.com.commerce.model.Categoria;
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
public class ProdutosControllerTest {
    @InjectMocks
    ProdutosController controller;

    @Mock
    ProdutosController controllerMockada;

    @Mock
    Result result;

    @Mock
    ProdutoDAO produtoDao;

    @Mock
    DAO<Categoria> categoriaDao;


    @Test
    public void produtosSucesso(){
        controller.produtos(null);
        verify(result, times(1)).include("categorias", categoriaDao.selectAll());
        verify(result, times(1)).include("produtos", produtoDao.buscaTodosOsProdutosOrdenadoPeloNome());

    }

}
