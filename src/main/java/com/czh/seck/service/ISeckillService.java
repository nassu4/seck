package com.czh.seck.service;

import com.czh.seck.dto.ExecutionResult;
import com.czh.seck.dto.Exposer;
import com.czh.seck.entity.Stock;
import com.czh.seck.exception.ExecutionException;
import com.czh.seck.exception.RepeatedKillException;
import com.czh.seck.exception.SeckillClosedException;

import java.util.List;

public interface ISeckillService {

    Stock queryStockById(long itemId);

    List<Stock> queryAllStockById();

    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     * @param itemId
     */
    Exposer exportSeckillUrl(long itemId);

    /**
     * 执行秒杀操作
     * @param itemId
     * @param userPhone
     * @param md5
     * @return
     * @throws RepeatedKillException
     * @throws SeckillClosedException
     * @throws ExecutionException
     */
    ExecutionResult executeSeckill(long itemId, long userPhone, String md5) throws
            RepeatedKillException, SeckillClosedException, ExecutionException;

}
