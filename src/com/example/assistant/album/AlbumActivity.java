package com.example.assistant.album;

import com.example.hassistant.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

public class AlbumActivity extends Activity {
	private GridView gridView;
	private AlbumAdapter adapter;
	private TextView titleText;
	private ImageButton titleLeft;
	private ImageButton titleRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// �Զ��������
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_album);
		gridView = (GridView) findViewById(R.id.gridView);
		adapter = new AlbumAdapter(this, getCacheDir());
		gridView.setAdapter(adapter);
		initTitle();
	}

	// ��ʼ��������
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText(R.string.activity_album_title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// ���ر���������ImageButton
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
	}
}
