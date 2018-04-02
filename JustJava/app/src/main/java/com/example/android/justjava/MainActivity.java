/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import javax.security.auth.Subject;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    public void submitOrder(View view) {
        boolean chocoChecked;
        boolean whippedCreamChecked;

        EditText nameTextField = findViewById(R.id.name_text_field);
        String name = nameTextField.getText().toString();
        CheckBox whippedCream = findViewById(R.id.whippedCream);
        CheckBox chocolate = findViewById(R.id.chocolate);
        whippedCreamChecked = whippedCream.isChecked();
        chocoChecked = chocolate.isChecked();

        int price = calculatePrice(chocoChecked, whippedCreamChecked);
        String summary = createOrderSummary(price, name, chocoChecked, whippedCreamChecked);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto: puneetsainirockz@gmail.com"));
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice(boolean chocoChecked, boolean whippedCreamChecked) {
        int price=5;
        if(chocoChecked && whippedCreamChecked){
            price+=3;
        }
        else if (chocoChecked){
            price+=2;
        }
        else if (whippedCreamChecked){
            price++;
        }
        return (quantity * price);
    }

    private void displayQuantity(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + num);
    }

    public void increment(View view) {
        if(quantity>=100) {
            Toast.makeText(this, getString(R.string.max_warning), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity<=1) {
            Toast.makeText(this, getString(R.string.min_warning), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        displayQuantity(quantity);
    }

    private String createOrderSummary(int price, String name, boolean chocoChecked, boolean whippedCreamChecked) {
        return (getString(R.string.order_name, name) +
                getString(R.string.whipped_cream_check, whippedCreamChecked) +
                getString(R.string.chocolate_check, chocoChecked) +
                "\n" + getString(R.string.quantity) + ": " + quantity +
                getString(R.string.price) + price +
                getString(R.string.thank_you));
    }

}