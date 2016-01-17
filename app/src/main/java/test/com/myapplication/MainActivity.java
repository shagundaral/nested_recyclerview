package test.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView multipleRowRecyclerView;
    private MultipleRowAdapter multipleRowAdapter;
    private List<Data> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multipleRowRecyclerView = (RecyclerView)findViewById(R.id.multipleRowRecyclerView);

        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(this);
        multipleRowRecyclerView.setLayoutManager(linearLayoutManager);
        multipleRowRecyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<Data>();
        List<String> innerData = new ArrayList<String>();
        innerData.add("sub1");
        innerData.add("sub2");
        innerData.add("sub3");
        Data d = new Data();
        d.setTitle("first title");
        d.setInnerData(innerData);
        data.add(d);

        List<String> innerData1 = new ArrayList<String>();
        innerData1.add("hello1");
        innerData1.add("hello2");
        innerData1.add("hello3");
        Data d1 = new Data();
        d1.setTitle("second title");
        d1.setInnerData(innerData);
        data.add(d1);

        multipleRowAdapter = new MultipleRowAdapter(this, data);

        multipleRowRecyclerView.setAdapter(multipleRowAdapter);
    }

}