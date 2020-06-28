package com.czh.seck.mapper;

import com.czh.seck.entity.SuccessKilledOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface ISuccessKilledOrderMapper {
    @Update("INSERT IGNORE INTO success_killed_order(item_id, user_phone_number, state) VALUES(#{itemId}, #{userPhone}, 0)")
    int createOrder(@Param("itemId") long itemId, @Param("userPhone") long userPhone);
//    @Select("SELECT sko.item_id, sko.user_phone_number, sko.state, sko.creation_time, s.item_id, s.item_name, s.item.stock, s.start_time, s.end_time, s.creation_time FROM success_killed_order AS sko INNER JOIN stock AS s ON sko.item_id = s.item_id WHERE sko.item_id = #{iteImd} AND sko.user_phone_number = #{userPhone}")
    @Select("SELECT item_id, user_phone_number, state, creation_time FROM success_killed_order WHERE item_id = #{itemId} AND user_phone_number = #{userPhone}")
    @Results({
            @Result(id = true, column = "item_id", property = "itemId"),
            @Result(column = "user_phone_number", property = "userPhoneNumber"),
            @Result(column = "state", property = "state"),
            @Result(column = "creation_time", property = "creationTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "item_id", property = "stock", one = @One(select = "com.czh.seck.mapper.IStockMapper.queryById", fetchType = FetchType.EAGER))
    })
    SuccessKilledOrder queryByIdWithStock(@Param("itemId") long itemId, @Param("userPhone") long userPhone);
}
