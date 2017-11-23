package com.ygl_consulting.myfluxrss.views;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ygl_consulting.myfluxrss.R;
import com.ygl_consulting.myfluxrss.databinding.ItemNewsLayoutBinding;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.viewmodels.ItemNewsViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {

    private List<News> newsList;

    public NewsAdapter() {
        this.newsList = Collections.emptyList();
    }

    @Override
    public NewsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemNewsLayoutBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_news_layout,
                parent, false);
        return new NewsAdapterViewHolder(itemNewsBinding);
    }

    @Override
    public void onBindViewHolder(NewsAdapterViewHolder holder, int position) {
        holder.bindNews(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setNewsList(List<News> newsList) {
        //FIXME utilise diffUtils, c'est pas bon de raffraichir la liste en totalite.
//        notifyDataSetChanged();
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffNewsCallback(this.newsList, newsList));
        diffResult.dispatchUpdatesTo(this);
        this.newsList = newsList;
    }

    static class NewsAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemNewsLayoutBinding mItemNewsBinding;

        public NewsAdapterViewHolder(ItemNewsLayoutBinding itemNewsBinding) {
            super(itemNewsBinding.itemNews);
            this.mItemNewsBinding = itemNewsBinding;
        }

        void bindNews(News news) {
            if (mItemNewsBinding.getNewsItemViewModel() == null) {
                ItemNewsViewModel itemNewsViewModel = new ItemNewsViewModel(news, itemView.getContext());
                mItemNewsBinding.setNewsItemViewModel(itemNewsViewModel);
            } else {
                mItemNewsBinding.getNewsItemViewModel().setNews(news);
            }
        }
    }
}