package com.ygl_consulting.myfluxrss;

import com.ygl_consulting.myfluxrss.data.FakeRandomNewsGeneratorApi;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.viewmodels.NewsDetailsWebViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsDetailsWebViewViewModelTest {

    private NewsDetailsWebViewModel newsDetailsWebViewModel;
    private News news;

    @Before
    public void setUpDetailViewModelTest() {
        news = FakeRandomNewsGeneratorApi.getNews();
        newsDetailsWebViewModel = new NewsDetailsWebViewModel(news);
    }

    @Test
    public void shouldGetNewsLink() throws Exception {
        Assert.assertEquals(news.link, newsDetailsWebViewModel.getLink());
    }
}
