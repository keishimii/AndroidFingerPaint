package utdallas.kam140430.androidfingerpaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by keishi on 4/13/17.
 */

public class Court extends View {
    private ShapeDrawable mDrawable;

    public Court(Context context, AttributeSet attr){
        super(context, attr);
        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;
        int x = 0;
        int y = 0;

        mDrawable = new ShapeDrawable(new RectShape());
        mDrawable.getPaint().setColor(Color.LTGRAY);
        mDrawable.setBounds(x, y, width, height);
    }

    @Override
    protected void onDraw(Canvas canvas){

        mDrawable.draw(canvas);

    }
}
