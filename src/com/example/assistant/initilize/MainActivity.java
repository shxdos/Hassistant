package com.example.assistant.initilize;

import java.util.Timer;
import java.util.TimerTask;

import com.example.assistant.login.LoginAcitivity;
import com.example.hassistant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
	private TimerTask task;
	private Timer timer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		task=new TimerTask() {
			
			@Override
			public void run() {
				Intent intent=new Intent(MainActivity.this,LoginAcitivity.class);
				startActivity(intent);
				finish();	
			}
		};
		timer=new Timer();
		timer.schedule(task, 3000);
	}

}
