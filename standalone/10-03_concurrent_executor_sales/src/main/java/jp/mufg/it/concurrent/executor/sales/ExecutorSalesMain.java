package jp.mufg.it.concurrent.executor.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSalesMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();
        List<List<Sales>> splitedListList = splitList(salesList, 10);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        // invokeAllで複数のタスクを同時に呼び出してジョインする
        List<Callable<Map<String, Integer>>> taskList =
                new ArrayList<Callable<Map<String, Integer>>>();
        for (List<Sales> splitedList : splitedListList) {
            taskList.add(new SalesTask(splitedList, "A"));
        }

        try {
            List<Future<Map<String, Integer>>> futureList =
                    executor.invokeAll(taskList);
            Map<String, Integer> resultMap = combineFutureList(futureList);
            for (String key : resultMap.keySet()) {
                System.out.println(key + " / " + resultMap.get(key));
            }
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        } finally {
            executor.shutdown();
        }

        /*
        invokeAllを使わない場合は以下のようにして自前でジョインする必要あり
        for (List<Sales> splitedList : splitedListList) {
            Future<Map<Integer, Integer>> future =
                    executor.submit(new SalesTask(splitedList));
            futureList.add(future);
        }

        // すべてのフューチャーが処理を終えるまで意図的にブロックさせる
        while (! idDoneAllFutureList(futureList)) {
            try {
                Thread.sleep(100);
            } catch(InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }
        */
    }

    // すべてのフューチャーを1つに統合する
    private static Map<String, Integer> combineFutureList(
            List<Future<Map<String, Integer>>> futureList)
                    throws InterruptedException, ExecutionException {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for (Future<Map<String, Integer>> futureMap : futureList) {
            Map<String, Integer> map = futureMap.get();
            for (String key : map.keySet()) {
                Integer value = resultMap.get(key);
                if (value != null) {
                    resultMap.put(key, value + map.get(key));
                } else {
                    resultMap.put(key, map.get(key));
                }
            }
        }
        return resultMap;
    }

    private static List<List<Sales>> splitList(List<Sales> salesList,
            int parallelCount) {
        int splitedListCount = Double.valueOf(
                Math.ceil(salesList.size() / parallelCount)).intValue();
        List<List<Sales>> resultList = new ArrayList<List<Sales>>();
        for (int i = 0;; i++) {
            int startPoint = i * splitedListCount;
            int endPoint = startPoint + splitedListCount;
            if (endPoint < salesList.size()) {
                resultList.add(salesList.subList(startPoint, endPoint));
                continue;
            } else if (salesList.size() == endPoint) {
                resultList.add(salesList.subList(startPoint, endPoint));
                break;
            } else if (salesList.size() < endPoint) {
                endPoint = salesList.size();
                resultList.add(salesList.subList(startPoint, endPoint));
                break;
            }
        }
        return resultList;
    }

    // すべてのフューチャーリストが処理を終えているかどうかを判定する
    /*
    private static <T> boolean idDoneAllFutureList(
            List<Future<Map<Integer, Integer>>> futureList) {
        for (Future<Map<Integer, Integer>> future : futureList) {
            if (! future.isDone()) {
                return false;
            }
        }
        return true;
    }
    */
}