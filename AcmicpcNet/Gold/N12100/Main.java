package AcmicpcNet.Gold.N12100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;

    private static int answer = 0;

    public static void merge(List<Integer> queue) {
        if (queue.size() >= 2) {
            for (int k = 1; k < queue.size(); k++) {
                int now = queue.get(k);
                int prev = queue.get(k-1);
                if (now == prev) {
                    queue.set(k-1, 2 * prev);
                    queue.set(k, 0);
                }
            }
        }
    }

    public static void permutate(int[][] prev, int depth) {
        int N = prev.length;

        if (depth >= 5) {
            return ;
        }

        for (int d = 0; d < 4; d++) {
            int[][] board = clone(prev);

            // 방향에 따른 블록 이동
            if (d == RIGHT) {
                for (int i = 0; i < N; i++) {
                    List<Integer> queue = new ArrayList<>();
                    for (int j = N - 1; j >= 0; j--) {
                        if (board[i][j] > 0) {
                            queue.add(board[i][j]);
                            board[i][j] = 0;
                        }
                    }
                    if (queue.isEmpty()) continue;
                    merge(queue);
                    int j = N - 1;
                    for (int block : queue) {
                        if (block > 0) {
                            board[i][j] = block;
                            j -= 1;
                        }
                    }
                }
            } else if (d == DOWN) {
                for (int j = 0; j < N; j++) {
                    List<Integer> queue = new ArrayList<>();
                    for (int i = N - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            queue.add(board[i][j]);
                            board[i][j] = 0;
                        }
                    }
                    if (queue.isEmpty()) continue;
                    merge(queue);
                    int i = N - 1;
                    for (int block : queue) {
                        if (block > 0) {
                            board[i][j] = block;
                            i -= 1;
                        }
                    }
                }
            } else if (d == LEFT) {
                for (int i = 0; i < N; i++) {
                    List<Integer> queue = new ArrayList<>();
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] > 0) {
                            queue.add(board[i][j]);
                            board[i][j] = 0;
                        }
                    }
                    if (queue.isEmpty()) continue;
                    merge(queue);
                    int j = 0;
                    for (int block : queue) {
                        if (block > 0) {
                            board[i][j] = block;
                            j += 1;
                        }
                    }
                }
            } else if (d == UP) {
                for (int j = 0; j < N; j++) {
                    List<Integer> queue = new ArrayList<>();
                    for (int i = 0; i < N; i++) {
                        if (board[i][j] > 0) {
                            queue.add(board[i][j]);
                            board[i][j] = 0;
                        }
                    }
                    if (queue.isEmpty()) continue;
                    merge(queue);
                    int i = 0;
                    for (int block : queue) {
                        if (block > 0) {
                            board[i][j] = block;
                            i += 1;
                        }
                    }
                }
            }
            
            // 최대 블록 값 탐색
            for (int i = 0; i < N; i++) {
                int maxBlock = Arrays.stream(board[i])
                    .max()
                    .orElse(0);
                answer = Math.max(answer, maxBlock);
            }

            permutate(board, depth + 1);
        }
    }

    public static int[][] clone(int[][] array) {
        int N = array.length;
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = array[i][j];
            }
        }
        return res;
    }

    public static void logs(int[][] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                0,
                board[i],
                0,
                N
            );
        }

        permutate(clone(board), 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
