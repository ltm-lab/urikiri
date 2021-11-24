package kr.taemin.urikiri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<group> GroupList = new ArrayList<group>();
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));
        GroupList.add(new group("asdadsa",Boolean.FALSE));

        ListView listview =(ListView) findViewById(R.id.groups);
        final groupAdapter GroupAdapter = new groupAdapter(this,GroupList);

        listview.setAdapter(GroupAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("위치공유그룹");

        Button buttonOpen = (Button) findViewById(R.id.open) ;
        buttonOpen.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer) ;
                if (!drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.openDrawer(Gravity.LEFT) ;
                }
            }
        });
    }
}