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
public class ItalianRestaurantActivity extends Activity {

    Button chooseItaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_restaurnant);

        chooseItaBtn = (Button) findViewById(R.id.chooseItaBtn);
        chooseItaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ItalianRestaurantActivity.this);
                View view = getLayoutInflater().inflate(R.layout.rest_spinner, null); // to access our spinner layout file
                builder.setTitle("Select your favourite American Restaurant");
                final Spinner amrRestSpinner = (Spinner) view.findViewById(R.id.amrRestSpinner);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ItalianRestaurantActivity.this,
                        android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.itaRestList));

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                amrRestSpinner.setAdapter(adapter);

                builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (amrRestSpinner.getSelectedItem().toString().equalsIgnoreCase("La Campagna")) {
                            Intent startLaActivity = new Intent("ca.georgebrown.comp3074.a1101043939.LaActivity");
                            startActivity(startLaActivity);
                            dialogInterface.dismiss();
                        }

                        else if (amrRestSpinner.getSelectedItem().toString().equalsIgnoreCase("Giorgio D")) {
                            Intent startGActivity = new Intent("ca.georgebrown.comp3074.a1101043939.GActivity");
                            startActivity(startGActivity);
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
