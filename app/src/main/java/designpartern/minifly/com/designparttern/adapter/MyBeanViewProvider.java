package designpartern.minifly.com.designparttern.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import designpartern.minifly.com.designparttern.MainActivity;
import designpartern.minifly.com.designparttern.R;
import designpartern.minifly.com.designparttern.tools.ConvertUtils;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by dama on 2017/10/2.
 */
public class MyBeanViewProvider extends ItemViewProvider<MainActivity.MyBean, MyBeanViewProvider.ViewHolder> {
    private Context mContext;
    public MyBeanViewProvider(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.demo_show_item_adapter_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(
            @NonNull ViewHolder holder, @NonNull final MainActivity.MyBean myBean) {
        holder.title.setText(myBean.getTitle());
        if(myBean.getClassName() ==  Object.class){
            holder.title.setTextSize(22);
            holder.allRel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }else{
            holder.title.setTextSize(15);
            holder.allRel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(mContext, myBean.getClassName());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull private final TextView title;
        @NonNull private final RelativeLayout allRel;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.allRel = itemView.findViewById(R.id.desk_adapter_rel);
            this.title = itemView.findViewById(R.id.desk_adapter_txt_id);
        }
    }
}