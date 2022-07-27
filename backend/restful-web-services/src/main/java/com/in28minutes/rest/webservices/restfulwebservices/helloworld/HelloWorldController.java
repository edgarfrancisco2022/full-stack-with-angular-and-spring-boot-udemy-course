package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	//@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("Some error has happened! Contact support at ***-***");
		return new HelloWorldBean("Hello World - Changed");
	}
	
	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	/*
	 * Retrieve all Todos for a user
	 * GET /users/{user_name}/todos
	 * 
	 * Delete a Todo for a user
	 * DELETE /users/{user_name}/todos/{todo_id}
	 * 
	 * Edit/Update a Todo
	 * PUT /users/{user_name}/todos/{todo_id}
	 * 
	 * Create a new Todo
	 * POST /users/{user_name}/todos
	 */

}
