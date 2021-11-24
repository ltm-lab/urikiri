package kr.taemin.urikiri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
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
    public static ArrayList<group> GroupList = new ArrayList<group>();

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리스트 생성

        //GroupList.add(new group("아무것도 하기 싫다",Boolean.FALSE,"잉여를 위한 모임")); DB에서 받아오는 구문 추가

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

                //listView 갱신
                GroupAdapter.notifyDataSetChanged();
            }
        });


        //툴바 이름설정
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle("위치공유그룹");

        Button addGroup = (Button) findViewById(R.id.add_group);
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
        addGroup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,add_group.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {

        super.onResume();

        //GroupAdapter.notifyDataSetChanged();
    }
}