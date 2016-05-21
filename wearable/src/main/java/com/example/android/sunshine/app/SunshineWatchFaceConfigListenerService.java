//package com.example.android.sunshine.app;
//
//import android.os.Bundle;
//import android.util.Log;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.wearable.DataMap;
//import com.google.android.gms.wearable.MessageEvent;
//import com.google.android.gms.wearable.Wearable;
//import com.google.android.gms.wearable.WearableListenerService;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by Jon on 5/7/2016.
// */
//public class SunshineWatchFaceConfigListenerService extends WearableListenerService
//        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
//    private static final String TAG = "SunshineListenerService";
//
//    private GoogleApiClient mGoogleApiClient;
//
//    @Override // WearableListenerService
//    public void onMessageReceived(MessageEvent messageEvent) {
//
//        if (Log.isLoggable(TAG, Log.DEBUG)) {
//            Log.d(TAG, "onMessageReceived: " + messageEvent);
//        }
//
//        if (!messageEvent.getPath().equals(SunshineWatchFaceUtil.PATH_WITH_FEATURE)) {
//            return;
//        }
//        byte[] rawData = messageEvent.getData();
//        // It's allowed that the message carries only some of the keys used in the config DataItem
//        // and skips the ones that we don't want to change.
//        DataMap configKeysToOverwrite = DataMap.fromByteArray(rawData);
//        if (Log.isLoggable(TAG, Log.DEBUG)) {
//            Log.d(TAG, "Received watch face config message: " + configKeysToOverwrite);
//        }
//
//        if (mGoogleApiClient == null) {
//            mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this).addApi(Wearable.API).build();
//        }
//        if (!mGoogleApiClient.isConnected()) {
//            ConnectionResult connectionResult =
//                    mGoogleApiClient.blockingConnect(30, TimeUnit.SECONDS);
//
//            if (!connectionResult.isSuccess()) {
//                Log.e(TAG, "Failed to connect to GoogleApiClient.");
//                return;
//            }
//        }
//
//        SunshineWatchFaceUtil.overwriteKeysInConfigDataMap(mGoogleApiClient, configKeysToOverwrite);
//    }
//
//    @Override // GoogleApiClient.ConnectionCallbacks
//    public void onConnected(Bundle connectionHint) {
//        if (Log.isLoggable(TAG, Log.DEBUG)) {
//            Log.d(TAG, "onConnected: " + connectionHint);
//        }
//    }
//
//    @Override  // GoogleApiClient.ConnectionCallbacks
//    public void onConnectionSuspended(int cause) {
//        if (Log.isLoggable(TAG, Log.DEBUG)) {
//            Log.d(TAG, "onConnectionSuspended: " + cause);
//        }
//    }
//
//    @Override  // GoogleApiClient.OnConnectionFailedListener
//    public void onConnectionFailed(ConnectionResult result) {
//        if (Log.isLoggable(TAG, Log.DEBUG)) {
//            Log.d(TAG, "onConnectionFailed: " + result);
//        }
//    }
//}