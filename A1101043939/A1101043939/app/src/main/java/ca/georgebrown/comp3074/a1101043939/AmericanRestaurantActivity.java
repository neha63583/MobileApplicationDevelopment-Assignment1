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
/**
 * Student id: 101043939
 * Student Name: Neha Arora**/


public class AmericanRestaurantActivity extends Activity {

    Button chooseAmrBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_american_restaurant);

        chooseAmrBtn = (Button) findViewById(R.id.chooseAmrBtn);
        chooseAmrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AmericanRestaurantActivity.this);
                View view = getLayoutInflater().inflate(R.layout.rest_spinner, null); // to access our spinner layout file
                builder.setTitle("Select your favourite American Restaurant");
                final Spinner amrRestSpinner = (Spinner) view.findViewById(R.id.amrRestSpinner);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AmericanRestaurantActivity.this,
                        android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.amrRestList));

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                amrRestSpinner.setAdapter(adapter);

                builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (amrRestSpinner.getSelectedItem().toString().equalsIgnoreCase("Popeyes Louisiana Kitchen")) {
                            Intent startPopeyesActivity = new Intent("ca.georgebrown.comp3074.a1101043939.PopeyesActivity");
                            startActivity(startPopeyesActivity);
                            dialogInterface.dismiss();
                        }

                        else if (amrRestSpinner.getSelectedItem().toString().equalsIgnoreCase("Kings Delight")) {
                            Intent startKingActivity = new Intent("ca.georgebrown.comp3074.a1101043939.KingActivity");
                            startActivity(startKingActivity);
                            dialogInterface.dismiss();
                        }

                        else if (amrRestSpinner.getSelectedItem().toString().equalsIgnoreCase("Mr.Sub")) {
                            Intent startMrSubActivity = new Intent("ca.georgebrown.comp3074.a1101043939.MrSubActivity");
                            startActivity(startMrSubActivity);
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
