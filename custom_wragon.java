package abhishek.project4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by HP on 17/10/2018.
 */

public class custom_wragon extends BaseAdapter {
    Context c;
   String br[],pri[],des[],ima[];
    public ImageView im;
    public TextView t1,t2,t3;
    custom_wragon (Context ce,String b[],String m[],String d[],String i[]){
   c=ce;
        br=b;
        pri=m;
        des=d;
        ima=i;
    }

    @Override
    public int getCount() {
        return ima.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        if(v==null) {

            LayoutInflater l = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = l.inflate(R.layout.wragon_list, null);
        }

    im = (ImageView) v.findViewById(R.id.imageView8);
             t1 = (TextView) v.findViewById(R.id.textView3);
             t2 = (TextView) v.findViewById(R.id.textView4);
             t3 = (TextView) v.findViewById(R.id.textView5);


    Picasso.with(c).load(ima[position]).tag(c).resize(178,260).into(im);
    t1.setText(" " + br[position]);
    t2.setText(" " + "\u20B9" + pri[position]);
    t3.setText(" " + des[position]);


        return v;
    }
}
