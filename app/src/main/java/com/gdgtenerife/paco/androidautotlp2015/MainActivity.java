package com.gdgtenerife.paco.androidautotlp2015;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;

import java.util.Calendar;


public class MainActivity extends Activity implements TextToSpeech.OnInitListener{

    private static final String MESSAGE_READ_ACTION = "com.gdgtenerife.paco.androidautotlp2015.ACTION_MESSAGE_READ";
    private static final String MESSAGE_REPLY_ACTION = "com.gdgtenerife.paco.androidautotlp2015.ACTION_MESSAGE_REPLY";
    public static final String MESSAGE_CONVERSATION_ID_KEY = "conversaton_key";
    public static final String VOICE_REPLY_KEY = "voice_reply_key";
    public static final String TEXT_REPLY_KEY = "text_reply_key";
    private static final String UNREAD_CONVERSATION_BUILDER_NAME = "Android Auto Messenger Demo";

    public static TextToSpeech engineVoiceApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main );

        engineVoiceApp = new TextToSpeech(this, this);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder( getApplicationContext() )
                        .setSmallIcon( R.drawable.tlp )
                        .setLargeIcon( BitmapFactory.decodeResource( getResources(), R.drawable.ic_launcher ) )
                        .setContentText( "Notificaciones Prueba Android Auto TLP" )
                        .setWhen( Calendar.getInstance().get( Calendar.SECOND ) )
                        .setContentTitle( "TLP Innova 2015" );

        notificationBuilder.extend( new NotificationCompat.CarExtender()
                .setUnreadConversation( getUnreadConversation() ) )
                .setColor(getResources().getColor( android.R.color.holo_blue_bright ) );

        NotificationManagerCompat.from( this ).notify( 1, notificationBuilder.build() );
    }

    private Intent getMessageReadIntent() {
        return new Intent()
                .addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                .setAction(MESSAGE_READ_ACTION)
                .putExtra(MESSAGE_CONVERSATION_ID_KEY, 1);
    }

    private PendingIntent getMessageReadPendingIntent() {
        return PendingIntent.getBroadcast( getApplicationContext(),
                1,
                getMessageReadIntent(),
                PendingIntent.FLAG_UPDATE_CURRENT );
    }

    private Intent getMessageReplyIntent() {
        return new Intent()
                .addFlags( Intent.FLAG_INCLUDE_STOPPED_PACKAGES )
                .setAction( MESSAGE_REPLY_ACTION )
                .putExtra( MESSAGE_CONVERSATION_ID_KEY, 1 )
                .putExtra(TEXT_REPLY_KEY, getString(R.string.replay));
    }

    private PendingIntent getMessageReplyPendingIntent() {
        return PendingIntent.getBroadcast( getApplicationContext(),
                1,
                getMessageReplyIntent(),
                PendingIntent.FLAG_UPDATE_CURRENT );
    }

    private RemoteInput getVoiceReplyRemoteInput() {
        return new RemoteInput.Builder( VOICE_REPLY_KEY )
                .setLabel("Reply")
                .build();
    }

    private NotificationCompat.CarExtender.UnreadConversation getUnreadConversation() {
        NotificationCompat.CarExtender.UnreadConversation.Builder unreadConversationBuilder =
                new NotificationCompat.CarExtender.UnreadConversation.Builder( UNREAD_CONVERSATION_BUILDER_NAME );

        unreadConversationBuilder.setReadPendingIntent(getMessageReadPendingIntent());
        unreadConversationBuilder.setReplyAction(getMessageReplyPendingIntent(), getVoiceReplyRemoteInput());
        unreadConversationBuilder.addMessage( "G D G... G D G... G D G... G D G... G D G" );
        unreadConversationBuilder.addMessage( "Gracias por venir." )
                .setLatestTimestamp(Calendar.getInstance().get(Calendar.SECOND));

        return unreadConversationBuilder.build();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Set Languague, if you want
            speech("Yo soy el móvil. Esta será mi voz sexy, para diferenciarme de la voz anglosajona fea y fría de: Android. Auto");
        }
    }

    public static void speech (String text){
        engineVoiceApp.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

}
