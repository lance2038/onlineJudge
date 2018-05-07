package com.haiyan.project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
/**
 * 程序启动页面
 * @author haiyan
 *
 */
public class StartActivity extends Activity {
	private static final long SPLASH_DISPLAY_LENGHT = 2000;
	boolean isFirstIn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//全屏显示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.start);


		//读取SharedPreFerences中需要的数据,使用SharedPreFerences来记录程序启动的使用次数
		SharedPreferences preferences = getSharedPreferences("haiyan", Activity.MODE_PRIVATE);
		//取得相应的值,如果没有该值,说明还未写入,用true作为默认值
		isFirstIn = preferences.getBoolean("haiyan", true);
		if (!isFirstIn) {
			new Handler().postDelayed(new Runnable(){
				@Override
				public void run() {
					Intent Intent = new Intent(StartActivity.this,LoginActivity.class);
					startActivity(Intent);
					finish();
					//动画效果
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				}
				//延迟时间
			}, SPLASH_DISPLAY_LENGHT); //new Handler().postDelayed(r, delayMillis)
		} else {
			new Handler().postDelayed(new Runnable(){
				@Override
				public void run() {
					Intent intent = new Intent(StartActivity.this, NavigationActivity.class);
					startActivity(intent);
					finish();
					//动画效果
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				}
				//延迟时间
			}, SPLASH_DISPLAY_LENGHT);


		}

	}
}
