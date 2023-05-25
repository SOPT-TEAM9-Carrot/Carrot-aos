package com.sopt.carrot.presentation.home

import androidx.lifecycle.ViewModel

class TodayPopularityJobViewModel : ViewModel() {
    val mockTodayPopularityJobLists = listOf(
        TodayPopularityJob(
            id = 0,
            ranking = "1위",
            title = "단기임대 청소",
            detail = "이문동",
            interest = "20",
            check = "1090",
            salary = "10만원"
        ),
        TodayPopularityJob(
            id = 1,
            ranking = "2위",
            title = "음식점 오전 청소 알바구합니다",
            detail = "강남역\t\t논현역",
            interest = "10",
            check = "900",
            salary = "250만원"
        ),
        TodayPopularityJob(
            id = 2,
            ranking = "3위",
            title = "주방알바",
            detail = "종로",
            interest = "8",
            check = "800",
            salary = "10,000원"
        ),
        TodayPopularityJob(
            id = 3,
            ranking = "4위",
            title = "매장관리 및 판매직원",
            detail = "공릉동",
            interest = "5",
            check = "675",
            salary = "2만원"
        ),
        TodayPopularityJob(
            id = 4,
            ranking = "5위",
            title = "야간포장직원 모집",
            detail = "건대입구",
            interest = "4",
            check = "200",
            salary = "30,000원"
        )
    )
}