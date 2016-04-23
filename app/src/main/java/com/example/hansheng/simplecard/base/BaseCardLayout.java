package com.example.hansheng.simplecard.base;

import android.content.Context;
import android.util.AttributeSet;

import com.hansheng.cardmenu.CardFrameLayout;

/**
 * Created by hansheng on 2016/4/23.
 */
public class BaseCardLayout extends CardFrameLayout {
    //protected TextView txt_title;

    public BaseCardLayout(Context context) {
        this(context, null);
    }

    public BaseCardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreateView(context);
    }

    private void onCreateView(final Context context) {
        findViews();
        setViewsContent();
        setViewsListener();
    }

    /**
     *
     * 描述：把所有View找出来
     *
     * @createTime 2014-3-30 下午3:09:24
     * @createAuthor 健兴
     *
     * @updateTime 2014-3-30 下午3:09:24
     * @updateAuthor 健兴
     * @updateInfo
     *
     */
    protected void findViews() {
//		View.inflate(getContext(), R.layout.view_main_item_title, this);
//		txt_title = (TextView) findViewById(R.id.txt_title);
    }

    /**
     *
     * 描述：设置View的内容
     *
     * @createTime 2014-3-30 下午3:10:22
     * @createAuthor 健兴
     *
     * @updateTime 2014-3-30 下午3:10:22
     * @updateAuthor 健兴
     * @updateInfo
     *
     */
    protected void setViewsContent() {
    }

    /**
     *
     * 描述：设置View的监控器
     *
     * @createTime 2014-3-30 下午3:10:36
     * @createAuthor 健兴
     *
     * @updateTime 2014-3-30 下午3:10:36
     * @updateAuthor 健兴
     * @updateInfo
     *
     */
    protected void setViewsListener() {
    }
}

