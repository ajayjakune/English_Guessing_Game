package asks.dev.englishguessinggame;


import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class rough extends AppCompatActivity {

    Button start;
    Button next;
    LinearLayout LL;
    ScrollView sv;
    LinearLayout queHolder;
    Random rm;
    int choice;
    DictionaryData dictionaryData;
    String word,option1,option2,option3,option4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rough);

        start = findViewById(R.id.start);
        next = findViewById(R.id.next_button);
        LL = findViewById(R.id.instruction_layout);
        queHolder = findViewById(R.id.question_holder);
        sv = findViewById(R.id.scroller_view);
        rm = new Random();
        try {
            dictionaryData = DictionaryData.getInstance(getApplicationContext());
            dictionaryData.open();
        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL.setVisibility(View.INVISIBLE);
                next.setClickable(true);
            }
        });

    }


    public void questionsView(View view){

        next.setClickable(false);
        next.setBackgroundColor(getResources().getColor(R.color.blackish));
        TextView que = new TextView(this);
        final TextView op1,op2,op3,op4;
        op1 = new TextView(this);
        op2 = new TextView(this);
        op3 = new TextView(this);
        op4 = new TextView(this);

        try {
            int randomNum = rm.nextInt(7127) + 1;
            word = dictionaryData.getWord(randomNum);
            option1 = dictionaryData.getSynonym(randomNum);
            randomNum = rm.nextInt(7127) + 1;
            option2 = dictionaryData.getSynonym(randomNum);
            randomNum = rm.nextInt(7127) + 1;
            option3 = dictionaryData.getSynonym(randomNum);
            randomNum = rm.nextInt(7127) + 1;
            option4 = dictionaryData.getSynonym(randomNum);
        }catch (Exception e){
            Toast.makeText(this, "" + e.toString(), Toast.LENGTH_SHORT).show();
        }

        que.setPadding(250,120,250,120);
        que.setBackground(getDrawable(R.drawable.border));
        que.setText(word);
        que.setTextSize(30);
        que.setTextColor(getResources().getColor(R.color.white));

        op1.setPadding(20,20,20,20);
        op1.setBackground(getDrawable(R.drawable.border));
        op1.setText(option1);
        op1.setTextSize(30);
        op1.setTextColor(getResources().getColor(R.color.white));

        op2.setPadding(20,20,20,20);
        op2.setBackground(getDrawable(R.drawable.border));
        op2.setText(option2);
        op2.setTextSize(30);
        op2.setTextColor(getResources().getColor(R.color.white));

        op3.setPadding(20,20,20,20);
        op3.setBackground(getDrawable(R.drawable.border));
        op3.setText(option3);
        op3.setTextSize(30);
        op3.setTextColor(getResources().getColor(R.color.white));

        op4.setPadding(20,20,20,20);
        op4.setBackground(getDrawable(R.drawable.border));
        //LinearLayout ll = new LinearLayout(this);
        op4.setText(option4);
        op4.setTextSize(30);
        op4.setTextColor(getResources().getColor(R.color.white));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                                                                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,24,0,24);


        choice = rm.nextInt(4) + 1;
        switch(choice) {

            case 1: queHolder.addView(que,layoutParams);
                    queHolder.addView(op1,layoutParams);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op4,layoutParams);
                break;
            case 2: queHolder.addView(que,layoutParams);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op1,layoutParams);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op4,layoutParams);
                break;
            case 3: queHolder.addView(que,layoutParams);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op1,layoutParams);
                    queHolder.addView(op4,layoutParams);
                break;
            case 4: queHolder.addView(que,layoutParams);
                    queHolder.addView(op4,layoutParams);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op1,layoutParams);
                break;

        }


        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1.setTextColor(getResources().getColor(R.color.green));
                op2.setClickable(false);
                op3.setClickable(false);
                op4.setClickable(false);
                next.setClickable(true);
                next.setBackground(getDrawable(R.drawable.rounded_button));
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op2.setTextColor(getResources().getColor(R.color.red));
                op1.setClickable(false);
                op3.setClickable(false);
                op4.setClickable(false);
                next.setClickable(true);
                next.setBackground(getDrawable(R.drawable.rounded_button));
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op3.setTextColor(getResources().getColor(R.color.red));
                op1.setClickable(false);
                op2.setClickable(false);
                op4.setClickable(false);
                next.setClickable(true);
                next.setBackground(getDrawable(R.drawable.rounded_button));
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op4.setTextColor(getResources().getColor(R.color.red));
                op1.setClickable(false);
                op2.setClickable(false);
                op3.setClickable(false);
                next.setClickable(true);
                next.setBackground(getDrawable(R.drawable.rounded_button));
            }
        });

        sv.post(new Runnable() {
            @Override
            public void run() {
                sv.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

}