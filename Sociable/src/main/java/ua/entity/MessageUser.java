//package ua.entity;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class MessageUser extends AbstractEntity implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	private String text;
//	
//	private LocalDateTime date;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="inputuser_id")
//	private User input;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="outputuser_id")
//	private User output;
//
//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}
//
//	public LocalDateTime getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}
//
//	public User getInput() {
//		return input;
//	}
//
//	public void setInput(User input) {
//		this.input = input;
//	}
//
//	public User getOutput() {
//		return output;
//	}
//
//	public void setOutput(User output) {
//		this.output = output;
//	}
//	
//	
//}
