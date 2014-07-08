package com.example.assistant.main;

import org.w3c.dom.Text;

import com.example.hassistant.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainWidget extends LinearLayout {
	public ImageView imageView;
	public TextView textView;

	public MainWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		//获取typedArray对象
		TypedArray types = context.obtainStyledAttributes(attrs,
				R.styleable.MainWidget);

		setOrientation(VERTICAL);
		imageView = new ImageView(context);
		imageView.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));
		imageView.setScaleType(ScaleType.FIT_CENTER);
		//设置图片
		imageView.setImageDrawable(types.getDrawable(R.styleable.MainWidget_src));

		textView = new TextView(context);
		textView.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 4.0f));
		textView.setTextAppearance(context, android.R.attr.textAppearanceMedium);

		textView.setTextColor(getResources().getColor(R.color.color_text_1));
		textView.setGravity(Gravity.CENTER);
		//设置文字
		textView.setText(types.getText(R.styleable.MainWidget_text));
		this.addView(imageView);
		this.addView(textView);

	}

}
