package ca.ulaval.glo4003.spring_security_sample.domain;

import java.security.Principal;

public class Employee implements Principal {

	private String name;
	private String password;
	private EmployeeRole role;
	
	public Employee(String name, String password, EmployeeRole role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	public boolean isPasswordValid(String password) {
		return this.password.equals(password);
	}
	
	public String getRoleName() {
		return role.toString();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public boolean hasName(String name) {
		return this.name.equals(name);
	}

}
