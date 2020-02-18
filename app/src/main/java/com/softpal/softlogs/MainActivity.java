package com.softpal.softlogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.softpal.softlog.SoftLog;

public class MainActivity extends AppCompatActivity
{
	private static final String TAG=MainActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SoftLog.v(TAG,"onCreate");
	}
}
