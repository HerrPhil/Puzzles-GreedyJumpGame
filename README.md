# Puzzles-GreedyJumpGame

Discover whether jump values in an array will allow the user to move to the end of the array.

## Description of Leetcode Lesson Task

The raw problem description is as follows.

You are given an integer array `nums`.

You are initially positioned at the array's first index,
and each element in the array represents your maximum
jump length at that posiiton.

Here is the goal of the game.

Return `true` if you can reach the last index,
or `false` otherwise.

Here is example 1.

The input is:

```
nums =     [2, 3, 1, 1, 4]
positions > 0  1  2  3  4
```
We start at position `0`.

We can jump `2` positions; the value of position `0` is `2`.

We are at position `2`.

We can jump `1` position; the value of position `2` is `1`.

We are at position `3`.

We can jump `1` position; the value of position `3` is `1`.

We are at position `4`.

We reached our goal.

Therefore, we return `true`.

Intuition, from past experience, suggests to do back-tracking.

However, that is very slow.

The optimal is to be greedy.

This means the solution asserts we do reach the goal.

Given that `n` = the number of values in `nums`,
then the `goal` is `n - 1`, the final index in the array.

We can work backwards through the array.

At every position, the `ith` value is the maximum number of positions we can jump.

So if we examine `i + max_jump` and discover that it is greater than or equal to the `goal`,
then we can reset the `goal` to be that of position `i`.

The acceptance criteria is a `goal` that is equal to `0` returns `true`.

Otherwise the solution returns `false`.

So, let's walk through this greedy algorithm.

Again, 

```
nums =     [2, 3, 1, 1, 4]
positions > 0  1  2  3  4
```

We note that the length of `nums` is `5`. Therefore the `goal` is `4`.

We are at `ith` position `4`.

Current `max_jump` is `4`.

When `i + max_jump` is 8 and is greater than or equal to the `goal` that is `4`,
then the `goal` is reset to the `ith` position of `4`. Oddly, no change, but that's ok.

We are at `ith` position `3`.

Current `max_jump` is `1`.

When `i + max_jump` is 4 and is greater than or equal to the `goal` that is `4`,
then the `goal` is reset to the `ith` position of `3`.

We are at `ith` position `2`.

Current `max_jump` is `1`.

When `i + max_jump` is 3 and is greater than or equal to the `goal` that is `3`,
then the `goal` is reset to the `ith` position of `2`.

We are at `ith` position `1`.

Current `max_jump` is `3`.

When `i + max_jump` is 4 and is greater than or equal to the `goal` thst is `2`,
then the `goal` is reset to the `ith` position of `1`.

We are at `ith` position `0`.

Current `max_jump` is `2`.

When `i + max_jump` is `2` and is greater than or equal to the `goal` that is `1`,
then the `goal` is reset to the `ith` position of `0`.

We are out of positions.

When the `goal` is `0`, then we return `true`.
The `goal` is `0`, so the solution does return `true`.

### Observation of leetcode solution suggestion

It is a lenient solution.

When the lesson task says the goal is to reach the last index,
then the solution allows for the last index to be reached or surpassed.

When I stress-test the solution with inputs like:
```
[3, 3, 3, 3, 0]
or
[4, 4, 4, 4, 0]
or
[5, 5, 5, 5, 0]
```
then the solution returns a true result.

It is not assuming that the solution must exactly reach the last index.

I mean, we could write that solution, too.

However, the lenient solution is allowed.

## Alternate solution

After pouring over the suggested, example solution,
I noted that jump values of zero (0) are important.

A few observations:

1. the solution does not care if the jump value of the last index is zero (0).
2. the solution will reach or surpass the goal of the last index
   when all jump values before the last index are one (1) or more.
3. the presence of a zero before the last index does not guarantee that the goal is not reached.
4. when a jump lands on an index with a zero (0) jump value, then the solution is stuck.
   Current position + zero is always current position.

