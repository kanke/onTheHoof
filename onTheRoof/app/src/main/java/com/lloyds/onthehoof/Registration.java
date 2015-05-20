package com.lloyds.onthehoof;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lloyds.onthehoof.Adapter.RegistrationDbAdapter;
import com.llyods.onthehoof.R;


public class Registration extends Activity {

    RegistrationDbAdapter dbAdapter;
    EditText customerNum;
    EditText sortCode;
    EditText accNum;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        customerNum = (EditText) findViewById(R.id.customer_number);
        sortCode = (EditText) findViewById(R.id.sort_code);
        accNum = (EditText) findViewById(R.id.acc_number);
        register = (Button) findViewById(R.id.register);

        dbAdapter = new RegistrationDbAdapter(this);
        dbAdapter.open();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(customerNum.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(sortCode.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(accNum.getWindowToken(), 0);
                try {
                    String cust_num = customerNum.getText().toString();
                    String sort_code = sortCode.getText().toString();
                    String acc_Num = accNum.getText().toString();

                    long sortCodeAndAccNum = dbAdapter.registerWithSrtCode(sort_code, acc_Num);
//                    long customerNum = dbAdapter.registerWithCustNum(cust_num);

                    if (sortCodeAndAccNum != -1) {
                        Toast.makeText(Registration.this, "You have successfully registered a Sort Code & Acc Number",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent("com.lloyds.onthehoof.MainActivity");
                        startActivity(intent);
                    }
//                    else if (customerNum != -1) {
//                        Toast.makeText(Registration.this, "You have successfully registered with a Customer Number",
//                                Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent("com.lloyds.onthehoof.MainActivity");
//                        startActivity(intent);
//                    }

                } catch (SQLiteException e) {
                    Toast.makeText(Registration.this, "Some problem occurred",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
