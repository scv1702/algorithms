package Algospot.Tree.Fortress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Circle {
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r){
            this.x = x; this.y = y; this.r = r;
        }

        private double distance(Circle circle) {
            return Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
        }

        public boolean contains(Circle circle) {
            return this.r > circle.r && distance(circle) < this.r;
        }
    }

    static class Wall {
        Circle circle;
        List<Wall> insides = new ArrayList<>();

        public Wall(Circle circle) {
            this.circle = circle;
        }

        public boolean contains(Wall wall) {
            // 성벽들이 서로 겹치거나 닿지 않는다는 가정 하에 참
            return circle.contains(wall.circle);
        }
    }

    static class Castle {
        Wall[] walls;
        Wall outside;
        int maxJump;

        public Castle(Wall[] walls) {
            this.walls = walls;
            this.outside = construct(walls);
        }

        public boolean isChild(Wall parent, Wall child) {
            if (parent == child || !parent.contains(child)) {
                return false;
            }
            for (Wall wall : walls) {
                if (wall != parent && wall != child &&
                    parent.contains(wall) && wall.contains(child)
                ) {
                    return false;
                }
            }
            return true;
        }

        private Wall constructHelper(Wall outside) {
            for (Wall wall : walls) {
                if (isChild(outside, wall)) {
                    outside.insides.add(constructHelper(wall));
                }
            }
            return outside;
        }

        private Wall construct(Wall[] walls) {
            Wall outside = walls[0];
            constructHelper(outside);
            return outside;
        }

        private int jumpHelper(Wall root) {
            if (root.insides.isEmpty()) {
                return 0;
            }
            List<Integer> heights = root.insides.stream()
                .map(wall -> jumpHelper(wall) + 1)
                .sorted()
                .collect(Collectors.toList());
            int C = heights.size();
            if (C == 1) {
                maxJump = Math.max(maxJump, heights.get(0));
                return heights.get(0);
            }
            maxJump = Math.max(maxJump, heights.get(C - 1) + heights.get(C - 2));
            return heights.get(C - 1);
        }

        public int jump() {
            jumpHelper(outside);
            return maxJump;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            int N = Integer.parseInt(br.readLine()); // 성벽의 수
            Wall[] walls = new Wall[N];
            for (int j = 0; j < N; j++) {
                String[] wall = br.readLine().split(" ");
                int x = Integer.parseInt(wall[0]);
                int y = Integer.parseInt(wall[1]);
                int r = Integer.parseInt(wall[2]);
                Circle circle = new Circle(x, y, r);
                walls[j] = new Wall(circle);
            }
            Castle castle = new Castle(walls);
            System.out.println(castle.jump());
        }
    }
}
