package cn.lihao;

public class Topic {
	private String id;
	private String titile;
	private String content;
	
	public Topic() {
		
	}
	
	public Topic(String id, String titile, String content) {
		this.id = id;
		this.titile = titile;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
