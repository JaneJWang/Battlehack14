package ca.myhealthsphere.challenger;

import ca.myhealthsphere.model.Challenge;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChallengeItemView extends RelativeLayout {

    private static final String TAG = "ChallengeItemView";
    
    private LayoutInflater mInflater;
    private Challenge mChallenge;
    private View mItemView;
    
    public ChallengeItemView(Context context, Challenge challenge) {
        super(context);
        
        mChallenge = challenge;
        
        Log.d(TAG, challenge.getTitle() + "/" + challenge.getDescription());
        
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        initView();
        
    }
    
    private void initView() {
        
        if (mInflater != null) {
            mItemView = inflate(getContext(), R.layout.fragment_challenge_item, null);
            addView(mItemView);
            setViewTextFromChallenge(mChallenge);
        }
        
    }
    
    private void setViewTextFromChallenge(Challenge challenge) {
        
        TextView title = (TextView) mItemView.findViewById(R.id.challenge_item_title);
        title.setText(challenge.getTitle());
        
        TextView description = (TextView) mItemView.findViewById(R.id.challenge_item_description);
        description.setText(challenge.getDescription());
        
    }
    
}
