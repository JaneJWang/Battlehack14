package ca.myhealthsphere.challenger;

import ca.myhealthsphere.challenger.pages.ChallengeListPageFragment;
import ca.myhealthsphere.challenger.pages.LeaderboardPageFragment;
import ca.myhealthsphere.challenger.pages.ProfilePageFragment;
import ca.myhealthsphere.challenger.pages.RewardsPageFragment;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ChallengerHomeActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
	
	private static final String TAG = "ChallengerHomeActivity";
	
	public static final int CHALLENGE_LIST_NAV_ID = 0;
	public static final int LEADERBOARD_NAV_ID = 1;
	public static final int REWARDS_NAV_ID = 2;
	public static final int PROFILE_NAV_ID = 3;
	public static final int TIMER_NAV_ID = 4;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	//Restore saved state of activity challenges
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenger_home);
        
        Parse.initialize(this, "KbeCbnYbyTjdsjlTXpI6wbsA8GcGHQ23gcR2cevo", "GLEgvH3bM1yoI2svHsx32801Zmdfdu2Ir1WTWuTa");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment newFragment = null;
        switch (position) {
	        case CHALLENGE_LIST_NAV_ID:
	        	newFragment = new ChallengeListPageFragment();
	        	break;
	        case LEADERBOARD_NAV_ID:
	        	newFragment = new LeaderboardPageFragment();
	        	break;
	        case REWARDS_NAV_ID:
	        	newFragment = new RewardsPageFragment();
	        	break;
	        case PROFILE_NAV_ID:
	        	newFragment = new ProfilePageFragment();
	        	break;
	        case TIMER_NAV_ID:
	        	newFragment = new ActiveChallengeTimerFragment();
	        	break;
        }
        if (newFragment != null) {
	        transaction.replace(R.id.container, newFragment);
	        transaction.addToBackStack(null);
	        transaction.commit();
        } else {
        	Log.d(TAG, "Page Not Found");
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case CHALLENGE_LIST_NAV_ID:
                mTitle = getString(R.string.title_challenge_list);
                break;
            case LEADERBOARD_NAV_ID:
                mTitle = getString(R.string.title_leaderboard);
                break;
            case REWARDS_NAV_ID:
                mTitle = getString(R.string.title_rewards);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.challenge_list, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
