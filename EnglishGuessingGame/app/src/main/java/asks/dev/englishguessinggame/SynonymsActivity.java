package asks.dev.englishguessinggame;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class SynonymsActivity extends AppCompatActivity {

    Button start;
    Button next;
    LinearLayout LL;
    ScrollView sv;
    LinearLayout queHolder;
    Random rm;
    int choice;
    DictionaryData dictionaryData;
    String word,option1,option2,option3,option4;
    TextView que,score;
    TextView op1,op2,op3,op4;
    RelativeLayout relativeLayoutForScore;
    LinearLayout.LayoutParams layoutParams;
    RelativeLayout.LayoutParams relativeLayoutParams;
    ImageView[] live;
    static int count;
    TextView actualScore;
    int updateScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonyms);

        start = findViewById(R.id.start);
        next = findViewById(R.id.next_button);
        LL = findViewById(R.id.instruction_layout);
        queHolder = findViewById(R.id.question_holder);
        sv = findViewById(R.id.scroller_view);
        updateScore = 0;
        actualScore = findViewById(R.id.actual_score);
        live = new ImageView[3];
        live[0] = findViewById(R.id.lives1);
        live[1] = findViewById(R.id.lives2);
        live[2] = findViewById(R.id.lives3);
        rm = new Random();
        count = 3;

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

        score = new TextView(this);
        relativeLayoutForScore = new RelativeLayout(this);
        relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                                                                RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        que = new TextView(this);
        op1 = new TextView(this);
        op2 = new TextView(this);
        op3 = new TextView(this);
        op4 = new TextView(this);


        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                                        LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,24,0,24);

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


        if(word.length()>14){
            que.setPadding(50, 100, 50, 100);
        } else if(word.length()>8) {
            que.setPadding(100, 100, 100, 100);
        }else{
            que.setPadding(200, 100, 200, 100);
        }
        que.setBackground(getDrawable(R.drawable.question_background));
        que.setText("Q. "+word);
        que.setTextSize(25);
        que.setTextColor(getResources().getColor(R.color.black));
        queHolder.addView(que,layoutParams);

        op1.setPadding(20,20,20,20);
        op1.setBackground(getDrawable(R.drawable.options_background_white));
        op1.setTextSize(20);
        op1.setTextColor(getResources().getColor(R.color.black));

        op2.setPadding(20,20,20,20);
        op2.setBackground(getDrawable(R.drawable.options_background_white));
        op2.setTextSize(20);
        op2.setTextColor(getResources().getColor(R.color.black));

        op3.setPadding(20,20,20,20);
        op3.setBackground(getDrawable(R.drawable.options_background_white));
        op3.setTextSize(20);
        op3.setTextColor(getResources().getColor(R.color.black));

        op4.setPadding(20,20,20,20);
        op4.setBackground(getDrawable(R.drawable.options_background_white));
        op4.setTextSize(20);
        op4.setTextColor(getResources().getColor(R.color.black));


        choice = rm.nextInt(4) + 1;
        switch(choice) {

            case 1: op1.setText("A. "+option1);
                    op2.setText("B. "+option2);
                    op3.setText("C. "+option3);
                    op4.setText("D. "+option4);
                    queHolder.addView(op1,layoutParams);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op4,layoutParams);
                break;
            case 2: op1.setText("B. "+option1);
                    op2.setText("A. "+option2);
                    op3.setText("C. "+option3);
                    op4.setText("D. "+option4);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op1,layoutParams);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op4,layoutParams);
                break;
            case 3: op1.setText("C. "+option1);
                    op2.setText("B. "+option2);
                    op3.setText("A. "+option3);
                    op4.setText("D. "+option4);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op1,layoutParams);
                    queHolder.addView(op4,layoutParams);
                break;
            case 4: op1.setText("D. "+option1);
                    op2.setText("B. "+option2);
                    op3.setText("C. "+option3);
                    op4.setText("A. "+option4);
                    queHolder.addView(op4,layoutParams);
                    queHolder.addView(op2,layoutParams);
                    queHolder.addView(op3,layoutParams);
                    queHolder.addView(op1,layoutParams);
                break;

        }


        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1.setTextColor(getResources().getColor(R.color.white));
                correctAnswer();
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op2.setTextColor(getResources().getColor(R.color.white));
                op2.setBackground(getDrawable(R.drawable.background_red));
                wrongAnswer();
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op3.setTextColor(getResources().getColor(R.color.white));
                op3.setBackground(getDrawable(R.drawable.background_red));
                wrongAnswer();
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op4.setTextColor(getResources().getColor(R.color.white));
                op4.setBackground(getDrawable(R.drawable.background_red));
                wrongAnswer();
            }
        });

        sv.post(new Runnable() {
            @Override
            public void run() {
                sv.fullScroll(View.FOCUS_DOWN);
            }
        });

    }

    private void correctAnswer(){
        op1.setBackground(getDrawable(R.drawable.background_green));
        op1.setClickable(false);
        op2.setClickable(false);
        op3.setClickable(false);
        op4.setClickable(false);
        next.setClickable(true);

        score.setBackground(getDrawable(R.drawable.correct_score_background));
        score.setText("10");
        score.setTypeface(null, Typeface.BOLD);
        score.setPadding(100,20,100,20);
        score.setTextColor(getResources().getColor(R.color.black));
        relativeLayoutForScore.addView(score,relativeLayoutParams);

        queHolder.addView(relativeLayoutForScore,layoutParams);

        next.setBackground(getDrawable(R.drawable.rounded_button));

        sv.post(new Runnable() {
            @Override
            public void run() {
                sv.fullScroll(View.FOCUS_DOWN);
            }
        });

        updateScore += 10;
        if(updateScore<100){
            actualScore.setText("0"+updateScore);
        }else{
            actualScore.setText(""+updateScore);
        }
    }

    private void wrongAnswer(){
        op1.setBackground(getDrawable(R.drawable.background_green));
        op1.setClickable(false);
        op2.setClickable(false);
        op3.setClickable(false);
        op4.setClickable(false);
        next.setClickable(true);

        score.setBackground(getDrawable(R.drawable.wrong_score_background));
        score.setText("00");
        score.setTypeface(null, Typeface.BOLD);
        score.setPadding(100,20,100,20);
        score.setTextColor(getResources().getColor(R.color.black));
        relativeLayoutForScore.addView(score,relativeLayoutParams);

        queHolder.addView(relativeLayoutForScore,layoutParams);

        next.setBackground(getDrawable(R.drawable.rounded_button));

        sv.post(new Runnable() {
            @Override
            public void run() {
                sv.fullScroll(View.FOCUS_DOWN);
            }
        });

        live[--count].setVisibility(View.INVISIBLE);

        if(count==0){
            next.setClickable(false);
            next.setBackgroundColor(getResources().getColor(R.color.blackish));
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SynonymsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },3000);

        }
    }

}