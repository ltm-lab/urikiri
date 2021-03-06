package kr.taemin.urikiri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class add_group extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        EditText input_name =(EditText) findViewById(R.id.input_group_name);
        EditText input_des =(EditText) findViewById(R.id.imput_group_des);
        Button add_group = (Button) findViewById(R.id.button_add_group);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);

        add_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = input_name.getText().toString();
                String subTitle = input_name.getText().toString();

                //로컬 데이터 넣는 구문
                MainActivity.GroupList.add(new group(input_name.getText().toString(),input_des.getText().toString(),Boolean.FALSE));
                //DB 데이터 넣는 구문
                AddGroup ad = new AddGroup(Title,subTitle,"asdasd",null);
                RequestQueue queue = Volley.newRequestQueue(add_group.this);
                queue.add(ad);

                Intent intent=new Intent(add_group.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);//액티비티 스택제거
                startActivity(intent);
            }
        });

    }
}