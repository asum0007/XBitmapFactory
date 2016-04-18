package com.asum.xbitmapfactory.utils.model;

import java.io.File;

import android.graphics.Bitmap;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;

public class CreateBitmapFromFilePath {
	public static Bitmap fromFilePath(String filePath, Quality quality) {
		File file = new File(filePath);
		return CreateBitmapFromFile.fromFile(file, quality);
	}
}
