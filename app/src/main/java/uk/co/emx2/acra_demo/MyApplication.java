package uk.co.emx2.acra_demo;

import android.app.Application;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

/**
 * Created by Android Studio.
 * User: Xin Meng
 * Date: 02/03/2016
 * Time: 23:44
 * Version: V 1.0
 */


/*
*
* Key
whisceselatcherlyseseefo
Password
609d74327d98c078f5cdf3b2e48e35400cfca829
* */
@ReportsCrashes(
        formUri = "https://mengxin.cloudant.com/acra-idigisign/_design/acra-storage/_update/report",
        reportType = HttpSender.Type.JSON,
        httpMethod = HttpSender.Method.POST,
        formUriBasicAuthLogin = "whisceselatcherlyseseefo",
        formUriBasicAuthPassword = "609d74327d98c078f5cdf3b2e48e35400cfca829",
        //formKey = "", // This is required for backward compatibility but not used
        customReportContent = {
                ReportField.APP_VERSION_CODE,
                ReportField.APP_VERSION_NAME,
                ReportField.ANDROID_VERSION,
                ReportField.PACKAGE_NAME,
                ReportField.REPORT_ID,
                ReportField.BUILD,
                ReportField.STACK_TRACE
        },
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.toast_crash
)

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // The following line triggers the initialization of ACRA
        ACRA.init(this);

    }
}
