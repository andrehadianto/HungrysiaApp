package com.example.andre.hungrysiaapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;


public class NotificationReminder extends ContextWrapper {
    private static final String ID = "com.example.andre.hungrysiaapp.Reminder";
    private static final String NAME = "Hungrysia Reminder";
    private NotificationManager manager;
    public NotificationReminder(Context base){
        super(base);
        createChannels();
    }

    private void createChannels() {
        NotificationChannel getReminder = new NotificationChannel(ID,NAME,NotificationManager.IMPORTANCE_DEFAULT);
        getReminder.enableLights(true);
        getReminder.enableVibration(true);
        getReminder.setLightColor(Color.BLUE);
        getReminder.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(getReminder);
    }

    public NotificationManager getManager() {
        if(manager == null){
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    public Notification.Builder getReminder(){
        return new Notification.Builder(getApplicationContext(),ID)
                .setContentText("Have you ordered your dinner/supper?")
                .setContentTitle("Hungrysia is now open!")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true);
    }

}
