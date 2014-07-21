package com.example.assistant.quest;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.assistant.main.MainAdapter;
import com.example.assistant.model.DataQuest;
import com.example.assistant.quest.answer.AnswerFragment;
import com.example.assistant.quest.choose.ChooseFragment;
import com.example.assistant.quest.coding.CodingFragment;
import com.example.assistant.util.XMLObject;
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
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class QuestActivity extends FragmentActivity {
	/** 标题栏组件 */
	private TextView titleText;
	/** 标题栏左按钮 */
	private ImageButton titleLeft;
	/** 标题栏右按钮 */
	private ImageButton titleRight;
	/** 滑动页面容器 */
	private ViewPager viewPager;
	/** 滑动页面容器适配器 */
	private QuestPageAdapter adapter;
	/** 底部单选组件 */
	private RadioGroup radioGroup;
	/** Item列表 */
	private ArrayList<PageItem> pageItems;
	
	private DataQuest quest;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 初始化标题栏
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_quest);
		
		initDocment();
		
		
		initTitle();
		initPageItem();
		initPageList();
		initRadioGroup();
		
		
	}
	private void initDocment() {
		try {
//			SAXUtil util = new SAXUtil(getAssets().open("test_1.xml"));
			XMLUtil util = new XMLUtil(getAssets().open("test1.xml"));
			XMLObject obj = util.getXMLObject();
			quest = new DataQuest(obj);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化标题栏
	 */
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// 隐藏标题栏左右按钮
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
		// 设置标题文字
		titleText.setText(getString(R.string.activity_quest_title_text));

	}
	/**
	 * 初始化Item列表
	 */
	private void initPageItem() {
		pageItems = new ArrayList<PageItem>();
		pageItems.add(new PageItem((RadioButton) findViewById(R.id.chooseItem),
				new ChooseFragment(quest.chooseList)));
		pageItems.add(new PageItem((RadioButton) findViewById(R.id.answerItem),
				new AnswerFragment()));
		pageItems.add(new PageItem((RadioButton) findViewById(R.id.codingItem),
				new CodingFragment()));
	}
	/**
	 * 初始化ViewPager
	 */
	private void initPageList() {
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		adapter = new QuestPageAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		// 设置ViewPager的页面切换监听
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			@Override
			public void onPageSelected(int arg0) {
				// 遍历Item列表设置Check状态
				int i=0;
				for (PageItem item : pageItems) {
					if (i == arg0) {
						pageItems.get(i).button.setChecked(true);
					} else {
						pageItems.get(i).button.setChecked(false);
					}
					i++;
				}
			}
			
		});
	}
	/**
	 * 初始化底部单选组件
	 */
	private void initRadioGroup() {
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				for(int i=0; i<pageItems.size(); i++) {
					if (pageItems.get(i).button.getId() == checkedId) {
						viewPager.setCurrentItem(i);
						break;
					}
				}
			}
		});
	}
	/**
	 * 充填Fragment的ViewPager适配器
	 * @author HalfmanHuang
	 * @since JDK7 SDK19
	 * @version 1.0.0
	 */
	public class QuestPageAdapter extends FragmentPagerAdapter {
		public QuestPageAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return pageItems.get(position).frament;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pageItems.size();
		}
	}
	/**
	 * Item模型，包含了一个单选Button与一个Fragment
	 * @author HalfmanHuang
	 * @since JDK7 SDK19
	 * @version 1.0.0
	 */
	public class PageItem {
		public RadioButton button;
		public Fragment frament;
		public PageItem(RadioButton button, Fragment fragment) {
			this.button = button;
			this.frament = fragment;
		}
	}
}
