package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import designpartern.minifly.com.designparttern.R;

/**
 * 欧几里得算法，算最大公因数
 */
public class AjldActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView mAlgorithmContentId;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajld);
        mAlgorithmContentId = (TextView) findViewById(R.id.algorithm_content_id);
        mTextView = (TextView) findViewById(R.id.algorithm_compute_id);
        mAlgorithmContentId.setText("public long gcd(long m, long n) {\n" +
                "        while (n != 0) {\n" +
                "            long rem = m % n;\n" +
                "            m = n;\n" +
                "            n = rem;\n" +
                "        }\n" +
                "        return m;\n" +
                "    }");
        mTextView.setText("100与1000的最大公因数： " + gcd(100, 1000) +"\n循环次数：" + count);
    }

    /**
     * 欧几里得算法，算最大公因数
     */
    public long gcd(long m, long n) {
        while (n != 0) {
            count++;
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}
