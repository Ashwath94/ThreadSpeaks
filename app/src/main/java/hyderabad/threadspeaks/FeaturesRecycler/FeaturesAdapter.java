package hyderabad.threadspeaks.FeaturesRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.List;

import hyderabad.threadspeaks.R;

/**
 * Created by Pavithran on 25-09-2016.
 */
public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesViewHolder> {
    private Context mContext;
    private List<FeaturesDataModel> featuresList;
    public FeaturesAdapter(Context mContext,List<FeaturesDataModel> featuresList){
        this.mContext = mContext;
        this.featuresList = featuresList;
    }

    @Override
    public FeaturesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_features,parent,false);
        return new FeaturesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FeaturesViewHolder holder, final int position) {
        holder.feature_name.setText(featuresList.get(position).getFeature());

        holder.checkbox.setChecked(featuresList.get(position).isSelected());

        holder.checkbox.setTag(featuresList.get(position));


        holder.checkbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                FeaturesDataModel contact = (FeaturesDataModel) cb.getTag();

                contact.setSelected(cb.isChecked());
                featuresList.get(position).setSelected(cb.isChecked());

                Toast.makeText(
                        v.getContext(),
                        "Clicked on Checkbox: " + cb.getText() + " is "
                                + cb.isChecked(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return featuresList.size();
    }
}
