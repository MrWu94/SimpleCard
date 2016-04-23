package com.example.hansheng.simplecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.hansheng.simplecard.R;
import com.example.hansheng.simplecard.base.BaseCardLayout;

/**
 * Created by hansheng on 2016/4/23.
 */
public class OpusView extends BaseCardLayout {


    public OpusView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void findViews() {
        inflate(getContext(), R.layout.view_main_opus, this);

        TextView txt_title = new TextView(getContext());
        int pad = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, getResources().getDisplayMetrics());
        txt_title.setPadding(pad, pad, pad, pad);
        txt_title.setGravity(Gravity.CENTER_HORIZONTAL);
        txt_title.setText("作品");
        addView(txt_title, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        //super.findViews();
    }

    @Override
    protected void setViewsContent() {
//		DrawableUtil.setTextDrawableLeft(txt_title, -1, R.drawable.icon_opus);
//		txt_title.setText(R.string.opus);
    }

    @Override
    protected void setViewsListener() {
    }

}

