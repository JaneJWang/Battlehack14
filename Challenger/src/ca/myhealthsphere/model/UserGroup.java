package ca.myhealthsphere.model;

public class UserGroup extends ModelObject {
	private String name;
	
	public UserGroup(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
