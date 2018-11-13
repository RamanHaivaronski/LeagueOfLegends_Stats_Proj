package lol.rest.demo.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionModel {
    private Map<String, BasicChampModel> data;
    private String type;
    private String version;

    public ChampionModel(){

    }

    public Map<String, BasicChampModel> getData() {
        return data;
    }

    public void setData(Map<String, BasicChampModel> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
