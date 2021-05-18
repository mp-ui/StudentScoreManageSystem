/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 21:59
 */

package com.prince.dao;

import com.prince.entity.Score;

import java.util.List;

public interface ScoreDao {

    List<Score> selectAll();

    List<Score> selectAllBySNo(String sNo);

}
