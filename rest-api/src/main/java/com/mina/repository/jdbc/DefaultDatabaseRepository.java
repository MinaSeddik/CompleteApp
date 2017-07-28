package com.mina.repository.jdbc;

import com.mina.common.concurrent.FutureData;
import com.mina.common.concurrent.Paralleizer;
import com.mina.repository.DatabaseRepository;
import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by menai on 2017-07-21.
 */
public class DefaultDatabaseRepository implements DatabaseRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private static final String THREAD_PREFIX = "PREFIX-";

    private ExecutorService executor = Executors.newFixedThreadPool(30, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setName(THREAD_PREFIX + counter.getAndIncrement());
        return thread;
    });

    @Override
    public List<String> getData(String value){

        // run database query

        // use RowMapper to map the dataset

        // return the list

        int sleep = Integer.parseInt(value);

        try{
            Thread.sleep(sleep);
        }catch (Exception ex){
//            throw ex;
        }

        String val1 = value + "--" + System.currentTimeMillis();
        String val2 = value + "--" + System.currentTimeMillis();
        String val3 = value + "--" + System.currentTimeMillis();

        return Arrays.asList(val1, val2, val3);
    }

    @Override
    public Map<String, List<String>> getData(List<String> values){
        return Paralleizer.paralleize(values, this::getData, executor);
    }

    @Override
    public Observable<FutureData<String, List<String>>> getDataAsObservable(List<String> values){
        return Paralleizer.paralleizeAndGetObservable(values, this::getData, executor);
    }

}
