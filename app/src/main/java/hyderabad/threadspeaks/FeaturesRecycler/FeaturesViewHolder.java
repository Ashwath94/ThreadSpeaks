package hyderabad.threadspeaks.FeaturesRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import hyderabad.threadspeaks.R;

/**
 * Created by Pavithran on 25-09-2016.
 */
public class FeaturesViewHolder extends RecyclerView.ViewHolder {
    public TextView feature_name;
    public CheckBox checkbox;

    public FeaturesViewHolder(View view) {
        super(view);
        feature_name = (TextView) view.findViewById(R.id.tv_features);
        checkbox = (CheckBox) view.findViewById(R.id.chkSelected);
    }
}
