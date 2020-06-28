package com.czh.seck.mapper;

import com.czh.seck.entity.Stock;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

public interface IStockMapper {
    @Update("UPDATE stock SET item_stock = item_stock - 1 WHERE item_id = #{itemId} and start_time <= #{dateTime} and end_time >= #{dateTime} and item_stock > 0")
    int reduceStock(@Param("itemId") long itemId, @Param("dateTime") LocalDateTime dateTime);
    @Select("SELECT item_id, item_name, item_stock, start_time, end_time, creation_time FROM stock WHERE item_id = #{itemId}")
    @Results({
            @Result(id = true, column = "item_id", property = "itemId"),
            @Result(column = "item_name", property = "itemName"),
            @Result(column = "item_stock", property = "itemStock"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "creation_time", property = "creationTime")
    })
    Stock queryById(@Param("itemId") long itemId);
    @Select("SELECT item_id, item_name, item_stock, start_time, end_time, creation_time FROM stock ORDER BY creation_time LIMIT #{offset},#{limit}")
    @Results({
            @Result(id = true, column = "item_id", property = "itemId"),
            @Result(column = "item_name", property = "itemName"),
            @Result(column = "item_stock", property = "itemStock"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "creation_time", property = "creationTime")
    })
    List<Stock> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
