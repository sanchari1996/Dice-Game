package com.example.user.scarnesdice;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    Button roll,hold,reset;
    ImageView dice;
    TextView t1,t2,t3,t4,t5,t6,t7;
    int y0,y1,a0,a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll=(Button)findViewById(R.id.button);
        hold=(Button)findViewById(R.id.button2);
        reset=(Button)findViewById(R.id.button3);
        dice=(ImageView)findViewById(R.id.ivdice);
        t1=(TextView)findViewById(R.id.tv1);
        t2=(TextView)findViewById(R.id.tv2);
        t3=(TextView)findViewById(R.id.tv3);
        t4=(TextView)findViewById(R.id.tv4);
        t5=(TextView)findViewById(R.id.tv5);
        t6=(TextView)findViewById(R.id.tv6);
        t7=(TextView)findViewById(R.id.tv7);
        roll.setOnClickListener(this);
        hold.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:

                Random random=new Random() ;
               int r=random.nextInt(6)+1;
                if(r==1)
                {
                    dice.setImageResource(R.drawable.dice1);
                }
                if(r==2)
                {
                    dice.setImageResource(R.drawable.dice2);
                }
                if(r==3)
                {
                    dice.setImageResource(R.drawable.dice3);
                }
                if(r==4)
                {
                    dice.setImageResource(R.drawable.dice4);
                }
                if(r==5)
                {
                    dice.setImageResource(R.drawable.dice5);
                }
                if(r==6)
                {
                    dice.setImageResource(R.drawable.dice6);
                }



                if(r!=1)
                {
                    y0=r+y0;
                    y1=y1+r;
                    t4.setText("CURRENT: "+y0);
                    t6.setText("TOTAL: "+y1);
                    if(y1>=50) {
                        Toast.makeText(getApplicationContext(), "YOU WIN ", Toast.LENGTH_SHORT).show();
                        reset.setEnabled(true);
                        hold.setEnabled(false);
                        roll.setEnabled(false);


                    }
                    //t1.setText("ANDI's TURN");
                }
                else
                {
                    y0=y1-y0;
                    y0=0;

                    t1.setText("ANDI's TURN.....");
                    roll.setEnabled(false);
                    hold.setEnabled(false);
                    reset.setEnabled(false);
                    andiplay();
                }
                t4.setText("CURRENT: " + y0);
                t6.setText("TOTAL: "+y1);
                //Toast.makeText(getApplicationContext(),"YOUR TURN ",Toast.LENGTH_SHORT ).show();
               // Toast.makeText(getApplicationContext(),"ROLL BUTTON CLICKED",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.button2 :
                y0=0;
                roll.setEnabled(false);
                hold.setEnabled(false);
                reset.setEnabled(false);
                t1.setText("ANDI's TURN.....");
                t4.setText("CURRENT: " + y0);
                t6.setText("TOTAL: "+y1);
                andiplay();

                //Toast.makeText(getApplicationContext(),"HOLD BUTTON CLICKED",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.button3 :
                y0=y1=a0=a1=0;
                t1.setText("STARTING GAME ..YOUR TURN.....");
                dice.setImageResource(R.drawable.dice1);
                t4.setText("CURRENT: " + 0);
                t6.setText("TOTAL: " + 0);
                t5.setText("CURRENT: " + 0);
                t7.setText("TOTAL: " + 0);
                roll.setEnabled(true);
                hold.setEnabled(true);
                reset.setEnabled(true);
                //Toast.makeText(getApplicationContext(),"RESET BUTTON CLICKED",Toast.LENGTH_SHORT ).show();
                break;

        }

    }

    private void andiplay() {
        //Toast.makeText(getApplicationContext(),"Sorry",Toast.LENGTH_SHORT ).show();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               // Toast.makeText(getApplicationContext(),"Sorry",Toast.LENGTH_SHORT ).show();

                Random random=new Random() ;
                int a=random.nextInt(6)+1;
                if(a==1)
                {
                    dice.setImageResource(R.drawable.dice1);
                }
                if(a==2)
                {
                    dice.setImageResource(R.drawable.dice2);
                }
                if(a==3)
                {
                    dice.setImageResource(R.drawable.dice3);
                }
                if(a==4)
                {
                    dice.setImageResource(R.drawable.dice4);
                }
                if(a==5)
                {
                    dice.setImageResource(R.drawable.dice5);
                }
                if(a==6)
                {
                    dice.setImageResource(R.drawable.dice6);
                }
                if(a!=1)
                {
                    a0=a0+a;
                    a1=a1+a;
                    t5.setText("CURRENT: "+a0);
                    t7.setText("TOTAL: "+a1);
                    //t1.setText("ANDI's TURN");

                    if(a1>=50) {
                        Toast.makeText(getApplicationContext(), "ANDI WINS ", Toast.LENGTH_SHORT).show();
                        reset.setEnabled(true);
                    }
                    else if(a1-y1<20)
                        andiplay();

                    else
                    {
                        a0 = 0;
                        t5.setText("CURRENT: " + a0);
                        t7.setText("TOTAL: "+a1);
                        Toast.makeText(getApplicationContext(),"ANDI CALLED HOLD",Toast.LENGTH_SHORT ).show();
                        roll.setEnabled(true);
                        hold.setEnabled(true);
                        reset.setEnabled(true);
                        t1.setText("YOUR'S TURN.....");
                    }
                }
                else {
                    a0 = 0;
                    t5.setText("CURRENT: " + a0);
                    t7.setText("TOTAL: " + a1);
                    t1.setText("YOUR TURN.....");
                    roll.setEnabled(true);
                    hold.setEnabled(true);
                    reset.setEnabled(true);
                    Toast.makeText(getApplicationContext(),"YOUR TURN ",Toast.LENGTH_SHORT ).show();
                }
            }
        },3000);
    }
}
