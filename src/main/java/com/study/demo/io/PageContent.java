package com.study.demo.io;

import java.io.Serializable;
import java.util.List;

public class PageContent implements Serializable
{
    private int pageNum;
    private int pageSize;
    private int rows;
    
    private int pageCount;
    
    private List<?> pageContent;

    /**
     * @return the pageNum
     */
    public int getPageNum()
    {
        return pageNum;
    }

    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize()
    {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    /**
     * @return the rows
     */
    public int getRows()
    {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows)
    {
        this.rows = rows;
    }

    /**
     * @return the pageCount
     */
    public int getPageCount()
    {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }

    /**
     * @return the pageContent
     */
    public List<?> getPageContent()
    {
        return pageContent;
    }

    /**
     * @param pageContent the pageContent to set
     */
    public void setPageContent(List<?> pageContent)
    {
        this.pageContent = pageContent;
    }
    
}
