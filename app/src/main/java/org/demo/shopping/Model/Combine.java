package org.demo.shopping.Model;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public List <ProductsCategory> onelist =new ArrayList<>();
    public List <ProductsCategory> secondlist = new ArrayList<>();

    public Combine ()
    {

    }

    public Combine(List<ProductsCategory> onelist, List<ProductsCategory> secondlist) {
        this.onelist = onelist;
        this.secondlist = secondlist;
    }

    public List<ProductsCategory> getOnelist() {
        return onelist;
    }

    public void setOnelist(List<ProductsCategory> onelist) {
        this.onelist = onelist;
    }

    public List<ProductsCategory> getSecondlist() {
        return secondlist;
    }

    public void setSecondlist(List<ProductsCategory> secondlist) {
        this.secondlist = secondlist;
    }
}
