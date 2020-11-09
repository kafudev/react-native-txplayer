package com.reactnativetxplayer;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class TxplayerModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext sContext;

    public TxplayerModule(ReactApplicationContext reactApplicationContext) {
      super(reactApplicationContext);
      sContext = reactApplicationContext;
      // init(appKey, appName);
      //Diagnosis.setDevServer(1);
    }

    @Override
    public String getName() {
        return "Txplayer";
    }

    @ReactMethod
    public void multiply(int a, int b, Promise promise) {
      promise.resolve(a * b);
    }


}
