package br.com.elton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.elton.models.Customer;
import br.com.elton.utils.TwitterConfiguration;

/**
 * 
 * Classe baseada nos exemplos do site Mkyong
 * http://www.mkyong.com/mongodb/spring-data-mongodb-hello-world-example/
 *
 * @author Elton
 * @since 16/02/2016
 * @version 1.0
 */

@Controller
public class HomeController {

	@Autowired
	MongoOperations mongoOperation;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	@ResponseBody
	public String home(){
		
		Customer customer = new Customer("elton", "nunes");
		TwitterConfiguration c = new TwitterConfiguration();
		c.config();
		mongoOperation.insert(customer);
		
		return "<html>Insert in Mongo DB</html>";
	}
	
}
