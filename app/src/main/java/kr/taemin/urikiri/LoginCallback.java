package kr.taemin.urikiri;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

public class LoginCallback implements FacebookCallback<LoginResult> {

    // 로그인 성공 시 호출.
    @Override
    public void onSuccess(LoginResult loginResult) {
        Log.e("Callback :: ", "onSuccess"); //디버깅용 로그
        requestMe(loginResult.getAccessToken()); //유저 정보 요청
    }

    // 로그인 창을 닫을 경우 호출
    @Override
    public void onCancel() {
        LoginManager.getInstance().logOut(); //로그아웃 호출
        Log.e("Callback :: ", "onCancel"); //디버깅용 로그
    }

    // 로그인 실패 시에 호출
    @Override
    public void onError(FacebookException error) {
        Log.e("Callback :: ", "onError : " + error.getMessage()); //디버깅용 로그
    }

    // 사용자 정보 요청 보내기
    public void requestMe(AccessToken token) {
        GraphRequest graphRequest = GraphRequest.newMeRequest(token,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.e("result", object.toString()); //디버깅용 로그
                    }
                });

        //사용자 정보 가공
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender,birthday");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }
}