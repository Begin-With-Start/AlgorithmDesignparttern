package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.BaseActivity;
import designpartern.minifly.com.designparttern.R;

/**
 * 二分查找的算法
 */
public class SearchBinaryActivity extends BaseActivity {

    private TextView mBinarySearchComputeId;
    private TextView binary_search_content_id;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search);
        initView();
    }

    private void initView() {
        mBinarySearchComputeId = (TextView) findViewById(R.id.binary_search_compute_id);
        mBinarySearchComputeId.setText("new int[]{1, 2, 3, 4, 5, 6, 7,10,20,21,22,23,34}查找23的结果是：" + binarysearchCompute(new int[]{1, 2, 3, 4, 5, 6, 7,10,20,21,22,23,34}, 23) + "\n 循环次数：" + count);

        binary_search_content_id = (TextView) findViewById(R.id.binary_search_content_id);

        binary_search_content_id.setText("public int binarysearchCompute(int[] array, int destInt) {\n" +
                "        int low = 0, high = array.length - 1;\n" +
                "        while (low <= high) {\n" +
                "            int mid = (low + high) / 2;\n" +
                "\n" +
                "            if (array[mid] < destInt) {\n" +
                "                low = mid + 1;\n" +
                "            } else if (array[mid] > destInt) {\n" +
                "                high = mid - 1;\n" +
                "            } else {\n" +
                "                return array[mid];\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        return -1;\n" +
                "    }");
    }

    /**
     * 有序数组的二分查找
     * @param array
     * @param destInt
     * @return
     */
    public int binarysearchCompute(int[] array, int destInt) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            count ++;
            int mid = (low + high) / 2;

            if (array[mid] < destInt) {
                low = mid + 1;
            } else if (array[mid] > destInt) {
                high = mid - 1;
            } else {
                return array[mid];
            }
        }

        return -1;
    }
}
