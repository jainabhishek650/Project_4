package abhishek.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Image extends AppCompatActivity {
ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        im=(ImageView)findViewById(R.id.imageView10);

        Bundle b=getIntent().getBundleExtra("bundle_image");
        String ur=b.getString("image_get");
        Picasso.with(Image.this).load(ur).into(im);
        PhotoViewAttacher ph=new PhotoViewAttacher(im);


    }
}
