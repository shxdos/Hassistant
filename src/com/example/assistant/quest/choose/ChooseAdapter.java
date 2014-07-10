package com.example.assistant.quest.choose;

import com.example.hassistant.R;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import android.widget.TextView;

public class ChooseAdapter extends BaseExpandableListAdapter {
	private LayoutInflater inflater;// ���ַ�����

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
				.setText("һλ������һ�����ĵĲ͹�ȥ�Է���һ������������һ�����ӷŵ���λ������ǰ����������������ʪ�ģ��㺰��������˵��������Ա�������������ʪ�ģ�������������һ������˵����������������������");
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
		holder.title.setText("����ɫ�����ꡡ�����ڵ���  ��ɫ���������ο��˽��");
		holder.description.setText("׼�����лᷢ��");
		holder.answer.setText("δ�ش�");
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// �Ƿ���Ա����
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
