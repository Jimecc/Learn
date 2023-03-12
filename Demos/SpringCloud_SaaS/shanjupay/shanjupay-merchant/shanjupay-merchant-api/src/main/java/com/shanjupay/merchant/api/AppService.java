package com.shanjupay.merchant.api;

import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.merchant.dto.AppDTO;

/**
 * @author Jim
 * @Description 应用管理相关接口
 * @createTime 2023年03月11日
 */
public interface AppService {

    /**
     * @Author: Jim
     * @Description: 创建应用
     * @param 商户ID
     * @param 应用信息
     */
    public AppDTO createApp(Long merchantId,AppDTO appDTO) throws BusinessException;

}
