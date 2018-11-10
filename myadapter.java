package abhishek.project4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by HP on 08/10/2018.
 */


public class myadapter extends RecyclerView.Adapter<myadapter.MyViewholder> {
    List<nature_model> objectlist;
    LayoutInflater inflater;
    OnItemClickListener clickListener;

    public myadapter(Context c, List<nature_model> l) {
        inflater = LayoutInflater.from(c);
        objectlist = l;
    }



    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.cardview, parent, false);
        MyViewholder holder = new MyViewholder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, final int position) {

     nature_model nat=objectlist.get(position);
      holder.setdata(nat,position);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               clickListener.onItemClick(v,position);
           }
       });
    }


    @Override
    public int getItemCount() {
        return objectlist.size();
    }


    class MyViewholder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tx;
        int po;
        nature_model nm;

        public MyViewholder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.imageView5);
            tx = (TextView) itemView.findViewById(R.id.textView2);
        }

        public void setdata(nature_model s, int posi) {
            im.setImageResource(s.getimage());
            tx.setText(s.getname());
            this.po=posi;
            nm=s;

        }

    }
    public interface OnItemClickListener {

        void onItemClick(View view, int position);
    }
    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


}


