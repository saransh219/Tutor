package com.example.tutor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout ;
    NavigationView navigationView;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    String [] name = {
            "Java",//1
            "Premier Pro",//2
            "Apple Software Developement",//3
            "JavaScript",//4
            "HTML",//5
            "CGI",//6
            "Photoshop",//7
            "PHP",//8
            "MS Word",//9
            "MS Excel",//10
            "MS Powerpoint",//11
            "SQL",//12
            "ASP.net",//13
            "Java Server Pages",//14
            "CAD",//15

    };
    String [] desc = {
            "Java Programming Language",
            "Video Editing",
            "Apple Developement",
            "JavaScript Programming Language",
            "HTML Programming Language",
            "CGI",
            "Photoshop ",
            "PHP",
            "MS Word",
            "MS Excel",
            "MS Powerpoint",
            "SQL",
            "ASP.net Programming Language",
            "Java Server Pages",
            "CAD",
    };
    int [] image = {
            R.drawable.java,
            R.drawable.mp4,
            R.drawable.dmg,
            R.drawable.js,
            R.drawable.html,
            R.drawable.cgi,
            R.drawable.psd,
            R.drawable.php,
            R.drawable.doc,
            R.drawable.xlsx,
            R.drawable.ppt,
            R.drawable.sql,
            R.drawable.asp,
            R.drawable.jsp,
            R.drawable.cad,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //

        //
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_id);
        List<User> sampleuser = new ArrayList<>();
        for(int i=0;i<name.length;i++)
        {
            User user = new User();
            user.subjectname = name[i];
            user.userdesc=desc[i];
            user.subimage=image[i];

            sampleuser.add(user);

        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerAdapter(getBaseContext(),sampleuser));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_menu,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id;
        id = menuItem.getItemId();
        switch (id)
        {
            case R.id.inbox_id:
                Toast.makeText(this, "This is inbox", Toast.LENGTH_SHORT).show();
                break;

            case R.id.starred_id:
                Toast.makeText(this, "These are Starred messages", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sent_id:
                Toast.makeText(this, "These are sent items", Toast.LENGTH_SHORT).show();
                break;

            case R.id.drafts_id:
                Toast.makeText(this, "Drafts", Toast.LENGTH_SHORT).show();
                break;

            case R.id.allmail_id:
                Toast.makeText(this, "All mails", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trash_id:
                Toast.makeText(this, "Deleted Junk", Toast.LENGTH_SHORT).show();
                break;
            case R.id.spam_id:
                Toast.makeText(this, "Spam Spam Spam", Toast.LENGTH_SHORT).show();
                break;


        }
        //after a conditional code is exectuted it will close the Drawer in this particular direction
        drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }

}
