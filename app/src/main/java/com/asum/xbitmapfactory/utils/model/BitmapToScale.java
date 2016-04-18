package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class BitmapToScale {
	public static Bitmap toScale(Bitmap bitmap, float scale, boolean recycle, Quality quality) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		Matrix matrix = new Matrix();
		matrix.preScale(scale, scale);
		Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

		if (recycle) {
			bitmap.recycle();
		}

		return mScaleBitmap;
	}
}
