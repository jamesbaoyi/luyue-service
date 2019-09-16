package cn.baoyi.luyue.service.domain.web;

import com.google.common.base.Stopwatch;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static java.lang.System.out;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/12 10:08
 * @Description:
 */

public class ForkJoinPoolController extends RecursiveTask<Integer> {

    private static final Integer THRESHOLD = 2;

    private Integer start;

    private Integer end;

    public ForkJoinPoolController(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        Integer sum = 0;
        Boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            Integer mid = (start + end) / 2;
            ForkJoinPoolController left = new ForkJoinPoolController(start, mid);
            ForkJoinPoolController right = new ForkJoinPoolController(mid + 1, end);
            left.fork();
            right.fork();
            Integer leftResult = left.join();
            Integer rightResult = right.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinPoolController task = new ForkJoinPoolController(1, 4);
        Integer result = forkJoinPool.invoke(task);

        out.println(result);

        List<Integer> responses = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            responses.add(i);
        }



    }
}
