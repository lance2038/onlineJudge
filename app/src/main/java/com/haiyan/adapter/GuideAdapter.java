package com.haiyan.adapter;

import java.util.List;

import com.haiyan.project.LoginActivity;
import com.haiyan.project.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * PagerAdapter适配器
 * @author haiyan
 *
 */
public class GuideAdapter extends PagerAdapter {
	private final List<View> views;
	private final Activity activity;

	public GuideAdapter(Activity activity,List<View> views) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
		this.views = views;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		((ViewPager) container).addView(views.get(position), 0);
		if (position == views.size() - 1) {
			Button imageViewStart = (Button) container.findViewById(R.id.tiyan);
			imageViewStart.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					SharedPreferences preferences = activity.getSharedPreferences("haiyan", 0);
					Editor editor = preferences.edit();
					editor.putBoolean("haiyan", false);
					editor.commit();
					Intent intent = new Intent(activity, LoginActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}

			});
		}
		return views.get(position);
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
}
