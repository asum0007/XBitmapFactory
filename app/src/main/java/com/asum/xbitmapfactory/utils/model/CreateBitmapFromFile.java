package com.asum.xbitmapfactory.utils.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class CreateBitmapFromFile {
	public static Bitmap fromFile(File file, Quality quality) {
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
		try {
			InputStream inputStream = new FileInputStream(file);
			return BitmapFactory.decodeStream(inputStream, null, option);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
