package com.evolutioninc.jobdispatcher;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by That's Enam on 7/4/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Job extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        Toast.makeText(this, "Job Executing........"+params.getExtras().getString("sec"), Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
