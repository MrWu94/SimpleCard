package com.example.hansheng.simplecard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.hansheng.simplecard.utils.Press;

import java.util.HashMap;

/**
 * Created by hansheng on 2016/4/23.
 */
public class ScaleFrameLayout extends FrameLayout{

    /**
     * scale属性的key值
     */
    protected static final String KEY_SCALE = "scale";
    /**
     * View的高宽比例，默认是1，也就是高宽相等，当等于-1时，根据bitmap的比例设置宽高比
     */
    protected float mScale = 1;

    public ScaleFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTextAttribute(getTextAttributeMap(attrs));
    }

    public ScaleFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTextAttribute(getTextAttributeMap(attrs));
    }

    public ScaleFrameLayout(Context context) {
        super(context);
    }

    /**
     * 描述：根据text属性设置高宽比例
     *
     * @param
     * @updateInfo (此处输入修改内容, 若无修改可不写.)
     */
    protected void setTextAttribute(HashMap<String, String> attributeMap) {
        setScale(attributeMap);
    }

    /**
     * 描述：解析text为键值对
     *
     * @param attrs

     * @updateInfo (此处输入修改内容, 若无修改可不写.)
     */
    private HashMap<String, String> getTextAttributeMap(AttributeSet attrs) {
        String str = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        if (str == null) {
            return null;
        }
        String[] splits = str.split(",");
        HashMap<String, String> keyValueMap = null;
        if (splits != null && splits.length > 0) {
            keyValueMap = new HashMap<String, String>();
            for (String split : splits) {
                String[] keyValue = split.split(":");
                keyValueMap.put(keyValue[0], keyValue[1]);
            }
        }
        return keyValueMap;
    }

    /**
     * 描述：根据属性设置高宽比
     *
     * @param attributeMap
     * @updateInfo (此处输入修改内容, 若无修改可不写.)
     */
    private void setScale(HashMap<String, String> attributeMap) {
        if (attributeMap != null) {
            String str = attributeMap.get(KEY_SCALE);
            if (str != null) {
                mScale = Float.parseFloat(str);
            }
        }
    }

    /**
     * 描述：设置高宽比例
     *
     * @param scale

     * @updateInfo (此处输入修改内容, 若无修改可不写.)
     */
    public void setScale(float scale, boolean toInvalidate) {
        mScale = scale;
        if (toInvalidate) {
            invalidate();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0) {
            ViewGroup.LayoutParams params = getLayoutParams();
            params.width = w;
            params.height = (int) (w * getScale());
            setLayoutParams(params);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childWidthSize = getMeasuredWidth();
        int childHeightSize = (int) (childWidthSize * getScale());
        // 重设高度
        setMeasuredDimension(childWidthSize, childHeightSize);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Press.press(this, canvas);
    }

    boolean isPressed = false;

    @Override
    public void refreshDrawableState() {
        this.isPressed = Press.refreshDrawableState(this, this.isPressed);
        super.refreshDrawableState();
    }

    /**
     * 描述：判断并且返回比例

     * @updateInfo (此处输入修改内容, 若无修改可不写.)
     */
    protected float getScale() {
        return mScale;
    }
}
