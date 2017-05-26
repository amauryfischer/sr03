package beans;

public class scientist {
	private int id;
	private String name;
	private String pwd;
	private String idea_ids;
	private String domain_ids;
	private String comment_ids;
	
	public scientist(int id, String name, String pwd, String idea_ids, String domain_ids, String comment_ids) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.idea_ids = idea_ids;
		this.domain_ids = domain_ids;
		this.comment_ids = comment_ids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIdea_ids() {
		return idea_ids;
	}

	public void setIdea_ids(String idea_ids) {
		this.idea_ids = idea_ids;
	}

	public String getDomain_ids() {
		return domain_ids;
	}

	public void setDomain_ids(String domain_ids) {
		this.domain_ids = domain_ids;
	}

	public String getComment_ids() {
		return comment_ids;
	}

	public void setComment_ids(String comment_ids) {
		this.comment_ids = comment_ids;
	}
	
}
