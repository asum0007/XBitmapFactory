package com.asum.xbitmapfactory.utils.model;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;

public class BitmapToAssignSize {
	public static Bitmap toAssignSize(Bitmap bitmap, double width, double height, boolean recycle) {
		if (recycle) {
			return ThumbnailUtils.extractThumbnail(bitmap, (int) width, (int) height, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		} else {
			return ThumbnailUtils.extractThumbnail(bitmap, (int) width, (int) height);
		}
	}
}
