package ca.georgebrown.comp3074.a1101043939;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/**
 * Student id: 101043939
 * Student Name: Neha Arora**/

public class TypesOfCuisineActivity extends Activity {

    private static RadioGroup typesRadioGrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_cuisine);

        onCheckedChanged(typesRadioGrp);
    }

    public void onCheckedChanged(RadioGroup group)
    {
        typesRadioGrp = (RadioGroup) findViewById(R.id.typesRadioGrp);
        typesRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton amrRadBtn = (RadioButton) findViewById(R.id.amrRadBtn);
                RadioButton itaRadBtn = (RadioButton) findViewById(R.id.itaRadBtn);
                RadioButton chiRadBtn = (RadioButton) findViewById(R.id.chiRadBtn);
                RadioButton indRadBtn = (RadioButton) findViewById(R.id.indRadBtn);

                if (amrRadBtn.isChecked()){
                    Intent startAmericanRestaurantActivity = new Intent("ca.georgebrown.comp3074.a1101043939.AmericanRestaurantActivity");
                    startActivity(startAmericanRestaurantActivity);
                }

                else if (itaRadBtn.isChecked()){
                    Intent startItalianRestaurantActivity = new Intent("ca.georgebrown.comp3074.a1101043939.ItalianRestaurantActivity");
                    startActivity(startItalianRestaurantActivity);
                }

                else if (chiRadBtn.isChecked()){
                    Intent startChineseRestaurantActivity = new Intent("ca.georgebrown.comp3074.a1101043939.ChineseRestaurantActivity");
                    startActivity(startChineseRestaurantActivity);
                }

                else if (indRadBtn.isChecked()){
                    Intent startIndianRestaurantActivity = new Intent("ca.georgebrown.comp3074.a1101043939.IndianRestaurantActivity");
                    startActivity(startIndianRestaurantActivity);
                }



            }
        });
    }
}
