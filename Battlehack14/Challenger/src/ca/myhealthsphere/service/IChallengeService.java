package ca.myhealthsphere.service;

import java.util.Collection;
import java.util.List;

import android.content.Context;
import ca.myhealthsphere.model.Challenge;
import ca.myhealthsphere.model.User;

public interface IChallengeService {
	List<Challenge> getAcceptedChallenges(User user);
}
