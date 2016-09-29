package banana_admin.controller;

import banana_admin.dao.StatsDao;
import banana_admin.view.StatsView;

public class StatsController {

	private StatsDao statsDao;

	public StatsController() {

		statsDao = new StatsDao();
	}

	public void requestStatsAnalysis(){

		//dao에서 조회: 일별 매출액
		String daySalesMoney = statsDao.statsDaySalesMoney();
		String sexMusicPattern = statsDao.statsSexMusicPattern();

		//view
		StatsView statsView = new StatsView();
		statsView.statsAnalysisView(daySalesMoney, sexMusicPattern);

	}

}
