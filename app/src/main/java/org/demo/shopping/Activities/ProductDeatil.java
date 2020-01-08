package org.demo.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.demo.shopping.R;

public class ProductDeatil extends AppCompatActivity {

  private   TextView txtname,textprice,txtcategory,txtstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_deatil);

        txtname=findViewById(R.id.txtName);
        textprice=findViewById(R.id.txtPrice);
        txtcategory=findViewById(R.id.txtcategory);
        txtstock=findViewById(R.id.txtstock);


        String txtnames = getIntent().getExtras().getString("proname");
        double price = getIntent().getExtras().getDouble("proprice");

        Integer stock = getIntent().getExtras().getInt("prostock");
        String category = getIntent().getExtras().getString("procategory");


        txtname.setText(txtnames);
        textprice.setText("Price:"+String.valueOf(price));
        txtcategory.setText("Category:"+category);
        txtstock.setText("Stock:"+String.valueOf(stock));






    }
}
