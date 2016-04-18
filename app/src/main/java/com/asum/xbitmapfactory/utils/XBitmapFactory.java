package com.asum.xbitmapfactory.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

import com.asum.xbitmapfactory.utils.XBitmap.Quality;
import com.asum.xbitmapfactory.utils.model.BitmapToAssignSize;
import com.asum.xbitmapfactory.utils.model.BitmapToCircle;
import com.asum.xbitmapfactory.utils.model.BitmapToGray;
import com.asum.xbitmapfactory.utils.model.BitmapToRectFPath;
import com.asum.xbitmapfactory.utils.model.BitmapToRectPath;
import com.asum.xbitmapfactory.utils.model.BitmapToReflected;
import com.asum.xbitmapfactory.utils.model.BitmapToRotated;
import com.asum.xbitmapfactory.utils.model.BitmapToRound;
import com.asum.xbitmapfactory.utils.model.BitmapToScale;
import com.asum.xbitmapfactory.utils.model.BitmapToScrew;
import com.asum.xbitmapfactory.utils.model.BitmapToSingleColor;

/**
 * Bitmap加工厂
 * 
 * @author Asum
 * 
 */
public class XBitmapFactory {
	/**
	 * 将Bitmap添加圆角
	 * 
	 * @param bitmap
	 *            源
	 * @param round
	 *            圆角像素
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 圆角Bitmap
	 */
	public static Bitmap toRound(Bitmap bitmap, double round, boolean recycle, Quality quality) {
		return BitmapToRound.toRound(bitmap, round, recycle, quality);
	}

	/**
	 * 将Bitmap转成圆形，注：前提是bitmap是一个正方形，否则将返回一个椭圆bitmap
	 * 
	 * @param bitmap
	 *            源
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 圆形Bitmap
	 */
	public static Bitmap toCircle(Bitmap bitmap, boolean recycle, Quality quality) {
		return BitmapToCircle.toCircle(bitmap, recycle, quality);
	}

	/**
	 * 将Bitmap灰度化
	 * 
	 * @param bitmap
	 *            源
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 灰度化Bitmap
	 */
	public static Bitmap toGray(Bitmap bitmap, boolean recycle, Quality quality) {
		return BitmapToGray.toGray(bitmap, recycle, quality);
	}

	/**
	 * 将Bitmap转换成一种颜色，覆盖原轮廓
	 * 
	 * @param bitmap
	 *            源
	 * @param color
	 *            覆盖的颜色
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 覆盖后的Bitmap
	 */
	public static Bitmap toSingleColor(Bitmap bitmap, double color, boolean recycle, Quality quality) {
		return BitmapToSingleColor.toSingleColor(bitmap, (int) color, recycle, quality);
	}

	/**
	 * 将Bitmap装换成指定大小
	 * 
	 * @param bitmap
	 *            源
	 * @param width
	 *            指定宽
	 * @param height
	 *            指定高
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @return 改变大小后的Bitmap
	 */
	public static Bitmap toAssignSize(Bitmap bitmap, double width, double height, boolean recycle) {
		return BitmapToAssignSize.toAssignSize(bitmap, width, height, recycle);
	}

	/**
	 * 将Bitmap按比例缩放
	 * 
	 * @param bitmap
	 *            源
	 * @param scale
	 *            倍率
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 缩放的bitmap
	 */
	public static Bitmap toScale(Bitmap bitmap, double scale, boolean recycle, Quality quality) {
		return BitmapToScale.toScale(bitmap, (float) scale, recycle, quality);
	}

	/**
	 * 将Bitmap旋转指定的角度
	 * 
	 * @param bitmap
	 *            源
	 * @param rotated
	 *            角度
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @return 旋转角度后的Bitmap
	 */
	public static Bitmap toRotated(Bitmap bitmap, double rotated, boolean recycle) {
		return BitmapToRotated.toRotated(bitmap, (float) rotated, recycle);
	}

