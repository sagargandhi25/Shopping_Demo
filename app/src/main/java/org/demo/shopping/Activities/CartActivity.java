package org.demo.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import org.demo.shopping.Adapter.CartdataAdapter;
import org.demo.shopping.DeleteClicklistner;
import org.demo.shopping.Model.ProductsCategory;
import org.demo.shopping.R;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    ImageView delete;

    CartdataAdapter cartdataAdapter;

    List<ProductsCategory> cartlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
       // delete=findViewById(R.id.delete);

        recyclerview=findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        Paper.init(this);
        getdata();




    }

    private void getdata() {


        if (Paper.book().read("addcart") != null)
        {
            cartlist = Paper.book().read("addcart");

        }


        cartdataAdapter = new CartdataAdapter(cartlist, this, new DeleteClicklistner() {
            @Override
            public void deletefuction(int productid) {
                for (int i = 0; i<cartlist.size() ; i++)
                {
                    if (cartlist.get(i).getProductid() == productid)
                    {
                        ProductsCategory productsCategory = cartlist.get(i);

                        cartlist.remove(productsCategory);

                        Paper.book().write("addcart",cartlist);
                        setRecyclerView();
                    }
                }
            }
        });


        setRecyclerView();


    }

    private void setRecyclerView() {

        recyclerview.setAdapter(cartdataAdapter);

    }


}
