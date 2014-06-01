package ca.myhealthsphere.service.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.myhealthsphere.model.Challenge;
import ca.myhealthsphere.model.ChallengeCategory;
import ca.myhealthsphere.model.User;
import ca.myhealthsphere.service.IChallengeService;

public class MockChallengeService implements IChallengeService {
	/*static final ChallengeCategory RELAXATION = new ChallengeCategory ("Relaxation";
	 * /
	 */
	static final ChallengeCategory WATER = new ChallengeCategory("Water");
	static final ChallengeCategory AEROBICS = new ChallengeCategory("Office Aerobics");
	
	@Override
	public List<Challenge> getAcceptedChallenges(User user) {
		List<Challenge> challenges = new ArrayList<Challenge>();
		challenges.add(new Challenge("30 Seconds of Body Twists ", AEROBICS, "Hold your phone in your hand with your arms outstretched parallel to the floor, complete 10 body twists in 30 seconds."));
		challenges.add(new Challenge("Drink 8 Glasses of Water Today", WATER, "We all know that staying hydrated is important. Let's try to maintain that habit of drinking water instead of pop or juices."));
		challenges.add(new Challenge("Post-meal Walk", AEROBICS, "After dinner (especially if it’s a big feast), resist the urge to sit down or take a nap. Going for a quick walk, as short as 15 minutes, after eating can help with digestion and improve blood sugar levels."));
		return challenges;
	}
}
