package com.mina.common.concurrent;

import rx.Observable;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by menai on 2017-07-21.
 */
public class Paralleizer {

    private static <T, R> List<CompletableFuture<FutureData<T, R>>> execute(Collection<T> values, Function<T, R> function, ExecutorService executor) {

        return values.stream().map(value -> CompletableFuture.supplyAsync(() -> executeAndBuildFutureData(value, function), executor)
                .exceptionally(e -> buildFailureFutureData(value)))
                .collect(Collectors.toList());
    }

    public static <T, R> Map<T, R> paralleize(Collection<T> values, Function<T, R> function, ExecutorService executor) {

        List<CompletableFuture<FutureData<T, R>>> futures = execute(values, function, executor);
        Map<T, R> results = new HashMap();

        for (CompletableFuture<FutureData<T, R>> future : futures) {

            try {
                FutureData<T, R> futureData = future.get();
                results.put(futureData.getKey(), futureData.getValue());
            } catch (InterruptedException | ExecutionException ex) {
                // report error
                ex.printStackTrace();
            }
        }

        return results;
    }

    public static <T, R> Observable<FutureData<T, R>> paralleizeAndGetObservable(Collection<T> values, Function<T, R> function, ExecutorService executor) {

        List<CompletableFuture<FutureData<T, R>>> result = execute(values, function, executor);

        // convert to Observable
        List<Observable<FutureData<T, R>>> observables = result.stream().map(Paralleizer::createObservable).collect(Collectors.toList());

        return Observable.merge(observables);
    }

    private static <R, T> Observable<FutureData<T, R>> createObservable(CompletableFuture<FutureData<T, R>> completableFuture) {
        return Observable.create(subscriber ->
                completableFuture.whenComplete((result, error) -> {
                    if (error != null) {
                        subscriber.onError(error);
                    } else {
                        subscriber.onNext(result);
                        subscriber.onCompleted();
                    }
                }));
    }

    private static <T, R> FutureData<T, R> executeAndBuildFutureData(T value, Function<T, R> function) {

        FutureData<T, R> futureData = new FutureData();
        futureData.setKey(value);

        // run the actual method
        R result = function.apply(value);
        futureData.setValue(result);
        futureData.setFail(false);

        return futureData;
    }

    private static <T, R> FutureData<T, R> buildFailureFutureData(T value) {

        // log error message

        FutureData<T, R> futureData = new FutureData<>();

        // todo find fix for this problem
//        R result = new Object();


        futureData.setKey(value);
//        futureData.setValue();
        futureData.setFail(true);

        return futureData;
    }

}
