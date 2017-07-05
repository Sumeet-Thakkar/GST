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


        private List<Movie> moviesList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_undrstnd_point;

            public MyViewHolder(View view) {
                super(view);
                tv_undrstnd_point = (TextView) view.findViewById(R.id.tv_undrstnd_point);

            }
        }


        public MoviesAdapter(List<Movie> moviesList) {
            this.moviesList = moviesList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.movie_list_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Movie movie = moviesList.get(position);
            holder.title.setText(movie.getTitle());
            holder.genre.setText(movie.getGenre());
            holder.year.setText(movie.getYear());
        }

        @Override
        public int getItemCount() {
            return moviesList.size();
        }

}
