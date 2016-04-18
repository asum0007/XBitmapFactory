package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class BitmapToRectFPath {
	public static Bitmap toRectFPath(Bitmap bitmap, int x, int y, int w, int h, int round, boolean recycle, Quality quality) {
		if (x == -1) {
			x = (bitmap.getWidth() - w) / 2;
		}
		if (y == -1) {
			y = (bitmap.getHeight() - h) / 2;
		}

		bitmap = BitmapToRectPath.toRectPath(bitmap, x, y, w, h, recycle);
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;

		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);

		canvas.drawRoundRect(rectF, round, round, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		if (recycle) {
			bitmap.recycle();
		}

		return output;
	}
}
