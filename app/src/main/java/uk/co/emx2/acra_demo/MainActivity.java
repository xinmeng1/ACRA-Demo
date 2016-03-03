package uk.co.emx2.acra_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.acra.ACRA;
import org.acra.ErrorReporter;


public class MainActivity extends AppCompatActivity {
    TextView tvHello;
    public static void trackBreadcrumb(String event) {

        ACRA.getErrorReporter().putCustomData("Event at " + System.currentTimeMillis(), event);
        Throwable caughtException = null;
        ACRA.getErrorReporter().handleException(caughtException);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ACRA.setLog(ACRA.log);
        trackBreadcrumb("MyActivity.onCreate()");
        //Send log by ACRA
        Log.d("TEst", "test d");
        Log.e("TEst", "test e");
        Log.w("TEst", "test w");
        Log.i("TEst", "test i");
        Log.v("TEst", "test v");
            Throwable caughtException = null;
        ErrorReporter errorReporter = ACRA.getErrorReporter();
        errorReporter.putCustomData("Event at " + System.currentTimeMillis(), "TEST");
        errorReporter.handleException(caughtException);
        ACRA.log.e("test","test-e");
        //tvHello.setText("Test Crash");
    }
}
