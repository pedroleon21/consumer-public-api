package br.com.linux4.service;

import br.com.linux4.exception.NotValidUserException;
import br.com.linux4.form.AuthForm;

public class AuthService {

	
	static private final String login = "4linux";
	static private final String password = "4linux";

	public String authenticate(AuthForm form) {
		if(form.getLogin().compareTo(login) != 0 || form.getPassword().compareTo(password) != 0)
			throw new NotValidUserException("Login or password not valid");
		return "asdasdasdasljdnaljdlajlaslasldjasldj";
	}

}
