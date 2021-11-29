package kr.taemin.urikiri;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Register extends StringRequest {
    final static private String URL = "http://urikiri.taemin.kr/register.php";
    private Map<String, String> map;

    public Register(String id, String name, String platform, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("platform", platform);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
