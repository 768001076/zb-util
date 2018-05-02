package entity;

import java.sql.Timestamp;

public class TestInfo {

    private Integer id;

    private String name;

    private Integer type;

    private Timestamp updateTime;

    public TestInfo(Integer id, String name, Integer type, Timestamp updateTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp String) {
        this.updateTime = updateTime;
    }
}
