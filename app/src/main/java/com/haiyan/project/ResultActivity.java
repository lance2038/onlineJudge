package com.haiyan.project;

import com.haiyan.utils.SelectPicPopupWindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 题目对错判断
 * @author haiyan
 *
 */
public class ResultActivity extends Activity {
	private long waitTime = 2000;
	private long touchTime = 0;
	private Button show_result,one_again;
	private TextView titlt,present1,present2,present3,present4,present5,
			right_wrong1,right_wrong2,right_wrong3,right_wrong4,right_wrong5,
			result1,result2,result3,result4,result5,
			score1,score2,score3,score4,score5,total_score;
	private String one_topic,two_topic,three_topic,four_topic,five_topic,label,
			answer1,answer2,answer3,answer4,answer5;
	private int result_score1,result_score2,result_score3,result_score4,result_score5;
	private char a[],b[];
	private boolean flag,mark;
	private SelectPicPopupWindow menuWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.result);
		findViewId();
		getResult();
		init();
		Listener();
	}

	private void findViewId() {
		titlt = (TextView) findViewById(R.id.result_title);
		present1 = (TextView) findViewById(R.id.present1);
		present2 = (TextView) findViewById(R.id.present2);
		present3 = (TextView) findViewById(R.id.present3);
		present4 = (TextView) findViewById(R.id.present4);
		present5 = (TextView) findViewById(R.id.present5);
		right_wrong1 = (TextView) findViewById(R.id.right_wrong1);
		right_wrong2 = (TextView) findViewById(R.id.right_wrong2);
		right_wrong3 = (TextView) findViewById(R.id.right_wrong3);
		right_wrong4 = (TextView) findViewById(R.id.right_wrong4);
		right_wrong5 = (TextView) findViewById(R.id.right_wrong5);
		result1 = (TextView) findViewById(R.id.result1);
		result2 = (TextView) findViewById(R.id.result2);
		result3 = (TextView) findViewById(R.id.result3);
		result4 = (TextView) findViewById(R.id.result4);
		result5 = (TextView) findViewById(R.id.result5);
		score1 = (TextView) findViewById(R.id.score1);
		score2 = (TextView) findViewById(R.id.score2);
		score3 = (TextView) findViewById(R.id.score3);
		score4 = (TextView) findViewById(R.id.score4);
		score5 = (TextView) findViewById(R.id.score5);
		total_score = (TextView) findViewById(R.id.total_score);
		show_result = (Button) findViewById(R.id.show_result);
		one_again = (Button) findViewById(R.id.one_again);


	}
	private void getResult() {
		Intent intents = getIntent();
		label = intents.getStringExtra("flag");
		one_topic = intents.getStringExtra("one_topic");
		two_topic = intents.getStringExtra("two_topic");
		three_topic = intents.getStringExtra("three_topic");
		four_topic = intents.getStringExtra("four_topic");
		five_topic = intents.getStringExtra("five_topic");
	}

	private void init() {
		if("android".equals(label)) {
			androidJudge();
		} else if ("java".equals(label)) {
			javaJudge();
		}
	}
	/**
	 * android结果处理
	 */
	private void androidJudge() {
		titlt.setText(R.string.android_test_result);
		answer1 = "B";
		answer2 = "D";
		answer3 = "A";
		answer4 = "BC";
		answer5 = "ABCD";
		Judge();

	}
	/**
	 * java结果处理
	 */
	private void javaJudge() {
		titlt.setText(R.string.java_test_result);
		answer1 = "A";
		answer2 = "C";
		answer3 = "B";
		answer4 = "ABC";
		answer5 = "BCD";
		Judge();

	}

	/**
	 * 判断对错
	 */
	private void Judge() {
		present1.setText(one_topic);
		present2.setText(two_topic);
		present3.setText(three_topic);
		present4.setText(four_topic);
		present5.setText(five_topic);

		if(one_topic.equals(answer1)) {
			right_wrong1.setText("√");
			result_score1 = 20;
		} else if (!one_topic.equals(answer1)) {
			right_wrong1.setText("×");
			result_score1 = 0;
		}
		if(two_topic.equals(answer2)) {
			right_wrong2.setText("√");
			result_score2 = 20;
		} else if (!two_topic.equals(answer2)) {
			right_wrong2.setText("×");
			result_score2 = 0;
		}
		if(three_topic.equals(answer3)) {
			right_wrong3.setText("√");
			result_score3 = 20;
		} else if (!three_topic.equals(answer3)) {
			right_wrong3.setText("×");
			result_score3 = 0;
		}
		//多选
		if(four_topic.equals(answer4)) {
			right_wrong4.setText("√");
			result_score4 = 20;
		} else if (!four_topic.equals(answer4)) {
			if(four_topic.length()>answer4.length()) {
				right_wrong4.setText("×");
				result_score4 = 0;
			} else if (four_topic.length()<answer4.length()) {
				a = new char[four_topic.length()];
				for(int i = 0; i < four_topic.length();i++) {
					a[i] = four_topic.charAt(i);
				}
				for(int i = 0; i < a.length;i++) {
					if(answer4.contains((a[i]+""))) {
						flag = true;
					} else if(!answer4.contains((a[i]+""))) {
						flag = false;
						break;
					}
				}
				if(flag==true) {
					right_wrong4.setText("√");
					result_score4 = 10;
				} else {
					right_wrong4.setText("×");
					result_score4 = 0;
				}

			} else {
				right_wrong4.setText("×");
				result_score4 = 0;
			}

		}

		if(five_topic.equals(answer5)) {
			right_wrong5.setText("√");
			result_score5 = 20;
		} else if (!five_topic.equals(answer5)) {
			if(five_topic.length()>answer5.length()) {
				right_wrong5.setText("×");
				result_score5 = 0;
			} else if (five_topic.length()<answer5.length()) {
				b = new char[five_topic.length()];
				for(int i = 0; i < five_topic.length();i++) {
					b[i] = five_topic.charAt(i);
				}
				for(int i = 0; i < b.length;i++) {
					if(answer5.contains((b[i]+""))) {
						mark = true;
					} else if(!answer5.contains((b[i]+""))) {
						mark = false;
						break;
					}
				}
				if(mark==true) {
					right_wrong5.setText("√");
					result_score5 = 10;
				} else {
					right_wrong5.setText("×");
					result_score5 = 0;
				}

			} else {
				right_wrong5.setText("×");
				result_score5 = 0;
			}

		}
	}

	private void Listener() {
		// TODO Auto-generated method stub
		show_result.setOnClickListener(buttonListener);
		one_again.setOnClickListener(buttonListener);
	}

	private OnClickListener buttonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v==show_result) {
				result1.setText(answer1);
				result2.setText(answer2);
				result3.setText(answer3);
				result4.setText(answer4);
				result5.setText(answer5);
				score1.setText(result_score1+"");
				score2.setText(result_score2+"");
				score3.setText(result_score3+"");
				score4.setText(result_score4+"");
				score5.setText(result_score5+"");
				total_score.setText(result_score1+result_score2+result_score3+result_score4+result_score5+"");

			} else if (v==one_again) {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				ResultActivity.this.finish();
			}
		}
	};

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub

		menuWindow = new SelectPicPopupWindow(ResultActivity.this, itemsOnClick);
		//显示窗口
		menuWindow.showAtLocation(findViewById(R.id.result_lin), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);

		return false;
	}


	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add("menu");
		return super.onPrepareOptionsMenu(menu);
	}
	//为弹出窗口实现监听类
	private OnClickListener  itemsOnClick = new OnClickListener(){

		public void onClick(View v) {
			menuWindow.dismiss();
			switch (v.getId()) {
				case R.id.help:
					Intent intents = new Intent(ResultActivity.this,helpActivity.class);
					ResultActivity.this.startActivity(intents);
					break;
				case R.id.exit:
					ResultActivity.this.finish();
					break;
				case R.id.cancel:
					Intent intent = new Intent(ResultActivity.this,LoginActivity.class);
					ResultActivity.this.startActivity(intent);
					ResultActivity.this.finish();
					break;
				case R.id.about:
					Intent intent1 = new Intent(ResultActivity.this,AboutActivity.class);
					ResultActivity.this.startActivity(intent1);
//				ResultActivity.this.finish();
					break;
				default:
					break;
			}


		}

	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
			long currentTime = System.currentTimeMillis();
			if((currentTime-touchTime)>=waitTime) {
				Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
				touchTime = currentTime;
			}else {
				finish();
				//退出后关闭进程
				android.os.Process.killProcess(android.os.Process.myPid());
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);


	}

}
