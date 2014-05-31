package ca.myhealthsphere.model;

import java.util.ArrayList;
import java.util.List;

public class User extends ModelObject {
	private String username;
	private UserGroup group;
	private int acceptedChallengeCount;
	private List<Challenge> acceptedChallenges;
	private List<Challenge> availableChallenges;
	
	public User(String username, UserGroup group) {
		this.username = username;
		this.group = group;
		this.acceptedChallengeCount = 0;
		this.acceptedChallenges = new ArrayList<Challenge>();
		this.availableChallenges = new ArrayList<Challenge>();
	}
	
	public boolean acceptChallenge(Challenge challenge) {
		if (!availableChallenges.contains(challenge)) {
			return false;
		}
		availableChallenges.remove(challenge);
		acceptedChallenges.add(challenge);
		acceptedChallengeCount++;
		return true;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserGroup getGroup() {
		return group;
	}
	public void setGroup(UserGroup group) {
		this.group = group;
	}
	public int getAcceptedChallengeCount() {
		return acceptedChallengeCount;
	}
	public List<Challenge> getAcceptedChallenges() {
		return acceptedChallenges;
	}
	public List<Challenge> getAvailableChallenges() {
		return availableChallenges;
	}
	public void addAvailableChallenge(Challenge challenge) {
		this.availableChallenges.add(challenge);
	}
}
