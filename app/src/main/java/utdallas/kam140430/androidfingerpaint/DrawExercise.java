package utdallas.kam140430.androidfingerpaint;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class DrawExercise extends AppCompatActivity {

    public Court paintCourt;

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
                        paintCourt.paintColor = Color.RED;
                        break;
                    case R.id.greenRadioButton:
                        paintCourt.paintColor = Color.GREEN;

                        break;
                    case R.id.blueRadioButton:
                        paintCourt.paintColor = Color.BLUE;
                        break;
                    case R.id.blackRadioButton:
                        paintCourt.paintColor = Color.BLACK;
                        break;
                }
            }
        });

        //intially setting red paint
        colorSwitches.check(R.id.redRadioButton);
    }

}
