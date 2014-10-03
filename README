Spring security sample
======================

This is an example of a spring security project for academic purposes.

This example showcases very basic spring security features and uses XML config. A java-based config example may follow some day.

See the pom.xml to make sure you are using similar versions.

How to run
==========

Run maven goal jetty:run. On the command line : `mvn jetty:run`

Navigate to http://localhost:8080 unless you changed the port. 

How to use
==========

The pages include a menu illustrating a few cases : 

 * Home page is accessible to anyone
 * _/admin/**_ is for admin only
 * Everything else is user-only (requires login).
 * Obviously the access denied page is accessible to everyone

The rules are defined in _src/main/webapp/WEB-INF/spring/security-context.xml_, which is loaded in the root context.

Users
=====

Users are defined in the in-memory repository and autowired in security-context.xml.

 * user/user is a normal user
 * admin/admin has a role of ADMIN

Configuration
=============

See the web.xml and security-context.xml files and look for the comments. In the web.xml file, comments relating to spring security begin with SEC.

View taglib
===========

See mainly the _header.jsp view for a few examples of how to use the spring security taglib.

Limitations
===========

This example does not include a custom login form. It might in the futur. Configure it using the &lt;form-login&gt; tag in security-context.xml and see the docs.

It's not possible to use the remember-me option when using a simple authenticationProvider. Create and use a UserDetailsService if you need it. There might be an example of this too in the future.

Why XML? Because it allows me to introduce spring without explaining java config, beans, contexts and DI up front, since this is for a course. Java-based config is now prefered in most cases, but the translation should be pain-free. For the purposes of the course, config should be minimal and XML is OK.

No tests included to focus on spring-security. You should check out [spring-test](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/testing.html). [Spring security](http://projects.spring.io/spring-security) also comes with [many samples](https://github.com/spring-projects/spring-security/blob/master/samples/insecuremvc/pom.xml) which have many tests.
