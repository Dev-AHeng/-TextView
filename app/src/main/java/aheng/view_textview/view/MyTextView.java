package aheng.view_textview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import aheng.view_textview.R;

/**
 * 自定义TextView
 *
 * @author AHeng
 * @date 2022/12/08 20:29
 */
public class MyTextView extends View {
    
    private final Rect rect;
    
    private final String text;
    private final Paint textContent;
    private int textSize = 11;
    private int textColor;
    
    /**
     * java new创建view时调用这里
     *
     * @param context
     */
    public MyTextView(Context context) {
        this(context, null);
    }
    
    /**
     * xml创建view时调用这里
     *
     * @param context
     * @param attrs
     */
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    /**
     * xml创建view时调用这里 支持style属性
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        rect = new Rect();
        
        // 获取attrs.xml的自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        text = typedArray.getString(R.styleable.MyTextView_my_text);
        textSize = typedArray.getDimensionPixelSize(R.styleable.MyTextView_my_textSize, textSize);
        textColor = typedArray.getColor(R.styleable.MyTextView_my_textColor, textColor);
        // 回收
        typedArray.recycle();
        
        textContent = new Paint();
        // 抗锯齿
        textContent.setAntiAlias(true);
        textContent.setTextSize(textSize);
        textContent.setColor(textColor);
    }
    
    /**
     * 测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(widthMeasureSpec);
    
        /*
          AT_MOST: wrap_content
          EXACTLY: match_parent或固定值(xxdp)
         */
        if (widthMode == MeasureSpec.AT_MOST) {
            textContent.getTextBounds(text, 0, text.length(), rect);
            width = rect.width() + getPaddingLeft() + getPaddingRight();
        } else if (widthMode == MeasureSpec.EXACTLY) {
        
        } else if (widthMode == MeasureSpec.UNSPECIFIED) {
            // ListView只显示一个
        }
        
        if (heightMode == MeasureSpec.AT_MOST) {
            textContent.getTextBounds(text, 0, text.length(), rect);
            height = rect.height() + getPaddingTop() + getPaddingBottom();
        } else if (heightMode == MeasureSpec.EXACTLY) {
        
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            // ListView只显示一个
        }
        
        setMeasuredDimension(width, height);
    }
    
    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 计算文本的baseline
        Paint.FontMetricsInt fontMetricsInt = textContent.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
        int baseline = getHeight() / 2 + dy;
        
        // 绘制文本
        canvas.drawText(text, getPaddingLeft(), baseline, textContent);
        
    }
}
