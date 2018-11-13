package lol.rest.demo.models;

import java.util.List;

public class FreeChampions {
    private List freeChampionIdsForNewPlayers;
    private List freeChampionIds;
    private int maxNewPlayerLevel;

    public List getFreeChampionIdsForNewPlayers() {
        return freeChampionIdsForNewPlayers;
    }

    public void setFreeChampionIdsForNewPlayers(List freeChampionIdsForNewPlayers) {
        this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
    }

    public List getFreeChampionIds() {
        return freeChampionIds;
    }

    public void setFreeChampionsId(List freeChampionIds) {
        this.freeChampionIds = freeChampionIds;
    }

    public int getMaxNewPlayerLevel() {
        return maxNewPlayerLevel;
    }

    public void setMaxNewPlayerLevel(int maxNewPlayerLevel) {
        this.maxNewPlayerLevel = maxNewPlayerLevel;
    }
}
