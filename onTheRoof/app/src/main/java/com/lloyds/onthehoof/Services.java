package com.lloyds.onthehoof;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.llyods.onthehoof.R;

import static com.llyods.onthehoof.R.color.darkgreen;

public class Services extends Activity {

    Button relationship_team;
    Button client_services;
    Button cardNet;
    Button online_helpdesk;
    Button bacs;
    Button lex;
    Button gtb;
    Button corpChargeCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        relationship_team = (Button) findViewById(R.id.relation_team);
        client_services = (Button) findViewById(R.id.client_services);
        cardNet = (Button) findViewById(R.id.card_net);
        online_helpdesk = (Button) findViewById(R.id.online_helpdesk);
        bacs = (Button) findViewById(R.id.BACS);
        lex = (Button) findViewById(R.id.LEX);
        gtb = (Button) findViewById(R.id.GTB);
        corpChargeCard = (Button) findViewById(R.id.corp_charge_card);

        relationship_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStart = new Intent("android.intent.action.COMMUNICATEWITHUS");
                startActivity(intentStart);
            }
        });

//        client_services.setBackgroundColor(darkgreen);
        client_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cardNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        online_helpdesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bacs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        gtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        corpChargeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_services, menu);
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
