package com.gfg1.keywordanalyzer;

import java.util.ArrayList;
import java.util.List;

public class KeywordAnalyzerImpl implements KeywordAnalyzerInterface {

    private List<String> dataStore = new ArrayList<>();

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getKeywords() {
        return dataStore;
    }


}
