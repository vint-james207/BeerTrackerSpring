package com.theironyard.services;

import com.sun.tools.javac.util.List;
import com.theironyard.entities.Beer;
import com.theironyard.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by zach on 11/10/15.
 */
public interface BeerRepository extends CrudRepository<Beer, Integer> {
    List<Beer> findByType(String type);
    List<Beer> findByTypeAndCalories(String type, Integer calories);
    List<Beer> findByTypeAndCaloriesIsLessThanEqual(String type, Integer calories);

    Beer findFirstByType(String type);
    int countByType(String type);
    List<Beer> findByTypeOrderByNameAsc(String type);

    @Query("SELECT b FROM Beer b WHERE LOWER(name) LIKE '%' || LOWER(?) || '%'")
    List<Beer> searchByName(String name);
}
