package com.haiyan.project;

import java.util.ArrayList;
import java.util.List;

import com.haiyan.adapter.GuideAdapter;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 初始化程序导航页
 * @author haiyan
 *
 */
public class NavigationActivity extends Activity implements OnPageChangeListener {
	boolean isFirstIn;
	private ViewPager viewPager;//滑动的页
	private List<View> list;
	// 底部小点图片
	private ImageView[] dots;
	// 记录当前选中位置
	private int currentIndex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//全屏显示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.navigation);

		viewPager = (ViewPager) findViewById(R.id.vp1);
		LayoutInflater inflater = LayoutInflater.from(NavigationActivity.this);


		list = new ArrayList<View>();
		// 初始化引导图片列表
		list.add(inflater.inflate(R.layout.start_one, null));
		list.add(inflater.inflate(R.layout.start_two, null));
		list.add(inflater.inflate(R.layout.start_three, null));
		list.add(inflater.inflate(R.layout.start_four, null));

		viewPager.setAdapter(new GuideAdapter(this,list));
		viewPager.setOnPageChangeListener(this);

		initDots();
	}
	/**
	 * 圆点
	 */
	private void initDots() {
		LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

		dots = new ImageView[list.size()];

		// 循环取得小点图片
		for (int i = 0; i < list.size(); i++) {
			dots[i] = (ImageView) ll.getChildAt(i);
			dots[i].setEnabled(true);// 都设为灰色
		}

		currentIndex = 0;
		dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
	}

	private void setCurrentDot(int position) {
		if (position < 0 || position > list.size() - 1 || currentIndex == position) {
			return;
		}

		dots[position].setEnabled(false);
		dots[currentIndex].setEnabled(true);

		currentIndex = position;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		setCurrentDot(arg0);
	}



}
