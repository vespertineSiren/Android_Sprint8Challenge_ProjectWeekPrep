package com.fatehistory.patrickjmartin.fatehistory;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fatehistory.patrickjmartin.fatehistory.HistoryAPI.HistoricalFigure;
import com.fatehistory.patrickjmartin.fatehistory.HistoryAPI.HistoricalFigureSearchHelper;
import com.fatehistory.patrickjmartin.fatehistory.HistoryAPI.WikiDao;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Context context;
    HistoricalFigure test;
    String[] testAray;
    String wiki, fate, fateImage;
    HistoricalFigureSearchHelper search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;


        search = HistoricalFigureSearchHelper.getINSTANCE();

        testAray = (String[])search.PEOPLE_MAP.get("minamoto no raikou");

        wiki = testAray[0];
        fate = testAray[1];
        fateImage = testAray[2];



        new Thread(new Runnable() {
            @Override
            public void run() {

                final HistoricalFigure testHF = test = WikiDao.getFateRealBio(wiki, fate);
            }
        }).start();





    }
}
