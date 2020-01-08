package org.demo.shopping.Activities.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.demo.shopping.Activities.ui.home.HomeViewModel;
import org.demo.shopping.Adapter.AllProductsAdapter;
import org.demo.shopping.Model.AllProduct;
import org.demo.shopping.Model.ForPaperDb;
import org.demo.shopping.Model.ProductsCategory;
import org.demo.shopping.R;
import org.demo.shopping.RestApi.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    RecyclerView recyclerview;

    private HomeViewModel homeViewModel;

    private RecyclerView recyclerView;

    private List<AllProduct> apiresponselist = new ArrayList<>();
    private List<ProductsCategory> getcategorydata = new ArrayList<>();
    public  List<ForPaperDb> forpaperdb = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

      Paper.init(getActivity());
        //Paper.book().destroy();
       // Paper.book().write("addcart",new ArrayList<ProductsCategory>());
        //forpaperdb = Paper.book().read("addcart");
        //Toast.makeText(getActivity(), ""+forpaperdb.size(), Toast.LENGTH_SHORT).show();
        getdata();
    }

    private void getdata() {


        Call<List<AllProduct>> call = RetrofitClient.getInstance().getapi().getallproducts();

        call.enqueue(new Callback<List<AllProduct>>() {
            @Override
            public void onResponse(Call<List<AllProduct>> call, Response<List<AllProduct>> response) {
                if (response.isSuccessful()){
                    //  Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    apiresponselist=response.body();

                    for (int i =0 ; i<apiresponselist.size() ; i++)

                    {
                        String category = apiresponselist.get(i).getCategory();
                        if (category.matches("Men's Footwear"))
                        {
                            String name = apiresponselist.get(i).getName();
                            double price = apiresponselist.get(i).getPrice();
                            int stock = apiresponselist.get(i).getStock();
                            int productid = apiresponselist.get(i).getProductId();
                            String categoryproduct = apiresponselist.get(i).getCategory();

                         //   Log.i("", "onResponse: ");

                            ProductsCategory productsCategory = new ProductsCategory();
                            productsCategory.setName(name);
                            productsCategory.setPrice(price);
                            productsCategory.setCategory(categoryproduct);
                            productsCategory.setStock(stock);
                            productsCategory.setProductid(productid);
                            getcategorydata.add(productsCategory);


                        }

                    }



                    AllProductsAdapter allProductsAdapter = new AllProductsAdapter(getcategorydata,getActivity());
                    recyclerView.setAdapter(allProductsAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<AllProduct>> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }

}