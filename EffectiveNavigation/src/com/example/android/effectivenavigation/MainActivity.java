
package com.example.android.effectivenavigation;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import android.util.Log;

import android.widget.TextView;

import com.example.android.effectivenavigation.R;

import java.util.ArrayList;
import java.util.List;

import com.example.android.effectivenavigation.models.Challenge;
import com.example.android.effectivenavigation.models.Challenger;

import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalFuturePaymentActivity;
import com.paypal.android.sdk.payments.PayPalItem;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import android.net.Uri;

import java.math.BigDecimal;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
//        final ActionBar actionBar = getActionBar();

        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
//        actionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
//        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                // When swiping between different app sections, select the corresponding tab.
//                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
//                // Tab.
//                actionBar.setSelectedNavigationItem(position);
//            }
//        });

        // For each of the sections in the app, add a tab to the action bar.
//        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
//            // Create a tab with text corresponding to the page title defined by the adapter.
//            // Also specify this Activity object, which implements the TabListener interface, as the
//            // listener for when this tab is selected.
//            actionBar.addTab(
//                    actionBar.newTab()
//                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
//                            .setTabListener(this));
//        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    private final static List <Challenge> mockChallenges_ = createMockedChallenges ();

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
//            switch (i) {
//                case 0:
//                    // The first section of the app is the most interesting -- it offers
//                    // a launchpad into the other demonstrations in this example application.
//                    return new LaunchpadSectionFragment();

//                default:
                    // The other sections of the app are dummy placeholders.
                    Fragment fragment = new DummySectionFragment();
                    Bundle args = new Bundle();

                    Log.v ( "ARG_SECTION_NUMBER is", DummySectionFragment.ARG_SECTION_NUMBER );
                    Log.v ( "i is: ", Integer.toString (i) );
                    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
                    fragment.setArguments(args);
                    return fragment;
//            }
        }



        @Override
        public int getCount() {
            return mockChallenges_.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section " + (position + 1);
        }
    }

    /**
     * A fragment that launches other parts of the demo application.
     */
    public static class LaunchpadSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_launchpad, container, false);

            // Demonstration of a collection-browsing activity.
            rootView.findViewById(R.id.demo_collection_button)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), CollectionDemoActivity.class);
                            startActivity(intent);
                        }
                    });

            // Demonstration of navigating to external activities.
            rootView.findViewById(R.id.demo_external_activity)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Create an intent that asks the user to pick a photo, but using
                            // FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET, ensures that relaunching
                            // the application from the device home screen does not return
                            // to the external activity.
                            Intent externalActivityIntent = new Intent(Intent.ACTION_PICK);
                            externalActivityIntent.setType("image/*");
                            externalActivityIntent.addFlags(
                                    Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            startActivity(externalActivityIntent);
                        }
                    });

            return rootView;
        }
    }

    private PayPalPayment getThingToBuy(String paymentIntent) {
        return new PayPalPayment(new BigDecimal("0.40"), "USD", "40 Challenger Points",
                paymentIntent);
    }
    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_NO_NETWORK;

    // note that these credentials will differ between live & sandbox environments.
    private static final String CONFIG_CLIENT_ID = "AbzdmRConLOQcTA6DCAnP4RwlxfTnLhJjaB6i0zQ_KGqk1OKREwKz_Fm9f2L";

    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID)
                    // The following are only used in PayPalFuturePaymentActivity.
            .merchantName("myHealthSphere Challenger")
            .merchantPrivacyPolicyUri(Uri.parse("https://www.example.com/privacy"))
            .merchantUserAgreementUri(Uri.parse("https://www.example.com/legal"));
    private static final int REQUEST_CODE_PAYMENT = 1;
    public void onMeImagePressed ( final View sourceView )
    {
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);

        PayPalPayment thingToBuy = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent2 = new Intent(this, PaymentActivity.class);

        intent2.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);

        startActivityForResult(intent2, REQUEST_CODE_PAYMENT);

    }
    public void onChallengerImagePressed ( final View sourceView ) {

        View rootView = getLayoutInflater().inflate( R.layout.fragment_section_dummy, null );
        Log.v ( "onChallengerImagePressed", "rootView is null? " + (null == rootView));
        ((TextView) rootView.findViewById(R.id.challenge_item_description)).setVisibility( View.GONE );
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED)
        {
            Toast.makeText( this, "Error with Paypal", Toast.LENGTH_SHORT).show();
        }
        else
        {
            View rootView = getLayoutInflater().inflate( R.layout.fragment_section_dummy, null );
            ((TextView) rootView.findViewById(R.id.challenge_item_description)).setVisibility( View.GONE );
        }
    }

    private static List <Challenge> createMockedChallenges() {

//        final String [][] mockData = { {"30 Seconds of Body Twists", "Hold your phone in your hand with your arms outstretched parallel", "Jane"},
//                {"Drink 8 Glasses of Water Today", "We all know that staying hydrated is important.", "Joe"},
//                {"Post-meal Walk", "After dinner (especially if it's a big feast), resist the urge", "Jack"} };
        final String [][] mockData = { {"30 Seconds of Body Twists", "Hold your phone in your hand with your arms outstretched parallel", "Jane"} };
        final List<Challenge> challenges = new ArrayList <Challenge> ();
        for ( int i = 0, count = mockData.length; i < count; i ++ )
        {
            final String [] data = mockData [i];
            challenges.add (
                new Challenge (data [0], data [1],
                    new ArrayList<Challenger>() {{ add( new Challenger (data [2]) ); }}  ) );
        }
        return challenges;
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_dummy, container, false);
            Bundle args = getArguments();

            final int myId = args.getInt ( ARG_SECTION_NUMBER );
            final Challenge challenge = mockChallenges_.get ( myId - 1 );
            Log.v ( "myId is: ", Integer.toString( myId) );
            ((TextView) rootView.findViewById(R.id.challenge_item_title)).setText( challenge.getTitle() );
            ((TextView) rootView.findViewById(R.id.challenge_item_description)).setText( challenge.getDescription() );

//            Toast.makeText(getActivity(), challenge.getTitle() + " " + challenge.getDescription(), Toast.LENGTH_SHORT).show();
            return rootView;
        }
    }
}
