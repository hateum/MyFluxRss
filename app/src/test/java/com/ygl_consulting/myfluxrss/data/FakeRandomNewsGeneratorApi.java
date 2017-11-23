package com.ygl_consulting.myfluxrss.data;

import com.ygl_consulting.myfluxrss.models.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public class FakeRandomNewsGeneratorApi {

    private static final String NEWS_TITLE_TEST = "Les crimes de Ratko Mladic, « parmi les plus haineux de l’humanité »";
    private static final String NEWS_DESCRIPTION_TEST = "Le Tribunal pénal pour l’ex-Yougoslavie a condamné à perpétuité le général serbo-bosniaque, principal responsable des crimes lors de la guerre en Bosnie-Herzégovine.";
    private static final String NEWS_PICTURE_TEST = "http://s1.lemde.fr/image/2017/11/22/644x322/5218825_3_bbed_2017-11-22-7232c55-yh202-warcrimes-mladic-1122_c22d709f28dd617e184822c13d486c11.jpg";
    private static final String NEWS_DATE_TEST = "Wed, 22 Nov 2017 11:04:22 +0100";
    private static final String NEWS_LINK_TEST = "http://www.lemonde.fr/europe/article/2017/11/22/le-verdict-du-proces-de-ratko-mladic-accuse-de-genocide-attendu-a-la-haye_5218588_3214.html?xtor=RSS-3208";


    public static List<News> getNewsList() {
        List<News> news = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            news.add(getNews());
        }
        return news;
    }

    public static News getNews() {
        News newsItem = new News();
        newsItem.title = NEWS_TITLE_TEST;
        newsItem.description = NEWS_DESCRIPTION_TEST;
        newsItem.imageUrl = NEWS_PICTURE_TEST;
        newsItem.date = NEWS_DATE_TEST;
        newsItem.link = NEWS_LINK_TEST;
        return newsItem;
    }
}
