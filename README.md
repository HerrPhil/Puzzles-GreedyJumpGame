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
We start at position 0.

We can jump 2 positions; the value is 2.

We are at position 2.

We can jump 1 position; the value is 1.

We are at position 3.

We can jump 1 position; the value is 1.

We are at position 4.

We reached our goal.

Therefore, we return true.

Intuition, from past experience, suggests to do back-tracking.
However, that is very slow.

The optimal is to be greedy.

This means the solution asserts we do reach the goal.

Given that n = the number of values,
then the goal is n - 1, the final index in the list.

We can work backwards through the array.

At every position, the `ith` value is the maximum position we can jump.

So if we examine `i + max_jump` and discover that it is greater than the `goal`,
then we can reset the `goal` to be that of position 'i'.

The acceptance criteria is a `goal` equal to `0` returns `true`.

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
