package ca.georgebrown.comp3074.a1101043939;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Student id: 101043939
 * Student Name: Neha Arora**/
public class OrderPlacedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(getIntent().getExtras().getString("Name"));
    }
}
