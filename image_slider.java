package abhishek.project4;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by HP on 01/09/2017.
 */

public class image_slider extends PagerAdapter {

    Context c;
    int image[];


    public image_slider(Context cx, int ar[])
    {
        c=cx;
        image=ar;

    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater ly=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=ly.inflate(R.layout.slider,container,false);
        ImageView im=(ImageView)view.findViewById(R.id.imageView6);

        im.setImageResource(image[position]);
        PhotoViewAttacher ph=new PhotoViewAttacher(im);

        ViewPager vp=(ViewPager)container;
        vp.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);

    }
}
