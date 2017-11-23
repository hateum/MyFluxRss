package com.ygl_consulting.myfluxrss;

import android.content.Intent;
import android.test.mock.MockContext;

import com.ygl_consulting.myfluxrss.data.MockView;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.viewmodels.ItemNewsViewModel;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemNewsViewModelTest {

    private static final String NEWS_TITLE_TEST = "Les crimes de Ratko Mladic, « parmi les plus haineux de l’humanité »";
    private static final String NEWS_DESCRIPTION_TEST = "Le Tribunal pénal pour l’ex-Yougoslavie a condamné à perpétuité le général serbo-bosniaque, principal responsable des crimes lors de la guerre en Bosnie-Herzégovine.";
    private static final String NEWS_PICTURE_TEST = "http://s1.lemde.fr/image/2017/11/22/644x322/5218825_3_bbed_2017-11-22-7232c55-yh202-warcrimes-mladic-1122_c22d709f28dd617e184822c13d486c11.jpg";
    private static final String NEWS_DATE_TEST = "Wed, 22 Nov 2017 11:04:22 +0100";
    private static final String NEWS_LINK_TEST = "http://www.lemonde.fr/europe/article/2017/11/22/le-verdict-du-proces-de-ratko-mladic-accuse-de-genocide-attendu-a-la-haye_5218588_3214.html?xtor=RSS-3208";

    @Mock
    private MockContext mockContext;

    @Test
    public void shouldGetNewsTitle() throws Exception {
        News news = new News();
        news.title = NEWS_TITLE_TEST;
        ItemNewsViewModel itemNewsViewModel = new ItemNewsViewModel(news, mockContext);
        Assert.assertEquals(news.title, itemNewsViewModel.getTitle());
    }

    @Test
    public void shouldGetNewsDate() throws Exception {
        News news = new News();
        news.date = NEWS_DATE_TEST;
        ItemNewsViewModel itemNewsViewModel = new ItemNewsViewModel(news, mockContext);
        Assert.assertEquals(news.date, itemNewsViewModel.getDate());
    }

    @Ignore
    public void shouldGetNewsPicture() throws Exception {
        News news = new News();
        news.imageUrl = NEWS_PICTURE_TEST;
        ItemNewsViewModel itemNewsViewModel = new ItemNewsViewModel(news, mockContext);
        Assert.assertEquals(news.imageUrl, itemNewsViewModel.getPicture());
    }

    @Test
    public void shouldStartNewsDetailActivityOnItemClick() throws Exception {
        News news = new News();
        ItemNewsViewModel itemNewsViewModel = new ItemNewsViewModel(news, mockContext);
        itemNewsViewModel.onItemClick(new MockView(mockContext));
        Mockito.verify(mockContext).startActivity(Mockito.any(Intent.class));
    }
}