package com.mina.repository;

import com.mina.common.concurrent.FutureData;
import rx.Observable;

import java.util.List;
import java.util.Map;

/**
 * Created by menai on 2017-07-21.
 */
public interface DatabaseRepository {

    List<String> getData(String value);

    Map<String, List<String>> getData(List<String> values);

    Observable<FutureData<String, List<String>>> getDataAsObservable(List<String> values);
}
