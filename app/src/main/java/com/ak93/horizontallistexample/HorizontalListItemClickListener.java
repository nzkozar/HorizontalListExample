package com.ak93.horizontallistexample;

/**
 * Created by Anže Kožar on 3.11.2016.
 * An interface to use for onItemClick callbacks from RecyclerView adapter to the context
 * listening for them
 */

public interface HorizontalListItemClickListener {
    void onHorizontalListItemClick(String adapterTag, int position);
}
