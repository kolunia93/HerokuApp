package ua.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="friendreqest")
public class FriendReqest extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 6587796009657913990L;

	private String msg;
	
	private LocalDateTime date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="inputuser_id")
	private User input;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="outputuser_id")
	private User output;
	
	private boolean cheack;

	public FriendReqest() {
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

	public User getInput() {
		return input;
	}

	public void setInput(User input) {
		this.input = input;
	}

	public User getOutput() {
		return output;
	}

	public void setOutput(User output) {
		this.output = output;
	}

	public boolean isCheack() {
		return cheack;
	}

	public void setCheack(boolean cheack) {
		this.cheack = cheack;
	}
		
}
