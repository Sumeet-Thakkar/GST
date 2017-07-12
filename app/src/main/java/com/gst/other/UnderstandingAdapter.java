package com.gst.other;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gst.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by thakkar on 6/7/17.
 */

public class UnderstandingAdapter extends RecyclerView.Adapter<UnderstandingAdapter.MyViewHolder> {


        private List<String> understandingList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_undrstnd_point;

            public MyViewHolder(View view) {
                super(view);
                tv_undrstnd_point = (TextView) view.findViewById(R.id.tv_undrstnd_point);

            }
        }


        public UnderstandingAdapter(List<String> understandingList) {
            this.understandingList = understandingList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.understanding_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            String understanding = understandingList.get(position);
            holder.tv_undrstnd_point.setText(understanding);
        }

        @Override
        public int getItemCount() {
            return understandingList.size();
        }
}