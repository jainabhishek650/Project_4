package abhishek.project4;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Levis extends AppCompatActivity {
GridView gv;
    ProgressBar pp;
    jason_parser jp;
    String fetch1="https://wwwajin.000webhostapp.com/project_4_levis.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levis);
        gv=(GridView)findViewById(R.id.gr);
        pp=(ProgressBar)findViewById(R.id.prbar);
        setTitle("Levis");
        if (isconnected(Levis.this)){

            senreque(fetch1);
            pp.setVisibility(View.VISIBLE);

        }else if (!isconnected(Levis.this)){
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }


    public void senreque(String ar){
        StringRequest st=new StringRequest(ar, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showLevisdata(response);
                pp.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Levis.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue eq= Volley.newRequestQueue(getApplicationContext());
        eq.add(st);
    }

    public void showLevisdata(String js){
      jp=new jason_parser(js);
        jp.parsejson();
        custom_wragon c=new custom_wragon(Levis.this,jp.brand,jp.mrp,jp.description,jp.image);
        gv.setAdapter(c);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle b2=new Bundle();
                b2.putString("image_get",jp.image[position]);
                b2.putString("brand_name",jp.brand[position]);
                b2.putString("mrp_name",jp.mrp[position]);
                b2.putString("description_name",jp.description[position]);

                Intent it=new Intent(Levis.this,Main3Activity.class);

                it.putExtra("bundle_image",b2);
                startActivity(it);
            }
        });

    }


    public boolean isconnected(Context c)
    {
        ConnectivityManager cm= (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nm=cm.getActiveNetworkInfo();

        if (nm !=null && nm.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (mobile != null && mobile.isConnectedOrConnecting() || wifi != null && wifi.isConnectedOrConnecting()) {
                return true;

            } else return false;
        }else return false;

    }
}

