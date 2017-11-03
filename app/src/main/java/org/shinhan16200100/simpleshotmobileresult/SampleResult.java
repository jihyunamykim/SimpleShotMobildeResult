package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SampleResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_result);

        Intent intent = getIntent();

        String test ;

        test = intent.getExtras().getString("sample");

        TextView Seethesample = (TextView)findViewById(R.id.seethesample);

        Seethesample.setText(test);
    }
}
