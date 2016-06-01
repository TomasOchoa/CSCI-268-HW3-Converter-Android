package com.tomasochoa.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button Calculate = (Button)findViewById(R.id.calculate);

        Calculate.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        // ***************** Get values from user input *****************
                        // Variable declaration
                        String feet_string_input, inches_string_input;
                        int feet_int_input, inches_int_input;
                        double cent;

                        // Setting feet input
                        EditText feet_input = (EditText)findViewById(R.id.edit_feet);
                        feet_string_input = feet_input.getText().toString();
                        feet_int_input = Integer.parseInt(feet_string_input);

                        // Setting inches input
                        EditText inches_input = (EditText)findViewById(R.id.edit_inches);
                        inches_string_input = inches_input.getText().toString();
                        inches_int_input = Integer.parseInt(inches_string_input);

                        //********************* Make Conversion Calculations ********************
                        cent = ((feet_int_input * 12) + inches_int_input) * 2.54;
                        //STUFF FOR CALCULATE BUTTON
                        // Convert the value of cent to string and
                        // post it to user
                        TextView Result = (TextView)findViewById(R.id.output);
                        Double cent_going_out = new BigDecimal(cent).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                        Result.setText(Double.toString(cent_going_out));
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
