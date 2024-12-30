package com.gfg.kanalyzer;

import java.util.*;

public class KeywordAnalyzerOrderByFreq implements KeywordAnalyzerInterface{

    Map<String,KeywordFreq> dataStore = new HashMap<>();

    @Override
    public void recordKeyword(String keyword) {
        if(dataStore.get(keyword) != null){
            KeywordFreq keywordFreq = dataStore.get(keyword);
            //treeSet.remove(keywordFreq);
            keywordFreq.increment();
            //treeSet.add(keywordFreq);
        }
        else{
            KeywordFreq keywordFreq = new KeywordFreq(keyword,1);
            dataStore.put(keyword,keywordFreq);
        }
    }

    @Override
    public List<String> getKeywords() {
        return dataStore.keySet().stream().toList();
    }

    @Override
    public List<KeywordFreq> getKeywordFreqOrderByFreq() {
        Collection<KeywordFreq> data = dataStore.values();
        List<KeywordFreq> list = data.stream().sorted(Comparator.reverseOrder()).toList();
        return list;
    }
}
