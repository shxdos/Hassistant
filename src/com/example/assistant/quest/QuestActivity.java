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
	/** ��������� */
	private TextView titleText;
	/** ��������ť */
	private ImageButton titleLeft;
	/** �������Ұ�ť */
	private ImageButton titleRight;
	/** ����ҳ������ */
	private ViewPager viewPager;
	/** ����ҳ������������ */
	private QuestPageAdapter adapter;
	/** �ײ���ѡ��� */
	private RadioGroup radioGroup;
	/** Item�б� */
	private ArrayList<PageItem> pageItems;
	
	private DataQuest quest;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ��ʼ��������
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
	 * ��ʼ��������
	 */
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// ���ر��������Ұ�ť
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
		// ���ñ�������
		titleText.setText(getString(R.string.activity_quest_title_text));

	}
	/**
	 * ��ʼ��Item�б�
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
	 * ��ʼ��ViewPager
	 */
	private void initPageList() {
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		adapter = new QuestPageAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		// ����ViewPager��ҳ���л�����
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			@Override
			public void onPageSelected(int arg0) {
				// ����Item�б�����Check״̬
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
	 * ��ʼ���ײ���ѡ���
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
	 * ����Fragment��ViewPager������
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
	 * Itemģ�ͣ�������һ����ѡButton��һ��Fragment
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
