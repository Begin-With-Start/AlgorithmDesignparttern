package designpartern.minifly.com.designparttern.algorithm;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Stack;

import designpartern.minifly.com.designparttern.BaseActivity;
import designpartern.minifly.com.designparttern.R;
import designpartern.minifly.com.designparttern.tools.LogUtils;

public class OtherMinStackActivity extends BaseActivity{
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_min_stack);
        text = (TextView) findViewById(R.id.minstack_txt_id);

        MinStack minStack = new MinStack();
        minStack.push(new Data(100));
        minStack.push(new Data(90));
        minStack.push(new Data(10));
        minStack.push(new Data(20));
        minStack.push(new Data(1));
        minStack.push(new Data(3222));


        LogUtils.showErrLog("最小值是：   " + minStack.getMinData());
        minStack.pop();
        minStack.pop();
        text.setText("最小值是：   " + minStack.getMinData() + " 当前栈是" + minStack.getStack().toString() + "  最小栈是： "  + minStack.getMinStack().toString() );

    }

    class MinStack{
        private Stack<Data> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public Stack<Data> getStack() {
            return stack;
        }

        public void setStack(Stack<Data> stack) {
            this.stack = stack;
        }

        public Stack<Integer> getMinStack() {
            return minStack;
        }

        public void setMinStack(Stack<Integer> minStack) {
            this.minStack = minStack;
        }

        public void pop(){
            if(stack!= null && !stack.isEmpty()){
                Data data = stack.pop();
                if(minStack.lastElement() == stack.size()-1){ //存储的是这个元素时候
                    minStack.pop();
                }
            }
        }

        public void push(Data data){
            if(stack!= null){
                stack.push(data);
                if(minStack.isEmpty() || stack.get(minStack.lastElement()).number > data.number){
                    minStack.push(stack.size() - 1);
                }
            }
        }

//        public void peek(){
//
//        }
        public int getMinData(){
            return stack.get(minStack.lastElement()).number;
        }
    }

    class Data{
        int number;

        public Data(int number) {
            this.number = number;
        }
    }

}
