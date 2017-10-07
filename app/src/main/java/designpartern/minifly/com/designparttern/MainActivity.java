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

import designpartern.minifly.com.designparttern.adapter.MyBeanViewProvider;
import designpartern.minifly.com.designparttern.algorithm.AlgorithmAjldActivity;
import designpartern.minifly.com.designparttern.algorithm.SearchBinaryActivity;
import designpartern.minifly.com.designparttern.algorithm.SortingBubbleActivity;
import designpartern.minifly.com.designparttern.algorithm.AlgorithmFBNQDataActivity;
import designpartern.minifly.com.designparttern.algorithm.SortingInsertActivity;
import designpartern.minifly.com.designparttern.algorithm.SortingMergeActivity;
import designpartern.minifly.com.designparttern.algorithm.SortingShellActivity;
import me.drakeet.multitype.MultiTypeAdapter;

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

        LinkedList<MyBean> listSecond = new LinkedList<>();
        MyBean myBeanSecond;


        myBeanSecond = new MyBean();
        myBeanSecond.setClassName(Object.class);
        myBeanSecond.setTitle("标题---------基本数据结构---------");
        listSecond.add(myBeanSecond);


        



        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("标题------------算法相关------------");
        myBeanSecond.setClassName(Object.class);
        listSecond.add(myBeanSecond);

        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("斐波那契数栈的实现方式");
        myBeanSecond.setClassName(AlgorithmFBNQDataActivity.class);
        listSecond.add(myBeanSecond);

        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("最大公因数的算法(欧几里得)");
        myBeanSecond.setClassName(AlgorithmAjldActivity.class);
        listSecond.add(myBeanSecond);

        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("二分查找的算法");
        myBeanSecond.setClassName(SearchBinaryActivity.class);
        listSecond.add(myBeanSecond);

        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("插入排序算法(从小到大的排序顺序)");
        myBeanSecond.setClassName(SortingInsertActivity.class);
        listSecond.add(myBeanSecond);

        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("冒泡排序算法(从小到大的排序顺序)");
        myBeanSecond.setClassName(SortingBubbleActivity.class);
        listSecond.add(myBeanSecond);

        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("希尔排序算法(小到大)一个插入排序的变种，旨在突破二次时间屏障O(n2)");
        myBeanSecond.setClassName(SortingShellActivity.class);
        listSecond.add(myBeanSecond);

        myBeanSecond = new MyBean();
        myBeanSecond.setTitle("归并排序的例子()");
        myBeanSecond.setClassName(SortingMergeActivity.class);
        listSecond.add(myBeanSecond);


        secondAdapter = new MultiTypeAdapter(listSecond);
//        MultiTypeAdapter
        /* 注册类型和 View 的对应关系 */
        secondAdapter.register(MyBean.class, new MyBeanViewProvider(this));
//        secondAdapter.register(MyBean.class, new SongViewProvider());

        mDesignPartternListview.setAdapter(secondAdapter);
        secondAdapter.notifyDataSetChanged();
    }
    private MultiTypeAdapter secondAdapter;

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

    public class MyBean {
        private String title;
        private Class className;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Class getClassName() {
            return className;
        }

        public void setClassName(Class className) {
            this.className = className;
        }
    }
}
