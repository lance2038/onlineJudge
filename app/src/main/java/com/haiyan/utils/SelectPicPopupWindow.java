package com.haiyan.utils;
import com.haiyan.project.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * �Զ���˵�
 * @author haiyan
 *
 */
public class SelectPicPopupWindow extends PopupWindow {


	public static Activity at;
	private Button help, exit, cancle,about;
	private View mMenuView;
    public SelectPicPopupWindow() {
	// TODO Auto-generated constructor stub
    }
	public SelectPicPopupWindow(Activity context,OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.menu, null);
		findViewId();
		listener(itemsOnClick);
		//����SelectPicPopupWindow��View
		this.setContentView(mMenuView);
		//���õ�������Ŀ�
		this.setWidth(LayoutParams.MATCH_PARENT);
		//���õ�������ĸ�
		this.setHeight(LayoutParams.WRAP_CONTENT);
		//���õ�������ɵ��
		this.setFocusable(true);
		//���õ������嶯��Ч��
		this.setAnimationStyle(R.style.AnimBottom);
		//��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		//����SelectPicPopupWindow��������ı���
		this.setBackgroundDrawable(dw);
		//��������
		mMenuView.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y=(int) event.getY();
				if(event.getAction()==MotionEvent.ACTION_UP){
					if(y<height){
						dismiss();
					}
				}				
				return true;
			}
		});

	}
	private void findViewId() {
		help = (Button) mMenuView.findViewById(R.id.help);
		exit = (Button) mMenuView.findViewById(R.id.exit);
		cancle = (Button) mMenuView.findViewById(R.id.cancel);
		about = (Button) mMenuView.findViewById(R.id.about);
	}
	private void listener(OnClickListener onClickListener) {
		help.setOnClickListener(onClickListener);
		exit.setOnClickListener(onClickListener);
		cancle.setOnClickListener(onClickListener);
		about.setOnClickListener(onClickListener);
	}
	
}


