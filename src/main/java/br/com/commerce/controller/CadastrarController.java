package br.com.commerce.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.commerce.model.Usuario;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("cadastrar")
public class CadastrarController {
	
	@Inject
	EntityManager em;
	
	@Inject
	Result result;
	
	@Inject
	DAO<Usuario> usuarioDAO;
	
	@Get("")
	public void cadastrar() {
		
	}
	
	@Post("salvaUsuario")
	public void salvaUsuario(Usuario usuario) {
		usuarioDAO.insert(usuario);
		em.persist(usuario);
		result.redirectTo(ProdutosController.class).produtos();
	}
}
