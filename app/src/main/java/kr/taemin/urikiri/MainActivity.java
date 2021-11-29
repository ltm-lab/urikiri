package kr.taemin.urikiri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 그룹 리스트 생성
    public static ArrayList<group> GroupList = new ArrayList<group>();

    // 뷰 관련 변수
    //DemoCollectionAdapter demoCollectionAdapter;
    //ViewPager2 viewPager;
    //private int num =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 뷰 페이지
        viewPager = (ViewPager2) findViewById(R.id.viewPager2);

        demoCollectionAdapter = new DemoCollectionAdapter(this, num);
        viewPager.setAdapter(demoCollectionAdapter);


        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
         */


        //리스트 뷰 생성
        ListView listview = (ListView) findViewById(R.id.groups);

        //아답터 생성
        groupAdapter GroupAdapter = new groupAdapter(this,GroupList);

        //데이터 생성

        // 리스트 뷰 아탑터 연결
        listview.setAdapter(GroupAdapter);

        //어탭터의 변경을 알림
        GroupAdapter.notifyDataSetChanged();


//        String keyHash = com.kakao.util.helper.Utility.getKeyHash(this /* context */);
////        Log.d("KeyHash : ", keyHash);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("위치공유그룹");


        Button addGroup = (Button) findViewById(R.id.add_group);

        addGroup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,add_group.class);
                startActivity(intent);
                GroupAdapter.notifyDataSetChanged();
            }
        });

        /*
        버튼 관련 부분
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
         */
    }
}