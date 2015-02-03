package com.example.iguest.notification;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toast  = (Button) findViewById(R.id.toast_button);

        // On button click Open 2nd activity
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "TOAST", Toast.LENGTH_SHORT).show();
            }
        });
        Button alert = (Button) findViewById(R.id.alert_button);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(
                        MainActivity.this).create();
                alertDialog.setTitle("Alert Dialog");
                alertDialog.setMessage("Welcome to AndroidHive.info");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        Button notif = (Button) findViewById(R.id.notification_button);

        notif.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                Notification noti = new Notification.Builder(MainActivity.this)
                        .setTicker("INFO 498")
                        .setContentTitle("INFFOOOO")
                        .setContentText("NOTIFICATIONNNNNN")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentIntent(pIntent).getNotification();
                noti.flags=Notification.FLAG_AUTO_CANCEL;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, noti);
            }
        });
    }



}
