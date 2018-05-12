package com.haiyan.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * ��¼����
 * @author haiyan
 *
 */
public class LoginActivity extends Activity {
	private Button login;
	private EditText username,passwor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//û������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		findViewId();
		listener();
	}

	private void findViewId() {
		login = (Button) findViewById(R.id.login_activity_login);
		username = (EditText) findViewById(R.id.username);
		passwor = (EditText) findViewById(R.id.password);
		//sssss
	}
	private void listener() {
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user = username.getText().toString().trim();
				String pass = passwor.getText().toString().trim();
				if(!user.trim().equals("")&&!pass.trim().equals("")) {

					if("406".equals(user)&&"406".equals(pass)) {
						Intent intent = new Intent(LoginActivity.this, MainActivity.class);
						startActivity(intent);
						finish();
					} else if ("406".equals(user)&&!"406".equals(pass)) {
						Toast.makeText(getApplicationContext(),R.string.pass_miss, Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(getApplicationContext(),R.string.login_lose, Toast.LENGTH_SHORT).show();
					}
				} else if (user.equals("")&&!pass.equals("")) {
					Toast.makeText(getApplicationContext(),R.string.user_isnotnull, Toast.LENGTH_SHORT).show();

				} else if (!user.equals("")&&pass.equals("")){
					Toast.makeText(getApplicationContext(),R.string.pass_isnotnull, Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(),R.string.user_pass_isnotnull, Toast.LENGTH_SHORT).show();
				}

			}
		});
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		    return true;
	      }
		 return super.onKeyDown(keyCode, event);
	}
}
