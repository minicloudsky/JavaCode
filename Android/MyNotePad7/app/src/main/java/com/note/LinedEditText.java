package com.note;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

public class LinedEditText extends EditText {
	private Rect mRect;
	private Paint mPaint;
	// we need this constructor for LayoutInflater
	public LinedEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		mRect = new Rect();
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.BLUE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int count = getLineCount();
		Rect r = mRect;
		Paint paint = mPaint;

		for (int i = 0; i < count; i++) {
			int baseline = getLineBounds(i, r);

			canvas.drawLine(r.left, baseline + 5, r.right, baseline + 5, paint);
		}

		super.onDraw(canvas);
	}

}
