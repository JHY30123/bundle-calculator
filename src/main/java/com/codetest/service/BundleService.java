package com.codetest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BundleService {
  /**
   * Calculate the fewest number of bundles to make up the given number, return empty list if no
   * combinations suitable
   *
   * @param bundleSizeList Size list of
   * @param amount The target value
   * @return bundle number list
   */
  public List<Integer> generateSelection(List<Integer> bundleSizeList, int amount) {
    Map<Integer, Result> memo = new HashMap<>();
    Result result = solve(bundleSizeList, amount, memo);
    return result.isValid() ? result.breakdown() : Collections.emptyList();
  }

  /**
   * Dynamic programming to find the fewest number of bundles to make up the given number,
   * memoized per call via {@code memo} so no state is shared across invocations/threads.
   *
   * @param bundleSizeList Size list of
   * @param target The target value
   * @param memo Per-call memoization cache
   * @return The best {@link Result} (fewest bundles + the selection) for this target
   */
  private Result solve(List<Integer> bundleSizeList, int target, Map<Integer, Result> memo) {
    if (target == 0) return new Result(0, Collections.nCopies(bundleSizeList.size(), 0));
    if (target < 0) return Result.NONE;
    Result cached = memo.get(target);
    if (cached != null) return cached;

    Result result =
        IntStream.range(0, bundleSizeList.size())
            .mapToObj(i -> extend(solve(bundleSizeList, target - bundleSizeList.get(i), memo), i))
            .filter(Result::isValid)
            .min(Comparator.comparingInt(Result::count))
            .orElse(Result.NONE);
    memo.put(target, result);
    return result;
  }

  /** Returns a new {@link Result} with the count at {@code index} incremented by one. */
  private Result extend(Result sub, int index) {
    if (!sub.isValid()) return Result.NONE;
    List<Integer> nextBreakdown = new ArrayList<>(sub.breakdown());
    nextBreakdown.set(index, nextBreakdown.get(index) + 1);
    return new Result(sub.count() + 1, nextBreakdown);
  }

  private record Result(int count, List<Integer> breakdown) {
    static final Result NONE = new Result(Integer.MAX_VALUE, null);

    boolean isValid() {
      return count != Integer.MAX_VALUE;
    }
  }
}
