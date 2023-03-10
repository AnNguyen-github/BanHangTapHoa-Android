package com.quanao.hanghieu.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public class Utils {

    Context context;
    public static String username= "";
    public static List<CartItem> lstCart= new ArrayList<>();
    public static List<ProductItem> productItems = new ArrayList<>();


    public static void addToProduct(Product product){
        ProductItem tmp = new ProductItem();
        tmp.id = product.id;
        tmp.description = product.description;;
        tmp.imageView = product.imageView;;
        tmp.name = product.name;
        tmp.price = product.price;
        tmp.quantity = product.quantity;
        tmp.type = product.type;
        productItems.add(tmp);
    }
    public static void removeItemCart(int pos){
        lstCart.remove(pos);
    }


    public static void addToCart(CartItem cartItem){
        lstCart.add(cartItem);
    }
    public Utils(Context context) {
        this.context = context;



    }

    public Utils() {

    }


    public ArrayList<Categories> getMockDataCategories() {
        ArrayList<Product> arrayListBanhKeo = new ArrayList<>();
        ArrayList<Product> arrayListSua = new ArrayList<>();
        ArrayList<Product> arrayListBia = new ArrayList<>();
        ArrayList<Product> arrayListGiavi = new ArrayList<>();
        ArrayList<Product> arrayListMi = new ArrayList<>();
        ArrayList<Product> arrayListCNhan = new ArrayList<>();
        ArrayList<Product> arrayListNCua = new ArrayList<>();
        ArrayList<Product> arrayListGao = new ArrayList<>();
        ArrayList<Product> arrayListCool = new ArrayList<>();
        ArrayList<Categories> tmp = new ArrayList<>();

        tmp.add(new Categories("Bánh Kẹo các loại", arrayListBanhKeo, "https://th.bing.com/th/id/R.5c0195dc956832daf185aacffc2a913a?rik=CQAX6hueRTP76g&pid=ImgRaw&r=0"));

        tmp.add(new Categories("Sữa tươi các loại", arrayListSua, "https://th.bing.com/th/id/R.95b0093c452fb49c27d567093b1af8db?rik=g9AV5kopBcjXnw&riu=http%3a%2f%2ftoplist.vn%2fimages%2f800px%2fsua-tuoi-vinamilk-31086.jpg&ehk=l5ZONmGJ0%2fVoQl6e6vgKCTkmQ4kl8GqMD5jmet5ksd4%3d&risl=&pid=ImgRaw&r=0"));

        tmp.add(new Categories("Bia, Nước giải khác", arrayListBia, "https://th.bing.com/th/id/R.d34de30c55ffc7b85c95e007d0345fd8?rik=cOyqysEzp0hbpg&pid=ImgRaw&r=0"));

        tmp.add(new Categories("Đầu ăn, Nước chấm, gia vị ", arrayListGiavi, "https://www.foodweb.it/wp-content/uploads/2012/04/aromi.jpg"));

        tmp.add(new Categories("Mì, Miến, Cháo, Phở", arrayListMi, "https://sieuthinhatbanhl.com/wp-content/uploads/2020/08/my-xao-2-1024x768.png"));

        tmp.add(new Categories("Chăm sóc cá nhân", arrayListCNhan, "https://cdn.fast.vn/tmp/20200919112617-bo-kem-danh-rang-va-ban-chai-danh-rang-p-s-bao-ve-123-tra-xanh-thanh-nhiet-1.jpg"));

        tmp.add(new Categories("Vệ sinh Nhà cửa", arrayListNCua, "https://th.bing.com/th/id/R.1d2e604798194bd881b8f23cddd51da0?rik=u76akx9yxg3uCg&riu=http%3a%2f%2fteasymart.com%2fwp-content%2fuploads%2f2021%2f03%2fBG-Omo-2.jpg&ehk=TBCwS1kaYFBQjoro%2bpBqDiFw%2fDlPz4oVNTlpRJKgebE%3d&risl=&pid=ImgRaw&r=0"));

        tmp.add(new Categories("Gạo, Bột, Đồ khô", arrayListGao, "https://gaosachonline.com/wp-content/uploads/2018/05/gao-ham-chau-dong-tui.png"));

        tmp.add(new Categories("Hàng Đông Mát", arrayListCool, "https://th.bing.com/th/id/R.773f5fe24edc7a6c3fc18b4d81aeb4be?rik=gFiKkhISlea4RA&riu=http%3a%2f%2fmedia.bizwebmedia.net%2fsites%2f54079%2fdata%2fimages%2f2014%2f7%2f4816098kem_merino_yeah.png&ehk=VbV4gJkePCeX%2bjSZmPgEfbkA4mPhF35rouvkg4MaFFk%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1"));

        return tmp;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
