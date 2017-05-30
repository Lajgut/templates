package ru.mbsl.duplexdx.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import ru.mbsl.duplexdx.R;

/**
 * Created by Kirill on 18.04.2017.
 */

public class ImageUtils {

    public static void setImageWithLink(String url,ImageView imgView, Context context){

        if (url != null) {
            Picasso.with(context)
                    .load(url)
                    //.placeholder(R.drawable.user_placeholder)
                    .error(R.drawable.error_zaglushka)
                    .into(imgView, new Callback() {
                        @Override
                        public void onSuccess() {
                            MsgConsole.printlnDebug("picasson done " + url);
                        }

                        @Override
                        public void onError() {
                            MsgConsole.printlnDebug("picasson fail " + url);
                        }
                    });
        }
    }

    public static void setImageInRecycler(String url, ImageView imgView, Context context) {

        Picasso.with(context)
                .load(url)
                .fit()
                .centerCrop()
                //.placeholder(R.drawable.user_placeholder)
                .error(R.drawable.error_zaglushka)
                .into(imgView);
    }

    public static void setImageWithLink(String url, ViewGroup view, Context context) {

        Picasso.with(context)
                .load(url)
                .error(R.drawable.error_zaglushka)
                .into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                view.setBackground(new BitmapDrawable(context.getResources(), bitmap));

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    public static void setImageWithLink(String url, ImageView imgView, Context context, int width, int height) {

        Picasso.with(context)
                .load(url)
                //.placeholder(R.drawable.user_placeholder)
                .error(R.drawable.error_zaglushka)
                .resize(width, height)
                .centerCrop()
                .into(imgView);
    }

}
