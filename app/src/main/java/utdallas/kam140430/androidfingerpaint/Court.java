package utdallas.kam140430.androidfingerpaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

/**
 * Created by keishi on 4/13/17.
 */

public class Court extends View {

    //drawing path
    private Path drawPath;
    //paint for brush
    private Paint brushPaint;
    //paint for canvas
    private Paint canvasPaint;
    //canvas
    private Canvas drawCanvas;
    //canvas bitmap
    private Bitmap canvasBitmap;

    public Court(Context context, AttributeSet attr){

        super(context, attr);
        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;

        canvasBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);

        brushPaint = new Paint();
        brushPaint.setAntiAlias(true);
        brushPaint.setStyle(Paint.Style.STROKE);
        brushPaint.setStrokeJoin(Paint.Join.ROUND);
        brushPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint();
        drawPath = new Path();
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, brushPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent m){
        float touchX = m.getX();
        float touchY = m.getY();

        switch (m.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, brushPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    // Used to change color of the paint brush
    public void changePaintColor(int color){
        brushPaint.setColor(color);
    }

    // Used to change the size of the paint brush
    public void changeBrushSize(float size){
        brushPaint.setStrokeWidth(size);
    }

}
