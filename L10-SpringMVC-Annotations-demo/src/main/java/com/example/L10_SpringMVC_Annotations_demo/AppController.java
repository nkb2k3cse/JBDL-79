package com.example.L10_SpringMVC_Annotations_demo;

import com.gfg.kanalyzer.KeywordAnalyzerInterface;
import com.gfg.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Value("${gfg.payment.default.amount}")
    private Double amount;

    @Autowired
    private ProductService productService;

    @Autowired(required = false)
    private PaymentService paymentService;

    @Autowired
    @Qualifier("uniqueKeywordAnalyzerImp")
    private KeywordAnalyzerInterface keywordAnalyzerInterface;

    @Autowired
    private KeywordAnalyzerInterface defaultKeywordAnalyzer;


    @GetMapping("/products")
    public List<Product> products(){
        return productService.getAll();
    }

    @GetMapping("/payment")
    public String payment(){
        return paymentService.doPayment(amount);
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword){
        keywordAnalyzerInterface.recordKeyword(keyword);
        return "Recorded";
    }

    @GetMapping("/getAllKeywords")
    public List<String> getAllKeywords(){
        return keywordAnalyzerInterface.getKeywords();
    }
}
