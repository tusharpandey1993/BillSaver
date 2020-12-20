package com.debugged.warrantysaver.alarm;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationManagerCompat;

import com.debugged.warrantysaver.MainActivity;
import com.debugged.warrantysaver.R;

public class MyNewIntentService extends JobIntentService {
    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {

    }

    @Override
    protected void onHandleWork(@NonNull @org.jetbrains.annotations.NotNull Intent intent) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("My Title");
        builder.setContentText("This is the Body");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        Intent notifyIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //to be able to launch your activity from the notification
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);
    }
}