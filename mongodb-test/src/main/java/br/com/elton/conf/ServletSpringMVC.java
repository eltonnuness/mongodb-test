package br.com.elton.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * Classe responsável por configurar a Servlet do Spring.
 *
 * @author Elton
 * @since 05/02/2016 - 12:25:59
 * @version 1.0
 */
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppWebConfiguration.class, MongoDbConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{};
		
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
