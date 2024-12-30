package com.gfg.kanalyzer;

public class Demo {

    public static void main(String[] args) {

       // KeywordAnalyzerInterface keywordAnalyzer = new KeywordAnalyzerImpl();
        //KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyzerImp();
        KeywordAnalyzerInterface keywordAnalyzer = new KeywordAnalyzerOrderByFreq();
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("mobile");
        keywordAnalyzer.recordKeyword("phone");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("phone");
        keywordAnalyzer.recordKeyword("phone");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("Acer Laptop");

        System.out.println(keywordAnalyzer.getKeywords());


        System.out.println(keywordAnalyzer.getKeywordFreqOrderByFreq());

    }
}
