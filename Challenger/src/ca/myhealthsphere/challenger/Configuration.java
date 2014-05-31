package ca.myhealthsphere.challenger;

import ca.myhealthsphere.service.IChallengeService;
import ca.myhealthsphere.service.IUserService;
import ca.myhealthsphere.service.test.MockChallengeService;
import ca.myhealthsphere.service.test.MockUserService;

public class Configuration {
	public static final IChallengeService CHALLENGE_SERVICE;
	public static final IUserService USER_SERVICE;

	static {
		CHALLENGE_SERVICE = new MockChallengeService();
		USER_SERVICE = new MockUserService();
	}
}
