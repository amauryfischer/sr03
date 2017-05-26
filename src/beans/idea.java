package beans;
import java.io.Serializable;

public class idea {
	private int id;
	private String title;
	private String content;
	private String created_at;
	private String comment_ids;
	private int scientist_id;
	private String domain_ids;
	
	
	public idea(){}
	// constructur seems to be needed
	public idea(int id, String title, String content, String created_at, String comment_ids, int scientist_id, String domain_ids ) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.comment_ids = comment_ids;
		this.scientist_id = scientist_id;
		this.domain_ids = domain_ids;
	}
	
	public int getId(){
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	
	
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content=content;
	}
	
	
	public String getCreatedAt(){
		return this.created_at;
	}
	public void setCreatedAt(String createdAt){
		this.created_at=createdAt;
	}
	
	public String getCommentIds(){
		return this.comment_ids;
	}
	public void setCommentIds(String CommentIds){
		this.comment_ids=CommentIds;
	}
	
	public int getScientistId(){
		return this.scientist_id;
	}
	public void setScientistId(int ScientistId){
		this.scientist_id=ScientistId;
	}
	
	public String getDomainIds(){
		return this.domain_ids;
	}
	public void setDomainIds(String domainIds){
		this.domain_ids=domainIds;
	}
}
