package kr.taemin.urikiri;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public class FriendListActivity extends AppCompatActivity {
    LinearLayout listview;
    int num, current = 0;
    private String[] response_arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);

        listview = findViewById(R.id.listview) ;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_fl);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("                  친구 목록");

        EditText editText = (EditText) findViewById(R.id.editText);
        String find_id = editText.getText().toString();

        String userid = getPreference("userid");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response_arr = response.split("|");
                try {
                    num = response_arr.length;
                    current = response_arr.length;
                    for (int i = 0; i < num; i++) {

                        //Resources res = getResources();
                        //Drawable img = ResourcesCompat.getDrawable(res, Integer.parseInt(image), null);
                        //img.setBounds(0, 0, 100, 100);

                        TextView textView = new TextView(getApplicationContext());
                        textView.setText(response_arr[i]);
                        //textView.setCompoundDrawables(img, null, null, null);
                        textView.setTextSize(12);
                        textView.setId(i++);

                        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        param.leftMargin = 30;
                        textView.setLayoutParams(param);
                        listview.addView(textView);


                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                } catch (Exception e) {

                }
            }
        };

        Friends friends = new Friends(userid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(FriendListActivity.this);
        queue.add(friends);


        //검색 버튼
        // 미완성 - 현재 검색한 아이디를 textview에 추가하는 방식으로 동작
        Button findButton = (Button) findViewById(R.id.findButton);
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findFriend(find_id, null);
            }
        });

        //친구추가 버튼
        //친구추가 버튼 클릭하면
        //    친구추가 페이지로 이동
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFriend addfriend = new addFriend(userid, find_id, null);
                RequestQueue queue = Volley.newRequestQueue(FriendListActivity.this);
                queue.add(addfriend);

                TextView textView = new TextView(getApplicationContext());
                textView.setText(find_id);
                //textView.setCompoundDrawables(img, null, null, null);
                textView.setTextSize(12);
                textView.setId(current++);

                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                param.leftMargin = 30;
                textView.setLayoutParams(param);
                listview.addView(textView);
            }
        });

        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delFriend delfriend = new delFriend(userid, find_id, null);
                RequestQueue queue = Volley.newRequestQueue(FriendListActivity.this);
                queue.add(delfriend);

               // listview.removeView();
            }
        });
    }

    @SuppressLint("ResourceType")
    public void findFriend(String find_id, Response.Listener<String> responseListener){
        listview.removeAllViews();
        TextView textView = new TextView(getApplicationContext());
        textView.setText(find_id);
        //textView.setCompoundDrawables(img, null, null, null);
        textView.setTextSize(12);
        textView.setId(99999);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        param.leftMargin = 30;
        textView.setLayoutParams(param);
        listview.addView(textView);
    }

    public String getPreference(String key){
        SharedPreferences pref = getSharedPreferences("kr.taemin.urikiri", MODE_PRIVATE);
        return pref.getString(key, "");
    }
}
