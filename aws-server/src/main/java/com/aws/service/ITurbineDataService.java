package com.aws.service;

import com.aws.vo.*;

public interface ITurbineDataService {

    /**
     * 根据风机id查询变桨系统最新一条数据
     * @param windTurbineId 风机id
     * @return 变桨系统最新一条数据
     */
    DataBianjiangxitongVO queryNewestBianjiangxitongByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询主轴最新一条数据
     * @param windTurbineId 风机id
     * @return 主轴最新一条数据
     */
    DataZhuzhouVO queryNewestZhuzhouByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询转子最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 主轴最新一条数据
     */
    DataZhuanziVO queryNewestZhuanziByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询油冷最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 油冷装置最新一条数据
     */
    DataYoulengzhuangzhiVO queryNewestYoulengzhuangzhiByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询偏航点击最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 偏航电机最新一条数据
     */
    DataPianhangdianjiVO queryNewestPianhangdianjiByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询控制柜最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 控制柜最新一条数据
     */
    DataKongzhiguiVO queryNewestKongzhiguiByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询风冷装置最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 风冷装置最新一条数据
     */
    DataFenglengzhuangzhiVO queryNewestFenglengzhuangzhiByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询发电机最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 发电机最新一条数据
     */
    DataFadianjiVO queryNewestFadianjiByTurbineId(String windTurbineId);

    /**
     * 根据风机id查询齿轮箱最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 齿轮箱最新一条数据
     */
    DataChilunxiangVO queryNewestChilunxiangByTurbineId(String windTurbineId);
}