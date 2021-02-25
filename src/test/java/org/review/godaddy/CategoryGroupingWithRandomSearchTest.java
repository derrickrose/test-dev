package org.review.godaddy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CategoryGroupingWithRandomSearchTest {

    private List<String> articleCategoryPairs;

    @Before
    public void init() {
        articleCategoryPairs = new ArrayList<>();
        for (int indexArticle = 1; indexArticle <= 1000; indexArticle++) {
            for (int indexCategory = 1; indexCategory <= 10; indexCategory++) {
                articleCategoryPairs.add("article" + indexCategory + indexArticle + ":category" + indexCategory);
            }
        }
    /*
    articleCategoryPairs.add("apple:fruit");
    articleCategoryPairs.add("coca:drink");
    articleCategoryPairs.add("orange:fruit");
    articleCategoryPairs.add("pepsi:drink");
    articleCategoryPairs.add("banana:fruit");
    //*/
    }

    private static final int SEARCH_ATTEMPT = 5000;

    @Test
    public void groupByCategoryUsingMapOfArray_searchForArticle9999() {
        long startTime = System.currentTimeMillis();

        Map<String, String[]> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfArray(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfArray_searchForArticle9999");

        //*
        //recherche aléatoire par valeur soit article9999
        for (int searchAttempt = 1; searchAttempt <= SEARCH_ATTEMPT; searchAttempt++) {
            for (Map.Entry<String, String[]> entrySet : groupedByCategory.entrySet()) {
                for (String article : entrySet.getValue()) {
                    if (article.equals("article9999")) {
                        if (searchAttempt == 1)
                            System.out.println("found on array");
                        break;
                    }
                }
            }
        }

        //*/

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }

    @Test
    public void groupByCategoryUsingMapOfList_searchForArticle9999() {
        long startTime = System.currentTimeMillis();
        Map<String, List<String>> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfList(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfList_searchForArticle9999");
        //*
        //recherche aléatoire par valeur soit article9999
        for (int searchAttempt = 1; searchAttempt <= SEARCH_ATTEMPT; searchAttempt++) {
            for (Map.Entry<String, List<String>> entrySet : groupedByCategory.entrySet()) {
                if (entrySet.getValue().contains("article9999")) {
                    if (searchAttempt == 1)
                        System.out.println("found on list");
                    break;
                }
            }
        }
        //*/

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }


    @Test
    public void groupByCategoryUsingMapOfMap_searchForArticle9999() {
        long startTime = System.currentTimeMillis();
        Map<String, Map<String, Object>> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfMap(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfMap_searchForArticle9999");

        //*
        //recherche aléatoire par valeur soit article9999
        for (int searchAttempt = 1; searchAttempt < SEARCH_ATTEMPT; searchAttempt++) {
            for (Map.Entry<String, Map<String, Object>> entrySet : groupedByCategory.entrySet()) {
                if (entrySet.getValue().containsKey("article9999")) {
                    if (searchAttempt == 1)
                        System.out.println("found on map");
                    break;
                }
            }
        }

        //*/

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }


    @Test
    public void groupByCategoryUsingMapOfHashSet_searchForArticle9999() {
        long startTime = System.currentTimeMillis();
        Map<String, Set<String>> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfHashSet(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfHashSet_searchForArticle9999");
        //*
        //recherche aléatoire par valeur soit article9999
        for (int searchAttempt = 1; searchAttempt < SEARCH_ATTEMPT; searchAttempt++) {
            for (Map.Entry<String, Set<String>> entrySet : groupedByCategory.entrySet()) {
                if (entrySet.getValue().contains("article9999")) {
                    if (searchAttempt == 1)
                        System.out.println("found on set");
                    break;
                }
            }
        }

        //*/

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }

}
