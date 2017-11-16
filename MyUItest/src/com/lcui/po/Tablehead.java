package com.lcui.po;

public class Tablehead {
    private Integer id;

    private String tablename;

    private String tablehead;

    
    @Override
	public String toString() {
		return "Tablehead [id=" + id + ", tablename=" + tablename
				+ ", tablehead=" + tablehead + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getTablehead() {
        return tablehead;
    }

    public void setTablehead(String tablehead) {
        this.tablehead = tablehead == null ? null : tablehead.trim();
    }
}