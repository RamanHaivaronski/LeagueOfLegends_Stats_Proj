package lol.rest.demo.dao;

import lol.rest.demo.models.BasicChampModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChampionDAO {

//    @Select("SELECT * FROM champions.list")
//    List<BasicChampModel> getAllChampions();

//    @Select("SELECT name FROM champions.list")
//    List<String> getAllChampionsName();
//
//    @Select("SELECT id FROM champions.list")
//    List<Integer> getChampionsId();

    @Select("SELECT name FROM champions.list WHERE id=#{id}")
    List<String> getChampionsName(int id);

    @Select("SELECT id FROM champions.list WHERE name=#{name}")
    long getChampionId(String name);
}
