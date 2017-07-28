package com.mina.service.impl;

import com.mina.common.concurrent.FutureData;
import com.mina.domain.CountryEntity;
import com.mina.model.Country;
import com.mina.repository.DatabaseRepository;
import com.mina.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by menai on 2017-07-28.
 */
public class ParallizerDatabaseService implements DatabaseService{

    private static Map<String, List<String>> mapper = new ConcurrentHashMap<>();

    @Autowired
    private DatabaseRepository databaseRepository;

//    @Scheduled
    public void scheduledUpdater(){

        List<String> dataToBeRetrieved = Arrays.asList("data1", "data2", "data3");
        databaseRepository.getDataAsObservable(dataToBeRetrieved).subscribe(data -> updateMapper(data));
    }

    private void updateMapper(FutureData<String, List<String>> futureData) {

        if( !futureData.isFail()){

            String key = futureData.getKey();
            List<String> value = futureData.getValue();

            mapper.put(key, value);
        }
    }

    @Override
    public List<String> getData(String data) {
        return mapper.get(data);
    }


}
