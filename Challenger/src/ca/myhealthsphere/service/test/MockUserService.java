package ca.myhealthsphere.service.test;

import ca.myhealthsphere.model.User;
import ca.myhealthsphere.model.UserGroup;
import ca.myhealthsphere.service.IUserService;

public class MockUserService implements IUserService {

	static final UserGroup MHS = new UserGroup("myHealthSphere");
	
	@Override
	public User getCurrentUser() {
		return new User("Jane", MHS);
	}
	
}
