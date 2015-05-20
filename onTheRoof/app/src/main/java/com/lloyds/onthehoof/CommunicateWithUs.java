package com.lloyds.onthehoof;

import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.llyods.onthehoof.R;


public class CommunicateWithUs extends Activity {

    Button callUs;
    Button emailUs;
    Button chatWithUs;
    Button callBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate_with_us);

        callUs = (Button) findViewById(R.id.call_us);
        emailUs = (Button) findViewById(R.id.email_us);
        chatWithUs = (Button) findViewById(R.id.chat_with_us);
        callBack = (Button) findViewById(R.id.we_call_back);

        callUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:07939694618"));
                startActivity(callIntent);
            }
        });

        emailUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@llyodsbanking.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "BACS HelpDesk Query");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "I will ike to require assistance in sorting out my BACS.Kindly assist.");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Choose an email provider :"));
            }
        });

        chatWithUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("clicks", "You Clicked Chat Button");
                Intent sky = new Intent(Intent.ACTION_VIEW);
                sky.setData(Uri.parse("https://plus.google.com/hangouts/_/72cpjj252brgi4hhtqn4j68a48?hl=en"));
                startActivity(sky);
            }
        });

        callBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("clicks", "You Clicked B1");
                Intent intent = new Intent(CommunicateWithUs.this, Main_2.class);
                startActivity(intent);
            }
        });
    }

    //monitor phone call activities
    private class PhoneCallListener extends PhoneStateListener {

        private boolean isPhoneCalling = false;

        String LOG_TAG = "LOGGING 123";

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                // phone ringing
                Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
            }

            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
                // active
                Log.i(LOG_TAG, "OFFHOOK");

                isPhoneCalling = true;
            }

            if (TelephonyManager.CALL_STATE_IDLE == state) {
                // run when class initial and phone call ended,
                // need detect flag from CALL_STATE_OFFHOOK
                Log.i(LOG_TAG, "IDLE");

                if (isPhoneCalling) {

                    Log.i(LOG_TAG, "restart app");

                    // restart app
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(
                                    getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                    isPhoneCalling = false;
                }

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_communicate_with_us, menu);
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
