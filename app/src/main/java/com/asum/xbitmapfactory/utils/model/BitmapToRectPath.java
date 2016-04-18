package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

public class BitmapToRectPath {
	public static Bitmap toRectPath(Bitmap bitmap, int x, int y, int w, int h, boolean recycle) {
		if (x == -1) {
			x = (bitmap.getWidth() - w) / 2;
		}
		if (y == -1) {
			y = (bitmap.getHeight() - h) / 2;
		}

		// 创建新的位图
		Bitmap bgBitmap = Bitmap.createBitmap(bitmap, x, y, w, h, new Matrix(), false);
		// 把创建的位图作为画板
		Canvas mCanvas = new Canvas(bgBitmap);

		Paint mPaint = new Paint();
		Rect mRect = new Rect(0, 0, w, h);
		Rect mRect2 = new Rect(x, y, x + w, y + h);
		mPaint.setAntiAlias(true);
		// 先绘制矩形
		mCanvas.drawRect(mRect, mPaint);
		// 设置图像的叠加模式
		mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		// 绘制图像
		mCanvas.drawBitmap(bitmap, mRect2, mRect, mPaint);

		if (recycle) {
			bitmap.recycle();
		}
		return bgBitmap;
	}
}
