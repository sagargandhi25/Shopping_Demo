package org.demo.shopping.RestApi;

import org.demo.shopping.Model.AllProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("products")
    Call<List<AllProduct>> getallproducts();


}
