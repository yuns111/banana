package banana_admin.controller;

import java.util.ArrayList;

import banana_admin.dao.StatsDao;
import banana_admin.domain.Stats;
import banana_admin.view.StatsView;

public class StatsController {

	private StatsDao statsDao;

	public StatsController() {

		statsDao = new StatsDao();
	}

	public void requestStatsAnalysis(){

		//일별 매출액
		ArrayList<Stats> daySumPrice = statsDao.statsDaySalesMoney();
		
		//총 매출액
		int totalSumPrice = statsDao.totalSumPrice();
		
		//성별 음악 패턴
		ArrayList<Stats> genderPattern = statsDao.statsGenderMusicPattern();

		//view
		StatsView statsView = new StatsView();
		statsView.statsAnalysisView(daySumPrice, genderPattern,totalSumPrice);

	}

}
