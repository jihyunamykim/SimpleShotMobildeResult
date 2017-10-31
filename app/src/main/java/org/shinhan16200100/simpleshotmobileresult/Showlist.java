package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Showlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist);

        TextView group_name = (TextView)findViewById(R.id.groupname);

        Intent intent = getIntent();
        String groupname = intent.getStringExtra("GROUP_NAME");

        group_name.setText(groupname);
    }
}
