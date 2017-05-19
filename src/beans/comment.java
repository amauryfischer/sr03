package beans;
import java.io.Serializable;

public class comment {
	private int id;
	private String date;
	private int scientist_id;
	private int idea_id;
	private String content;
	
	
	public comment(){}
	
	public int getId(){
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date=date;
	}
	
	
	public int getScientistId(){
		return this.scientist_id;
	}
	public void setScientistId(int scientist_id){
		this.scientist_id=scientist_id;
	}
	
	public int getIdeaId(){
		return this.idea_id;
	}
	public void setIdeaId(int idea_id){
		this.idea_id=idea_id;
	}
	
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content=content;
	}
}
