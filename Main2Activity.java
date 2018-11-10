package abhishek.project4;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;



public class Main2Activity extends AppCompatActivity {
    ImageView im;
    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent it=getIntent();
        Bundle bn=getIntent().getBundleExtra("bundle2");

        int positio=it.getExtras().getInt("bundle");
        int position2[]=bn.getIntArray("array");

       //custom_mengrid ap=new custom_mengrid(this, position2);
        //im=(ImageView)findViewById(R.id.imageView6);
       // im.setImageResource(ap.img[positio]);


        vp=(ViewPager)findViewById(R.id.pager);
        image_slider is=new image_slider(this,position2);
        vp.setAdapter(is);
        vp.setCurrentItem(positio);

    }
}
