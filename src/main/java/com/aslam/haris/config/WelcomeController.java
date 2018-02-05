package com.aslam.haris.config;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aslam.haris.entity.Todo;
import com.aslam.haris.repository.TodoRepository;

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
    public String addTodo(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        ModelAndView model = new ModelAndView("welcome");
        model.addObject("todo", new Todo());
        model.addObject("todoList", getAllTodo());
        return "redirect:/";
    }

    @RequestMapping(value = "/completed", method = RequestMethod.POST)
    @ResponseBody
    public String markCompleted(@RequestBody int todoId) {
        Todo todo = todoRepository.findById(todoId);
        todo.setStatus(true);
        todoRepository.save(todo);
        return "success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody int todoId) {
        Todo todo = todoRepository.findById(todoId);
        todoRepository.delete(todo);
        return "success";
    }

    private List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

}