package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.R;

public class MergeSortActivity extends AppCompatActivity {

    private TextView mAlgorithmContentMergesortId;
    private TextView mAlgorithmComputeMergesortId;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_sort);

        mAlgorithmContentMergesortId = (TextView) findViewById(R.id.algorithm_content_mergesort_id);
        mAlgorithmComputeMergesortId = (TextView) findViewById(R.id.algorithm_compute_mergesort_id);
        int [] array = new int[]{7,6,5,4,3,2,1};
        mergeSort(array);
        mAlgorithmComputeMergesortId.setText("new int[]{7,6,5,4,3,2,1} \n 排序之后的顺序是：  " +array + " \n 循环的次数(最差情况)：" + count);


        mAlgorithmContentMergesortId.setText("/**\n" +
                "     * 归并排序\n" +
                "     * 切割和合并操作\n" +
                "     *\n" +
                "     * @param data int []\n" +
                "     */\n" +
                "    public  void mergeSort(int[] data) {\n" +
                "        sort(data, 0, data.length - 1);\n" +
                "    }\n" +
                "\n" +
                "    public  void sort(int[] data, int left, int right) {\n" +
                "\n" +
                "//        count ++ ;\n" +
                "        if (left >= right)\n" +
                "            return;\n" +
                "        // 找出中间索引\n" +
                "        int center = (left + right) / 2;\n" +
                "        // 对左边数组进行递归\n" +
                "        sort(data, left, center);\n" +
                "        // 对右边数组进行递归\n" +
                "        sort(data, center + 1, right);\n" +
                "        // 合并\n" +
                "        merge(data, left, center, right);\n" +
                "        print(data);\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序\n" +
                "     * @param data   数组对象\n" +
                "     * @param left   左数组的第一个元素的索引\n" +
                "     * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引\n" +
                "     * @param right  右数组最后一个元素的索引\n" +
                "     */\n" +
                "    public  void merge(int[] data, int left, int center, int right) {\n" +
                "        // 临时数组\n" +
                "        int[] tmpArr = new int[data.length];\n" +
                "        // 右数组第一个元素索引\n" +
                "        int mid = center + 1;\n" +
                "        // third 记录临时数组的索引\n" +
                "        int third = left;\n" +
                "        // 缓存左数组第一个元素的索引\n" +
                "        int tmp = left;\n" +
                "        while (left <= center && mid <= right) {\n" +
                "            count ++ ;\n" +
                "            // 从两个数组中取出最小的放入临时数组\n" +
                "            if (data[left] <= data[mid]) {\n" +
                "                tmpArr[third++] = data[left++];\n" +
                "            } else {\n" +
                "                tmpArr[third++] = data[mid++];\n" +
                "            }\n" +
                "        }\n" +
                "        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）\n" +
                "        while (mid <= right) {\n" +
                "            count ++ ;\n" +
                "            tmpArr[third++] = data[mid++];\n" +
                "        }\n" +
                "        while (left <= center) {\n" +
                "            count ++ ;\n" +
                "            tmpArr[third++] = data[left++];\n" +
                "        }\n" +
                "        // 将临时数组中的内容拷贝回原数组中\n" +
                "        // （原left-right范围的内容被复制回原数组）\n" +
                "        while (tmp <= right) {\n" +
                "            count ++ ;\n" +
                "            data[tmp] = tmpArr[tmp++];\n" +
                "        }\n" +
                "    }");
    }


    /**
     * 归并排序
     * 切割和合并操作
     *
     * @param data int []
     */
    public  void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public  void sort(int[] data, int left, int right) {

//        count ++ ;
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        sort(data, left, center);
        // 对右边数组进行递归
        sort(data, center + 1, right);
        // 合并
        merge(data, left, center, right);
        print(data);
    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     * @param data   数组对象
     * @param left   左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right  右数组最后一个元素的索引
     */
    public  void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            count ++ ;
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            count ++ ;
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            count ++ ;
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            count ++ ;
            data[tmp] = tmpArr[tmp++];
        }
    }

    public  String print(int [] array){
        StringBuilder sb = new StringBuilder("");
        for(int tempi : array){
            sb.append(" " + tempi);
        }
        return sb.toString();
    }
}
