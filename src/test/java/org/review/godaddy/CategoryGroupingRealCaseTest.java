package org.review.godaddy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CategoryGroupingRealCaseTest {

    private List<String> articleCategoryPairs;

    @Before
    public void init() {
        articleCategoryPairs = new ArrayList<>();
        articleCategoryPairs.add("apple:fruit");
        articleCategoryPairs.add("coca:drink");
        articleCategoryPairs.add("orange:fruit");
        articleCategoryPairs.add("pepsi:drink");
        articleCategoryPairs.add("banana:fruit");
    }

    @Test
    public void groupByCategoryUsingMapOfArray_printExpectedValue() {
        long startTime = System.currentTimeMillis();

        Map<String, String[]> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfArray(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfArray_printExpectedValue");
        //*
        for (Map.Entry<String, String[]> entrySet : groupedByCategory.entrySet()) {
            System.out.println(entrySet.getKey() + " :");
            for (String article : entrySet.getValue()) {
                System.out.println("\t\t" + article);
            }
        }

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }

    @Test
    public void groupByCategoryUsingMapOfList_printExpectedValue() {
        long startTime = System.currentTimeMillis();
        Map<String, List<String>> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfList(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfList_printExpectedValue");

        for (Map.Entry<String, List<String>> entrySet : groupedByCategory.entrySet()) {
            System.out.println(entrySet.getKey() + " :");
            for (String article : entrySet.getValue()) {
                System.out.println("\t\t" + article);
            }
        }

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }


    @Test
    public void groupByCategoryUsingMapOfMap_printExpectedValue() {
        long startTime = System.currentTimeMillis();
        Map<String, Map<String, Object>> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfMap(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfMap_printExpectedValue");

        //*

        for (Map.Entry<String, Map<String, Object>> entrySet : groupedByCategory.entrySet()) {
            System.out.println(entrySet.getKey() + " :");
            for (Map.Entry<String, Object> article : entrySet.getValue().entrySet()) {
                System.out.println("\t\t" + article.getKey());
            }
        }

        //*/

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }


    @Test
    public void groupByCategoryUsingMapOfHashSet_printExpectedValue() {
        long startTime = System.currentTimeMillis();
        Map<String, Set<String>> groupedByCategory =
                CategoryGrouping.groupByCategoryUsingMapOfHashSet(articleCategoryPairs);

        System.out.println("----------groupByCategoryUsingMapOfHashSet_printExpectedValue");
        //*
        for (Map.Entry<String, Set<String>> entrySet : groupedByCategory.entrySet()) {
            System.out.println(entrySet.getKey() + " :");
            for (String article : entrySet.getValue()) {
                System.out.println("\t\t" + article);
            }
        }
        //*/

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("executionTime " + executionTime);
    }

}
