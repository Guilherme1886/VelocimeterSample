package com.gui.toledo.velocimetersample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class VelocimeterView extends View {

    private Paint circlePaint, needlePaint, textPaint;
    private float currentSpeed = 0f;
    private float maxSpeed = 240f;
    private float needleAngle = 0f;

    public VelocimeterView(Context context) {
        super(context);
        init();
    }

    public VelocimeterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VelocimeterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        circlePaint = new Paint();
        circlePaint.setColor(Color.BLACK);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(2);

        needlePaint = new Paint();
        needlePaint.setColor(Color.RED);
        needlePaint.setStrokeWidth(4);
        needlePaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(40);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(325, 325, 250, circlePaint);

        canvas.save();
        canvas.rotate(needleAngle, 325, 325);
        canvas.drawLine(325, 325, 325, 80, needlePaint);
        canvas.restore();

        canvas.drawText(String.format("%.1f km/h", currentSpeed), 325, 680, textPaint);
    }

    public void setSpeed(float speed) {
        this.currentSpeed = speed;
        needleAngle = (speed / maxSpeed) * 180f;
        invalidate();
    }
}

