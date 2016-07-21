package ru.lionzxy.easystudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Подчеркивание текста
        TextView forgetPasswordText = (TextView) findViewById(R.id.text_forgotpassword);
        String text = forgetPasswordText.getText().toString();
        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        forgetPasswordText.setText(content);
    }
}
