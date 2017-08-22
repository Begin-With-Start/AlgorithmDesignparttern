package designpartern.minifly.com.designparttern.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import designpartern.minifly.com.designparttern.R;

/**
 * 插入排序，最好情况：O(n) 当所有的数据都是已经排序好的时候
 *          最坏情况：O(n2) 当所有的数据的顺序都是相反的时候
 *          往手里插牌的一个感觉
 *
 */
public class InsertSortingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_sorting);
    }

    public void insertSorting(){

    }
}
