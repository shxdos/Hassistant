package com.example.assistant.login;

import com.example.assistant.main.MainViewActivity;
import com.example.hassistant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginAcitivity extends Activity {
	private TextView titleText;
	private ImageButton titleLeft;
	private ImageButton titleRight;
	private EditText user;// �û���
	private EditText pass;// ����
	private ImageButton loginBtn;// ��½��ť

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// �Զ��������
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_login);
		initTitle();
		initView();
	}

	// ��ʼ��������
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText(R.string.activity_lgoin_title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// ���ر���������ImageButton
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
	}

	// ��ʼ������
	private void initView() {
		user = (EditText) findViewById(R.id.userEdit);
		pass = (EditText) findViewById(R.id.passEdit);
		loginBtn = (ImageButton) findViewById(R.id.loginBtn);
		// �����¼�
		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (loginBtn == v) {
					Intent intent = new Intent(LoginAcitivity.this,
							MainViewActivity.class);
					startActivity(intent);
				}
			}
		});
	}
}
