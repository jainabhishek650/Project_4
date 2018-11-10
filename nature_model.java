package abhishek.project4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 08/10/2018.
 */

public class nature_model {
   int position;
    String sc;

   public int getimage(){
        return position;
    }
    public void setimage(int im){
        this.position=im;
    }
    public String getname(){
        return sc;
    }
    public void setname(String st){
        this.sc=st;
    }

    public static List<nature_model>getobjectist(){
        List<nature_model> li=new ArrayList<>();
        int imag[]={R.drawable.mensicon,R.drawable.womenicon,R.drawable.kids_icon,R.drawable.home_icon};
         String sc[]={"MEN","WOMEN","KIDS","HOME"};

        for(int i=0;i<imag.length;i++){
            nature_model n=new nature_model();
            n.setimage(imag[i]);
            n.setname(sc[i]);
            li.add(n);

        }return li;

    }

}
