package br.com.commerce.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.commerce.interceptors.SomenteLogado;

@Controller
@Path("formproduto")
public class FormProdutoController {
	
	@Get("")
	@SomenteLogado
	public void formproduto() {
		
	}
}
