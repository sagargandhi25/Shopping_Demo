package org.demo.shopping.Activities.ui.wishlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.demo.shopping.Activities.ui.tools.ToolsViewModel;
import org.demo.shopping.Adapter.WhishlistAdapter;
import org.demo.shopping.DeleteClicklistner;
import org.demo.shopping.Model.ProductsCategory;
import org.demo.shopping.R;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class Wishlist extends Fragment {

    private ToolsViewModel toolsViewModel;

    RecyclerView recyclerview;
    ImageView delete;

    WhishlistAdapter cartdataAdapter;

    List<ProductsCategory> apiresponselist = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.wishlist_fragment, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerview=view.findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        Paper.init(getActivity());
        getdata();



    }

    private void getdata() {


        if (Paper.book().read("addcart") != null)
        {
            apiresponselist = Paper.book().read("addcart");

        }


        cartdataAdapter = new WhishlistAdapter(apiresponselist,getActivity() , new DeleteClicklistner() {
            @Override
            public void deletefuction(int productid) {
                for (int i = 0; i<apiresponselist.size() ; i++)
                {
                    if (apiresponselist.get(i).getProductid() == productid)
                    {
                        ProductsCategory productsCategory = apiresponselist.get(i);

                        apiresponselist.remove(productsCategory);

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
