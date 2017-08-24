package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.R;

public class ShellSortActivity extends AppCompatActivity {

    private TextView mShellSortingId;
    private TextView mShellSortingContentId;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell_sort);

        mShellSortingId = (TextView) findViewById(R.id.shell_sorting_id);
        mShellSortingContentId = (TextView) findViewById(R.id.shell_sorting_content_id);

        mShellSortingContentId.setText("new int[]{7,6,5,4,3,2,1} \n 排序之后的顺序是：  " + printArray(shellSort(new int[]{7,6,5,4,3,2,1})) + " \n 循环的次数(最差情况)：" + count);

        mShellSortingId.setText("/**\n" +
                "     * 希尔排序\n" +
                "     */\n" +
                "    public int [] shellSort(int [] array){\n" +
                "        int temp = 0 , j = 0;\n" +
                "        //每次的间隔比较成倍减小的\n" +
                "        for(int step = array.length/2 ; step > 0 ; step /= 2){\n" +
                "            for(int i = step ; i < array.length ; i ++ ){\n" +
                "                temp = array[i];\n" +
                "                for( j = i; j >= step && temp > array[i - step] ; j -= step){\n" +
                "                    count ++ ;\n" +
                "                    array[j] = array[j-step];\n" +
                "                    //赋值到了j之后，下次的循环会被退出 退出后会将temp给到j-step处故而可以完成交换值.\n" +
                "                }\n" +
                "                array[j] = temp;\n" +
                "            }\n" +
                "        }\n" +
                "        return array;\n" +
                "    }");

    }

    /**
     * 希尔排序
     */
    public int [] shellSort(int [] array){
        int temp = 0 , j = 0;
        //每次的间隔比较成倍减小的
        for(int step = array.length/2 ; step > 0 ; step /= 2){
            for(int i = step ; i < array.length ; i ++ ){
                temp = array[i];
                for( j = i - step; j >= 0 ; j -= step){
                    count ++ ;

                    if(temp < array[j]){
                        array[j + step] = array[j];
                        //赋值到了j之后，下次的循环会被退出(break退出了) 退出后会将temp给到j-step处故而可以完成交换值.
                    }else{
                        break;
                    }
                }
                array[j + step] = temp;
            }
        }
        return array;
    }


    public String printArray(int[] array) {
        StringBuilder sb = new StringBuilder("");
        for (int tempi : array) {
            sb.append(" " + tempi);
        }
        return sb.toString();
    }
}
