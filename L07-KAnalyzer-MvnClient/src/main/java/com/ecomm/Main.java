package com.ecomm;

import com.gfg.kanalyzer.KeywordAnalyzerInterface;
import com.gfg.kanalyzer.NewKeywordAnalyzerImpl;
import com.gfg.kanalyzer.RecentKeywordAnalyzerImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        KeywordAnalyzerInterface keywordAnalyzerInterface = new RecentKeywordAnalyzerImpl();

    }
}