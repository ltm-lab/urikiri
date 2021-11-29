package kr.taemin.urikiri;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class delFriend extends StringRequest {
    final static private String URL = "http://urikiri.taemin.kr/delFriend.php";
    private Map<String, String> map;

    public delFriend(String userid, String delid, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userid", userid);
        map.put("delid", delid);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
