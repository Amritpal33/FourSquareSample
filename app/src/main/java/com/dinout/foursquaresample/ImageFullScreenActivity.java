package com.dinout.foursquaresample;

/**
 * Created by amritpalsingh on 08/02/16.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageFullScreenActivity extends Activity
{

    private static final String KEY_IMAGE_URL = ImageFullScreenActivity.class.getSimpleName() + ".image_url";

    public static Intent createIntent(Context context, String imageUrl)
    {
        Intent intent = new Intent(context, ImageFullScreenActivity.class);
        intent.putExtra(KEY_IMAGE_URL, imageUrl);
        return intent;
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        ImageView imageView = (ImageView) findViewById(R.id.imgFullScreen);
        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(imageView);

        String url = getIntent().getStringExtra(KEY_IMAGE_URL);
        Picasso.with(this).load(url).into(imageView);
        mAttacher.update();
    }
}
