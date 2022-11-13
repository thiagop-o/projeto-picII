package br.com.commerce.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.commerce.model.Usuario;

@Controller
@Path("cadastrar")
public class CadastrarController {
	
	@Get("")
	public void cadastrar() {
		
	}
	
	@Post("salvaUsuario")
	public void salvaUsuario(Usuario usuario) {
		System.out.printf("\n\n\n\n");
		System.out.println(usuario.getNome());
	}
}
