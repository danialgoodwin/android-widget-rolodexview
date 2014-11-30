package net.simplyadvanced.rolodexview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/** A simple prototype for making an "infinite" scrolling rolodex-like view.
 *
 * It's current limitation is that user can only scroll INT_MAX / 2 in either direction. But, it
 * would take 248+ days of constant scrolling at 100 items per second, which would be very fast. */
public class RolodexViewAdapter extends RecyclerView.Adapter<RolodexViewAdapter.ViewHolder> {

    private String[] mDataset;

    // Provide a reference to the views for each data item.
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset).
    public RolodexViewAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager).
    @Override
    public RolodexViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rolodex_view_card, parent, false);
        // Set the view's size, margins, paddings and layout parameters.
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager).
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - Get element from your dataset at this position.
        // - Replace the contents of the view with that element.
        holder.mTextView.setText(mDataset[position % mDataset.length]);
    }

    // Return the size of your dataset (invoked by the layout manager).
    @Override
    public int getItemCount() {
        // Hackish: This is set to INT_MAX so that user has a lot of free space to move around to
        // make the view appear as infinite. This should be improved.
        return Integer.MAX_VALUE;
//        return mDataset.length;
    }

}
