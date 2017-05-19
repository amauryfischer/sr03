package beans;

public class scientist {
	private int id;
	private String name;
	private String domainIds;
	private String ideaIds;
	private String commentIds;
	private String pwd;
	
	public scientist(){}
	public scientist(int id, String name, String pwd ,String domainIds, String ideaIds, String commentIds ) {
		super();
		this.id = id;
		this.name = name;
		this.domainIds = domainIds;
		this.ideaIds = ideaIds;
		this.commentIds = commentIds;
		this.pwd = pwd;

	}
	
	
	public int getId(){
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getName(){
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDomainIds(){
		return this.domainIds;
	}
	public void setDomainIds(String domainIds) {
		this.domainIds = domainIds;
	}
	
	public String getIdeaIds(){
		return this.ideaIds;
	}
	public void setIdeaIds(String ideaIds) {
		this.ideaIds = ideaIds;
	}
	
	public String getCommentIds(){
		return this.commentIds;
	}
	public void setCommentIds(String commentIds) {
		this.commentIds = commentIds;
	}
		
	public String getPwd(){
		return this.pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
