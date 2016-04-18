package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class BitmapToRound {
	public static Bitmap toRound(Bitmap bitmap, double round, boolean recycle, Quality quality) {
		// 创建新的位图
		Bitmap bgBitmap = null;
		if (quality == Quality.HIGHT) {
			bgBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		} else if (quality == Quality.NORMAL) {
			bgBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_4444);
		} else if (quality == Quality.LOW) {
			bgBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.RGB_565);
		}
		// 把创建的位图作为画板
		Canvas mCanvas = new Canvas(bgBitmap);

		Paint mPaint = new Paint();
		Rect mRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		RectF mRectF = new RectF(mRect);
		mPaint.setAntiAlias(true);
		// 先绘制圆角矩形
		mCanvas.drawRoundRect(mRectF, (float) (round), (float) round, mPaint);
		// 设置图像的叠加模式
		mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		// 绘制图像
		mCanvas.drawBitmap(bitmap, mRect, mRect, mPaint);

		if (recycle) {
			bitmap.recycle();
		}

		return bgBitmap;
	}
}
