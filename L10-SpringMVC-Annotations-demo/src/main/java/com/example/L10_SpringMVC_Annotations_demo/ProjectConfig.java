package com.example.L10_SpringMVC_Annotations_demo;

import com.gfg.kanalyzer.KeywordAnalyzerImpl;
import com.gfg.kanalyzer.KeywordAnalyzerInterface;
import com.gfg.kanalyzer.UniqueKeywordAnalyzerImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    @Primary
    public KeywordAnalyzerInterface getKeywordAnalyzerImpl(){
        return new KeywordAnalyzerImpl();
    }

    @Bean("uniqueKeywordAnalyzerImp")
    public KeywordAnalyzerInterface getUniqueKeywordAnalyzerImp(){
        return new UniqueKeywordAnalyzerImp();
    }
}
