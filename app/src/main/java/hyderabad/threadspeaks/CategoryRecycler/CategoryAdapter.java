package hyderabad.threadspeaks.CategoryRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import hyderabad.threadspeaks.R;

/**
 * Created by Pavithran on 24-09-2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private Context mContext;
    private List<CategoryDataModel> CategoryList;
    public CategoryAdapter(Context mContext, List<CategoryDataModel> CategoryList) {
        this.mContext = mContext;
        this.CategoryList = CategoryList;
    }


    @Override
    public int getItemCount() {
        return CategoryList.size();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_arrivals, parent, false);

        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        CategoryDataModel dataModel = CategoryList.get(position);
        holder.name.setText(dataModel.getName());
        holder.image.setImageResource(dataModel.getImage());
    }
}
