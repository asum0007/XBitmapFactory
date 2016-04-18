package com.asum.xbitmapfactory;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.asum.xbitmapfactory.utils.XBitmap;
import com.asum.xbitmapfactory.utils.XBitmapCreator;
import com.asum.xbitmapfactory.utils.XBitmapFactory;

public class BitmapFactoryMainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_factory_main);

        LinearLayout contentLayout = (LinearLayout) findViewById(R.id.activity_bitmapfactory_content_layout);
        contentLayout.setBackgroundColor(Color.WHITE);
        contentLayout.setOrientation(LinearLayout.VERTICAL);

        ImageView imageView1 = new ImageView(getApplicationContext());
        Bitmap bitmap1 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView1.setImageBitmap(XBitmapFactory.toAssignSize(bitmap1, 100, 100, true));
        contentLayout.addView(imageView1);

        ImageView imageView2 = new ImageView(getApplicationContext());
        Bitmap bitmap2 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView2.setImageBitmap(XBitmapFactory.toCircle(bitmap2, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView2);

        ImageView imageView3 = new ImageView(getApplicationContext());
        Bitmap bitmap3 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView3.setImageBitmap(XBitmapFactory.toGray(bitmap3, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView3);

        ImageView imageView4 = new ImageView(getApplicationContext());
        Bitmap bitmap4 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView4.setImageBitmap(XBitmapFactory.toRectPath(bitmap4, 50, 50, 400, 300, true));
        contentLayout.addView(imageView4);

        ImageView imageView5 = new ImageView(getApplicationContext());
        Bitmap bitmap5 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView5.setImageBitmap(XBitmapFactory.toRectFPath(bitmap5, -1, -1, 400, 300, 50, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView5);

        ImageView imageView6 = new ImageView(getApplicationContext());
        Bitmap bitmap6 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView6.setImageBitmap(XBitmapFactory.toReflected(bitmap6, 0.2, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView6);

        ImageView imageView7 = new ImageView(getApplicationContext());
        Bitmap bitmap7 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView7.setImageBitmap(XBitmapFactory.toRotated(bitmap7, 45, true));
        contentLayout.addView(imageView7);

        ImageView imageView8 = new ImageView(getApplicationContext());
        Bitmap bitmap8 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView8.setImageBitmap(XBitmapFactory.toRound(bitmap8, 50, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView8);

        ImageView imageView9 = new ImageView(getApplicationContext());
        Bitmap bitmap9 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView9.setImageBitmap(XBitmapFactory.toScale(bitmap9, 0.5, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView9);

        ImageView imageView10 = new ImageView(getApplicationContext());
        Bitmap bitmap10 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView10.setImageBitmap(XBitmapFactory.toScrew(bitmap10, 0.5, 0.5, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView10);

        ImageView imageView11 = new ImageView(getApplicationContext());
        Bitmap bitmap11 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, XBitmap.Quality.HIGHT);
        imageView11.setImageBitmap(XBitmapFactory.toSingleColor(bitmap11, Color.BLUE, true, XBitmap.Quality.HIGHT));
        contentLayout.addView(imageView11);

        ImageView imageView12 = new ImageView(getApplicationContext());
        Bitmap bitmap12 = XBitmapCreator.fromResId(getApplicationContext(), R.drawable.test, 400, 700, XBitmap.Quality.HIGHT);
        imageView12.setImageBitmap(bitmap12);
        contentLayout.addView(imageView12);
    }
}
