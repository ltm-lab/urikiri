package kr.taemin.urikiri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;

import java.util.Arrays;
import java.util.Random;

public class LoginActivity extends Activity {

    /* 카카오 로그인 세팅 */
    private Button kakao_login;
    private SessionCallback sessionCallback = new SessionCallback();
    Session session;

    /* 페이스북 로그인 세팅 */
    private Button facebook_login;
    private LoginCallback mLoginCallback;
    private CallbackManager mCallbackManager;

    /* 비회원 로그인 세팅 */
    private Button anonymous_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 카카오 로그인 셋업
        kakao_login = (Button) findViewById(R.id.kakao_login);

        session = Session.getCurrentSession();
        session.addCallback(sessionCallback);

        //카카오 로그인 버튼 클릭시
        kakao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.open(AuthType.KAKAO_LOGIN_ALL, LoginActivity.this); //메인 액티비티에서 로그인 창 열기
            }
        });

        //페이스북 로그인 셋업
        mCallbackManager = CallbackManager.Factory.create(); //콜백 매니저 생성
        mLoginCallback = new LoginCallback(); //콜백 수신부 설정

        facebook_login = (Button) findViewById(R.id.facebook_login); //로그인 버튼 등록
        facebook_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager loginManager = LoginManager.getInstance(); //로그인 매니저 인스턴스 가져오기
                loginManager.logInWithReadPermissions(LoginActivity.this,
                        Arrays.asList("public_profile", "email")); //로그인 시 어떤 정보를 가져올 것인지 선택하기
                loginManager.registerCallback(mCallbackManager, mLoginCallback); //콜백을 보내고, 데이터를 가져올 콜백 선택
            }
        });

        /* 네이버 로그인은 사용하려면 앱에 대한 검수를 받아야 가능하기에 일단 스킵 */

        //비회원 로그인 셋업
        anonymous_login = (Button) findViewById(R.id.anonymous_login); //비회원 로그인 버튼
        anonymous_login.setOnClickListener(new View.OnClickListener() { //비회원 로그인 버튼 터치 시
            @Override
            public void onClick(View view) {
                Random rand = new Random(); //랜덤함수 사용
                StringBuffer sb = new StringBuffer(); //스트링버퍼에 랜덤 토큰값을 담는다.
                for(int i = 0; i < 30; i ++) { //30자리의 문자를 추출한다.
                    int index = rand.nextInt(3); //0~2를 랜덤으로 뽑아 대문자, 소문자, 숫자 0~9까지중 선택한다.
                    switch(index) {
                        case 0: //index의 값이 0일 경우
                            sb.append((char)(rand.nextInt(26) + 97)); //알파벳 대문자
                            break;
                        case 1: //index의 값이 1일 경우
                            sb.append((char)(rand.nextInt(26) + 65)); //알파벳 소문자
                            break;
                        case 2: //index의 값이 2일 경우
                            sb.append(rand.nextInt(10)); //숫자 0~9
                            break;
                    }
                }
                Toast.makeText(getApplicationContext(), "토큰 : "+sb, Toast.LENGTH_SHORT).show(); //토스트로 생성된 토큰값을 보여준다.
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        // 카카오톡 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }

        //로그인 성공 메세지
        Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();

        //페이스북 로그인 리턴값이 있을경우 보내준다.
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
