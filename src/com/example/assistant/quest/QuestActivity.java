package com.example.assistant.quest;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.assistant.main.MainAdapter;
import com.example.assistant.quest.answer.AnswerFragment;
import com.example.assistant.quest.choose.ChooseFragment;
import com.example.assistant.quest.coding.CodingFragment;
import com.example.assistant.util.XMLUtil;
import com.example.hassistant.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class QuestActivity extends FragmentActivity {
	private TextView titleText;// 标题
	private ImageButton titleLeft;// 标题左侧图标
	private ImageButton titleRight;// 标题右侧图标
	private ViewPager viewPager;// 滑动页面容器
	private ArrayList<PageItem> pageItems;
	private QuestPageAdapter adapter;//滑动页面容器的适配器
	private RadioGroup radioGroup;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		// 自定义标题栏
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_quest);
		initTitle();
		initPageItem();
		initPagerList();
		initRadioGroup();
	}
	
	private void initDocument(){
		
//		try {
//		//	XMLUtil util=new XMLUtil(getAssets().open("test1.xml"));
//			
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	// 初始化标题栏
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText(R.string.activity_quest_title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// 隐藏标题栏两次ImageButton
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
	}

	private void initPageItem() {
		pageItems = new ArrayList<PageItem>();
		pageItems.add(new PageItem((RadioButton) findViewById(R.id.chooseItem),
				new ChooseFragment()));
		pageItems.add(new PageItem((RadioButton) findViewById(R.id.answerItem),
				new AnswerFragment()));
		pageItems.add(new PageItem((RadioButton) findViewById(R.id.codingItem),
				new CodingFragment()));

	}
	private void initRadioGroup(){
		radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedid) {
				
			for(int i=0;i<pageItems.size();i++){
				if(pageItems.get(i).button.getId()==checkedid){
					viewPager.setCurrentItem(i);
					break;
				}
			}
				
			}
		});
	}
	private void initPagerList() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		adapter=new QuestPageAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				int i=0;
				for(PageItem item:pageItems){
					if(i==arg0){
						pageItems.get(i).button.setChecked(true);
					}else{
						pageItems.get(i).button.setChecked(false);
					}
					i++;
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public class QuestPageAdapter extends FragmentPagerAdapter {

		public QuestPageAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int positiont) {
			// TODO Auto-generated method stub
			return pageItems.get(positiont).fragment;
		}

		@Override
		public int getCount() {
			
			return pageItems.size();
		}

	}

	public class PageItem {
		public RadioButton button;
		public Fragment fragment;

		public PageItem(RadioButton button, Fragment fragment) {
			this.button = button;
			this.fragment = fragment;

		}
	}
}
