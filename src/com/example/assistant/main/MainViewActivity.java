package com.example.assistant.main;

import com.example.assistant.album.AlbumActivity;
import com.example.assistant.message.MessageDialog;
import com.example.assistant.phone.PhoneDialog;
import com.example.assistant.phone.PhoneInfo;
import com.example.assistant.quest.QuestActivity;
import com.example.hassistant.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainViewActivity extends Activity implements OnClickListener{
	private TextView titleText;
	private ImageButton titleLeft;
	private ImageButton titleRight;
	private ViewPager viewPager;//头部滑动页面
	private MainAdapter adapter;//头部滑动页面适配器
	private MainWidget quests;//阶段测试
	private MainWidget album;//学习相册
	private MainWidget message;//消息提问
	private MainWidget telephone;//电话支持
	private MainWidget share;//经验分享
	private MainWidget setting;//系统设置
	private Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 自定义标题栏
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main_view);
		initTitle();
		initView();
		initPager();
	}

	// 初始化标题栏
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText(R.string.activity_main_title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// 隐藏标题栏两次ImageButton
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
	}
	private void initView(){
		//实例化
		quests=(MainWidget) findViewById(R.id.item_quests);
		album=(MainWidget) findViewById(R.id.item_album);
		message=(MainWidget) findViewById(R.id.item_message);
		telephone=(MainWidget) findViewById(R.id.item_telephone);
		share=(MainWidget) findViewById(R.id.item_share);
		setting=(MainWidget) findViewById(R.id.item_setting);
		//监听
		quests.setOnClickListener(this);
		album.setOnClickListener(this);
		message.setOnClickListener(this);
		telephone.setOnClickListener(this);
		share.setOnClickListener(this);
		setting.setOnClickListener(this);
	}
	private void initPager(){
		viewPager=(ViewPager) findViewById(R.id.viewPager);
		adapter=new MainAdapter();
		View v=new View(this);
		v.setLayoutParams(new LayoutParams(-1,-1));
		v.setBackgroundColor(Color.WHITE);
		
		View v2=new View(this);
		v2.setLayoutParams(new LayoutParams(-1,-1));
		v2.setBackgroundColor(Color.RED);
		
		View v3=new View(this);
		v3.setLayoutParams(new LayoutParams(-1,-1));
		v3.setBackgroundColor(Color.GREEN);
		adapter.addItem("第一页", v);
		adapter.addItem("第二页", v2);
		adapter.addItem("第三页", v3);
		viewPager.setAdapter(adapter);
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
		//阶段测试
		if(v==quests){
			Intent intent=new Intent(MainViewActivity.this,QuestActivity.class);
			startActivity(intent);
		}else if(v==album){
			//学习相册
			Intent intent=new Intent(MainViewActivity.this,AlbumActivity.class);
			startActivity(intent);
		}else if(v==message){
			//消息支持
			//避免多次点击多次弹出
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
			PhoneInfo[] infos=new PhoneInfo[3];
			for(int i=0;i<3;i++){
				infos[i]=new PhoneInfo();
				infos[i].name="电话支持"+i;
				infos[i].number="13341195865";
			}
			//电话支持
			//避免多次点击多次弹出
			if(null!=dialog){
				if(dialog.isShowing()){
					if(dialog.getClass()==PhoneDialog.class){
						return;
					}
					dialog.dismiss();
				}
			}
			dialog=new PhoneDialog(this,infos);
			dialog.show();
		}else if(v==share){
			
		}else if(v==setting){
			
		}
		
	}

}
