package dz4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DiagramView extends View {
    float paddingLeft, paddingTop, paddingRight, paddingBottom,
            startAngle, degrees, canvasRotate = 0;
    private Paint paint;
    int sum, min;

    public DiagramView(Context context) {
        super(context);
    }

    public DiagramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DiagramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DiagramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setTextSize(60);
        min = Math.min(getWidth(), getHeight());
        paddingLeft = min / 6;
        paddingTop = getHeight() / 2 - min / 6 * 2;
        paddingRight = min - min / 6;
        paddingBottom = getHeight() / 2 + min / 6 * 2;
        startAngle = 270;


        List<Integer> share = getList();

        sum = 0;
        for (int a : share) {
            sum += a;
        }
        degrees = 360F / sum;

        for (int i = 0; i < share.size(); i++) {
            paint.setColor(getRandomColor());
            canvas.drawArc(paddingLeft, paddingTop,
                    paddingRight, paddingBottom,
                    startAngle, degrees * share.get(i), true, paint);
            startAngle = startAngle + (degrees * share.get(i));
        }

        for (int i = 0; i < share.size(); i++) {
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(5);
            canvas.rotate((degrees * share.get(i)) / 2,
                    getWidth() / 2, getHeight() / 2);
            canvas.drawLine(getWidth() / 2, paddingTop,
                    getWidth() / 2, paddingTop - 35, paint);
            canvas.drawCircle(getWidth() / 2, paddingTop - 35, 10, paint);

            canvasRotate = canvasRotate + (degrees * share.get(i)) / 2;

            canvas.rotate(0 - canvasRotate, getWidth() / 2, paddingTop - 110);
            canvas.drawText(String.valueOf(share.get(i)), getWidth() / 2,
                    paddingTop - 85, paint);
            canvas.rotate(canvasRotate, getWidth() / 2, paddingTop - 110);

            canvasRotate = canvasRotate + (degrees * share.get(i)) / 2;
            canvas.rotate((degrees * share.get(i)) / 2,
                    getWidth() / 2, getHeight() / 2);

        }

    }

    private List<Integer> getList() {
        List<Integer> share = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            share.add((int) (Math.random() * 20 + 1));
        }
        return share;
    }

    public int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256));

    }

}
