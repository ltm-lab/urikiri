package kr.taemin.urikiri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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

        // 리스트 생성
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

        //리스트 뷰 생성
        ListView listview =(ListView) findViewById(R.id.groups);

        //아답터 생성
        final groupAdapter GroupAdapter = new groupAdapter(this,GroupList);

        // 리스트 뷰 아탑터 연결
        listview.setAdapter(GroupAdapter);

        //어탭터의 변경을 알림
        GroupAdapter.notifyDataSetChanged();

        // ListView 이벤트 처리
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 데이터 수정
                if(GroupList.get(position).isOn)
                {
                    GroupList.set(position,new group("OFF",false));
                }else
                {
                    GroupList.set(position,new group("ON",true));
                }
                //listView 갱신
                GroupAdapter.notifyDataSetChanged();
            }
        });


        //툴바 이름설정
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