	/**
	 * 将Bitmap倾斜指定比例
	 * 
	 * @param bitmap
	 *            源
	 * @param screwX
	 *            X轴方向倾斜（取值0.5为顺时针倾斜45度）
	 * @param screwY
	 *            Y轴方向倾斜（取值0.5为顺时针倾斜45度）
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 倾斜之后的Bitmap
	 */
	public static Bitmap toScrew(Bitmap bitmap, double screwX, double screwY, boolean recycle, Quality quality) {
		return BitmapToScrew.toScrew(bitmap, (float) screwX, (float) screwY, recycle, quality);
	}

	/**
	 * 创建带投影效果的Bitmap
	 * 
	 * @param bitmap
	 *            源
	 * @param reflect
	 *            投影占源Bitmap的比例（<1）
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 带投影效果的Bitmap
	 */
	public static Bitmap toReflected(Bitmap bitmap, double reflect, boolean recycle, Quality quality) {
		return BitmapToReflected.toReflected(bitmap, (float) reflect, recycle, quality);
	}

	/**
	 * 将Bitmap截取一个矩形区域
	 * 
	 * @param bitmap
	 *            源
	 * @param x
	 *            矩形X坐标（传入-1代表X轴居中）
	 * @param y
	 *            矩形Y坐标（传入-1代表Y轴居中）
	 * @param w
	 *            矩形的宽
	 * @param h
	 *            矩形的高
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @return 矩形区域的Bitmap
	 */
	public static Bitmap toRectPath(Bitmap bitmap, double x, double y, double w, double h, boolean recycle) {
		return BitmapToRectPath.toRectPath(bitmap, (int) x, (int) y, (int) w, (int) h, recycle);
	}

	/**
	 * 将Bitmap截取一个圆角矩形区域
	 * 
	 * @param bitmap
	 *            源
	 * @param x
	 *            矩形X坐标（传入-1代表X轴居中）
	 * @param y
	 *            矩形Y坐标（传入-1代表Y轴居中）
	 * @param w
	 *            矩形的宽
	 * @param h
	 *            矩形的高
	 * @param round
	 *            圆角度数
	 * @param recycle
	 *            是否释放原bitmap占用的内存
	 * @param quality
	 *            bitmap质量
	 * @return 矩形区域的Bitmap
	 */
	public static Bitmap toRectFPath(Bitmap bitmap, double x, double y, double w, double h, double round, boolean recycle, Quality quality) {
		return BitmapToRectFPath.toRectFPath(bitmap, (int) x, (int) y, (int) w, (int) h, (int) round, recycle, quality);
	}

	public static Bitmap covertToPath(Bitmap bitmap, boolean recycle) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Bitmap bm = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		Canvas canvas = new Canvas(bm);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		canvas.drawBitmap(bitmap, 0, 0, paint);

		int deltX = 76;
		int deltY = 98;
		DashPathEffect dashStyle = new DashPathEffect(new float[] { 10, 5, 5, 5 }, 2);// 创建虚线边框样式
		RectF faceRect = new RectF(0, 0, 88, 106);
		float[] faceCornerii = new float[] { 30, 30, 30, 30, 75, 75, 75, 75 };
		Paint mPaint = new Paint();// 创建画笔
		mPaint.setColor(0xFF6F8DD5);
		mPaint.setStrokeWidth(6);
		mPaint.setPathEffect(dashStyle);
		Path clip = new Path();// 创建路径
		clip.reset();
		clip.addRoundRect(faceRect, faceCornerii, Direction.CW);// 添加圆角矩形路径
		canvas.save();// 保存画布
		canvas.translate(deltX, deltY);
		canvas.clipPath(clip, Region.Op.DIFFERENCE);
		canvas.drawColor(0xDF222222);
		canvas.drawPath(clip, mPaint);// 绘制路径
		canvas.restore();

		Rect srcRect = new Rect(0, 0, 88, 106);
		srcRect.offset(deltX, deltY);
		PaintFlagsDrawFilter dfd = new PaintFlagsDrawFilter(Paint.ANTI_ALIAS_FLAG, Paint.FILTER_BITMAP_FLAG);
		canvas.setDrawFilter(dfd);
		canvas.clipPath(clip);// 使用路径剪切画布
		canvas.drawBitmap(bitmap, srcRect, faceRect, mPaint);

		return bm;
	}
}
