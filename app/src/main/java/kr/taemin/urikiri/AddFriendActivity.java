package kr.taemin.urikiri;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;


public class AddFriendActivity extends AppCompatActivity {

    LinearLayout listview;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfriend);

        listview = findViewById(R.id.listview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("                  친구 추가");

        EditText editText = (EditText) findViewById(R.id.editText);
        Editable find_id = editText.getText();

        //검색 버튼
        Button findButton = (Button) findViewById(R.id.findButton);
        //검색 버튼 클릭하면
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTextView(find_id);
            }
        });

    }

    private void createTextView(Editable find_id) {
        // user db에서 find_id에 해당하는 user name, image ...
        String name = "";
        String image = "";

        Resources res = getResources();
        Drawable img = ResourcesCompat.getDrawable(res, Integer.parseInt(image), null);
        img.setBounds(0, 0, 100, 100);

        TextView textView = new TextView(getApplicationContext());
        textView.setText(name);
        textView.setCompoundDrawables(img, null, null, null);
        textView.setTextSize(12);
        textView.setId(i++);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        param.leftMargin=30;
        textView.setLayoutParams(param);
        listview.addView(textView);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.getText();

                // 클릭 하면 친구추가
                // db.send - db에 등록

            }
        });

    }
}
