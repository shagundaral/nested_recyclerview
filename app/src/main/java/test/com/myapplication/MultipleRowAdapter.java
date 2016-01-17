package test.com.myapplication;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MMT3760 on 1/17/2016.
 */
public class MultipleRowAdapter extends RecyclerView.Adapter<MultipleRowAdapter.ViewHolder> {

    List<Data> data;
    Context context;
    SecondAdapter secondAdapter;


    MultipleRowAdapter (Context context, List<Data> dataSet ){
        this.context = context;
        this.data = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_first_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Data d = data.get(position);
        if(null!=d){
            holder.tv.setText(d.getTitle());
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.rv.setVisibility(View.VISIBLE);
                    secondAdapter = new SecondAdapter(context, d.getInnerData());
                    CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(context);
                    holder.rv.setLayoutManager(linearLayoutManager);
                    holder.rv.setAdapter(secondAdapter);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        RecyclerView rv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.text1);
            rv = (RecyclerView) itemView.findViewById(R.id.meal_list);
        }
    }

}
