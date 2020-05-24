package com.mangluan.cornersimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * ScrollView 里直接嵌套 RecyclerView
 *      导致RecyclerView一次性全部加载完，复用机制消失
 */
public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        RecyclerView mRecyclerView = findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new SimpleAdapter());
        mRecyclerView.setNestedScrollingEnabled(false);
    }

    public int dp2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(DemoActivity.this)
                    .inflate(R.layout.item_recycler_view, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title.setText("测试性能 item - " + String.valueOf(position));
            Log.e("SimpleAdapter", "onBindViewHolder: " + position);
        }

        @Override
        public int getItemCount() {
            return 208;
        }


        class ViewHolder extends RecyclerView.ViewHolder {

            TextView title;

            public ViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.item_title);
            }
        }
    }

}
