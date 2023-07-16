package com.example.myshop.mylistview;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshop.Data.ShoppingCartData;
import com.example.myshop.Data.myItem;
import com.example.myshop.R;
import com.example.myshop.activity.MainActivity;
import com.example.myshop.activity.ShoppingCartActivity;
import com.example.myshop.pay.PayActivity;

import java.util.List;
import java.util.Objects;

public class mycartlistview extends BaseAdapter {
    private final Context context;
    private final List<myItem> myItemList;
    private final String username;

    public mycartlistview(Context context, List<myItem> myItemList, String username) {
        this.context=context;
        this.myItemList=myItemList;
        this.username=username;
    }

    @Override
    public int getCount() {
        return myItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return myItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.itemcart,null);
        }
        ImageView imageView=convertView.findViewById(R.id.cart_image1);
        TextView describe=convertView.findViewById(R.id.cart_image1_describe);
        TextView price=convertView.findViewById(R.id.cart_image1_price);
        TextView number=convertView.findViewById(R.id.cart_image1_number);
        int flag=0;
        if(Objects.equals(myItemList.get(i).getProductName(), "berry")){
            imageView.setImageResource(R.drawable.discountberry);
            describe.setText("现摘新鲜商用云南草莓烘焙奶茶甜品原料产地直发奶油草莓孕妇水果");
            price.setText("￥"+myItemList.get(i).getPrice().toString());
            number.setText(myItemList.get(i).getNumber().toString());
            flag=1;
        }else if(Objects.equals(myItemList.get(i).getProductName(), "meat")){
            imageView.setImageResource(R.drawable.discountmeat);
            describe.setText("藏香猪五花肉新鲜5斤藏猪肉西藏正宗农家土黑猪肉红烧肉猪肉10斤");
            price.setText("￥"+myItemList.get(i).getPrice().toString());
            number.setText(myItemList.get(i).getNumber().toString());
            flag=2;
        }else{
            imageView.setImageResource(R.drawable.discountbrocoli);
            describe.setText("西兰花种籽西兰花种子花苗曼陀绿青花菜四季种籽花籽孑优秀西蓝花");
            price.setText("￥"+myItemList.get(i).getPrice().toString());
            number.setText(myItemList.get(i).getNumber().toString());
        }

        return convertView;
    }



}
