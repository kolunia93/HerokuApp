package ua.entity.form;

import java.time.LocalDateTime;

public class FriendReqestForm {
	
	private String id;
	
	private String msg;
	
	private LocalDateTime date;
	
	private String input;
	
	private String output;
	
	private boolean cheack;

	
	public FriendReqestForm() {
		this.date=LocalDateTime.now();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public boolean isCheack() {
		return cheack;
	}

	public void setCheack(boolean cheack) {
		this.cheack = cheack;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
