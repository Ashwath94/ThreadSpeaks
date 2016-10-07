package hyderabad.threadspeaks.CategoryRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import hyderabad.threadspeaks.R;

/**
 * Created by Pavithran on 24-09-2016.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public ImageView image;

    public CategoryViewHolder(View view) {
        super(view);
        name = (TextView) view.findViewById(R.id.tv_arrivalname);
        image = (ImageView) view.findViewById(R.id.iv_arrivalimage);
    }
}
