import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reportCount = new HashMap<>(); // <유저 ID, 신고 당한 횟수>
        HashMap<String, Set<String>> reportHistory = new HashMap<>(); // <유저 ID, <신고한 회원 집합>>
        
        // 유저가 신고 당한 횟수 초기화
        for (String userId: id_list) {
            reportCount.put(userId, 0);    
        }        
        
        for (int i = 0; i < report.length; i++) {
            String[] reportDetail = report[i].split(" ");
            String userId = reportDetail[0];
            String reportedId = reportDetail[1];
            
            Set<String> reportHistoryDetail = reportHistory.get(userId);
            if (reportHistoryDetail == null)
                reportHistoryDetail = new HashSet<String>();
            
            if (!reportHistoryDetail.contains(reportedId)) {
                reportHistoryDetail.add(reportedId);
                reportHistory.put(userId, reportHistoryDetail);
                reportCount.put(reportedId, reportCount.get(reportedId) + 1);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            Set<String> reportHistoryDetail = reportHistory.get(userId);
            if (reportHistoryDetail != null) {
                for (String reportedId: reportHistoryDetail) { 
                    if (reportCount.get(reportedId) >= k) {
                        answer[i]++;
                    }
                }
            }
        }  
    
        return answer;
    }
}
