package org.demo.shopping.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.like.LikeButton;

import org.demo.shopping.DeleteClicklistner;
import org.demo.shopping.Model.ProductsCategory;
import org.demo.shopping.R;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class CartdataAdapter extends RecyclerView.Adapter<CartdataAdapter.ViewHolder> {

    List<ProductsCategory> apiResponseList;
    Context context;
    private RequestOptions requestsearch;

    private List<ProductsCategory> fordb = new ArrayList<>();
    DeleteClicklistner deleteClicklistner;


    public CartdataAdapter(List<ProductsCategory> apiResponseList, Context context,DeleteClicklistner deleteClicklistner) {
        this.apiResponseList = apiResponseList;
        this.context = context;
        this.deleteClicklistner=deleteClicklistner;
        requestsearch = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
    }




    @NonNull
    @Override
    public CartdataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cartandwhislistlayout, parent, false);
        return new CartdataAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final CartdataAdapter.ViewHolder holder, final int position) {


        Paper.init(context);

        final ProductsCategory productsCategory = apiResponseList.get(position);

        holder.txtPrice.setText("$" + String.valueOf(apiResponseList.get(position).getPrice()));
        holder.txtName.setText(apiResponseList.get(position).getName());
        holder.txtcategory.setText("Category: " + apiResponseList.get(position).getCategory());
        holder.txtstock.setText("Stock: " + String.valueOf(apiResponseList.get(position).getStock()));

        holder.addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteClicklistner.deletefuction(apiResponseList.get(position).getProductid());
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
        LikeButton wishlist;


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


