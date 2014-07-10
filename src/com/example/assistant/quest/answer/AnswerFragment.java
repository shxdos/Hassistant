package com.example.assistant.quest.answer;

import com.example.hassistant.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AnswerFragment extends Fragment {
	private ListView answerList;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root=inflater.inflate(R.layout.fragment_answer, container, false);
		answerList=(ListView) root.findViewById(R.id.anserList);
		return root;
	}

}
