package com.example.assistant.main;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MainAdapter extends PagerAdapter {
	private ArrayList<PagerItem> pagerList;
	
	public MainAdapter() {
		super();
		this.pagerList =new ArrayList<PagerItem>();
	}
	/**
	 * 添加一个Item到列表
	 * @param title
	 * @param view
	 */
	public void addItem(String title, View view) {
		pagerList.add(new PagerItem(view, title));
	}
	/**
	 * 获取一个Item
	 * @param position 要获取的Item的位置
	 * @return 获取到的Item
	 */
	public PagerItem getItem(int position) {
		return pagerList.get(position);
	}
	/**
	 * 移除一个Item
	 * @param position 要移除的Item的位置
	 */
	public void remove(int position) {
		pagerList.remove(position);
	}
	/**
	 * 移除所有Item
	 */
	public void removeAll() {
		pagerList.clear();
	}
	@Override
	public int getCount() {
		return pagerList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		
		return arg0==((PagerItem)arg1).view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager)container).removeView(pagerList.get(position).view);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		
		return pagerList.get(position).title;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager)container).addView(pagerList.get(position).view);
		return pagerList.get(position);
	}
	public class PagerItem{
		public View view;
		public String title;
		public PagerItem(View v,String t){
			view=v;
			title=t;
		}
	}
}
