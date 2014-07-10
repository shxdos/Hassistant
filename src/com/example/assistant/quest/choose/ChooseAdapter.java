package com.example.assistant.quest.choose;

import com.example.hassistant.R;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import android.widget.TextView;

public class ChooseAdapter extends BaseExpandableListAdapter {
	private LayoutInflater inflater;// 布局反射器

	public ChooseAdapter(Context context) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int groupPositon, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder holder;
		if (null == convertView) {
			convertView = inflater
					.inflate(R.layout.listitem_choose_child, null);
			holder = new ChildViewHolder();
			holder.tag = (TextView) convertView.findViewById(R.id.child_tag);
			holder.description = (TextView) convertView
					.findViewById(R.id.child_description);
			convertView.setTag(holder);
		} else {
			holder = (ChildViewHolder) convertView.getTag();

		}
		holder.tag.setText(""+(char) ('A' + childPosition));
		holder.description
				.setText("一位先生到一家吝啬的餐馆去吃饭，一个服务生端来一个盘子放到那位先生面前，先生看见盘子是湿的，便喊来服务生说：“服务员，你这个盘子是湿的！”服务生看了一眼盘子说：“先生，这是您的汤。");
		return convertView;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public long getGroupId(int groupPositon) {
		// TODO Auto-generated method stub
		return groupPositon;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		GroupViewHolder holder;
		if (null == convertView) {
			convertView = inflater
					.inflate(R.layout.listitem_choose, null);
			holder = new GroupViewHolder();
			holder.index = (TextView) convertView.findViewById(R.id.index);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.answer = (TextView) convertView.findViewById(R.id.answer);
			holder.description = (TextView) convertView
					.findViewById(R.id.description);
			convertView.setTag(holder);
		} else {
			holder = (GroupViewHolder) convertView.getTag();

		}
		holder.index.setText("" + (groupPosition + 1));
		holder.title.setText("天青色等烟雨　而我在等你  月色被打捞起　晕开了结局");
		holder.description.setText("准备年中会发言");
		holder.answer.setText("未回答");
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// 是否可以被点击
		return true;
	}

	public class GroupViewHolder {
		public TextView index;
		public TextView title;
		public TextView description;
		public TextView answer;
	}

	public class ChildViewHolder {
		public TextView tag;
		public TextView description;
	}
}
