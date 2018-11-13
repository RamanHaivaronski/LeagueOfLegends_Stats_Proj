package lol.rest.demo.services;

import lol.rest.demo.dao.ChampionDAO;
import lol.rest.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ChampionsServiceImpl {

    @Autowired
    ChampionDAO championDAO;

    //@Autowired
    //SummonerController controller;

//    @Override
//    public List<BasicChampModel> getAllChampions() {
//        return championDAO.getAllChampions();
//    }

    public List<String> getChampionsName(){
        final String uri = "https://ru.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=RGAPI-f6cb90fb-e204-44e7-91a7-53b616e3c8fc";
        RestTemplate restTemplate = new RestTemplate();
        FreeChampions result = restTemplate.getForObject(uri, FreeChampions.class);

        List<Integer> values = result.getFreeChampionIds();
        List<String> names = new ArrayList<>();

        for(Integer id: values){
            for(String name: championDAO.getChampionsName(id))
            names.add(name);

        }

        return names;
    }

    public int getSummonerMastery(String summonerName){
        final String uri = "https://ru.api.riotgames.com/lol/champion-mastery/v3/scores/by-summoner/" + getSummonerInfo(summonerName).getId() + "?api_key=RGAPI-26b6cc6e-ad4c-456a-8eb6-0823d0d6b139";
        RestTemplate restTemplate = new RestTemplate();
        Integer result = Integer.valueOf(restTemplate.getForObject(uri, String.class));

        return result;
    }

    public ChampionMastery getChampionMastery(String summonerName, String championName, ChampionMastery cm){
        final String uri = "https://ru.api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/" + getSummonerInfo(summonerName).getId() + "/by-champion/" + championDAO.getChampionId(championName) +"?api_key=RGAPI-26b6cc6e-ad4c-456a-8eb6-0823d0d6b139";
        RestTemplate restTemplate = new RestTemplate();
        cm = restTemplate.getForObject(uri, ChampionMastery.class);

        return cm;
    }

    public List<ChampionMastery> getChampionsList(String summonerName){
        final String uri = "https://ru.api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/" + getSummonerInfo(summonerName).getId() + "?api_key=RGAPI-26b6cc6e-ad4c-456a-8eb6-0823d0d6b139";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ChampionMastery>> responseEntity
                = restTemplate.exchange(uri, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ChampionMastery>>(){});
        List<ChampionMastery> objects = responseEntity.getBody();

//       ResponseEntity<ChampionMastery[]> responseEntity = restTemplate.getForEntity(uri, ChampionMastery[].class);
//       ChampionMastery[] objects = responseEntity.getBody();
//       List<ChampionMastery> result =  Arrays.asList(objects);
        return objects;
    }

    public Set<LeaguePositionDTO> getSummonerLeague(String summonerName) {
        final String uri = "https://ru.api.riotgames.com/lol/league/v3/positions/by-summoner/" + getSummonerInfo(summonerName).getId() + "?api_key=RGAPI-26b6cc6e-ad4c-456a-8eb6-0823d0d6b139";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Set<LeaguePositionDTO>> responseEntity
                = restTemplate.exchange(uri, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<LeaguePositionDTO>>(){});
        Set<LeaguePositionDTO> league = responseEntity.getBody();

        return league;
    }

    public LeagueListDTO getChallengerList(String queueName, LeagueListDTO cm){
        final String uri = "https://ru.api.riotgames.com/lol/league/v3/challengerleagues/by-queue/" + queueName + "?api_key=RGAPI-26b6cc6e-ad4c-456a-8eb6-0823d0d6b139";
        RestTemplate restTemplate = new RestTemplate();
        cm = restTemplate.getForObject(uri, LeagueListDTO.class);

        return cm;
    }

    public ShardStatus getOnlineCheck() {
        final String uri = "https://ru.api.riotgames.com/lol/status/v3/shard-data?api_key=RGAPI-26b6cc6e-ad4c-456a-8eb6-0823d0d6b139";
        RestTemplate restTemplate = new RestTemplate();
        ShardStatus cm = restTemplate.getForObject(uri, ShardStatus.class);

        return cm;
    }

    public SummonerDTO getSummonerInfo(String name){
        final String uri = "https://ru.api.riotgames.com/lol/summoner/v3/summoners/by-name/" + name + "?api_key=RGAPI-26b6cc6e-ad4c-456a-8eb6-0823d0d6b139";
        RestTemplate restTemplate = new RestTemplate();
        SummonerDTO summonerInfo = restTemplate.getForObject(uri, SummonerDTO.class);

        return summonerInfo;
    }
}
