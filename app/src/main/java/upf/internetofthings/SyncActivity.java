package upf.internetofthings;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import upf.internetofthings.utilities.MyAsyncTask;

public class SyncActivity extends AppCompatActivity implements View.OnClickListener {
    private final static int INTERVAL = 2000; //2 minutes
    Handler mHandler = new Handler();

    Runnable mHandlerTask = new Runnable()
    {
        @Override
        public void run() {
            MyAsyncTask runner = new MyAsyncTask();
            runner.execute();
            mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        Button btn_run_sync = (Button) findViewById(R.id.btn_run_synctask);
        btn_run_sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandlerTask.run();
            }
        });

        Button btn_stop_sync = (Button) findViewById(R.id.btn_stop_synctask);
        btn_stop_sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.removeCallbacks(mHandlerTask);            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
