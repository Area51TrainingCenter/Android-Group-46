package com.area51.claseserviciopost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class InternetBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentService = new Intent(context, InternetService.class);
        context.startService(intentService);
    }
}
