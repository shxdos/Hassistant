package com.example.assistant.quest.choose;

import com.example.hassistant.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class ChooseFragment extends Fragment {
	private ExpandableListView listView;
	private ChooseAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root=inflater.inflate(R.layout.fragment_choose, container, false);
		listView=(ExpandableListView) root.findViewById(R.id.listView);
		adapter=new ChooseAdapter(this.getActivity());
		listView.setAdapter(adapter);
		return root;
	}
}
