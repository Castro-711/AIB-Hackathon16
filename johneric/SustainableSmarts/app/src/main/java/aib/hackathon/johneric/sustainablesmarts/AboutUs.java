package aib.hackathon.johneric.sustainablesmarts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity
{
    private TextView messageView;
    private Button back;
    private Button moreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        messageView = (TextView) findViewById(R.id.messageView);

        messageView.setMovementMethod(new ScrollingMovementMethod());

        back = (Button) findViewById(R.id.aboutBackBtn);
        moreInfo = (Button) findViewById(R.id.moreInfoBtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_act = new Intent(AboutUs.this, MainActivity.class);
                startActivity(main_act);
            }
        });

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this, "Feature to be added at a later date", Toast.LENGTH_LONG)
                    .show();
            }
        });

    }
}
