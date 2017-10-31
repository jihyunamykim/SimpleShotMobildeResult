package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Seethegroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seethegroup);

        //금융개발부
        Button geumyoong =(Button)findViewById(R.id.geumyoong);

        geumyoong.setText("금융개발부");
        geumyoong.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Showlist.class);
                        intent.putExtra("GROUP_NAME","금융개발부");
                        startActivity(intent);
                    }
                }
        );
        //ICT 기획부
        Button ictgeehyeock =(Button)findViewById(R.id.ictgeehyeock);

        ictgeehyeock.setText("ICT 기획부");
        ictgeehyeock.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Showlist.class);
                        intent.putExtra("GROUP_NAME","ICT 기획부");
                        startActivity(intent);
                    }
                }
        );
        //정보개발부
        Button jeongbo =(Button)findViewById(R.id.jeongbo);

        jeongbo.setText("정보개발부");
        findViewById(R.id.jeongbo).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Showlist.class);
                        intent.putExtra("GROUP_NAME","정보개발부");
                        startActivity(intent);
                    }
                }
        );

        //글로벌개발부
        Button global =(Button)findViewById(R.id.global);

        global.setText("글로벌개발부");
        findViewById(R.id.global).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Showlist.class);
                        intent.putExtra("GROUP_NAME","글로벌개발부");
                        startActivity(intent);
                    }
                }
        );
        //디지털개발부
        Button digital =(Button)findViewById(R.id.digital);

        digital.setText("디지털개발부");
        findViewById(R.id.digital).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Showlist.class);
                        intent.putExtra("GROUP_NAME","디지털개발부");
                        startActivity(intent);
                    }
                }
        );

        //정보보호본부
        Button boho =(Button)findViewById(R.id.boho);

        boho.setText("정보보호본부");
        findViewById(R.id.boho).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Showlist.class);
                        intent.putExtra("GROUP_NAME","정보보호본부");
                        startActivity(intent);
                    }
                }
        );
    }

}
