package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.R;
import designpartern.minifly.com.designparttern.tools.LogUtils;

/**
 * 插入排序，最好情况：O(n) 当所有的数据都是已经排序好的时候
 * 最坏情况：O(n2) 当所有的数据的顺序都是相反的时候
 * 往手里插牌的一个感觉
 */
public class InsertSortingActivity extends AppCompatActivity {

    private TextView mInsertSortingId;
    private TextView mInsertSortingContentId;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_sorting);

        mInsertSortingId = (TextView) findViewById(R.id.insert_sorting_id);
        mInsertSortingContentId = (TextView) findViewById(R.id.insert_sorting_content_id);

        mInsertSortingContentId.setText("new int[]{7,6,5,4,3,2,1} \n 排序之后的顺序是(最差情况)：  " + printArray(insertSorting(new int[]{7,6,5,4,3,2,1})) + " \n 循环的次数：" + count);

        mInsertSortingId.setText(
                "    /**\n" +
                "     * 从小到大的排序--- 插入排序\n" +
                "     * 默认第一个排序好，\n" +
                "     * 每次往已经排序好的里面插入元素\n" +
                "     */\n" +
                "    public void insertSorting(int[] array) {\n" +
                "        int target = 0;\n" +
                "        for (int i = 0; i < array.length - 1; i++) {\n" +
                "            int j = i;\n" +
                "            target = array[i];\n" +
                "            while (j > 0 && target < array[j - 1]) {\n" +
                "                target = array[j - 1];\n" +
                "                j--;\n" +
                "            }\n" +
                "            array[j] = target;\n" +
                "        }\n" +
                "    }");
    }

    /**
     * 从小到大的排序--- 插入排序
     * 默认第一个排序好，
     * 每次往已经排序好的里面插入元素
     *
     */
    public int[] insertSorting(int[] array) {
        int target , j;
        for (int i = 1; i < array.length; i++) {
            j = i;
            target = array[i];
            while (j > 0 && target < array[j - 1]) {
                count ++ ;
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
            LogUtils.showErrLog("" + printArray(array));
        }
        return array;
    }

    public String printArray(int [] array){
        StringBuilder sb = new StringBuilder("");
        for(int tempi : array){
            sb.append(" " + tempi);
        }
        return sb.toString();
    }
}
