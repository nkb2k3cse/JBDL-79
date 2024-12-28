package com.gfg.kanalyzer;

import java.util.List;
import java.util.Map;

public interface KeywordAnalyzerInterface {

    void recordKeyword(String keyword);

    List<String> getKeywords();

   // Map<String,Integer> getKeywordWithFreq();

    default Map<String,Integer> getKeywordWithFreq(){
        return null;
    }

    default List<KeywordFreq> getKeywordFreqOrderByFreq(){
        return null;
    }
}
