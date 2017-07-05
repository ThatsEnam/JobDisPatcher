package com.evolutioninc.jobdispatcher;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static int x = 0;
    JobScheduler jobScheduler;
    JobInfo.Builder jobInfo;
    EditText editText;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void TriggerJob(View view) {
        PersistableBundle persistableBundle = new PersistableBundle(10);
        // for (int i = 0; i <= 20000; i += 5000) {
        x++;
        jobInfo = new JobInfo.Builder(1 + x, new ComponentName(this, Job.class));
        //  jobInfo.setMinimumLatency(1 * 1000);
        persistableBundle.putString("sec", x + "");
        jobInfo.setExtras(persistableBundle);
        jobInfo.setOverrideDeadline(Integer.parseInt(editText.getText().toString()) * 1000);

        // if (i != 0) {
        //  jobInfo.setOverrideDeadline(Integer.parseInt(editText.getText().toString()) * 1000*i);
        // }
        jobScheduler.schedule(jobInfo.build());
        // }
    }

}