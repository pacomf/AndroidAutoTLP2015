package com.gdgtenerife.paco.androidautotlp2015;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by Paco on 04/07/2015.
 */
public class MessageReplyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // If you set up the intent as described in
        // "Create conversation read and reply intents",
        // you can get the conversation ID by calling:

        int thisConversationId = intent.getIntExtra(MainActivity.MESSAGE_CONVERSATION_ID_KEY, -1);
        Log.d("Message Reply", "id: " + thisConversationId);
        NotificationManagerCompat.from(context).cancel( thisConversationId );

        String messageText = intent.getStringExtra(MainActivity.TEXT_REPLY_KEY);

        Log.d("Paco out: ", "Texto Recibido: "+messageText);

        MainActivity.speech(messageText);

        String messageVoice = getMessageFromIntent(intent);

        Log.d("Paco out: ", "Mensaje de Voz Recibido: "+messageVoice);

    }

    /**
     * Get the message text from the intent.
     * Note that you should call
     * RemoteInput.getResultsFromIntent() to process
     * the RemoteInput.
     */
    private String getMessageFromIntent( Intent intent ) {
        //Note that Android Auto does not currently allow voice responses in their simulator
        Bundle remoteInput = RemoteInput.getResultsFromIntent( intent );
        if( remoteInput != null && remoteInput.containsKey( "extra_voice_reply" ) ) {
            return remoteInput.getCharSequence( "extra_voice_reply" ).toString();
        }

        return null;
    }

}
