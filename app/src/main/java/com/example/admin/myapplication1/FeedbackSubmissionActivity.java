package com.example.admin.myapplication1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackSubmissionActivity extends AppCompatActivity {
    private RatingBar ratingBar;
    private EditText editText;
    private Button button;
    static float ratingS;
    private NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_submission);
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingS=rating;
            }
        });
        notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          //  Toast.makeText(FeedbackSubmissionActivity.this, "Onclick", Toast.LENGTH_SHORT).show();
            String msg=editText.getText().toString();
            NotificationCompat.Builder builder=new NotificationCompat.Builder(FeedbackSubmissionActivity.this);
            builder.setContentTitle("You have a new feedback");
            builder.setContentText(msg);
            builder.setSmallIcon(R.mipmap.ic_launcher_round);
            Intent intent=new Intent(FeedbackSubmissionActivity.this,FeedbacksVisualizationApp.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),101,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            Notification notification=builder.build();

            notificationManager.notify(10,notification);
        }
    });
    }
}
