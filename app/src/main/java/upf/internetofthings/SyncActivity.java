package upf.internetofthings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import upf.internetofthings.utilities.MyAsyncTask;

public class SyncActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_run_synctask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        Button btn_sync = (Button) findViewById(R.id.btn_run_synctask);
        btn_sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask runner = new MyAsyncTask();
                runner.execute();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
