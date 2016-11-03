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
 * Adapted and modified from official android documentation
 */

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.ViewHolder>{

    //Context to use when retrieving resources such as drawables,...
    private Context mContext;
    //Dataset
    private ArrayList<String> mDataset = new ArrayList<>();
    //On item click callback
    private HorizontalListItemClickListener onClickCallback = null;
    //This tag is used to identify the adapter in interface callbacks
    // where multiple adapters are reporting to a single callback method
    public String adapterTAG;


    /** Provide a reference to the views for each data item
     *  Complex data items may need more than one view per item, and
     *  you provide access to all the views for a data item in a view holder
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        View mView;
        TextView mTextView;
        ImageView mImageView;
        ViewHolder(View v) {
            super(v);
            mView = v;
            mTextView = (TextView)v.findViewById(R.id.itemText);
            mImageView = (ImageView)v.findViewById(R.id.itemImage);
        }
    }

    /**
     * Construct a new adapter
     * @param context Context for resource retrieval
     * @param myDataset Dataset to populate the list from
     * @param tag String TAG to identify the adapter in interface callbacks
     */
    public HorizontalListAdapter(Context context, ArrayList<String> myDataset, String tag) {
        mDataset = myDataset;
        mContext = context;
        adapterTAG = tag;
    }

    /**
     * Sets an on itemClickListener
     * @param listener Listener interface implementation to which callbacks should be made
     */
    public void setOnItemClickListener(HorizontalListItemClickListener listener){
        this.onClickCallback = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters ...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //Set item name
        holder.mTextView.setText(mDataset.get(position));
        //Set item picture (different picture based on item position)
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
        //Set an on item click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickCallback!=null){
                    //Make a callback in the event of an item click
                    onClickCallback.onHorizontalListItemClick(adapterTAG,holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //Return the size of our dataset
        return mDataset.size();
    }

}
