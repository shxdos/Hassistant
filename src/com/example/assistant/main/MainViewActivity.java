package com.example.assistant.main;

import com.example.assistant.message.MessageDialog;
import com.example.hassistant.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainViewActivity extends Activity implements OnClickListener{
	private TextView titleText;
	private ImageButton titleLeft;
	private ImageButton titleRight;
	private MainWidget quests;//�׶β���
	private MainWidget album;//ѧϰ���
	private MainWidget message;//��Ϣ����
	private MainWidget telephone;//�绰֧��
	private MainWidget share;//�������
	private MainWidget setting;//ϵͳ����
	private Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// �Զ��������
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main_view);
		initTitle();
		initView();
	}

	// ��ʼ��������
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText(R.string.activity_main_title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// ���ر���������ImageButton
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
	}
	private void initView(){
		//ʵ����
		quests=(MainWidget) findViewById(R.id.item_quests);
		album=(MainWidget) findViewById(R.id.item_album);
		message=(MainWidget) findViewById(R.id.item_message);
		telephone=(MainWidget) findViewById(R.id.item_telephone);
		share=(MainWidget) findViewById(R.id.item_share);
		setting=(MainWidget) findViewById(R.id.item_setting);
		//����
		quests.setOnClickListener(this);
		album.setOnClickListener(this);
		message.setOnClickListener(this);
		telephone.setOnClickListener(this);
		share.setOnClickListener(this);
		setting.setOnClickListener(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(null!=dialog&&dialog.isShowing()){
			dialog.dismiss();
		}
	}

	@Override
	public void onClick(View v) {
		//Toast.makeText(this, v.toString(), Toast.LENGTH_SHORT).show();
		if(v==quests){
			
		}else if(v==album){
			
		}else if(v==message){
			//�����ε����ε���
			if(null!=dialog){
				if(dialog.isShowing()){
					if(dialog.getClass()==MessageDialog.class){
						return;
					}
					dialog.dismiss();
				}
			}
			dialog=new MessageDialog(this,"13341194865");
			dialog.show();
		}else if(v==telephone){
			
		}else if(v==share){
			
		}else if(v==setting){
			
		}
		
	}

}
