package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn React", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn Microservices", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}

}
