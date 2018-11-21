package upf.internetofthings;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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

    public class MyAsyncTask extends AsyncTask<String, Object, Object> {

        private Object resp;
        ProgressDialog progressDialog;


        @Override
        protected Object doInBackground(String... params) {
            resp = requestHttp();
            return resp;
        }

        private Object requestHttp() {
            publishProgress("Connecting..."); // Calls onProgressUpdate()
            try {
                URL url = new URL("http://192.168.2.10:3161/devices/");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(url.openStream());


                NodeList ids = doc.getElementsByTagName("id");
                String id;
                // Turn on every RFID antena
                for (int i = 0; i < ids.getLength(); i++) {
                    id = ids.item(i).getTextContent();
                    String url_path = "http://192.168.2.10:3161/devices/" + id + "/start/";
                    URL url_device = new URL(url_path);
                    HttpURLConnection con_device = (HttpURLConnection) url_device.openConnection();
                    con_device.getInputStream();
                    con_device.disconnect();
                }
                NodeList epc_tag = null;
                for (int i = 0; i < ids.getLength(); i++) {
                    id = ids.item(i).getTextContent();
                    String url_path_epc = "http://192.168.2.10:3161/devices/" + id + "/inventory/";
                    URL url_device_epc = new URL(url_path_epc);
                    HttpURLConnection con_device_epc = (HttpURLConnection) url_device_epc.openConnection();

                    con_device_epc.setRequestMethod("GET");
                    DocumentBuilderFactory dbf_device = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db_device = dbf_device.newDocumentBuilder();
                    Document doc_device = db_device.parse(url_device_epc.openStream());


                    epc_tag = doc_device.getElementsByTagName("epc");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


    }
}
