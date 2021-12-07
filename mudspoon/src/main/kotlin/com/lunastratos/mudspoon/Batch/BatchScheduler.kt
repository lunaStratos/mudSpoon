package com.lunastratos.mudspoon.Batch

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled

/**
 * Batch 스케쥴러
 * 일정시간 되면 작동하는 배치 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
class BatchScheduler {

    //로그찍기
    val logger = LoggerFactory.getLogger(BatchScheduler::class.java)

    //초 분 시 일 월 요일
    // 05시에 실행되는 배치
    @Scheduled(cron="0 0 05 * * *")
    fun TestScheduler(){
        val msg = "5시 실행 배치입니다."
        logger.debug(msg)
    }

    /**
     * 순위배치
     * 조회수 기준
     * 1시간 마다 실행
     * */
    @Scheduled(fixedDelay = 60000*60)
    fun testTime(){

    }
}