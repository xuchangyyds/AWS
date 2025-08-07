package com.aws.service.impl;

import com.aws.mapper.data.*;
import com.aws.po.*;
import com.aws.service.ITurbineDataService;
import com.aws.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TurbineDataService implements ITurbineDataService {

    @Autowired
    private BianjiangxitongMapper bianjiangxitongMapper;
    @Autowired
    private ZhuzhouMapper zhuzhouMapper;
    @Autowired
    private ZhuanziMapper zhuanziMapper;
    @Autowired
    private YoulengzhuangzhiMapper youlengzhuangzhiMapper;
    @Autowired
    private PianhangdianjiMapper pianhangdianjiMapper;
    @Autowired
    private KongzhiguiMapper kongzhiguiMapper;
    @Autowired
    private FenglengzhuangzhiMapper fenglengzhuangzhiMapper;
    @Autowired
    private FadianjiMapper fadianjiMapper;
    @Autowired
    private ChilunxiangMapper chilunxiangMapper;

    /**
     * 根据风机id查询变桨系统最新一条数据
     * @param windTurbineId 风机id
     * @return 变桨系统最新一条数据
     */
    @Override
    public DataBianjiangxitongVO queryNewestBianjiangxitongByTurbineId(String windTurbineId) {
        DataBianjiangxitong dataBianjiangxitong = bianjiangxitongMapper.queryNewestBianjiangxitongByTurbineId(windTurbineId);
        DataBianjiangxitongVO dataBianjiangxitongVO = DataBianjiangxitongVO.builder()
                .turbineId(dataBianjiangxitong.getTurbineId())
                .pitchAngle(dataBianjiangxitong.getPitchAngle())
                .pitchSpeed(dataBianjiangxitong.getPitchSpeed())
                .systemTemperature(dataBianjiangxitong.getSystemTemperature())
                .motorLoad(dataBianjiangxitong.getMotorLoad())
                .positionFeedback(dataBianjiangxitong.getPositionFeedback())
                .faultStatus(dataBianjiangxitong.getFaultStatus())
                .powerVoltage(dataBianjiangxitong.getPowerVoltage())
                .bladePressure(dataBianjiangxitong.getBladePressure())
                .angleChange(dataBianjiangxitong.getAngleChange())
                .responseTime(dataBianjiangxitong.getResponseTime())
                .current(dataBianjiangxitong.getCurrent())
                .recordTime(dataBianjiangxitong.getRecordTime())
                .createTime(dataBianjiangxitong.getCreateTime())
                .updateTime(dataBianjiangxitong.getUpdateTime())
                .build();
        return dataBianjiangxitongVO;
    }

    /**
     * 根据风机id查询主轴最新一条数据
     * @param windTurbineId 风机id
     * @return 主轴最新一条数据
     */
    @Override
    public DataZhuzhouVO queryNewestZhuzhouByTurbineId(String windTurbineId) {
        DataZhuzhou dataZhuzhou = zhuzhouMapper.queryNewestZhuzhouByTurbineId(windTurbineId);
        DataZhuzhouVO dataZhuzhouVO = DataZhuzhouVO.builder()
                .turbineId(dataZhuzhou.getTurbineId())
                .shaftDiameter(dataZhuzhou.getShaftDiameter())
                .shaftLength(dataZhuzhou.getShaftLength())
                .shaftMaterial(dataZhuzhou.getShaftMaterial())
                .shaftWeight(dataZhuzhou.getShaftWeight())
                .rotationSpeed(dataZhuzhou.getRotationSpeed())
                .loadCapacity(dataZhuzhou.getLoadCapacity())
                .shaftTemperature(dataZhuzhou.getShaftTemperature())
                .bearingType(dataZhuzhou.getBearingType())
                .materialHardness(dataZhuzhou.getMaterialHardness())
                .operatingHours(dataZhuzhou.getOperatingHours())
                .wearLevel(dataZhuzhou.getWearLevel())
                .recordTime(dataZhuzhou.getRecordTime())
                .createTime(dataZhuzhou.getCreateTime())
                .updateTime(dataZhuzhou.getUpdateTime())
                .build();
        return dataZhuzhouVO;
    }

    /**
     * 根据风机id查询转子最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 主轴最新一条数据
     */
    @Override
    public DataZhuanziVO queryNewestZhuanziByTurbineId(String windTurbineId) {
        DataZhuanzi dataZhuzhou = zhuanziMapper.queryNewestZhuanziByTurbineId(windTurbineId);
        DataZhuanziVO dataZhuanziVO = DataZhuanziVO.builder()
                .turbineId(dataZhuzhou.getTurbineId())
                .rotorDiameter(dataZhuzhou.getRotorDiameter())
                .rotorWeight(dataZhuzhou.getRotorWeight())
                .rotorMaterial(dataZhuzhou.getRotorMaterial())
                .rotationSpeed(dataZhuzhou.getRotationSpeed())
                .maxLoad(dataZhuzhou.getMaxLoad())
                .tiltAngle(dataZhuzhou.getTiltAngle())
                .lifeSpan(dataZhuzhou.getLifeSpan())
                .aerodynamicEfficiency(dataZhuzhou.getAerodynamicEfficiency())
                .rotorSpeed(dataZhuzhou.getRotorSpeed())
                .materialStrength(dataZhuzhou.getMaterialStrength())
                .vibrationFrequency(dataZhuzhou.getVibrationFrequency())
                .recordTime(dataZhuzhou.getRecordTime())
                .createTime(dataZhuzhou.getCreateTime())
                .build();
        return dataZhuanziVO;
    }

    /**
     * 根据风机id查询油冷最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 油冷装置最新一条数据
     */
    @Override
    public DataYoulengzhuangzhiVO queryNewestYoulengzhuangzhiByTurbineId(String windTurbineId) {
        DataYoulengzhuangzhi dataYoulengzhuangzhi = youlengzhuangzhiMapper.queryNewestYoulengzhuangzhiByTurbineId(windTurbineId);
        DataYoulengzhuangzhiVO dataYoulengzhuangzhiVO = DataYoulengzhuangzhiVO.builder()
                .turbineId(dataYoulengzhuangzhi.getTurbineId())
                .coolerType(dataYoulengzhuangzhi.getCoolerType())
                .oilFlow(dataYoulengzhuangzhi.getOilFlow())
                .oilTemperature(dataYoulengzhuangzhi.getOilTemperature())
                .coolingEfficiency(dataYoulengzhuangzhi.getCoolingEfficiency())
                .deviceWeight(dataYoulengzhuangzhi.getDeviceWeight())
                .oilType(dataYoulengzhuangzhi.getOilType())
                .coolantTemperature(dataYoulengzhuangzhi.getCoolantTemperature())
                .maxPressure(dataYoulengzhuangzhi.getMaxPressure())
                .operatingHours(dataYoulengzhuangzhi.getOperatingHours())
                .faultCount(dataYoulengzhuangzhi.getFaultCount())
                .flowVariation(dataYoulengzhuangzhi.getFlowVariation())
                .recordTime(dataYoulengzhuangzhi.getRecordTime())
                .createTime(dataYoulengzhuangzhi.getCreateTime())
                .build();
        return dataYoulengzhuangzhiVO;
    }

    /**
     * 根据风机id查询偏航电机最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 偏航电机最新一条数据
     */
    @Override
    public DataPianhangdianjiVO queryNewestPianhangdianjiByTurbineId(String windTurbineId) {
        DataPianhangdianji dataPianhangdianji = pianhangdianjiMapper.queryNewestPianhangdianjiByTurbineId(windTurbineId);
        DataPianhangdianjiVO dataPianhangdianjiVO = DataPianhangdianjiVO.builder()
                .turbineId(dataPianhangdianji.getTurbineId())
                .motorType(dataPianhangdianji.getMotorType())
                .ratedPower(dataPianhangdianji.getRatedPower())
                .ratedVoltage(dataPianhangdianji.getRatedVoltage())
                .ratedSpeed(dataPianhangdianji.getRatedSpeed())
                .maxTorque(dataPianhangdianji.getMaxTorque())
                .motorWeight(dataPianhangdianji.getMotorWeight())
                .controlType(dataPianhangdianji.getControlType())
                .workingTemperature(dataPianhangdianji.getWorkingTemperature())
                .operatingHours(dataPianhangdianji.getOperatingHours())
                .faultStatus(dataPianhangdianji.getFaultStatus())
                .startCount(dataPianhangdianji.getStartCount())
                .recordTime(dataPianhangdianji.getRecordTime())
                .createTime(dataPianhangdianji.getCreateTime())
                .build();
        return dataPianhangdianjiVO;
    }

    /**
     * 根据风机id查询控制柜最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 控制柜最新一条数据
     */
    @Override
    public DataKongzhiguiVO queryNewestKongzhiguiByTurbineId(String windTurbineId) {
        DataKongzhigui dataKongzhigui = kongzhiguiMapper.queryNewestKongzhiguiByTurbineId(windTurbineId);
        DataKongzhiguiVO dataKongzhiguiVO = DataKongzhiguiVO.builder()
                .turbineId(dataKongzhigui.getTurbineId())
                .cabinetType(dataKongzhigui.getCabinetType())
                .ratedVoltage(dataKongzhigui.getRatedVoltage())
                .ratedCurrent(dataKongzhigui.getRatedCurrent())
                .protectionLevel(dataKongzhigui.getProtectionLevel())
                .controlMethod(dataKongzhigui.getControlMethod())
                .cabinetMaterial(dataKongzhigui.getCabinetMaterial())
                .cabinetWeight(dataKongzhigui.getCabinetWeight())
                .workingTemperature(dataKongzhigui.getWorkingTemperature())
                .internalCurrent(dataKongzhigui.getInternalCurrent())
                .internalVoltage(dataKongzhigui.getInternalVoltage())
                .workingStatus(dataKongzhigui.getWorkingStatus())
                .recordTime(dataKongzhigui.getRecordTime())
                .createTime(dataKongzhigui.getCreateTime())
                .build();
        return dataKongzhiguiVO;
    }

    /**
     * 根据风机id查询风冷装置最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 风冷装置最新一条数据
     */
    @Override
    public DataFenglengzhuangzhiVO queryNewestFenglengzhuangzhiByTurbineId(String windTurbineId) {
        DataFenglengzhuangzhi dataFenglengzhuangzhi = fenglengzhuangzhiMapper.queryNewestFenglengzhuangzhiByTurbineId(windTurbineId);
        DataFenglengzhuangzhiVO dataFenglengzhuangzhiVO = DataFenglengzhuangzhiVO.builder()
                .turbineId(dataFenglengzhuangzhi.getTurbineId())
                .coolerType(dataFenglengzhuangzhi.getCoolerType())
                .fanType(dataFenglengzhuangzhi.getFanType())
                .fanPower(dataFenglengzhuangzhi.getFanPower())
                .airFlow(dataFenglengzhuangzhi.getAirFlow())
                .coolingEfficiency(dataFenglengzhuangzhi.getCoolingEfficiency())
                .workingTemperature(dataFenglengzhuangzhi.getWorkingTemperature())
                .deviceWeight(dataFenglengzhuangzhi.getDeviceWeight())
                .fanSpeed(dataFenglengzhuangzhi.getFanSpeed())
                .operatingHours(dataFenglengzhuangzhi.getOperatingHours())
                .faultStatus(dataFenglengzhuangzhi.getFaultStatus())
                .noiseLevel(dataFenglengzhuangzhi.getNoiseLevel())
                .recordTime(dataFenglengzhuangzhi.getRecordTime())
                .createTime(dataFenglengzhuangzhi.getCreateTime())
                .build();
        return dataFenglengzhuangzhiVO;
    }

    /**
     * 根据风机id查询发电机最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 发电机最新一条数据
     */
    @Override
    public DataFadianjiVO queryNewestFadianjiByTurbineId(String windTurbineId) {
        DataFadianji dataFadianji = fadianjiMapper.queryNewestFadianjiByTurbineId(windTurbineId);
        DataFadianjiVO dataFadianjiVO = DataFadianjiVO.builder()
                .turbineId(dataFadianji.getTurbineId())
                .generatorType(dataFadianji.getGeneratorType())
                .ratedPower(dataFadianji.getRatedPower())
                .ratedVoltage(dataFadianji.getRatedVoltage())
                .ratedFrequency(dataFadianji.getRatedFrequency())
                .efficiency(dataFadianji.getEfficiency())
                .weight(dataFadianji.getWeight())
                .rotationSpeed(dataFadianji.getRotationSpeed())
                .coolingMethod(dataFadianji.getCoolingMethod())
                .operatingHours(dataFadianji.getOperatingHours())
                .faultStatus(dataFadianji.getFaultStatus())
                .startCount(dataFadianji.getStartCount())
                .recordTime(dataFadianji.getRecordTime())
                .createTime(dataFadianji.getCreateTime())
                .updateTime(dataFadianji.getUpdateTime())
                .build();
        return dataFadianjiVO;
    }

    /**
     * 根据风机id查询齿轮箱最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 齿轮箱最新一条数据
     */
    @Override
    public DataChilunxiangVO queryNewestChilunxiangByTurbineId(String windTurbineId) {
        DataChilunxiang dataChilunxiang = chilunxiangMapper.queryNewestChilunxiangByTurbineId(windTurbineId);
        DataChilunxiangVO dataChilunxiangVO = DataChilunxiangVO.builder()
                .turbineId(dataChilunxiang.getTurbineId())
                .gearboxType(dataChilunxiang.getGearboxType())
                .gearRatio(dataChilunxiang.getGearRatio())
                .inputSpeed(dataChilunxiang.getInputSpeed())
                .outputSpeed(dataChilunxiang.getOutputSpeed())
                .efficiency(dataChilunxiang.getEfficiency())
                .gearboxTemperature(dataChilunxiang.getGearboxTemperature())
                .gearboxWeight(dataChilunxiang.getGearboxWeight())
                .gearMaterial(dataChilunxiang.getGearMaterial())
                .noiseLevel(dataChilunxiang.getNoiseLevel())
                .lubricationMethod(dataChilunxiang.getLubricationMethod())
                .wearLevel(dataChilunxiang.getWearLevel())
                .recordTime(dataChilunxiang.getRecordTime())
                .createTime(dataChilunxiang.getCreateTime())
                .updateTime(dataChilunxiang.getUpdateTime())
                .build();
        return dataChilunxiangVO;
    }



}

