package com.asum.xbitmapfactory.utils;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;
import com.asum.xbitmapfactory.utils.model.CreateBitmapFromFile;
import com.asum.xbitmapfactory.utils.model.CreateBitmapFromFilePath;
import com.asum.xbitmapfactory.utils.model.CreateBitmapFromResId;

/**
 * Bitmap创造者
 * 
 * @author Asum
 * 
 */
public class XBitmapCreator {
	/**
	 * 根据R文件ID获取Bitmap
	 * 
	 * @param context
	 *            上下文对象
	 * @param resId
	 *            R文件ID
	 * @param quality
	 *            Bitmap质量
	 * @return Bitmap
	 */
	public static Bitmap fromResId(Context context, int resId, Quality quality) {
		return CreateBitmapFromResId.fromResId(context, resId, quality);
	}

	/**
	 * 根据R文件ID获取Bitmap
	 * 
	 * @param context
	 *            上下文对象
	 * @param resId
	 *            R文件ID
	 * @param w
	 *            最大宽
	 * @param h
	 *            最大高
	 * @param quality
	 *            Bitmap质量
	 * @return Bitmap
	 */
	public static Bitmap fromResId(Context context, int resId, double w, double h, Quality quality) {
		return CreateBitmapFromResId.fromResId(context, resId, w, h, quality);
	}

	/**
	 * 根据文件路径获取Bitmap
	 * 
	 * @param filePath
	 *            文件路径
	 * @param quality
	 *            Bitmap质量
	 * @return
	 */
	public static Bitmap fromFilePath(String filePath, Quality quality) {
		return CreateBitmapFromFilePath.fromFilePath(filePath, quality);
	}

	/**
	 * 根据文件流获取Bitmap
	 * 
	 * @param file
	 * @param quality
	 * @return
	 */
	public static Bitmap fromFile(File file, Quality quality) {
		return CreateBitmapFromFile.fromFile(file, quality);
	}
}
