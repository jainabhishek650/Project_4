package abhishek.project4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.datatype.Duration;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
ImageView im1,im2,im3,im4,im5;
    RecyclerView rc;
    LinearLayout l;
    RelativeLayout rl;
    Toolbar tl;

ListView li;
    ArrayAdapter<String> adapter;
    String Women_url1="https://wwwajin.000webhostapp.com/project_4_women.php";
    String men_url="https://wwwajin.000webhostapp.com/project_4_men.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl=(RelativeLayout)findViewById(R.id.relate);
        final Snackbar sc=Snackbar.make(rl,"No Internet ",Snackbar.LENGTH_LONG);
        Timer timer=new Timer();
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                if (!isconnected(MainActivity.this)){

                    sc.show();

                } else if (isconnected(MainActivity.this)){
                    sc.dismiss();
                 }

            }
        };timer.schedule(tt,0,1000);










        l=(LinearLayout)findViewById(R.id.ly);
        tl=(Toolbar)findViewById(R.id.too);
        tl.setTitle("Myntra");
        tl.setTitleTextColor(getResources().getColor(R.color.abhi));
        setSupportActionBar(tl);

//        li=(ListView)findViewById(R.id.listV);
//           ArrayList<String> arrayList=new ArrayList<>();
//        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.bnds)));
//
//        adapter=new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1,
//                arrayList);

        im1= (ImageView)findViewById(R.id.imageView);
        im2=(ImageView)findViewById(R.id.imageView2);
        rc=(RecyclerView)findViewById(R.id.recyclerview);
        im3=(ImageView)findViewById(R.id.imageVie2);
        im4=(ImageView)findViewById(R.id.brandday);

        im5=(ImageView)findViewById(R.id.imageVie4);
        myadapter ma=new myadapter(this,nature_model.getobjectist());
        LinearLayoutManager lc=new LinearLayoutManager(this);
        lc.setOrientation(LinearLayout.HORIZONTAL);

        rc.setLayoutManager(lc);
        rc.setAdapter(ma);
        rc.setItemAnimator(new DefaultItemAnimator());
        ma.SetOnItemClickListener(new myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Bundle b1=new Bundle();
                        b1.putString("data",men_url);
                        b1.putString("title","Men");
                        Intent it1=new Intent(MainActivity.this,Show_image.class);
                        it1.putExtra("bundle1",b1);
                        startActivity(it1);

                        break;

                    case 1:
                        Bundle b=new Bundle();
                        b.putString("data",Women_url1);
                        b.putString("title","Women");
                        Intent it=new Intent(MainActivity.this,Show_image.class);
                        it.putExtra("bundle1",b);
                        startActivity(it);

                        break;

                }
            }
        });

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3=new Intent(MainActivity.this, Mens_list.class);
                startActivity(it3);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4=new Intent(MainActivity.this, Womens_list.class);
                startActivity(it4);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Wragon.class));
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Levis.class));
            }
        });



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Do you Want to Exit?")

                .setCancelable(false)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })

                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog ad=builder.create();
        ad.setTitle("Exit");
        ad.show();
         }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searc,menu);
        MenuItem m=menu.findItem(R.id.search1);
        SearchView sc = (SearchView)m.getActionView();

        m.getActionView();


        sc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
      });

 return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {




        return super.onOptionsItemSelected(item);
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
