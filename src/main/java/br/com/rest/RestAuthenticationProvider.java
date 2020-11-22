package br.com.rest;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {
	
	@Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        try {
        	// subsituir o if por algum servico de validacao de usuario @autowired
        	if("user".equals(userName) && "password".equals(password)) {
        		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password, new ArrayList<>());
            	token.setDetails(password);
            	return token;	
        	}else {
        		throw new BadCredentialsException("usuario ou senha invalido");
        	}
        	
		} catch (Exception e) {
			throw new BadCredentialsException(e.getMessage());
		}
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}