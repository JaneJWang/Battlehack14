package ca.myhealthsphere.challenger;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ActiveChallengeTimerFragment extends Fragment {
	private Button restartButton;
	private Button pauseButton;
	private TextView timerValue;
	private boolean started = false;

	private long startTime = 0L;

	private Handler customHandler = new Handler();

	long maxTimeMilliseconds = 1000 * 30;
	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_countdown_timer,
				container, false);

		timerValue = (TextView) view.findViewById(R.id.timerValue);
		restartButton = (Button) view.findViewById(R.id.restartButton);
		restartButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				startTime = SystemClock.uptimeMillis();
				customHandler.postDelayed(updateTimerThread, 0);
			}
		});

		pauseButton = (Button) view.findViewById(R.id.pauseButton);
		pauseButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				timeSwapBuff += timeInMilliseconds;
				customHandler.removeCallbacks(updateTimerThread);
			}
		});

		return view;
	}

	private Runnable updateTimerThread = new Runnable() {
		public void run() {
			timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
			updatedTime = timeSwapBuff + timeInMilliseconds;

			updatedTime = maxTimeMilliseconds - timeInMilliseconds;

			if (updatedTime > 5) {
				int secs = (int) (updatedTime / 1000);
				int mins = secs / 60;
				secs = secs % 60;
				int milliseconds = (int) (updatedTime % 1000);
				timerValue.setText(String.format("%02d", mins) + ":"
						+ String.format("%02d", secs) + ":"
						+ String.format("%03d", milliseconds));
				customHandler.postDelayed(this, 0);
			} else {
				customHandler.removeCallbacks(updateTimerThread);
				timerValue.setText(String.format("%02d", 0) + ":"
						+ String.format("%02d", 0) + ":"
						+ String.format("%03d", 0));
			}
		}
	};
}
