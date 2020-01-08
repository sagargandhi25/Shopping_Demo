package org.demo.shopping.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;

import org.demo.shopping.Activities.ProductDeatil;
import org.demo.shopping.Model.ProductsCategory;
import org.demo.shopping.R;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.ViewHolder> {

    List<ProductsCategory> apiResponseList;
    Context context;
    private RequestOptions requestsearch;
    ArrayList<Integer> mylist = new ArrayList<>();
    ArrayAdapter<Integer> myadpater;
    List<ProductsCategory> newlist = new ArrayList<>();
    ArrayList<ProductsCategory> newlistsecond = new ArrayList<>();

    private List<ProductsCategory> fordb = new ArrayList<>();


    public AllProductsAdapter(List<ProductsCategory> apiResponseList, Context context) {
        this.apiResponseList = apiResponseList;
        this.context = context;
        requestsearch = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
    }

    @NonNull
    @Override
    public AllProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.productbycategorylayout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final AllProductsAdapter.ViewHolder holder, final int position) {


        Paper.init(context);

        final ProductsCategory productsCategory = apiResponseList.get(position);

        holder.txtPrice.setText("$" + String.valueOf(apiResponseList.get(position).getPrice()));
        holder.txtName.setText(apiResponseList.get(position).getName());
        holder.txtcategory.setText("Category: " + apiResponseList.get(position).getCategory());
        holder.txtstock.setText("Stock: " + String.valueOf(apiResponseList.get(position).getStock()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(context, ProductDeatil.class);
                intent.putExtra("proname",apiResponseList.get(position).getName());
                intent.putExtra("procategory",apiResponseList.get(position).getCategory());
                intent.putExtra("prostock",apiResponseList.get(position).getStock());
                intent.putExtra("proprice",apiResponseList.get(position).getPrice());
                context.startActivity(intent);
            }
        });

        holder.addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stockvalue = apiResponseList.get(position).getStock();

                Log.i("ok", "onClick: "+apiResponseList.get(position).getProductid());

                if (Paper.book().read("addcart") != null) {
                    int abc = 0;
                    fordb = Paper.book().read("addcart");
                    for (int i = 0; i < fordb.size(); i++) {
                        fordb = Paper.book().read("addcart");
                        int getid = fordb.get(i).getProductid();

                        Log.i("ok", "pr" + fordb.get(i).getProductid() + "  " + getid + "  " +
                                apiResponseList.get(position).getProductid());

                        if (getid == apiResponseList.get(position).getProductid()) {
                            Toast.makeText(context, "Already exist in the card", Toast.LENGTH_SHORT).show();
                            abc = 40;
                            break;
                        } else {
                            abc = 10;
                        }

                    }
                    if (abc == 10) {
                        if (stockvalue > 0) {
                            Toast.makeText(context, "successfully added to cart", Toast.LENGTH_SHORT).show();
                            mylist.add(apiResponseList.get(position).getProductid());


                            fordb.add(apiResponseList.get(position));
                            Paper.book().write("addcart", fordb);


                        } else {
                            Toast.makeText(context, "Stock is not available", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    if (stockvalue > 0) {
                        Toast.makeText(context, "successfully added to cart", Toast.LENGTH_SHORT).show();
                        List<ProductsCategory> dummyList = new ArrayList<>();
                        dummyList.add(apiResponseList.get(position));
                        Paper.book().write("addcart", dummyList);

//


                    } else {
                        Toast.makeText(context, "Out of stock", Toast.LENGTH_SHORT).show();
                    }

                }
            }
//

        });

       holder.wishlist.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int stockvalue = apiResponseList.get(position).getStock();

               Log.i("ok", "onClick: "+apiResponseList.get(position).getProductid());

               if (Paper.book().read("addcart") != null) {
                   int abc = 0;
                   fordb = Paper.book().read("addcart");
                   for (int i = 0; i < fordb.size(); i++) {
                       fordb = Paper.book().read("addcart");
                       int getid = fordb.get(i).getProductid();

                       Log.i("ok", "pr" + fordb.get(i).getProductid() + "  " + getid + "  " +
                               apiResponseList.get(position).getProductid());

                       if (getid == apiResponseList.get(position).getProductid()) {
                           Toast.makeText(context, "Already exist in the wishlist", Toast.LENGTH_SHORT).show();
                           abc = 40;
                           break;
                       } else {
                           abc = 10;
                       }

                   }
                   if (abc == 10) {
                       if (stockvalue > 0) {
                           Toast.makeText(context, "successfully added to wishlist", Toast.LENGTH_SHORT).show();
                           mylist.add(apiResponseList.get(position).getProductid());


                           fordb.add(apiResponseList.get(position));
                           Paper.book().write("addcart", fordb);


                       } else {
                           Toast.makeText(context, "Stock is not available", Toast.LENGTH_SHORT).show();
                       }
                   }
               } else {
                   if (stockvalue > 0) {
                       Toast.makeText(context, "successfully added to wishlist", Toast.LENGTH_SHORT).show();
                       List<ProductsCategory> dummyList = new ArrayList<>();
                       dummyList.add(apiResponseList.get(position));
                       Paper.book().write("addcart", dummyList);

//


                   } else {
                       Toast.makeText(context, "Out of stock", Toast.LENGTH_SHORT).show();
                   }

               }


           }
       });

    }

    @Override
    public int getItemCount() {
        return apiResponseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView flutesimage;
        private TextView txtName;
        TextView txtPrice;
        private ProgressBar progressbar;
        LinearLayout addcart;
        TextView txtcategory, txtstock;
        ImageView wishlist;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            flutesimage = itemView.findViewById(R.id.flutesimage);
            // progressbar = itemView.findViewById(R.id.progressbar);
            addcart = itemView.findViewById(R.id.addcart);
            txtcategory = itemView.findViewById(R.id.txtcategory);
            txtstock = itemView.findViewById(R.id.txtstock);
            wishlist = itemView.findViewById(R.id.wishlisticon);


        }
    }
}





