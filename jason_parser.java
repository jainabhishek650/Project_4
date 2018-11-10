package abhishek.project4;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HP on 13/10/2018.
 */

public class jason_parser {

    public static String[] mrp;
    public static String[] brand;
    public static String[] description;
    public static String[] image;
    public static String[] size;
    public static Integer[] id;



    public static final String Json_array="result";
    public static final String mrp_key="Mrp";
    public static final String description_key="Description";
    public static final String brand_key="Brand";
    public static final String image_key="Image";
    public static final String size_key="Size";
    public static final String id_key="Id";


    public static String json;

    jason_parser(String st){
         this.json=st;
    }

    protected static void parsejson(){
          JSONObject js=null;
        try {
              js=new JSONObject(json);
            JSONArray ja=js.getJSONArray(Json_array);

            mrp=new String[ja.length()];
            brand=new String[ja.length()];
            description=new String[ja.length()];
            image=new String[ja.length()];
            size=new String[ja.length()];
            id=new Integer[ja.length()];

            for (int i=0;i<ja.length();i++){
                 JSONObject j2=ja.getJSONObject(i);

                brand[i]=j2.getString(brand_key);
                description[i]=j2.getString(description_key);
                mrp[i]=j2.getString(mrp_key);
                image[i]=j2.getString(image_key);
                size[i]=j2.getString(size_key);
                id[i]=j2.getInt(id_key);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}