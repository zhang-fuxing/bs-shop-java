package com.z.common.util;

/**
 * @author zfx
 * @date 2022-04-19 14:59
 */
public class IPages {
    private Integer currentPage;
    private Integer pageIndex;
    private Integer pageSize;
    private Integer cid;
    private Integer did;

    public IPages() {
    }

    public IPages(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageIndex = (currentPage-1)*pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "IPages{" +
                "currentPage=" + currentPage +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", cid=" + cid +
                ", did=" + did +
                '}';
    }
}
