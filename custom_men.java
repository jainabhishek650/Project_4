package abhishek.project4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 22/08/2017.
 */

public class custom_men extends BaseAdapter {
    TextView t1;
    Context c;
    int image1[]={R.drawable.casual,R.drawable.sports,R.drawable.formal,R.drawable.sandals,R.drawable.flipflops};
    String st[]={"CASUAL SHOES","SPORTS SHOES","FORMAL SHOES","SANDALS","FLIP FLOPS"};



    public  custom_men(Context cw)
    {
        c=cw;
    }


    @Override
    public int getCount() {
       return image1.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {


        LayoutInflater lo= (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=lo.inflate(R.layout.mens,null);

        TextView t1= (TextView)v.findViewById(R.id.textView);
        ImageView im=(ImageView)v.findViewById(R.id.imageView3);
        t1.setText(st[i]);
        im.setImageResource(image1[i]);
        return v;
    }


}
