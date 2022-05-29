package com.alze.kurs;

import com.alze.kurs.searchEngine.Search;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSearch {
    Search search= new Search();
    @Test
    public void TestEditor(){
        String str = "JUnit: Test passed";
        str=search.editor(str);
        assertTrue((str=="today&")||(str.indexOf(" ")==-1));
    }

    @Test
    public void TestRadioMethod(){
        int rad=2;
        String radresult;
        radresult=search.radioMethod(rad);
        assertTrue(radresult=="sortBy=relevancy&");
    }

    @Test
    public void TestDateMethod(){
        String data_from=null, data_to=null,dataresult;
        dataresult=search.dateMethod(data_from,data_to);
        assertTrue(dataresult=="");
    }
}
