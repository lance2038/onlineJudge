package com.haiyan.project;


import com.haiyan.utils.SendResult;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/**
 * android 题目
 * @author haiyan
 *
 */
public class AndroidTestFragment extends Fragment implements OnClickListener {
	private View view;
	private Button submit;
	private RadioGroup android_rg1,android_rg2,android_rg3;
	private RadioButton android_rb1_a,android_rb1_b,android_rb1_c,android_rb1_d,
			android_rb2_a,android_rb2_b,android_rb2_c,android_rb2_d,
			android_rb3_a,android_rb3_b,android_rb3_c,android_rb3_d;
	private CheckBox cb4_a,cb4_b,cb4_c,cb4_d,cb5_a,cb5_b,cb5_c,cb5_d;

	private String one_topic="",two_topic="",three_topic="";
	private String four_topic1="",four_topic2="",four_topic3="",four_topic4="",
			five_topic1="",five_topic2="",five_topic3="",five_topic4="",
			four_topic,five_topic;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.androidtest, container, false);
		findViewId();
		listener();

		return view;
	}

	private void findViewId() {
		android_rg1 = (RadioGroup) view.findViewById(R.id.android_rg1);
		android_rg2 = (RadioGroup) view.findViewById(R.id.android_rg2);
		android_rg3 = (RadioGroup) view.findViewById(R.id.android_rg3);

		android_rb1_a = (RadioButton) view.findViewById(R.id.android_rb1_a);
		android_rb1_b = (RadioButton) view.findViewById(R.id.android_rb1_b);
		android_rb1_c = (RadioButton) view.findViewById(R.id.android_rb1_c);
		android_rb1_d = (RadioButton) view.findViewById(R.id.android_rb1_d);
		android_rb2_a = (RadioButton) view.findViewById(R.id.android_rb2_a);
		android_rb2_b = (RadioButton) view.findViewById(R.id.android_rb2_b);
		android_rb2_c = (RadioButton) view.findViewById(R.id.android_rb2_c);
		android_rb2_d = (RadioButton) view.findViewById(R.id.android_rb2_d);
		android_rb3_a = (RadioButton) view.findViewById(R.id.android_rb3_a);
		android_rb3_b = (RadioButton) view.findViewById(R.id.android_rb3_b);
		android_rb3_c = (RadioButton) view.findViewById(R.id.android_rb3_c);
		android_rb3_d = (RadioButton) view.findViewById(R.id.android_rb3_d);


		cb4_a = (CheckBox) view.findViewById(R.id.androidtest_4_a);
		cb4_b = (CheckBox) view.findViewById(R.id.androidtest_4_b);
		cb4_c = (CheckBox) view.findViewById(R.id.androidtest_4_c);
		cb4_d = (CheckBox) view.findViewById(R.id.androidtest_4_d);
		cb5_a = (CheckBox) view.findViewById(R.id.androidtest_5_a);
		cb5_b = (CheckBox) view.findViewById(R.id.androidtest_5_b);
		cb5_c = (CheckBox) view.findViewById(R.id.androidtest_5_c);
		cb5_d = (CheckBox) view.findViewById(R.id.androidtest_5_d);

		submit = (Button) view.findViewById(R.id.submit);
	}

	private void listener() {
		// TODO Auto-generated method stub
		android_rg1.setOnCheckedChangeListener(rgListener);
		android_rg2.setOnCheckedChangeListener(rgListener);
		android_rg3.setOnCheckedChangeListener(rgListener);
		cb4_a.setOnCheckedChangeListener(listener);
		cb4_b.setOnCheckedChangeListener(listener);
		cb4_c.setOnCheckedChangeListener(listener);
		cb4_d.setOnCheckedChangeListener(listener);
		cb5_a.setOnCheckedChangeListener(listener);
		cb5_b.setOnCheckedChangeListener(listener);
		cb5_c.setOnCheckedChangeListener(listener);
		cb5_d.setOnCheckedChangeListener(listener);

		submit.setOnClickListener(this);
	}

	/**
	 * 单选题
	 */
	private RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup rg, int checkedId) {
			// TODO Auto-generated method stub
			if(rg==android_rg1) {
				if(android_rb1_a.getId()==checkedId) {
					one_topic="A";
				} else if(android_rb1_b.getId()==checkedId){
					one_topic="B";
				} else if(android_rb1_c.getId()==checkedId){
					one_topic="C";
				} else if(android_rb1_d.getId()==checkedId){
					one_topic="D";
				}
			} else if (rg==android_rg2) {
				if(android_rb2_a.getId()==checkedId) {
					two_topic="A";
				} else if(android_rb2_b.getId()==checkedId) {
					two_topic="B";
				} else if(android_rb2_c.getId()==checkedId) {
					two_topic="C";
				} else if(android_rb2_d.getId()==checkedId) {
					two_topic="D";
				}
			} else if (rg==android_rg3) {
				if(android_rb3_a.getId()==checkedId) {
					three_topic="A";
				} else if(android_rb3_b.getId()==checkedId) {
					three_topic="B";
				} else if(android_rb3_c.getId()==checkedId) {
					three_topic="C";
				} else if(android_rb3_d.getId()==checkedId) {
					three_topic="D";
				}
			}

		}
	};

	/**
	 * 多选题
	 */
	private OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
			// TODO Auto-generated method stub
			//多选一
			if(cb==cb4_a && isChecked) {
				four_topic1 = "A";
			} else if (cb==cb4_a && !isChecked) {
				four_topic1 = "";
			} else if (cb==cb4_b && isChecked) {
				four_topic2 = "B";
			} else if (cb==cb4_b && !isChecked) {
				four_topic2 = "";
			} else if (cb==cb4_c && isChecked) {
				four_topic3 = "C";
			} else if (cb==cb4_c && !isChecked) {
				four_topic3 = "";
			} else if (cb==cb4_d && isChecked) {
				four_topic4 = "D";
			} else if (cb==cb4_d && !isChecked) {
				four_topic4 = "";
				//多选二
			} else if (cb==cb5_a && isChecked) {
				five_topic1 = "A";
			} else if (cb==cb5_a && !isChecked) {
				five_topic1 = "";
			} else if (cb==cb5_b && isChecked) {
				five_topic2 = "B";
			} else if (cb==cb5_b && !isChecked) {
				five_topic2 = "";
			} else if (cb==cb5_c && isChecked) {
				five_topic3 = "C";
			} else if (cb==cb5_c && !isChecked) {
				five_topic3 = "";
			} else if (cb==cb5_d && isChecked) {
				five_topic4 = "D";
			} else if (cb==cb5_d && !isChecked) {
				five_topic4 = "";
			}
		}
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		four_topic = four_topic1+four_topic2+four_topic3+four_topic4;
		five_topic = five_topic1+five_topic2+five_topic3+five_topic4;
		new SendResult(getActivity(), one_topic, two_topic, three_topic, four_topic, five_topic,"android");

	}

}
