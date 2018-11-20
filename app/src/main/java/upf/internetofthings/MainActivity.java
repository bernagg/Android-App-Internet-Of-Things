package upf.internetofthings;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_run_async;
    private TextView tv_finalresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_run_async = (Button) findViewById(R.id.btn_run_main);
        tv_finalresult = (TextView) findViewById(R.id.tv_result);

        bt_run_async.setOnClickListener(new View.OnClickListener() {
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

    private class MyAsyncTask extends AsyncTask<String, Object, Object> {

        private Object resp;
        ProgressDialog progressDialog;


        @Override
        protected Object doInBackground(String... params) {
            publishProgress("Connecting..."); // Calls onProgressUpdate()
            try {
                URL url = new URL("https://www.ara.cat/rss/esports/");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");


                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(url.openStream());


                NodeList titles = doc.getElementsByTagName("title");
                for (int i = 0; i < titles.getLength(); i++) {
                    Log.i("INFOOOOOOOOOOOOOOOOOOOO", titles.item(i).getTextContent());
                }


            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            //return resp;
            return resp;
        }


    }
}
