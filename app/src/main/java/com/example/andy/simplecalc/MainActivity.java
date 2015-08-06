package com.example.andy.simplecalc;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
        private EditText mCalcString;
        private SharedPreferences mShPref;
        final String SAVED_RESULT = "saved_result";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                mCalcString= (EditText) this.findViewById(R.id.edit_calc_string);
                //blocks device keyboard on touch
                mCalcString.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                                mCalcString.setFocusable(true);
                                switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                        Layout layout = ((EditText) v).getLayout();
                                        float x = event.getX() + mCalcString.getScrollX();
                                        int offset = layout.getOffsetForHorizontal(0, x);
                                        if (offset > 0)
                                        if (x > layout.getLineMax(0))
                                                mCalcString.setSelection(offset);
                                        else
                                                mCalcString.setSelection(offset - 1);
                                        break;
                                }
                                return true;
                        }
                });
                //load last saved result
                mShPref = getPreferences(MODE_PRIVATE);
                String savedText = mShPref.getString(SAVED_RESULT, "");
                mCalcString.setText(savedText);
                //set button actions
                Button oneButton = (Button) findViewById(R.id.button_one);
                oneButton.setOnClickListener(this); // calling onClick() method
                Button twoButton = (Button) findViewById(R.id.button_two);
                twoButton.setOnClickListener(this);
                Button threeButton = (Button) findViewById(R.id.button_three);
                threeButton.setOnClickListener(this);
                Button fourButton = (Button) findViewById(R.id.button_four);
                fourButton.setOnClickListener(this); // calling onClick() method
                Button fiveButton = (Button) findViewById(R.id.button_five);
                fiveButton.setOnClickListener(this);
                Button sixButton = (Button) findViewById(R.id.button_six);
                sixButton.setOnClickListener(this);
                Button sevenButton = (Button) findViewById(R.id.button_seven);
                sevenButton.setOnClickListener(this); // calling onClick() method
                Button eightButton = (Button) findViewById(R.id.button_eight);
                eightButton.setOnClickListener(this);
                Button nineButton = (Button) findViewById(R.id.button_nine);
                nineButton.setOnClickListener(this);
                Button zeroButton = (Button) findViewById(R.id.button_zero);
                zeroButton.setOnClickListener(this); // calling onClick() method
                Button pointButton = (Button) findViewById(R.id.button_point);
                pointButton.setOnClickListener(this);
                Button openBktButton = (Button) findViewById(R.id.button_open_bkt);
                openBktButton.setOnClickListener(this);
                Button closeBktButton = (Button) findViewById(R.id.button_close_bkt);
                closeBktButton.setOnClickListener(this);
                Button backspaceButton = (Button) findViewById(R.id.button_backspace);
                backspaceButton.setOnClickListener(this);
                Button eqButton = (Button) findViewById(R.id.button_equal);
                eqButton.setOnClickListener(this);
                Button divButton = (Button) findViewById(R.id.button_divide);
                divButton.setOnClickListener(this);
                Button multButton = (Button) findViewById(R.id.button_multiply);
                multButton.setOnClickListener(this);
                Button addButton = (Button) findViewById(R.id.button_addition);
                addButton.setOnClickListener(this);
                Button subButton = (Button) findViewById(R.id.button_subtract);
                subButton.setOnClickListener(this);
                Button clearButton = (Button) findViewById(R.id.button_clear);
                clearButton.setOnClickListener(this);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                 // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                return super.onOptionsItemSelected(item);
        }

        private String zeroDelete(String input){String CalcStr= mCalcString.getText().toString();
                if(CalcStr.compareTo("0")==0){
                        return input;
                }
                else {
                        return CalcStr+input;
                }
        }

        //on click listener method
        @Override
        public void onClick(View v) {
                switch (v.getId()) {
                //buttons with numbers
                case R.id.button_one: {
                                String def = zeroDelete("1");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_two: {
                                String def = zeroDelete("2");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_three: {
                                String def = zeroDelete("3");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_four: {
                                String def = zeroDelete("4");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_five: {
                                String def = zeroDelete("5");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_six: {
                                    String def = zeroDelete("6");
                                    mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_seven: {
                                String def = zeroDelete("7");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_eight: {
                                String def = zeroDelete("8");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_nine: {
                                String def = zeroDelete("9");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_zero: {
                                String def = zeroDelete("0");
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                //operations actions
                case R.id.button_divide: {
                                String def = mCalcString.getText().toString();
                                def = def + "/";
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_multiply: {
                                String def = mCalcString.getText().toString();
                                def = def + "*";
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_addition: {
                                String def = mCalcString.getText().toString();
                                def = def + "+";
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_subtract: {
                                String def = mCalcString.getText().toString();
                                def = def + "-";
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_point: {
                                String def = mCalcString.getText().toString();
                                def = def + ".";
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_open_bkt: {
                                String def = mCalcString.getText().toString();
                                def = def + "(";
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                case R.id.button_close_bkt: {
                                String def = mCalcString.getText().toString();
                                def = def + ")";
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                //backspace button deletes last symbol in input line
                case R.id.button_backspace: {
                                String def = mCalcString.getText().toString();
                                if (def.length() > 0) {
                                        def = def.substring(0, def.length()-1);
                                }
                                else{
                                        def="";
                                }
                                mCalcString.setText(def, TextView.BufferType.EDITABLE);
                        }
                        break;
                /* equal button computes input string */
                case R.id.button_equal: {
                                String resultString;
                                int integ;
                                float fract;
                                String calcText= mCalcString.getText().toString();
                                if (calcText.length()==0){
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(),
                                            R.string.error, duration);
                                }
                                else {
                                        float result = 0;
                                        int i = 0;
                                        ReversePolishNotation rev = new ReversePolishNotation(calcText);
                                        rev.toReverseDefinition();
                                        /*if arise error while converting to reverse definition
                                        view message*/
                                        if (rev.ismError()) {
                                                int duration = Toast.LENGTH_LONG;
                                                Toast toast = Toast.makeText(getApplicationContext(),
                                                    R.string.error,duration);
                                                toast.setGravity(Gravity.CENTER, 0, 0);
                                                toast.show();
                                                mCalcString.setText("", TextView.BufferType.EDITABLE);
                                        }
                                        else {
                                                result = rev.Calc();
                                                if ((result == Float.POSITIVE_INFINITY) || (result == Float.NEGATIVE_INFINITY)) {
                                                        int duration = Toast.LENGTH_LONG;
                                                        Toast toast = Toast.makeText(getApplicationContext(),
                                                            R.string.div_zero, duration);
                                                        toast.setGravity(Gravity.CENTER, 0, 0);
                                                        toast.show();
                                                        mCalcString.setText("", TextView.BufferType.EDITABLE);
                                                }
                                                else {
                                                        if (Float.isNaN(result)) {
                                                                int duration = Toast.LENGTH_LONG;
                                                                Toast toast = Toast.makeText(getApplicationContext(),
                                                                    R.string.error, duration);
                                                                toast.setGravity(Gravity.CENTER, 0, 0);
                                                                toast.show();
                                                                mCalcString.setText("", TextView.BufferType.EDITABLE);
                                                        }
                                                        else {
                                                                integ = (int) Math.floor(result);
                                                                fract = Math.abs(result - integ);
                                                                if (fract == 0) {
                                                                        resultString = Integer.toString((int) result);
                                                                }
                                                                else {
                                                                        resultString = Float.toString(result);
                                                                }
                                                                mCalcString.setText(resultString, TextView.BufferType.EDITABLE);
                                                        }
                                                }
                                        }
                                }
                        }
                        break;
                 //clears input string
                case R.id.button_clear: {
                                mCalcString.setText("", TextView.BufferType.EDITABLE);
                        }
                        break;
                }
        }

        //save last computed result on destroy
        @Override
        protected void onDestroy() {
                mShPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = mShPref.edit();
                editor.putString(SAVED_RESULT, mCalcString.getText().toString());
                editor.commit();
                super.onDestroy();
        }
}
