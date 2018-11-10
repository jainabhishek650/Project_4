package abhishek.project4;

import android.content.Context;
import android.media.ImageReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import static abhishek.project4.R.id.imageView;

/**
 * Created by HP on 22/08/2017.
 */

public class custom_mengrid extends BaseAdapter {
    int img[];
    Context c;


    public custom_mengrid(Context cw, int ar[])
    {
        c=cw;
        img=ar;
    }



    @Override
    public int getCount() {

        return img.length;
    }

    @Override
    public Object getItem(int i) {
        return img[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {

        LayoutInflater lo= (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=lo.inflate(R.layout.mensgrid,null);

        ImageView im=(ImageView)v.findViewById(R.id.imageView4);
        im.setImageResource(img[position]);

        return im;

    }

}
