package com.example.wzw.gameapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wzw.gameapp.R;
import com.example.wzw.gameapp.model.net.bean.ImageBean;
import com.example.wzw.gameapp.ui.activity.GameActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzw on 2018/6/4.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> implements View.OnClickListener{
    private Context mContext;
    private List<ImageBean> mList = new ArrayList<>();
    private List<Integer> mHeights;
    public GameListAdapter(Context context) {
        mContext = context;
    }

   public void  getRandomHeight(List<ImageBean> list) {
        mHeights = new ArrayList<>();
        for (int i = 0;i < mList.size();i++){
            double random = Math.random();
            if (random*10>5){
                mHeights.add(343);
            }else {
                mHeights.add(448);
            }
        }
   }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                                  .inflate(R.layout.item_iamge_text,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder.itemView.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams params = holder.mImageView.getLayoutParams();
        if (mHeights.get(position)==343){
            params.height = mHeights.get(position)-120;
            holder.mImageView.setImageResource(R.drawable.typeone);
        }else {
            params.height = mHeights.get(position)-120;
            holder.mImageView.setImageResource(R.drawable.typetwo);
        }

        holder.mImageView.setLayoutParams(params);

        holder.mTitle.setText("标题");
        holder.mGold.setText("10枚");
        holder.itemView.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, GameActivity.class);
        mContext.startActivity(intent);
    }

    public class ViewHolder
            extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTitle;
        TextView mGold;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview);
            mTitle = itemView.findViewById(R.id.card_title);
            mGold = itemView.findViewById(R.id.goldnumber);

        }
    }

    public List<ImageBean> getList(){
        return mList;
    }


}
