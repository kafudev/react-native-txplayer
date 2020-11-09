package com.reactnativetxplayer;

import androidx.annotation.NonNull;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.image.ImageResizeMode;

public class TxplayerManager extends SimpleViewManager<TxplayerView> {

  ReactApplicationContext mCallerContext;

  public TxplayerManager(ReactApplicationContext reactContext) {
    mCallerContext = reactContext;
  }

  @Override
  public String getName() {
    return "TxplayerView";
  }

  @NonNull
  @Override
  protected TxplayerView createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new TxplayerView(reactContext);
//    return new TxplayerView(reactContext, Fresco.newDraweeControllerBuilder(), null, mCallerContext);
  }

//  @ReactProp(name = "src")
//  public void setSrc(TxplayerView view, @Nullable ReadableArray sources) {
//    view.setSource(sources);
//  }
//
//  @ReactProp(name = "borderRadius", defaultFloat = 0f)
//  public void setBorderRadius(TxplayerView view, float borderRadius) {
//    view.setBorderRadius(borderRadius);
//  }
//
//  @ReactProp(name = ViewProps.RESIZE_MODE)
//  public void setResizeMode(TxplayerView view, @Nullable String resizeMode) {
//    view.setScaleType(ImageResizeMode.toScaleType(resizeMode));
//  }
}
