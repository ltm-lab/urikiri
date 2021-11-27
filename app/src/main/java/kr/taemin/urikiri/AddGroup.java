package kr.taemin.urikiri;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddGroup extends StringRequest {
    final static private String URL = "http://urikiri.taemin.kr/addGroup.php";
    private Map<String, String> map;

    public AddGroup(String title, String subtitle, String members, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("title", title);
        map.put("subtitle", subtitle);
        map.put("members", members);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
