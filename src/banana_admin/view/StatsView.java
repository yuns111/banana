package banana_admin.view;

import java.util.ArrayList;

import banana_admin.domain.Stats;

public class StatsView {

	public StatsView() {

	}

	public void statsAnalysisView(ArrayList<Stats> daySumPrice, ArrayList<Stats> genderPattern, int totalSumPrice){

		System.out.println("\n[통계 내용]");
		System.out.println("1. 일별 매출액");
		System.out.println("일별\t\t매출액");

		for(int i = 0; i < daySumPrice.size(); i++) {
			
			System.out.print(daySumPrice.get(i).getDay()+"\t");
			System.out.println(daySumPrice.get(i).getDaySumPrice());
			
		}
		
		System.out.println("총 매출액 : " + totalSumPrice);
		System.out.println("\n2. 성별 음악 패턴 ");
		System.out.println("성별\t순위\t음악패턴");

		for(int i = 0; i < genderPattern.size(); i++) {
			
			System.out.print(genderPattern.get(i).getGender()+"\t");
			System.out.print(genderPattern.get(i).getRank()+"\t");
			System.out.println(genderPattern.get(i).getEmotionName());
			
		}

	}

}