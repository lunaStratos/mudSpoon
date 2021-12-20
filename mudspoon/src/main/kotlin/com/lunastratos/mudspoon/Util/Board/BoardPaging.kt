package com.lunastratos.mudspoon.Util

/**
 * 게시판 페이징
 * @version     1.0
 * @author      LunaStratos
 * */

class BoardPaging {
    // 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
    var nowPage = 0
    var startPage = 0
    var endPage = 0
    var total = 0
    var cntPerPage = 0
    var lastPage = 0
    var start = 0
    var end = 0
    private var cntPage = 10

    constructor(total: Int, nowPage: Int, cntPerPage: Int) {
        this.nowPage = nowPage
        this.cntPerPage = cntPerPage
        this.total = total
        calcLastPage(total, cntPerPage)
        calcStartEndPage(nowPage, cntPage)
        calcStartEnd(nowPage, cntPerPage)
    }

    // 제일 마지막 페이지 계산
    fun calcLastPage(total: Int, cntPerPage: Int) {
        lastPage = Math.ceil(total.toDouble() / cntPerPage.toDouble()).toInt()
    }

    // 시작, 끝 페이지 계산
    fun calcStartEndPage(nowPage: Int, cntPage: Int) {
        endPage = Math.ceil(nowPage.toDouble() / cntPage.toDouble()).toInt() * cntPage
        if (lastPage < endPage) {
            endPage = lastPage
        }
        startPage = endPage - cntPage + 1
        if (startPage < 1) {
            startPage = 1
        }
    }

    // DB 쿼리에서 사용할 start, end값 계산
    fun calcStartEnd(nowPage: Int, cntPerPage: Int) {
        end = nowPage * cntPerPage -1
        start = end - cntPerPage + 1
    }

    fun setCntPage(): Int {
        return cntPage
    }

    fun getCntPage(cntPage: Int) {
        this.cntPage = cntPage
    }

    override fun toString(): String {
        return ("PagingVO [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
                + ", cntPerPage=" + cntPerPage + ", lastPage=" + lastPage + ", start=" + start + ", end=" + end
                + ", cntPage=" + cntPage + "]")
    }
}
