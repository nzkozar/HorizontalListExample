package com.ak93.horizontallistexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Anže Kožar on 3.11.2016.
 */

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mDataset = new ArrayList<>();
    private LayoutInflater mLayoutInflater;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mTextView;
        ImageView mImageView;
        ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.itemText);
            mImageView = (ImageView)v.findViewById(R.id.itemImage);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HorizontalListAdapter(Context context, ArrayList<String> myDataset) {
        mDataset = myDataset;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));
        if(position%3==0) {
            holder.mImageView.setImageDrawable(mContext.getResources()
                    .getDrawable(R.drawable.book_cover2));
        }else if(position%2==0){
            holder.mImageView.setImageDrawable(mContext.getResources()
                    .getDrawable(R.drawable.book_cover1));
        }else{
            holder.mImageView.setImageDrawable(mContext.getResources()
                    .getDrawable(R.drawable.book_cover3));
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
