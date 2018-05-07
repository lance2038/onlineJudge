package com.haiyan.adapter;

import com.haiyan.project.AndroidTestFragment;
import com.haiyan.project.JavaTestFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * fragmentPagerAdapter适配器
 * @author haiyan
 *
 */
public class FragmentAdapter extends FragmentPagerAdapter {
	private static final int TAB_ANDROID = 0;
	private static final int TAB_JAVA = 1;
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	public final static int TAB_COUNT = 2;
	// 获取要滑动的控件的数量
	@Override
	public int getCount() {
//		return list.size();
		return TAB_COUNT;
	}
	@Override
	public Fragment getItem(int id) {
		// TODO Auto-generated method stub
		switch (id) {
			case TAB_ANDROID:
				new AndroidTestFragment();
				return new AndroidTestFragment();
			case TAB_JAVA:
				new JavaTestFragment();
				return new JavaTestFragment();
		}
		return null;
	}

}
