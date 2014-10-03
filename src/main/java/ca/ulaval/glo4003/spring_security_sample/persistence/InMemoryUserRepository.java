package ca.ulaval.glo4003.spring_security_sample.persistence;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.spring_security_sample.domain.Employee;
import ca.ulaval.glo4003.spring_security_sample.domain.EmployeeNotFoundException;
import ca.ulaval.glo4003.spring_security_sample.domain.EmployeeRole;
import ca.ulaval.glo4003.spring_security_sample.domain.UserRepository;

public class InMemoryUserRepository implements UserRepository {

	public List<Employee> employees = new ArrayList<>();
	
	public InMemoryUserRepository() {
		employees.add(new Employee("user", "user", EmployeeRole.USER));
		employees.add(new Employee("admin", "admin", EmployeeRole.ADMIN));
	}
	

	@Override
	public Employee findEmployeeByName(String name) {
		for (Employee employee : employees) {
			if(employee.hasName(name)) {
				return employee;
			}
		}
		
		throw new EmployeeNotFoundException();
	}


}
