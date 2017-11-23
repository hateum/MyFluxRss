package com.ygl_consulting.myfluxrss;

import android.test.mock.MockContext;
import android.view.View;

import com.ygl_consulting.myfluxrss.data.FakeRandomNewsGeneratorApi;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.network.NewsService;
import com.ygl_consulting.myfluxrss.viewmodels.NewsViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsViewModelTest {

    @Mock
    private NewsService newsService;
    @Mock
    private MockContext mockContext;

    private NewsViewModel newsViewModel;

    @Before
    public void setUpMainViewModelTest() {
        newsViewModel = new NewsViewModel(mockContext);
    }

    @Test
    public void simulateGivenTheUserCallListFromApi() throws Exception {
        List<News> newsList = FakeRandomNewsGeneratorApi.getNewsList();
//        Mockito.doReturn(Observable.just(newsList)).when(newsService).fetchNews(BuildConfig.RSS_URL);
    }

    @Test
    public void ensureTheViewsAreInitializedCorrectly() throws Exception {
        newsViewModel.initializeViews();
        Assert.assertEquals(View.GONE, newsViewModel.newsLabel.get());
        Assert.assertEquals(View.GONE, newsViewModel.newsRecycler.get());
        Assert.assertEquals(View.VISIBLE, newsViewModel.newsProgress.get());
    }
}
