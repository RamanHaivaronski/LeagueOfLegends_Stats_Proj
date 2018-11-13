package lol.rest.demo;

import lol.rest.demo.models.*;
import lol.rest.demo.services.ChampionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class SummonerController {

    @Autowired
    ChampionsServiceImpl service;

    // 1 free week champs
    @GetMapping("/freeChampions")
    public List<String> showFreeChampions() {
        return service.getChampionsName();
    }

    // 2 returns your total mastery level
    @GetMapping("/summonerMastery/{summonerName}")
    public int getSummonerMastery(@PathVariable("summonerName") String summonerName) {
        return service.getSummonerMastery(summonerName);
    }

    // 3 returns champions info
    @GetMapping("/championMastery/{summonerName}/{championName}")
    @ResponseBody
    public ChampionMastery getChampionMastery(@PathVariable("summonerName") String summonerName, @PathVariable("championName") String championName, ChampionMastery cm){
        return service.getChampionMastery(summonerName, championName, cm);
    }

    // 4 list all champions list the summoner have played
    @GetMapping("/championMastery/{summonerName}")
    @ResponseBody
    public  List<ChampionMastery> getChampionsList(@PathVariable("summonerName") String summonerName){
        return service.getChampionsList(summonerName);
    }

    // 5 shows the current league of the player
    @GetMapping("/summonerLeague/{summonerName}")
    @ResponseBody
    public Set<LeaguePositionDTO> getSummonerLeague(@PathVariable("summonerName") String summonerName){
        return service.getSummonerLeague(summonerName);
    }

    // 6 show the list of challenger players RANKED_SOLO_5x5 RANKED_FLEX_SR RANKED_FLEX_TT
    @GetMapping("/challengerList/{queueName}")
    @ResponseBody
    public LeagueListDTO getChallengerList(@PathVariable("queueName") String queueName, LeagueListDTO cm){
        return service.getChallengerList(queueName, cm);
    }

    // 7 checks if the server is online
    @GetMapping("/onlineCheck")
    public ShardStatus getOnlineCheck(){
        return service.getOnlineCheck();
    }

    // 8 get the summoner info
    @GetMapping("/summoner/{summonerName}")
    public SummonerDTO getChallengerList(@PathVariable("summonerName") String summonerName){
        return service.getSummonerInfo(summonerName);
    }

}
