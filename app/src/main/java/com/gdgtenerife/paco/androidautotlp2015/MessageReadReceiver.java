package com.gdgtenerife.paco.androidautotlp2015;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by Paco on 04/07/2015.
 */
public class MessageReadReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int thisConversationId = intent.getIntExtra(MainActivity.MESSAGE_CONVERSATION_ID_KEY, -1);

        Log.d("Message Read", "id: " + thisConversationId);
        NotificationManagerCompat.from( context ).cancel( thisConversationId );
    }
}
