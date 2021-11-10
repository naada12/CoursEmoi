package com.example.project;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.database.AppDataBase;
import com.example.project.entity.Cour;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<Cour> productList;
    Intent intent;



    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView= LayoutInflater.from(mContext).inflate(R.layout.items,parent,false);
        return new ViewHolder((mItemView));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cour singleProduct=productList.get(position);
        AppDataBase db=AppDataBase.getAppDatabase(mContext);
        holder.txtProduct.setText(singleProduct.getTitre());
        holder.imgProduct.setImageURI(Uri.parse(singleProduct.getResume()));

        holder.imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(mContext,Detail.class);

                intent.putExtra("var",singleProduct.getId());

                mContext.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView txtProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct=itemView.findViewById(R.id.imageView10);
            txtProduct=itemView.findViewById(R.id.textView22);


        }
    }
    MyAdapter(Context mContext,List<Cour>productList){
        this.mContext=mContext;
        this.productList=productList;

    }
}