package com.jnshu.ssm.pojo;

/**
 * author : baiyunzhong
 * created time : 2019/7/25
 */
public class Page {
    //当前页，是第几页
    private Integer currentPage;
    //记录总数
    private Integer totalCount;
    //开始行数 sql 分页查询第一个数字(开始行数-1)
    private Integer start;
    //每页显示几行
    private Integer count;
    //总页数
    private Integer pageCount;


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
