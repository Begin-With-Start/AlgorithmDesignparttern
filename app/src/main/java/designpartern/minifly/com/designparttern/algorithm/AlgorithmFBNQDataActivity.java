package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.BaseActivity;
import designpartern.minifly.com.designparttern.R;

public class AlgorithmFBNQDataActivity extends BaseActivity {
    private TextView contentTxt,computeTxt;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbnqdata);

        contentTxt = (TextView) findViewById(R.id.algorithm_content_fbnq_id);
        computeTxt = (TextView) findViewById(R.id.algorithm_compute_fbnq_id);
        computeTxt.setText("斐波那契的结果：  " + fbnq(5));
        contentTxt.setText("public int fbnq(int i){\n" +
                "        if(i == 0){\n" +
                "            return 0;\n" +
                "        }\n" +
                "        if(i == 1){\n" +
                "            return 1;\n" +
                "        }\n" +
                "        return fbnq(i - 1) + fbnq(i-2);\n" +
                "    }");
    }

    /**
     * 递归方法来求斐波那契数，中断条件：当i=1返回1 ， 当i=0 返回0
     * @param i
     * @return
     */
    public int fbnq(int i){
        if(i<2){
            return  i;
        }
        return fbnq(i - 1) + fbnq(i-2);
    }
}
