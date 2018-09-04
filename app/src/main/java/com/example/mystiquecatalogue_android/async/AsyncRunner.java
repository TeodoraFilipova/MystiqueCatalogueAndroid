package com.example.mystiquecatalogue_android.async;

import android.os.AsyncTask;
import android.os.Handler;

public class AsyncRunner {
    public static void runInBackground(Runnable action) {
        Handler handler = new Handler();
        handler.postDelayed(()-> {
            new AsyncTask<Boolean, Void, Void>() {
                @Override
                protected Void doInBackground(Boolean... booleans) {
                    action.run();
                    return null;
                }
            }.execute(true);
        }, 4000);

    }
}
