package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirstMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmenu);

        Button takeapicture = (Button)findViewById(R.id.takeapicture);
        takeapicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),//현재 화면의 제어권자
                        Takeapicture.class);// 다음 넘어갈 클래스 지정
                startActivity(intent);//다음 화면으로 넘어간다
            }
        });
    }
}