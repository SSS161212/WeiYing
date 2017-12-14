package com.bwie.lithography;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

public class FoldSlidingPaneLayout extends SlidingPaneLayout {
	private float mEdgeSlop;
	private float mInitialMotionX;
	private float mInitialMotionY;

	public FoldSlidingPaneLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		ViewConfiguration config = ViewConfiguration.get(context);
		mEdgeSlop = config.getScaledEdgeSlop();

	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();

		View child = getChildAt(0);
		if (child != null) {

			removeView(child);
			final FoldLayout foldLayout = new FoldLayout(getContext());
			// foldLayout.setAnchor(0);
			foldLayout.addView(child);
			ViewGroup.LayoutParams layPar = child.getLayoutParams();
			addView(foldLayout, 0, layPar);

			setPanelSlideListener(new PanelSlideListener() {

				@Override
				public void onPanelSlide(View arg0, float arg1) {
					foldLayout.setFactor(arg1);
				}

				@Override
				public void onPanelOpened(View arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onPanelClosed(View arg0) {

				}
			});

		}
	}

	// �Լ����ϵġ�������Χ����Ϊֻ���ڱ�Ե����������������ϵ�����������ͻ
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (MotionEventCompat.getActionMasked(ev)) {
		case MotionEvent.ACTION_DOWN: {
			mInitialMotionX = ev.getX();
			mInitialMotionY = ev.getY();
			break;
		}

		case MotionEvent.ACTION_MOVE: {
			final float x = ev.getX();
			final float y = ev.getY();
			//�����ָ���µ�λ�õ�x����>1,��ȡ�������������ܻ���
			if (mInitialMotionX > 1) {
				MotionEvent cancelEvent = MotionEvent.obtain(ev);
				cancelEvent.setAction(MotionEvent.ACTION_CANCEL);
				return super.onInterceptTouchEvent(cancelEvent);
			}
		}
		}

		return super.onInterceptTouchEvent(ev);
	}
}
