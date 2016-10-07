package hyderabad.threadspeaks.ArrivalRecycler;

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
public class ArrivalAdapter extends RecyclerView.Adapter<ArrivalViewHolder> {

    private Context mContext;
    private List<ArivalDataModel> arrivalList;
    public ArrivalAdapter(Context mContext, List<ArivalDataModel> arrivalList) {
        this.mContext = mContext;
        this.arrivalList = arrivalList;
    }


    @Override
    public int getItemCount() {
        return arrivalList.size();
    }

    @Override
    public ArrivalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_arrivals, parent, false);

        return new ArrivalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArrivalViewHolder holder, int position) {

        ArivalDataModel dataModel = arrivalList.get(position);
        holder.name.setText(dataModel.getName());
        holder.image.setImageResource(dataModel.getImage());
    }
}
