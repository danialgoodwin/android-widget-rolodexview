# RolodexView
A simple prototype RolodexView using RecyclerView and CardView.



## Usage

1. Create a RecyclerView as you regularly would
2. Add the following code to the RecyclerView's adapter:

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - Get element from your dataset at this position.
            // - Replace the contents of the view with that element.
            holder.mTextView.setText(mDataset[position % mDataset.length]);
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            // Hackish: Set to the middle position so that user can scroll in either direction for a
            // long time. This eventually needs to be improved to wrap better.
            recyclerView.scrollToPosition(Integer.MAX_VALUE / 2);
        }

        @Override
        public int getItemCount() {
            // Hackish: This is set to INT_MAX so that user has a lot of free space to move around to
            // make the view appear as infinite. This should be improved.
            return Integer.MAX_VALUE;
        }


3. Just by using the larger item count, starting in the middle, and modulus on the position, you'll have a wrapping view.



## Notes

- Starting in the exact middle may not be showing the first data item at the top. If that's a feature you're interested in, then a little more logic can be applied to round up or down to the nearest (position % datasetSize == 0) item
- I use a `CardView` and `String[]` in the sample app, but of course, you don't have to



## TODO

- Custom scrollbar that shows current location within the dataset.
- Allow more proper wrapping. (Currently, there are INT_MAX positions and the data shown is `dataset[position % data_size]`).
  - But, it would take 248+ days of constant scrolling at 100 items per second to reach the end. So, maybe don't need to worry about reaching the end for now.



## License
MIT
