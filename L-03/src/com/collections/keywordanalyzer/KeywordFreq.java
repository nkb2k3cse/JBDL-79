package com.collections.keywordanalyzer;

import java.util.Objects;

public class KeywordFreq implements Comparable{

    private String keyword;

    private Integer freq;

    public KeywordFreq(String keyword, Integer freq) {
        this.keyword = keyword;
        this.freq = freq;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    @Override
    public int compareTo(Object o) {
        return this.getFreq() - ((KeywordFreq)o).getFreq();
    }

    public void increment(){
        freq++;
    }

    @Override
    public String toString() {
        return "KeywordFreq{" +
                "keyword='" + keyword + '\'' +
                ", freq=" + freq +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeywordFreq that = (KeywordFreq) o;
        return Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(keyword);
    }
}
