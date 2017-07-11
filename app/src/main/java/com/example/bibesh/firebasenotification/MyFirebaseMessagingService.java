package com.example.bibesh.firebasenotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.MainThread;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * Created by Bibesh on 7/11/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.v(TAG, "FROM: " + remoteMessage.getFrom());
        //Check if message conftains data
        if (remoteMessage.getData().size() > 0) {
            Log.v(TAG, "DATA" + remoteMessage.getData());
        }


        //check if contains notification
        if (remoteMessage.getNotification() != null) {
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String body) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("HELLO")
                .setContentText(body).setContentIntent(pi);
        NotificationManager nM = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nM.notify(0,builder.build());
    }
}
