package com.sample.abdullah.config;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sample.abdullah.entity.Todo;
import com.sample.abdullah.repository.TodoRepository;

@Controller
public class WelcomeController {

	private static final Logger LOG = Logger.getLogger(WelcomeController.class);
	private TodoRepository todoRepository;

	@Autowired
	public WelcomeController(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@RequestMapping("/")
	public ModelAndView welcome() {
		Todo todo = new Todo();
		LOG.info("Home page accessed.");
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("todo", todo);
		model.addObject("todoList", getAllTodo());
		return model;
	}

	@RequestMapping(value = "/addTodo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addTodo(@RequestBody Todo toDoItem) {
		todoRepository.save(toDoItem);
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("todo", new Todo());
		model.addObject("todoList", getAllTodo());
		return ResponseEntity.ok().body("success");
	}

	@RequestMapping(value = "/completed", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> markCompleted(@RequestBody int todoId) {
		Todo todo = todoRepository.findById(todoId);
		todo.setStatus(true);
		todoRepository.save(todo);
		return ResponseEntity.ok().body("success");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> delete(@RequestBody int todoId) {
		Todo todo = todoRepository.findById(todoId);
		todoRepository.delete(todo);
		return ResponseEntity.ok().body("success");
	}

	private List<Todo> getAllTodo() {
		List<Todo> todos = todoRepository.findAll();
		System.out.println(todos);
		return todos;
	}

}