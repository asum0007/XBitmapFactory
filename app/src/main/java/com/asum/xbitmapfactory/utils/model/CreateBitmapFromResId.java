package com.asum.xbitmapfactory.utils.model;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class CreateBitmapFromResId {
	public static Bitmap fromResId(Context context, int resId, Quality quality) {
		BitmapFactory.Options option = new BitmapFactory.Options();
		if (quality == Quality.HIGHT) {
			option.inPreferredConfig = Bitmap.Config.ARGB_8888;
		} else if (quality == Quality.NORMAL) {
			option.inPreferredConfig = Bitmap.Config.ARGB_4444;
		} else if (quality == Quality.LOW) {
			option.inPreferredConfig = Bitmap.Config.RGB_565;
		}
		option.inPurgeable = true;
		option.inInputShareable = true;
		InputStream inputStream = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(inputStream, null, option);
	}

	public static Bitmap fromResId(Context context, int resId, double w, double h, Quality quality) {
		Bitmap bitmap = null;
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;

		InputStream inputStream = context.getResources().openRawResource(resId);
		BitmapFactory.decodeStream(inputStream, null, opts);

		opts.inSampleSize = computeSampleSize(opts, -1, (int) (w * h));
		opts.inJustDecodeBounds = false;
		try {
			bitmap = BitmapFactory.decodeStream(inputStream, null, opts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}

	public static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
		int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);
		int roundedSize;
		if (initialSize <= 8) {
			roundedSize = 1;
			while (roundedSize < initialSize) {
				roundedSize <<= 1;
			}
		} else {
			roundedSize = (initialSize + 7) / 8 * 8;
		}
		return roundedSize;
	}

	private static int computeInitialSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
		double w = options.outWidth;
		double h = options.outHeight;
		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(Math.floor(w / minSideLength), Math.floor(h / minSideLength));
		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}
		if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
			return 1;
		} else if (minSideLength == -1) {
			return lowerBound;
		} else {
			return upperBound;
		}
	}
}
