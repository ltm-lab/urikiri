package kr.taemin.urikiri;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    DemoCollectionAdapter demoCollectionAdapter;
    ViewPager2 viewPager;


    private int num =2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager2) findViewById(R.id.viewPager2);

        demoCollectionAdapter = new DemoCollectionAdapter(this, num);
        viewPager.setAdapter(demoCollectionAdapter);


        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);



//        String keyHash = com.kakao.util.helper.Utility.getKeyHash(this /* context */);
////        Log.d("KeyHash : ", keyHash);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("                  위치공유그룹");

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