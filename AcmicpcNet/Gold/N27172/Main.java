package AcmicpcNet.Gold.N27172;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int MAX = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> cardToPlayer = new HashMap<>();
        Map<Integer, Integer> playerToPoint = new HashMap<>();

        for (int me = 0; me < N; me++) {
            cardToPlayer.put(cards[me], me);
            playerToPoint.put(cards[me], 0);
        }

        for (int me = 0; me < N; me++) {
            for (int enemy = 2 * cards[me]; enemy <= MAX; enemy += cards[me]) {
                if (cardToPlayer.containsKey(enemy)) {
                    playerToPoint.put(enemy, playerToPoint.get(enemy) - 1);
                    playerToPoint.put(cards[me], playerToPoint.get(cards[me]) + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int me = 0; me < N; me++) {
            sb.append(playerToPoint.get(cards[me])).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
