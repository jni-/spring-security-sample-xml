package ca.ulaval.glo4003.spring_security_sample.domain;


public interface UserRepository {

	public abstract Employee findEmployeeByName(String name);

}