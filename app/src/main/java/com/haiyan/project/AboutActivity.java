package com.haiyan.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
/**
 * ���ڽ���
 * @author haiyan
 *
 */
public class AboutActivity extends Activity {
	private ImageButton about;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//û�б�����
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about);
		about = (ImageButton) findViewById(R.id.about_back);
		about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				AboutActivity.this.finish();
			}
		});
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			
			AboutActivity.this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
