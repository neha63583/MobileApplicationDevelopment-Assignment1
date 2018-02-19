package ca.georgebrown.comp3074.a1101043939;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Student id: 101043939
 * Student Name: Neha Arora**/
public class CustInfoActivity extends Activity {

    private Button placeOrderBtn;
    private EditText custNameEditText;
    private EditText custEmailEditText;
    private EditText custPhoneEditText;
    private EditText custAddEditText;
    private EditText custCardEditText;
    private EditText favFoodEditText;
    private EditText favChefEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_info);

        TextView selectedItemsTextView = (TextView) findViewById(R.id.selectedItemsTextView);
        selectedItemsTextView.setText(getIntent().getExtras().getString("Ordered_Items"));
        OnValidation();
    }

    protected void OnValidation() {
        custNameEditText = (EditText) findViewById(R.id.custNameEditText);
        custNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                ValidationForm.isName(custNameEditText, true);}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        custEmailEditText = (EditText) findViewById(R.id.custEmailEditText);
        custEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                ValidationForm.isEmailAddress(custEmailEditText, true);}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        custPhoneEditText = (EditText) findViewById(R.id.custPhoneEditText);
        custPhoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                ValidationForm.isContactNumber(custPhoneEditText, true);
                ValidationForm.hasText(custPhoneEditText);}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        custCardEditText = (EditText) findViewById(R.id.custCardEditText);
        custCardEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                ValidationForm.hasText(custCardEditText);}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        custAddEditText = (EditText) findViewById(R.id.custAddEditText);
        custAddEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                ValidationForm.hasText(custAddEditText);}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        favFoodEditText = (EditText) findViewById(R.id.favFoodEditText);
        favFoodEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                ValidationForm.hasText(favFoodEditText);}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        favChefEditText = (EditText) findViewById(R.id.favChefEditText);
        favChefEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                ValidationForm.hasText(favChefEditText);}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });



        placeOrderBtn = (Button) findViewById(R.id.placeOrderBtn);  //reference of the order place button
        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidationForm()) {
                    submit();}
                else {
                    Toast.makeText(CustInfoActivity.this, "Sorry! Please fill the valid data.", Toast.LENGTH_LONG).show();}}
        });
    }
    protected void submit(){
        Intent startOrderPlaceActivity = new Intent(CustInfoActivity.this, OrderPlacedActivity.class);
        startOrderPlaceActivity.putExtra("Name", custNameEditText.getText().toString());
        startActivity(startOrderPlaceActivity);
        setContentView(R.layout.activity_order_placed);
    }

    private boolean checkValidationForm() {
        boolean flag = true;

        if (!ValidationForm.isName(custNameEditText, true)) flag = false;
        if (!ValidationForm.isEmailAddress(custEmailEditText, true)) flag = false;
        if (!ValidationForm.isContactNumber(custPhoneEditText, false)) flag = false;
        if (!ValidationForm.hasText(custCardEditText)) flag = false;
        if (!ValidationForm.hasText(custAddEditText)) flag = false;
        if (!ValidationForm.hasText(favFoodEditText)) flag = false;
        if (!ValidationForm.hasText(favChefEditText)) flag = false;

        return flag;
    }
}



