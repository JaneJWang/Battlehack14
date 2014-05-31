package ca.myhealthsphere.service.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.myhealthsphere.model.Challenge;
import ca.myhealthsphere.model.ChallengeCategory;
import ca.myhealthsphere.model.User;
import ca.myhealthsphere.service.IChallengeService;

public class MockChallengeService implements IChallengeService {
	static final ChallengeCategory WATER = new ChallengeCategory("Water");
	static final ChallengeCategory AEROBICS = new ChallengeCategory("Aerobics");
	
	@Override
	public List<Challenge> getAcceptedChallenges(User user) {
		List<Challenge> challenges = new ArrayList<Challenge>();
		challenges.add(new Challenge("Drink a glass of water", WATER, "Drinking water increase protein synthesis so you will make better use of the protein you ingest. Water is also a good way to stay hydrated without adding all the sugary drinks like soda and tea. If you sweat a lot during your workout you definitely should be striving for more than a gallon per day. Water also keeps your metabolism up due to the oxygen content in the water. An easy way to track your water intake is to carry around a gallon jug wherever you go. "));
		challenges.add(new Challenge("Drink 8 Glasses of Water Today", WATER, "We all know that staying hydrated is important. Let's try to maintain that habit of drinking water instead of pop or juices."));
		challenges.add(new Challenge("Post-meal Walk", AEROBICS, "After dinner (especially if it’s a big feast), resist the urge to sit down or take a nap. Going for a quick walk, as short as 15 minutes, after eating can help with digestion and improve blood sugar levels."));
		return challenges;
	}
}
