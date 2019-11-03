package com.learn.javabasic.core;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class OptionalTest {
    @Test
    public void test001() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        girl = null;
        optionalGirl = Optional.of(girl); //java.lang.NullPointerException
    }

    @Test
    public void test002() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        //girl = null;
        optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        Girl girl1 = optionalGirl.orElse(new Girl("hhhhh"));
        System.out.println(girl1);

    }

    private String getGirlName1(Boy boy) {
        return boy.getGirl().getName();
    }

    private String getGirlName2(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    private String getGirlName3(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("ddddddddddd")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("shabi"));
        return girl1.getName();
    }

    @Test
    public void test003() {
        System.out.println(getGirlName3(null));
        System.out.println(getGirlName3(new Boy(null)));
        System.out.println(getGirlName3(new Boy(new Girl("ni hao"))));
    }

    @Test
    public void test004() {
        /*
        相除是下取整的关系
        * */
        System.out.println((1 + 2) / 2);

        int x = 0;

        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (mid * mid * 1L <= x) l = mid;
            else r = mid - 1;
        }
        //return r;
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        for (long s = 1; s <= x; s++) {
            if (s * s > x) return (int) s - 1;
        }
        return -1;
    }

}


class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    markByBFS(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void markByBFS(char[][] grid, int x, int y) {
        int[] diX = {0, 0, 1, -1};
        int[] diY = {1, -1, 0, 0};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y] = '0';

        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(coor.x + diX[i], coor.y + diY[i]);
                if (!inBound(adj, grid)) continue;
                if (grid[adj.x][adj.y] == '1') {
                    grid[adj.x][adj.y] = '0';
                    queue.offer(adj);
                }
            }
        }
    }

    private boolean inBound(Coordinate coor, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }
}


class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
