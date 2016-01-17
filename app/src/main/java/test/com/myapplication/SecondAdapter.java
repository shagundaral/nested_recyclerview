package test.com.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MMT3760 on 1/17/2016.
 */
public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondViewHolder> {

    Context context;
    List<String> innerData;

    SecondAdapter(Context c, List<String> data){
        this.context = c;
        this.innerData = data;
    }

    @Override
    public SecondViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row_other, parent, false);
        SecondViewHolder vh = new SecondViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SecondViewHolder holder, int position) {

        if(null!=innerData && !innerData.isEmpty()){
            holder.tv.setText(innerData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return innerData.size();
    }

    public class SecondViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public SecondViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.sub_title);
        }
    }

}
