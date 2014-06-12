package ca.myhealthsphere.challenger;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import ca.myhealthsphere.model.Challenge;

public class ChallengeArrayAdapter extends ArrayAdapter<Challenge> {

	public ChallengeArrayAdapter(Context context, List<Challenge> challenges) {
		super(context, R.layout.fragment_challenge_item, challenges);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ChallengeItemView challView = new ChallengeItemView(getContext(), getItem(position));
				
		return challView;
	}

}
