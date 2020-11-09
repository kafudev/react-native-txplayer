package com.reactnativetxplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.FrameLayout;

import com.tencent.liteav.demo.play.SuperPlayerView;

class TxplayerView extends FrameLayout  {
  public TxplayerView(Context context) {
    super(context);
    new SuperPlayerView(context);
  }

  public TxplayerView(Context context, AttributeSet attrs) {
      super(context, attrs);
  }

  public TxplayerView(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
  }
}
