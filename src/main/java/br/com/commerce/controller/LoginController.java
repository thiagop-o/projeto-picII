package br.com.commerce.controller;

import javax.inject.Inject;

import org.hibernate.annotations.ResultCheckStyle;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
@Path("login")
public class LoginController {
	
	@Get("")
	public void login() {
		
	}
}
