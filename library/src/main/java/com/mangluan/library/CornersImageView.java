package com.mangluan.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义控件
 * 后期会加入蒙层、边框
 * <p>
 * 圆角ImageView
 */
public class CornersImageView extends android.support.v7.widget.AppCompatImageView {


    /**
     * 初始化方法   单位 px
     *
     * @param context 上下文
     * @param radius  圆角弧度
     */
    public CornersImageView(Context context, float radius) {
        this(context, null);
        this.radius = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
    }

    /**
     * 初始化方法   单位 px
     *
     * @param context           上下文
     * @param bottomLeftRadius  左下角弧度
     * @param bottomRightRadius 右下角弧度
     * @param topRightRadius    右上角弧度
     * @param topLeftRadius     左上角弧度
     */
    public CornersImageView(Context context, float bottomLeftRadius, float bottomRightRadius, float topRightRadius, float topLeftRadius) {
        this(context, null);
        this.radius = new float[]{topLeftRadius, topLeftRadius, topRightRadius
                , topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius};
    }

    public CornersImageView(Context context) {
        this(context, 0);
    }

    public CornersImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CornersImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // 圆角的半径，依次为左上角xy半径，右上角，右下角，左下角
    private float[] radius;

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {    // 不等于null的时候  可以获取里面的内容
            // 绑定属性
            TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.CornersImageView);
            // 获取各种属性
            float radius = mTypedArray.getDimension(R.styleable.CornersImageView_radius, 0);
            float bottomLeftRadius = mTypedArray.getDimension(R.styleable.CornersImageView_bottomLeftRadius, radius);
            float bottomRightRadius = mTypedArray.getDimension(R.styleable.CornersImageView_bottomRightRadius, radius);
            float topRightRadius = mTypedArray.getDimension(R.styleable.CornersImageView_topRightRadius, radius);
            float topLeftRadius = mTypedArray.getDimension(R.styleable.CornersImageView_topLeftRadius, radius);
            // 圆角初始化
            this.radius = new float[]{topLeftRadius, topLeftRadius, topRightRadius
                    , topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius};
            mTypedArray.recycle();
        }
        mPath = new Path();
        paintFlagsDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);
    }

    private Path mPath;
    private RectF mRectF;
    private PaintFlagsDrawFilter paintFlagsDrawFilter;

    @Override
    protected void onDraw(Canvas canvas) {
        mPath.reset();
        mPath.addRoundRect(mRectF, radius, Path.Direction.CW);
        canvas.setDrawFilter(paintFlagsDrawFilter);
        canvas.save();
        canvas.clipPath(mPath);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRectF = new RectF(0, 0, w, h);
    }

    /**
     * 单独设置 全局圆角弧度
     *
     * @param radius 全局圆角弧度
     */
    public void setRadius(float radius) {
        this.radius = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
    }

    /**
     * 单独设置 左下角弧度
     *
     * @param bottomLeftRadius 左下角弧度
     */
    public void setBottomLeftRadius(float bottomLeftRadius) {
        this.radius[6] = bottomLeftRadius;
        this.radius[7] = bottomLeftRadius;
    }

    /**
     * 单独设置 右下角弧度
     *
     * @param bottomRightRadius 右下角弧度
     */
    public void setBottomRightRadius(float bottomRightRadius) {
        this.radius[4] = bottomRightRadius;
        this.radius[5] = bottomRightRadius;
    }

    /**
     * 单独设置 右上角弧度
     *
     * @param topRightRadius 右上角弧度
     */
    public void setTopRightRadius(float topRightRadius) {
        this.radius[2] = topRightRadius;
        this.radius[3] = topRightRadius;
    }

    /**
     * 单独设置 左上角弧度
     *
     * @param topLeftRadius 左上角弧度
     */
    public void setTopLeftRadius(float topLeftRadius) {
        this.radius[0] = topLeftRadius;
        this.radius[1] = topLeftRadius;
    }

}

