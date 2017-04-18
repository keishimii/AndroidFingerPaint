package utdallas.kam140430.androidfingerpaint;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class DrawExercise extends AppCompatActivity {

    public Court paintCourt;
    private final int customGreen = Color.parseColor("#27C327");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_exercise);
        paintCourt = (Court)findViewById(R.id.court_id);

        RadioGroup colorSwitches = (RadioGroup) findViewById(R.id.color_button_switches);
        colorSwitches.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.redRadioButton:
                        paintCourt.changePaintColor(Color.RED);
                        break;
                    case R.id.greenRadioButton:
                        paintCourt.changePaintColor(customGreen);
                        break;
                    case R.id.blueRadioButton:
                        paintCourt.changePaintColor(Color.BLUE);
                        break;
                    case R.id.blackRadioButton:
                        paintCourt.changePaintColor(Color.BLACK);
                        break;
                }
            }
        });

        //initially setting red paint
        colorSwitches.check(R.id.redRadioButton);

        //constraints for brush size
        final int step = 1;
        final int max = (this.getResources().getDisplayMetrics().widthPixels) /4 ;
        final int min = 3;

        //Brush size toggle
        SeekBar brushSizeToggle = (SeekBar) findViewById(R.id.brush_toggle);
        brushSizeToggle.setMax((max - min) / step);
        brushSizeToggle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float size = min + (progress * step);
                paintCourt.changeBrushSize(size);
            }
        });
    }

}
