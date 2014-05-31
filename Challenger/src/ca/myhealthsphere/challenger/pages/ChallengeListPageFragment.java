package ca.myhealthsphere.challenger.pages;

import ca.myhealthsphere.challenger.R;
import ca.myhealthsphere.challenger.R.id;
import ca.myhealthsphere.challenger.R.layout;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ChallengeListPageFragment extends Fragment {

	private Button mAddChallengesButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		// Bind to layout from layout/fragment_challenge_list.xml
		View rootView = inflater.inflate(R.layout.fragment_challenge_list_page, container, false);
		
		// Hook up add challenges button
		mAddChallengesButton = (Button)rootView.findViewById(R.id.add_challenges);
	    mAddChallengesButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(ChallengeListPageFragment.this.getActivity(), "Adding...", Toast.LENGTH_SHORT);
				toast.show();
				// TODO go to new challenges to allow users to add new challenges		
			}
		});
	    
		return rootView;		
	}
}
