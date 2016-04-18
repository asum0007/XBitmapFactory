package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class BitmapToSingleColor {
	public static Bitmap toSingleColor(Bitmap bitmap, int color, boolean recycle, Quality quality) {
		// 创建新的位图
		Bitmap mAlphaBitmap = null;
		if (quality == Quality.HIGHT) {
			mAlphaBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		} else if (quality == Quality.NORMAL) {
			mAlphaBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_4444);
		} else if (quality == Quality.LOW) {
			mAlphaBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.RGB_565);
		}

		Canvas mCanvas = new Canvas(mAlphaBitmap);
		Paint mPaint = new Paint();

		mPaint.setColor(color);
		// 从原位图中提取只包含alpha的位图
		Bitmap alphaBitmap = bitmap.extractAlpha();
		// 在画布上（mAlphaBitmap）绘制alpha位图
		mCanvas.drawBitmap(alphaBitmap, 0, 0, mPaint);

		if (recycle) {
			bitmap.recycle();
		}

		return mAlphaBitmap;
	}
}
