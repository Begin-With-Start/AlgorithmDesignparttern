package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.BaseActivity;
import designpartern.minifly.com.designparttern.R;

/**
 * 冒泡排序 ： 每次确定一个最大或者最小的值，放到位置上 (插入排序是每次把一个数据放到已经排序好的位置上)
 * 最差情况： O(n2)
 * 最好情况： O(n)
 */

public class BubbleSortingActivity extends BaseActivity {

    private TextView mBubblesortContentId;
    private TextView mBubblesortComputeId;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sorting);
        initView();
    }


    private void initView() {
        mBubblesortContentId = (TextView) findViewById(R.id.bubblesort_content_id);
        mBubblesortComputeId = (TextView) findViewById(R.id.bubblesort_compute_id);

        mBubblesortContentId.setText("/**\n" +
                "     * 从小到大的冒泡排序\n" +
                "     */\n" +
                "    public int[] bubbleSort(int [] array){\n" +
                "        int temp = 0;\n" +
                "\n" +
                "        for(int i = 0 ; i < array.length - 1 ; i++){\n" +
                "            for(int j = 0 ; j < array.length - 1 - i; j ++ ){\n" +
                "                count ++ ;\n" +
                "                if(array[j] > array[j+1]){\n" +
                "                    temp = array[j+1];\n" +
                "                    array[j+1] = array[j];\n" +
                "                    array[j] = temp;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        return array;\n" +
                "    }");
        mBubblesortComputeId.setText("new int[]{7,6,5,4,3,2,1} \n 排序之后的顺序是：  " + printArray(bubbleSort(new int[]{7,6,5,4,3,2,1})) + " \n 循环的次数(最差情况)：" + count);
    }

    /**
     * 从小到大的冒泡排序
     */
    public int[] bubbleSort(int [] array){
        int temp = 0;

        for(int i = 0 ; i < array.length - 1 ; i++){
            for(int j = 0 ; j < array.length - 1 - i; j ++ ){
                count ++ ;
                if(array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
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
