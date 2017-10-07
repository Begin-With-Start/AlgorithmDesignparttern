package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.BaseActivity;
import designpartern.minifly.com.designparttern.R;
import designpartern.minifly.com.designparttern.tools.LogUtils;

/**
 * 插入排序，最好情况：O(n) 当所有的数据都是已经排序好的时候
 * 最坏情况：O(n2) 当所有的数据的顺序都是相反的时候
 * 往手里插牌的一个感觉
 */
public class SortingInsertActivity extends BaseActivity {

    private TextView mInsertSortingId;
    private TextView mInsertSortingContentId;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_sorting);

        mInsertSortingId = (TextView) findViewById(R.id.insert_sorting_id);
        mInsertSortingContentId = (TextView) findViewById(R.id.insert_sorting_content_id);

        mInsertSortingContentId.setText("new int[]{7,6,5,4,3,2,1} \n 排序之后的顺序是：  " + printArray(insertSorting(new int[]{7,6,5,4,3,2,1})) + " \n 循环的次数(最差情况)：" + count);

        mInsertSortingId.setText("/**\n" +
                "     * 从小到大的排序--- 插入排序\n" +
                "     * 默认第一个排序好，\n" +
                "     * 每次往已经排序好的里面插入元素\n" +
                "     */\n" +
                "    public int[] insertSorting(int[] array) {\n" +
                "        int target , j;\n" +
                "        for (int i = 1; i < array.length; i++) {\n" +
                "            j = i;\n" +
                "            target = array[i];\n" +
                "            while (j > 0 && target < array[j - 1]) {\n" +
                "                //交换了之后会结束掉循环，所以每次都是交换两个比较点的值的\n" +
                "                count ++ ;\n" +
                "                array[j] = array[j - 1];\n" +
                "                j--;\n" +
                "            }\n" +
                "            array[j] = target;\n" +
                "            LogUtils.showErrLog(\"\" + printArray(array));\n" +
                "        }\n" +
                "        return array;\n" +
                "    }");
    }

    /**
     * 从小到大的排序--- 插入排序
     * 默认第一个排序好，
     * 每次往已经排序好的里面插入元素
     */
    public int[] insertSorting(int[] array) {
        int target , j;
        for (int i = 1; i < array.length; i++) {
            j = i;
            target = array[i];
            while (j > 0 && target < array[j - 1]) {
                //交换了之后会结束掉循环，所以每次都是交换两个比较点的值的
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
