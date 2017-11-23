package com.ygl_consulting.myfluxrss;

import com.ygl_consulting.myfluxrss.data.FakeRandomNewsGeneratorApi;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.viewmodels.NewsDetailsViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsDetailsViewModelTest {

    private NewsDetailsViewModel newsDetailsViewModel;
    private News news;

    @Before
    public void setUpDetailViewModelTest() {
        news = FakeRandomNewsGeneratorApi.getNews();
        newsDetailsViewModel = new NewsDetailsViewModel(news);
    }

    @Test
    public void shouldGetNewsTitle() throws Exception {
        Assert.assertEquals(news.title, newsDetailsViewModel.getTitle());
    }

    @Test
    public void shouldGetNewsDescription() throws Exception {
        Assert.assertEquals(news.description, newsDetailsViewModel.getDescription());
    }

    @Test
    public void shouldGetNewsDate() throws Exception {
        Assert.assertEquals(news.date, newsDetailsViewModel.getDate());
    }

    @Test
    public void shouldGetNewsLink() throws Exception {
        Assert.assertEquals(news.link, newsDetailsViewModel.getLink());
    }
}
