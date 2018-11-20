package upf.internetofthings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import upf.internetofthings.utilities.ConnSQLiteHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnSQLiteHelper conn = new ConnSQLiteHelper(this, "bd_items", null, 1);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_activity_sync:
                intent = new Intent(MainActivity.this, SyncActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }


}
