package kr.taemin.urikiri;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Friends extends StringRequest {
    final static private String URL = "http://urikiri.taemin.kr/friends.php";
    private Map<String, String> map;


    public Friends(String userid, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userid", userid);
    }

    public Friends(String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        // 만약 POST 방식에서 전달할 요청 파라미터가 있다면 HashMap 객체에 넣어준다.
        Map<String, String> map = new HashMap<>();
        return map;
    }

}
