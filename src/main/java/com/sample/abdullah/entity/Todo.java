package com.sample.abdullah.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Todo")
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	private boolean status;
	private String todoWork;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTodoWork() {
		return todoWork;
	}

	public void setTodoWork(String todoWork) {
		this.todoWork = todoWork;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", status=" + status + ", todoWork=" + todoWork + "]";
	}

}
