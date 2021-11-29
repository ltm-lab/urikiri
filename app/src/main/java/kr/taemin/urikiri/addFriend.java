package kr.taemin.urikiri;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class addFriend extends StringRequest {
    final static private String URL = "http://urikiri.taemin.kr/addFriend2.php";
    private Map<String, String> map;

    public addFriend(String sender, String receiver, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("sender", sender);
        map.put("receiver", receiver);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
