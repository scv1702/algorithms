import java.util.*;

class Solution {

    // 1. 모든 판매원은 칫솔의 판매에 의하여 발생하는 이익에서 10% 를 계산하여 자신을 조직에 참여시킨 추천인에게 배분하고 나머지는 자신이 가집니다.
    // 2. 모든 판매원은 자신이 칫솔 판매에서 발생한 이익 뿐만 아니라, 자신이 조직에 추천하여 가입시킨 판매원에게서 발생하는 이익의 10% 까지 자신에 이익이 됩니다.
    // 3. 자신에게 발생하는 이익 또한 마찬가지의 규칙으로 자신의 추천인에게 분배됩니다.
    // 4. 단, 10% 를 계산할 때에는 원 단위에서 절사하며, 10%를 계산한 금액이 1 원 미만인 경우에는 이득을 분배하지 않고 자신이 모두 가집니다.

    private static final int BRUSH_PRICE = 100;

    public int getTax(int money) {
        return (int) (money * 0.1F);
    }

    public int[] solution(String[] enroll, String[] referrals, String[] sellers, int[] amounts) {
        Map<String, String> referralMap = new HashMap<>();
        Map<String, Integer> profits = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            String seller = enroll[i];
            String referral = referrals[i];
            profits.put(seller, 0);
            referralMap.put(seller, referral);
        }

        for (int i = 0; i < sellers.length; i++) {
            String seller = sellers[i];
            int amount = amounts[i] * BRUSH_PRICE;
            String referral = referralMap.get(seller);
            while (!seller.equals("-") && amount > 0) {
                int tax = getTax(amount);
                int profit = amount - tax;
                profits.put(seller, profits.get(seller) + profit);
                seller = referral;
                referral = referralMap.getOrDefault(seller, "-");
                amount = tax;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profits.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}