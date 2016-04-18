package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class BitmapToScrew {
	public static Bitmap toScrew(Bitmap bitmap, float screwX, float screwY, boolean recycle, Quality quality) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		Matrix matrix = new Matrix();
		matrix.preSkew(screwX, screwY);
		Bitmap mScrewBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

		if (recycle) {
			bitmap.recycle();
		}

		return mScrewBitmap;
	}
}
