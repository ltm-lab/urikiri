package kr.taemin.urikiri;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class serch_UserGroupById extends StringRequest {
    final static private String URL = " http://urikiri.taemin.kr/groupDB.php";
    private Map<String, String> map;
    Response.Listener<String> listener;

    public serch_UserGroupById(String userid,Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        this.listener = listener;
        map = new HashMap<>();
        map.put("userid", userid);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}

