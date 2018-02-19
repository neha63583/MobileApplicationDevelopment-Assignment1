package ca.georgebrown.comp3074.a1101043939;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
/**
 * Student id: 101043939
 * Student Name: Neha Arora**/
public class IndianRestaurantActivity extends Activity {

    Button chooseIndBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_restaurnant);

        chooseIndBtn = (Button) findViewById(R.id.chooseIndBtn);
        chooseIndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IndianRestaurantActivity.this);
                View view = getLayoutInflater().inflate(R.layout.rest_spinner, null); // to access our spinner layout file
                builder.setTitle("Select your favourite Indian Restaurant");
                final Spinner amrRestSpinner = (Spinner) view.findViewById(R.id.amrRestSpinner);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(IndianRestaurantActivity.this,
                        android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.indRestList));

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                amrRestSpinner.setAdapter(adapter);

                builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (amrRestSpinner.getSelectedItem().toString().equalsIgnoreCase("Punjabi Dhaba")) {
                            Intent startPunjabiActivity = new Intent("ca.georgebrown.comp3074.a1101043939.PunjabiActivity");
                            startActivity(startPunjabiActivity);
                            dialogInterface.dismiss();
                        }

                        else if (amrRestSpinner.getSelectedItem().toString().equalsIgnoreCase("Bollywood Restaurant")) {
                            Intent startBollywoodActivity = new Intent("ca.georgebrown.comp3074.a1101043939.BollywoodActivity");
                            startActivity(startBollywoodActivity);
                            dialogInterface.dismiss();
                        }


                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInteface, int i) {
                        dialogInteface.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}
