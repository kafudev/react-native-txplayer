package com.reactnativetxplayer;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.reactnativetxplayer.R;

import com.tencent.liteav.demo.play.SuperPlayerConst;
import com.tencent.liteav.demo.play.SuperPlayerGlobalConfig;
import com.tencent.liteav.demo.play.SuperPlayerModel;
import com.tencent.liteav.demo.play.SuperPlayerView;
import com.tencent.rtmp.TXLiveConstants;

class TxplayerView extends FrameLayout {
  public TextView textView;
  public SuperPlayerView mSuperPlayerView;

  public TxplayerView(Context context) {
    super(context);
    init(context);
  }

  public TxplayerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public TxplayerView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context) {
//    LayoutInflater.from(context).inflate(R.layout.superplayer_view, this, true);
//    textView = (TextView) this.findViewById(R.id.tv01);
//    textView.setText("我是一个CustomView");
//    textView.setTextColor(Color.parseColor("#ff0000"));

//    mSuperPlayerView = (SuperPlayerView) this.findViewById(R.id.superVodPlayerView);
    mSuperPlayerView = new SuperPlayerView(context);
    addView(mSuperPlayerView);

    // 播放器配置
    SuperPlayerGlobalConfig prefs = SuperPlayerGlobalConfig.getInstance();
    // 开启悬浮窗播放
    prefs.enableFloatWindow = false;
    // 设置悬浮窗的初始位置和宽高
    SuperPlayerGlobalConfig.TXRect rect = new SuperPlayerGlobalConfig.TXRect();
    rect.x = 0;
    rect.y = 0;
    rect.width = 480;
    rect.height = 320;
    prefs.floatViewRect = rect;
    // 播放器默认缓存个数
    prefs.maxCacheItem = 5;
    // 设置播放器渲染模式
    prefs.enableHWAcceleration = true;
    prefs.renderMode = TXLiveConstants.RENDER_MODE_ADJUST_RESOLUTION;

  }

  public SuperPlayerView getSuperPlayerView() {
    return mSuperPlayerView;
  }

  public void setSuperPlayerView(SuperPlayerView mSuperPlayerView) {
    this.mSuperPlayerView = mSuperPlayerView;
  }

  public void onReceiveNativeEvent(String message, Integer state) {
    WritableMap event = Arguments.createMap();
    WritableMap ee = Arguments.createMap();
    ee.putString("message", message);
    ee.putInt("state", state);
    event.putMap("message", ee);
    ReactContext reactContext = (ReactContext) getContext();
    reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
      getId(),
      "topChange",
      event);
  }
}
