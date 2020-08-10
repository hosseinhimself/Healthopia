package ir.hosseinmh.healthopia;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class init extends Application {
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
