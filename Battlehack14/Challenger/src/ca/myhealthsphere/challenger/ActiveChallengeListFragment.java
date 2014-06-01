package ca.myhealthsphere.challenger;

import java.util.List;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import ca.myhealthsphere.model.Challenge;

public class ActiveChallengeListFragment extends ListFragment {

	private List<Challenge> mChallenges;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		mChallenges = Configuration.CHALLENGE_SERVICE.getAcceptedChallenges(null);
	
		ArrayAdapter<Challenge> adapter = new ChallengeArrayAdapter(getActivity(), mChallenges);
		setListAdapter(adapter);
	}


}
