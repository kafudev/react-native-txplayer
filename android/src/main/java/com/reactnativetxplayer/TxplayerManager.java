package com.reactnativetxplayer;

import androidx.annotation.NonNull;

import android.view.SurfaceView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.image.ImageResizeMode;

import com.reactnativetxplayer.R;

import com.tencent.liteav.demo.play.SuperPlayerConst;
import com.tencent.liteav.demo.play.SuperPlayerGlobalConfig;
import com.tencent.liteav.demo.play.SuperPlayerModel;
import com.tencent.liteav.demo.play.SuperPlayerView;
import com.tencent.rtmp.TXLiveConstants;

public class TxplayerManager extends SimpleViewManager<TxplayerView> {

  ReactApplicationContext mCallerContext;
  SuperPlayerView mSuperPlayerView;

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

  @ReactProp(name = "showVideoView", defaultBoolean = false)
  public void setShowVideoView(final TxplayerView txplayerView, boolean showVideoView) {
    if (showVideoView) {
      // SurfaceView surfaceView = ILiveManager.getInstance().getVideoView();
      // txplayerView.addView(surfaceView);
      //  mSuperPlayerView = findViewById(R.layout.superVodPlayerView);
//            mSuperPlayerView = new SuperPlayerView(mCallerContext);
      //mSuperPlayerView = txplayerView.getSuperPlayerView();
//          txplayerView.addView(mSuperPlayerView);
//          // 播放器配置
//          SuperPlayerGlobalConfig prefs = SuperPlayerGlobalConfig.getInstance();
//          // 开启悬浮窗播放
//          prefs.enableFloatWindow = true;
//          // 设置悬浮窗的初始位置和宽高
//          SuperPlayerGlobalConfig.TXRect rect = new SuperPlayerGlobalConfig.TXRect();
//          rect.x = 0;
//          rect.y = 0;
//          rect.width = 810;
//          rect.height = 540;
//          prefs.floatViewRect = rect;
//          // 播放器默认缓存个数
//          prefs.maxCacheItem = 5;
//          // 设置播放器渲染模式
//          prefs.enableHWAcceleration = true;
//          prefs.renderMode = TXLiveConstants.RENDER_MODE_ADJUST_RESOLUTION;
//
//      // 通过URL方式的视频信息配置
//      SuperPlayerModel model2 = new SuperPlayerModel();
//      model2.title = "测试视频-720P";
//      model2.url = "http://1252463788.vod2.myqcloud.com/95576ef5vodtransgzp1252463788/68e3febf4564972819220421305/v.f30.mp4";
//      // 开始播放
//      // mSuperPlayerView.playWithModel(model2);
    }
  }


  @ReactProp(name = "startPlay", defaultBoolean = false)
  public void setStartPlay(final TxplayerView txplayerView, boolean startPlay) {
    mSuperPlayerView = txplayerView.getSuperPlayerView();
    if (startPlay) {
      if (mSuperPlayerView.getPlayState() == SuperPlayerConst.PLAYSTATE_PAUSE) {
        mSuperPlayerView.onResume();
        mSuperPlayerView.requestPlayMode(SuperPlayerConst.PLAYMODE_WINDOW);
      } else if (mSuperPlayerView.getPlayMode() == SuperPlayerConst.PLAYSTATE_END) {
        mSuperPlayerView.onResume();
        mSuperPlayerView.requestPlayMode(SuperPlayerConst.PLAYMODE_WINDOW);
      } else {
        // 重新开始播放
        // 通过URL方式的视频信息配置
        SuperPlayerModel model2 = new SuperPlayerModel();
        model2.appId = 1252463788;
        model2.title = "测试视频-720P";
        model2.url = "http://1252463788.vod2.myqcloud.com/95576ef5vodtransgzp1252463788/68e3febf4564972819220421305/v.f30.mp4";
        mSuperPlayerView.playWithModel(model2);
        mSuperPlayerView.requestPlayMode(SuperPlayerConst.PLAYMODE_WINDOW);
      }
    }
  }

  @ReactProp(name = "pausePlay", defaultBoolean = false)
  public void setPausePlay(final TxplayerView txplayerView, boolean pausePlay) {
    mSuperPlayerView = txplayerView.getSuperPlayerView();
    if (pausePlay) {
      if (mSuperPlayerView.getPlayMode() == SuperPlayerConst.PLAYSTATE_PLAYING) {
        // 暂停播放
        mSuperPlayerView.onPause();
      }
    }
  }

  @ReactProp(name = "stopPlay", defaultBoolean = false)
  public void setStopPlay(final TxplayerView txplayerView, boolean stopPlay) {
    mSuperPlayerView = txplayerView.getSuperPlayerView();
    if (stopPlay) {
      // 停止播放
      mSuperPlayerView.resetPlayer();
    }
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
