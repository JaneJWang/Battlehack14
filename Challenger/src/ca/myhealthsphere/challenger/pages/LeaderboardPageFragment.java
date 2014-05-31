package ca.myhealthsphere.challenger.pages;

import ca.myhealthsphere.challenger.R;
import ca.myhealthsphere.challenger.R.layout;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LeaderboardPageFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//Created a view for Leaderboard page
		View rootView = inflater.inflate(R.layout.fragment_leaderboard_page, container, false);
		// TODO Create a Leaderboard with user score
		
		return rootView;
	}
	
	
	
}
