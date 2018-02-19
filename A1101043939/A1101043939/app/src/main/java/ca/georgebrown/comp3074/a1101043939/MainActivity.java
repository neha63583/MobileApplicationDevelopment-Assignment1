package ca.georgebrown.comp3074.a1101043939;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/**
 * Student id: 101043939
 * Student Name: Neha Arora**/

public class MainActivity extends AppCompatActivity {

    private static Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calling start button on click function for a second page
        OnClickStartButtonListener();
    }

    public void OnClickStartButtonListener(){

        startBtn = (Button) findViewById(R.id.startBtn);  //reference of the start button
        startBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startTypesOfCuisineActivity = new Intent("ca.georgebrown.comp3074.a1101043939.TypesOfCuisineActivity");
                    startActivity(startTypesOfCuisineActivity);
                }
            });
    }


}
