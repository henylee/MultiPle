package kr.co.tjenit.multiple;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private android.widget.EditText inputEdt;
    private android.widget.Button okBtn;
    private android.widget.TextView printTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {

    }

    private void setupEvents() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(inputEdt.getText().toString());
                if (2<=number&&number<=9) {
                    String result="";

                    for (int i=1; i<=9; i++) {
                        result = result + number + "X" + i + "=" + (number*i) + "\n";
                    }

                    printTxt.setText(result);

                    View view = getCurrentFocus();
                    if (view != null) {
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "잘못된 숫자입니다.", Toast.LENGTH_SHORT).show();
                    inputEdt.setText("");
                }
            }
        });
    }

    private void bindViews() {
        this.printTxt = (TextView) findViewById(R.id.printTxt);
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.inputEdt = (EditText) findViewById(R.id.inputEdt);
    }
}
