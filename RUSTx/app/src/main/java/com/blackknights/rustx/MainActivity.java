package com.blackknights.rustx;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<Custom_Items> list;
    public CustomAdapter adapter;
    private Toolbar toolbar;
    private TextView textView;
    NetworkInfo info;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        dialog = new ProgressDialog(this);


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
        if (info != null) {


            Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_LONG).show();

        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        list = new ArrayList<>();


        list.add(new Custom_Items("https://fsb.zobj.net/crop.php?r=TQ17OTvRvqIRq6m-kcLMlU-g68IHkNtXYQ5B3j9twk_CkS6zM7rH_C-OzOS4iVM6pDE9P2fHuo3Swz1_qVGWT7gRAIxzDby0x7rrCtfroFsHSC7aau-HbAFN7i6SGowXNJmowCJGeoUz5S-Uj16rIKacUVpvxTXLR4YhxW2NK_BXHJErHMF1oh7lD4k"));
        list.add(new Custom_Items("https://fsa.zobj.net/crop.php?r=uxggRgqukj0SDhVE44E8Ey-gWr4NWtNUyThWHhvsk6hdUmeJ5lv6miAg-xDzWAycq9tj4QKAeQjRqCFOVKfGIRWFZ-DItNqGQ7xhkd90C02GASDP5PKs047Wt57djnEvS6gZrVv0C1GqM6s4HoNhT6SGbT15lal6FwqLPyFsYJL0HWLAmiJMBjUHURE"));
        list.add(new Custom_Items("https://fsa.zobj.net/crop.php?r=naxyeFjzuiwqq2Y2E6g9xpvOJS640EQzN-_wpRkgNvH5kAaX5CQL2l11TOVVRGAwXEeRO23EVx39CsokvyZra2jeGhwJiy8St5VelhlFtonppQLF4ZiB9g_AHdEhrFkTWq3lDLLhKvCajttH8ZvG-OzOSyN7D85YhhsDnEOWPSKRt8vVhh2j3qu9pms"));
        list.add(new Custom_Items("https://fsa.zobj.net/crop.php?r=TyNPh-taEXT5LPy2LY7NcnqFgmCq202lgD6HIp1SXIh0UU2v8FLhod6S8ePxyMWNVr0WGpLVK2IjlFRhSUMnC3-JY2b_nNSlwAIMQCkBoMgPeHg2TRfXL5IpQ8eJbx684zh68xhrnhvubPS0hNvajNzYs8Lr9wXQcYZRLb_3_vAEzqKup4hl7gjojcY"));
        list.add(new Custom_Items("https://images.unsplash.com/photo-1545744451-c85a83bb3c91?ixlib=rb-1.2.1&w=1000&q=80"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1624496/pexels-photo-1624496.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://fsb.zobj.net/crop.php?r=I9UpMgSky9ff5XRWAGXrpod6v-ugVmUrWG6bt8NEQZMRui9CWz_npsHQTRtEAluZe_NtEoM-M4eIJTvyQmjESKt-akAuXFUymAdmjb1omK9KcaOIYUOFQhYaZRKABIRVEk7tEwjOOpSIOepAPOW6Y7NIMhoIRhLSV5nrfyCvk63Bhpe9Hzrv0ShYDXk"));
        list.add(new Custom_Items("https://cuteiphonewallpaper.com/wp-content/uploads/2019/06/iPhone-8-Wallpaper-in-HD.jpg"));
        list.add(new Custom_Items("https://i.pinimg.com/originals/74/a3/f4/74a3f4ff10b20c1ea8edd6174a190b58.png"));
        list.add(new Custom_Items("https://images.unsplash.com/photo-1538524270287-6704e888cda2?ixlib=rb-1.2.1&w=1000&q=80"));
        list.add(new Custom_Items("https://fsa.zobj.net/crop.php?r=NzCp__6JshHnOGAfX22sl4Gd3nzelb1ozowx_sRSSn_Q4ByHvjx94LdCgjWrnIvasUJBAsmjdBzoHpFo3GlYiNC8D49zW4psfXVFEr3ZII60A2jw0zEkCPOJqKBCX1bh8lFuf9O5HRctTJDy2IZMAPhcuR17VrIlQqCELeH5_bCX-rJ4bBX_O2pteN6x8F_sLHFVZjOYNilMZ-Lx"));
        list.add(new Custom_Items("https://lh3.googleusercontent.com/proxy/uiV7IP3MU2sOCb2Bf1cZDa2Ml8h4Vi6wRjG5YfkR6k-bVuJFIVla0Dme_iQJDn-pPZfw91vf5xcnL6DQC3C5l2sY-ixc7D3OU4f4ruQVWeQ"));
        list.add(new Custom_Items("https://i.pinimg.com/originals/95/87/eb/9587eb968f64f6d6fc20e5b3d0d71abc.jpg"));
        list.add(new Custom_Items("https://cuteiphonewallpaper.com/wp-content/uploads/2019/09/iPhone-7-Wallpaper-HD.jpg"));
        list.add(new Custom_Items("https://r1.ilikewallpaper.net/iphone-wallpapers/download/74731/nightlight-iphone-wallpaper-ilikewallpaper_com_200.jpg"));
        list.add(new Custom_Items("https://cuteiphonewallpaper.com/wp-content/uploads/2019/06/iPhone-XS-Wallpaper-Size.jpg"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/169615.jpg"));
        list.add(new Custom_Items("https://fsa.zobj.net/crop.php?r=4l4W8vjtY3tor-VYyfQaOOOl3slkqTHp4btfagGWdYJ4ZDw9BPDgM-iAA3Lb0O1AeaVNosTm1OW2-h8pfX2bEm8JXmNAOjVLL6gVmNNTbHxm0SgDvWwsc1Gi3d4Um2Z-Z_FopEghAAzjxyolJMiJ7IkuDuH7yOQx3lr0-M3rTq4U5P3qP-lCEQPQxvW5eYF46xv2HZYIaJSk679h"));
        list.add(new Custom_Items("https://media.idownloadblog.com/wp-content/uploads/2019/09/iPhone-11-Wallpaper-7-YTECHB.png"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/1146081.jpg"));
        list.add(new Custom_Items("https://www.setaswall.com/wp-content/uploads/2019/09/Apple-iPhone-11-Stock-Wallpaper-04-1436x3113-380x824.jpg"));
        list.add(new Custom_Items("https://www.designbolts.com/wp-content/uploads/2019/09/Leaves-iPhone-11-Wallpaper-High-Quality.jpg"));
        list.add(new Custom_Items("https://1.bp.blogspot.com/-7Bz21ZXIK5g/XXjoBib2goI/AAAAAAAACyQ/cUjVudfVtPQpsypXwM2a0zdf9LKFu5QmQCLcBGAsYHQ/s1600/iPhone-11-wallpapers-18.jpg"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/1340371.jpg"));
        list.add(new Custom_Items("https://media.idownloadblog.com/wp-content/uploads/2019/09/iPhone-11-Wallpaper-3-YTECHB.png"));
        list.add(new Custom_Items("https://wallpapercave.com/wp/wp4361108.png"));
        list.add(new Custom_Items("https://wallpaperaccess.com/full/983727.png"));
        list.add(new Custom_Items("https://www.setaswall.com/wp-content/uploads/2018/09/828x1792-Wallpaper-265-380x822.jpg"));
        list.add(new Custom_Items("https://live.staticflickr.com/7877/46880859591_00a2e43cfd_b.jpg"));
        list.add(new Custom_Items("https://lh3.googleusercontent.com/proxy/P7CtXsQs34WHAEDILg2aB8_L3VBbYvWaj5bpaZAfDi25__dvl5L4pCLnAIvmgod3ngLjmDD_WuU_-SBqIqIdMPcjVDYyAg_TjGopVvxg6Bt9ctu0KUdSzK1wZtVs-2V7rPHDv0BObsIJtts"));


        getdata();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    private void getdata() {


        adapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }
        if (id == R.id.action_exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        if (id == R.id.action_search) {

            finish();
            startActivity(getIntent());
            if (info != null) {
                getdata();

            } else {


                Toast.makeText(this, "Internet Not Connected!", Toast.LENGTH_SHORT).show();
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.wallpaper) {

            getdata();


        } else if (id == R.id.favorites) {

            getdata();

        } else if (id == R.id.Settings) {

            startActivity(new Intent(MainActivity.this, SettingsActivity.class));


        } else if (id == R.id.rate_us) {
            //rateme();
        } else if (id == R.id.more_app) {

            //MoreApp();


        }


        //Shere


        else if (id == R.id.share) {


            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plan");

            String shareBoday = "Your Boday Here";

            String shareSub = "\"http://play.google.com/store/apps/details?id=" + getPackageName();
            myintent.putExtra(Intent.EXTRA_SUBJECT, shareBoday);
            myintent.putExtra(Intent.EXTRA_TEXT, shareSub);
            startActivity(Intent.createChooser(myintent, "share Using"));

        }


        //Exit


        else if (id == R.id.exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MoreApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://developer?id=" + "Account Name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=" + "Account Name!")));


        }
    }




    public void rateme() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "Your Package name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }


}