package com.example.mystiquecatalogue_android.views.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mystiquecatalogue_android.R;


public class EmailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        final EditText to = (EditText) findViewById(R.id.sendTo);
        final EditText subject = (EditText) findViewById(R.id.subject);
        final EditText massage = (EditText) findViewById(R.id.massageText);

        Button sendE = (Button) findViewById(R.id.btn_sendMail);
        sendE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toS = to.getText().toString();
                String subS = subject.getText().toString();
                String mesS = massage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, toS);
                email.putExtra(Intent.EXTRA_SUBJECT, subS);
                email.putExtra(Intent.EXTRA_TEXT, mesS);

                email.setType("massager/rfc822");

                startActivity(Intent.createChooser(email, "Choose app to send mail"));
            }
        });
    }
}
