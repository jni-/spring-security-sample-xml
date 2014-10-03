package ca.ulaval.glo4003.spring_security_sample.web.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ca.ulaval.glo4003.spring_security_sample.domain.Employee;
import ca.ulaval.glo4003.spring_security_sample.domain.EmployeeNotFoundException;
import ca.ulaval.glo4003.spring_security_sample.domain.UserRepository;

public class EmployeeAuthenticationProvider implements AuthenticationProvider {

	private UserRepository repository;

	@Inject
	public EmployeeAuthenticationProvider(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		try {
			Employee employee = repository.findEmployeeByName(name);
			return validateUserPassword(employee, password);
		} catch (EmployeeNotFoundException e) {
			return null; // Return null means login failed.
		}
	}

	private Authentication validateUserPassword(Employee employee, String password) {
		if (employee.isPasswordValid(password)) {
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(employee.getRoleName()));
			return new UsernamePasswordAuthenticationToken(employee, password, roles);
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authenticationClass) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationClass));
	}

}
