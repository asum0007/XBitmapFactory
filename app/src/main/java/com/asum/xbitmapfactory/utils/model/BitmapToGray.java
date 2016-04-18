package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class BitmapToGray {
	public static Bitmap toGray(Bitmap bitmap, boolean recycle, Quality quality) {
		// 创建新的位图
		Bitmap bgBitmap = null;
		if (quality == Quality.HIGHT) {
			bgBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		} else if (quality == Quality.NORMAL) {
			bgBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_4444);
		} else if (quality == Quality.LOW) {
			bgBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.RGB_565);
		}
		Canvas mCanvas = new Canvas(bgBitmap);
		Paint mPaint = new Paint();

		// 创建颜色变换矩阵
		ColorMatrix mColorMatrix = new ColorMatrix();
		// 设置灰度影响范围
		mColorMatrix.setSaturation(0);
		// 创建颜色过滤矩阵
		ColorMatrixColorFilter mColorFilter = new ColorMatrixColorFilter(mColorMatrix);
		// 设置画笔的颜色过滤矩阵
		mPaint.setColorFilter(mColorFilter);
		// 使用处理后的画笔绘制图像
		mCanvas.drawBitmap(bitmap, 0, 0, mPaint);

		if (recycle) {
			bitmap.recycle();
		}

		return bgBitmap;
	}
}
