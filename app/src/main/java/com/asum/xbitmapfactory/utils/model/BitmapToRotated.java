package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class BitmapToRotated {
	public static Bitmap toRotated(Bitmap bitmap, float rotated, boolean recycle) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		Matrix matrix = new Matrix();
		matrix.preRotate(rotated);
		Bitmap mRotateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);

		if (recycle) {
			bitmap.recycle();
		}

		return mRotateBitmap;
	}
}
