package ca.georgebrown.comp3074.a1101043939;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Student id: 101043939
 * Student Name: Neha Arora**/
public class GActivity extends Activity {

    private static Button addToCartBtn;
    private static Button popMenuBtn;
    private static TextView selectedItemsTextView;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> custItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g);


        selectedItemsTextView= (TextView) findViewById(R.id.selectedItemsTextView);
        listItems = getResources().getStringArray(R.array.gMenuList);
        checkedItems = new boolean[listItems.length];
        popMenuBtn = (Button) findViewById(R.id.popMenuBtn);

        final TextView items= (TextView) findViewById(R.id.selectedItemsTextView);

        addToCartBtn = (Button) findViewById(R.id.addToCartBtn);  //reference of the add to cart button
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startCustInfoActivity = new Intent("ca.georgebrown.comp3074.a1101043939.CustInfoActivity");
                startCustInfoActivity.putExtra("Ordered_Items", items.getText().toString());
                startActivity(startCustInfoActivity);
            } });


        popMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GActivity.this);
                builder.setTitle("Choose your items:");
                builder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                        if(isChecked){
                            custItems.add(i);
                        }
                        else{
                            custItems.remove((Integer.valueOf(i)));
                        }
                    }
                });
                builder.setCancelable(false);
                builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {        // Submit Button
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < custItems.size(); i++) {
                            item = item + listItems[custItems.get(i)];
                            if (i != custItems.size() - 1) {
                                item = item + "\n";      // here
                            }
                        }

                        selectedItemsTextView.setText(item);   // calling text view
                    }
                });


                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {       // dismissing dialog
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });


                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {   //clear all selected
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            custItems.clear();
                            selectedItemsTextView.setText("");
                        }
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }
}
