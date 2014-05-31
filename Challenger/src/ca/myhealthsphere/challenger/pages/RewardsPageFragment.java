package ca.myhealthsphere.challenger.pages;

import ca.myhealthsphere.challenger.R;
import ca.myhealthsphere.challenger.R.layout;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RewardsPageFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//Created a link to an external web URL
		View rootView = inflater.inflate(R.layout.fragment_rewards, container, false);
		// TODO Link Rewards Site
		
		return rootView;
	}
	
}
