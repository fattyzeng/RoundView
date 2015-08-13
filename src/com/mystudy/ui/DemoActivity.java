package com.mystudy.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

@SuppressLint("ResourceAsColor")
public class DemoActivity extends Activity {

	private static final String TAG = "TAG";

	private RoundView roundProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_main);

		roundProgressBar = (RoundView) findViewById(R.id.roundProgressBar);
		new Thread(new Runnable() {

			@Override
			public void run() {
				int progress = 0;
				while (true) {
					progress++;
					roundProgressBar.setProgress(progress);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (progress > 100) {
						progress = 0;
					}
				}

			}
		}).start();

	}
}
