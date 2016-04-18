package com.asum.xbitmapfactory.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * 控件填充者
 * 
 * @author Asum
 * 
 */
public class XBitmapFillter {
	public static void fill(ImageView imageView, int resId, double w, double h) {
		Bitmap bitmap = null;
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;

		InputStream inputStream = imageView.getContext().getResources().openRawResource(resId);
		BitmapFactory.decodeStream(inputStream, null, opts);

		double wScale = w / opts.outWidth;
		double bitmapH = opts.outHeight * wScale;
		double bitmapW = w;

		if (bitmapH < h) {
			double hScale = h / opts.outHeight;
			bitmapH = h;
			bitmapW = opts.outWidth * hScale;
		}

		opts.inSampleSize = computeSampleSize(opts, -1, (int) (bitmapW * bitmapH));
		opts.inJustDecodeBounds = false;
		bitmap = BitmapFactory.decodeStream(inputStream, null, opts);

		imageView.setImageBitmap(bitmap);
	}

	private static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
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
