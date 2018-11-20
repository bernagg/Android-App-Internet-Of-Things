package upf.internetofthings.utilities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MyAsyncTask extends AsyncTask<String, Object, Object> {

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