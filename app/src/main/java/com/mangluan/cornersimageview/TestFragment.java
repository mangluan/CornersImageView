package com.mangluan.cornersimageview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 50834 on 2020/5/24.
 */
public class TestFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment, null);
        RecyclerView mRecyclerView = view.findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new SimpleAdapter());
        return view;
    }


    class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getContext())
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
