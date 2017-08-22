package designpartern.minifly.com.designparttern;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

import designpartern.minifly.com.designparttern.algorithm.AjldActivity;
import designpartern.minifly.com.designparttern.algorithm.BinarySearchActivity;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mDesignPartternListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDesignPartternListview = (RecyclerView) findViewById(R.id.design_parttern_listview);
        mDesignPartternListview.setLayoutManager(new LinearLayoutManager(this));

        LinkedList<MyBean> list = new LinkedList<>();
        MyBean myBean;

        myBean = new MyBean();
        myBean.setTitle("最大公因数的算法(欧几里得)");
        myBean.setClassName(AjldActivity.class);
        list.add(myBean);

        myBean = new MyBean();
        myBean.setTitle("二分查找的算法");
        myBean.setClassName(BinarySearchActivity.class);
        list.add(myBean);

        MyAdapter myAdapter = new MyAdapter(this, list);
        mDesignPartternListview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }


    class MyAdapter extends RecyclerView.Adapter {
        private Context context;
        private View view;
        private LinkedList<MyBean> list;

        public MyAdapter(Context context, LinkedList<MyBean> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = LayoutInflater.from(context).inflate(R.layout.demo_show_item_adapter_item, parent, false);
            final MyHolder viewHolder = new MyHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            final MyBean myBean = list.get(position);
            ((MyHolder) holder).myTextView.setText(myBean.getTitle());
            ((MyHolder) holder).myRel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(context, myBean.getClassName());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            if (list == null) {
                return 0;
            } else {
                return list.size();
            }
        }

        class MyHolder extends RecyclerView.ViewHolder {
            private TextView myTextView;
            private RelativeLayout myRel;

            public MyHolder(View itemView) {
                super(itemView);
                myRel = (RelativeLayout) view.findViewById(R.id.desk_adapter_rel);
                myTextView = (TextView) view.findViewById(R.id.desk_adapter_txt_id);
            }
        }
    }

    class MyBean<T> {
        private String title;
        private Class<T> className;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Class<T> getClassName() {
            return className;
        }

        public void setClassName(Class<T> className) {
            this.className = className;
        }
    }
}
