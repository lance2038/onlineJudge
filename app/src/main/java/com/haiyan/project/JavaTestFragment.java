package com.haiyan.project;

import com.haiyan.utils.SendResult;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
/**
 * java题目
 * @author haiyan
 *
 */
public class JavaTestFragment extends Fragment implements OnClickListener {
	private View view;
	private Button submit_java;
	private RadioGroup java_rg1,java_rg2,java_rg3;
	private RadioButton java_rb1_a,java_rb1_b,java_rb1_c,java_rb1_d,
			java_rb2_a,java_rb2_b,java_rb2_c,java_rb2_d,
			java_rb3_a,java_rb3_b,java_rb3_c,java_rb3_d;
	private CheckBox cb4_a,cb4_b,cb4_c,cb4_d,cb5_a,cb5_b,cb5_c,cb5_d;

	private String one_topic="",two_topic="",three_topic="";
	private String four_topic1="",four_topic2="",four_topic3="",four_topic4="",
			five_topic1="",five_topic2="",five_topic3="",five_topic4="",
			four_topic,five_topic;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.javatest, container, false);
		findViewId();
		listener();

		return view;
	}

	private void findViewId() {
		java_rg1 = (RadioGroup) view.findViewById(R.id.java_rg1);
		java_rg2 = (RadioGroup) view.findViewById(R.id.java_rg2);
		java_rg3 = (RadioGroup) view.findViewById(R.id.java_rg3);

		java_rb1_a = (RadioButton) view.findViewById(R.id.java_rb1_a);
		java_rb1_b = (RadioButton) view.findViewById(R.id.java_rb1_b);
		java_rb1_c = (RadioButton) view.findViewById(R.id.java_rb1_c);
		java_rb1_d = (RadioButton) view.findViewById(R.id.java_rb1_d);
		java_rb2_a = (RadioButton) view.findViewById(R.id.java_rb2_a);
		java_rb2_b = (RadioButton) view.findViewById(R.id.java_rb2_b);
		java_rb2_c = (RadioButton) view.findViewById(R.id.java_rb2_c);
		java_rb2_d = (RadioButton) view.findViewById(R.id.java_rb2_d);
		java_rb3_a = (RadioButton) view.findViewById(R.id.java_rb3_a);
		java_rb3_b = (RadioButton) view.findViewById(R.id.java_rb3_b);
		java_rb3_c = (RadioButton) view.findViewById(R.id.java_rb3_c);
		java_rb3_d = (RadioButton) view.findViewById(R.id.java_rb3_d);


		cb4_a = (CheckBox) view.findViewById(R.id.javatest_4_a);
		cb4_b = (CheckBox) view.findViewById(R.id.javatest_4_b);
		cb4_c = (CheckBox) view.findViewById(R.id.javatest_4_c);
		cb4_d = (CheckBox) view.findViewById(R.id.javatest_4_d);
		cb5_a = (CheckBox) view.findViewById(R.id.javatest_5_a);
		cb5_b = (CheckBox) view.findViewById(R.id.javatest_5_b);
		cb5_c = (CheckBox) view.findViewById(R.id.javatest_5_c);
		cb5_d = (CheckBox) view.findViewById(R.id.javatest_5_d);

		submit_java = (Button) view.findViewById(R.id.submit_java);
	}

	private void listener() {
		// TODO Auto-generated method stub
		java_rg1.setOnCheckedChangeListener(rgListener);
		java_rg2.setOnCheckedChangeListener(rgListener);
		java_rg3.setOnCheckedChangeListener(rgListener);
		cb4_a.setOnCheckedChangeListener(listener);
		cb4_b.setOnCheckedChangeListener(listener);
		cb4_c.setOnCheckedChangeListener(listener);
		cb4_d.setOnCheckedChangeListener(listener);
		cb5_a.setOnCheckedChangeListener(listener);
		cb5_b.setOnCheckedChangeListener(listener);
		cb5_c.setOnCheckedChangeListener(listener);
		cb5_d.setOnCheckedChangeListener(listener);

		submit_java.setOnClickListener(this);
	}

	/**
	 * 单选题
	 */
	private RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup rg, int checkedId) {
			// TODO Auto-generated method stub
			if(rg==java_rg1) {
				if(java_rb1_a.getId()==checkedId) {
					one_topic="A";
				} else if(java_rb1_b.getId()==checkedId){
					one_topic="B";
				} else if(java_rb1_c.getId()==checkedId){
					one_topic="C";
				} else if(java_rb1_d.getId()==checkedId){
					one_topic="D";
				}
			} else if (rg==java_rg2) {
				if(java_rb2_a.getId()==checkedId) {
					two_topic="A";
				} else if(java_rb2_b.getId()==checkedId) {
					two_topic="B";
				} else if(java_rb2_c.getId()==checkedId) {
					two_topic="C";
				} else if(java_rb2_d.getId()==checkedId) {
					two_topic="D";
				}
			} else if (rg==java_rg3) {
				if(java_rb3_a.getId()==checkedId) {
					three_topic="A";
				} else if(java_rb3_b.getId()==checkedId) {
					three_topic="B";
				} else if(java_rb3_c.getId()==checkedId) {
					three_topic="C";
				} else if(java_rb3_d.getId()==checkedId) {
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
			if(cb==cb4_a && isChecked) {
				four_topic1 = "A";
			} else if (cb==cb4_a && !isChecked) {
				four_topic1 = null;
			} else if (cb==cb4_b && isChecked) {
				four_topic2 = "B";
			} else if (cb==cb4_b && !isChecked) {
				four_topic2 = null;
			} else if (cb==cb4_c && isChecked) {
				four_topic3 = "C";
			} else if (cb==cb4_c && !isChecked) {
				four_topic3 = null;
			} else if (cb==cb4_d && isChecked) {
				four_topic4 = "D";
			} else if (cb==cb4_d && !isChecked) {
				four_topic4 = null;

			} else if (cb==cb5_a && isChecked) {
				five_topic1 = "A";
			} else if (cb==cb5_a && !isChecked) {
				five_topic1 = null;
			} else if (cb==cb5_b && isChecked) {
				five_topic2 = "B";
			} else if (cb==cb5_b && !isChecked) {
				five_topic2 = null;
			} else if (cb==cb5_c && isChecked) {
				five_topic3 = "C";
			} else if (cb==cb5_c && !isChecked) {
				five_topic3 = null;
			} else if (cb==cb5_d && isChecked) {
				five_topic4 = "D";
			} else if (cb==cb5_d && !isChecked) {
				five_topic4 = null;
			}
		}
	};
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		four_topic = four_topic1+four_topic2+four_topic3+four_topic4;
		five_topic = five_topic1+five_topic2+five_topic3+five_topic4;
		//判断题目
		new SendResult(getActivity(), one_topic, two_topic, three_topic, four_topic, five_topic,"java");
	}
}
