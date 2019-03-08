package dz4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class Clock extends View {
    private float width, height, min, radius;
    private Paint paint = new Paint();
    private Calendar calendar;
    int hours, minutes, seconds;

    public Clock(Context context) {
        super(context);
    }

    public Clock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Clock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Clock(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
		drawClock(canvas, paint);
            drawHours(canvas, paint);
            drawMinutesSeconds(canvas, paint);
 
    }

    private void drawClock(Canvas canvas, Paint paint) {
        calendar = Calendar.getInstance();
        hours = calendar.get(Calendar.HOUR);
        minutes = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);

        paint.setStrokeWidth(5);
        paint.setTextSize(80);
        width = getWidth();
        height = getHeight();
        min = Math.min(width, height);
        radius = min / 3;
        canvas.drawCircle(width / 2, height / 2, 20, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width / 2, height / 2, radius, paint);

    }

    private void drawHours(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(10);
        for (int i = 1; i <= 12; i++) {
            canvas.drawLine(width / 2, height / 2 - radius - min / 50,
                    width / 2, height / 2 - radius + min / 50, paint);
            canvas.rotate(-30, width / 2, height / 2);

        }

        int hoursText = 12;
        for (int i = 1; i <= 12; i++) {
            canvas.drawText(String.valueOf(hoursText), width / 2 - 20,
                    height / 2 - radius - min / 30, paint);
            if (hours == hoursText) {
                canvas.drawLine(width / 2, height / 2, width / 2,
                        height / 2 - radius + 90, paint);
            }
            canvas.rotate(-30, width / 2, height / 2);
            hoursText--;

        }

    }


    private void drawMinutesSeconds(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3);
        for (int i = 1; i <= 60; i++) {
            canvas.drawLine(width / 2, height / 2 - radius - min / 110,
                    width / 2, height / 2 - radius + min / 110, paint);
            canvas.rotate(6, width / 2, height / 2);


            if (minutes == i) {
                paint.setStrokeWidth(7);
                canvas.drawLine(width / 2, height / 2, width / 2,
                        height / 2 - radius + 30, paint);
                paint.setStrokeWidth(3);
            }
            if (seconds == i) {
                canvas.drawLine(width / 2, height / 2, width / 2,
                        height / 2 - radius + 30, paint);

            }

        }

    }

}

