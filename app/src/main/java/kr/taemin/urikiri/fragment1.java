package kr.taemin.urikiri;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class fragment1 extends Fragment {
    // ArrayList 연결
    public static ArrayList<group> GroupList = new ArrayList<group>();
    //private static groupAdapter GroupAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment1, container, false);

        //LayoutInflater 사용해 Resource Layout을 View로 변환해준 후 findViewById() 호출
        View view = (View) inflater.inflate(R.layout.fragment1, container, false);

        // 리스트 생성
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));
        GroupList.add(new group("아무것도 하기 싫다","잉여를 위한 모임",Boolean.FALSE));



        //아답터 생성
        final groupAdapter GroupAdapter = new groupAdapter();

        //리스트 뷰 생성
        ListView listview =(ListView) view.findViewById(R.id.groups);


        // 리스트 뷰 아탑터 연결
        listview.setAdapter(GroupAdapter);

        //어탭터의 변경을 알림
        GroupAdapter.notifyDataSetChanged();

        // ListView 이벤트 처리

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 데이터 수정

                //listView 갱신
                GroupAdapter.notifyDataSetChanged();
            }
        });


        return rootView;
    }

}