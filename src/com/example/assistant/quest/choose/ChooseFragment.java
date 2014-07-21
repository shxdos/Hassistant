package com.example.assistant.quest.choose;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.example.assistant.model.DataChooseList;
import com.example.hassistant.R;

@SuppressLint("ValidFragment")
public class ChooseFragment extends Fragment {

	private ExpandableListView listView;
	
	private ChooseAdapter adapter;
	
	private DataChooseList chooseList;

	public ChooseFragment(DataChooseList chooseList) {
		this.chooseList = chooseList;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Fragment获得布局实例的方法参照此处
		View root = inflater.inflate(R.layout.fragment_choose, container, false);
		listView = (ExpandableListView)root.findViewById(R.id.listView);
		adapter = new ChooseAdapter(getActivity(), chooseList);
		listView.setAdapter(adapter);
		return root;
	}

	
}
