package com.shanjupay.merchant.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.common.domain.CommonErrorCode;
import com.shanjupay.merchant.api.AppService;
import com.shanjupay.merchant.convert.AppConvert;
import com.shanjupay.merchant.dto.AppDTO;
import com.shanjupay.merchant.entity.App;
import com.shanjupay.merchant.entity.Merchant;
import com.shanjupay.merchant.mapper.AppMapper;
import com.shanjupay.merchant.mapper.MerchantMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author Jim
 * @Description
 * @createTime 2023年03月11日
 */
@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public AppDTO createApp(Long merchantId, AppDTO appDTO) throws BusinessException {
        // 调用appMapper向应用表插入数据
        if(merchantId == null || appDTO.getAppId() == null || appDTO.getAppName() == null){
            throw new BusinessException(CommonErrorCode.E_300009);
        }
        Merchant merchant = merchantMapper.selectById(merchantId);
        if(merchant == null){
            throw new BusinessException(CommonErrorCode.E_200002);
        }
        // 取出商户的资质申请的状态
        if(!"2".equals(merchant.getAuditStatus())){
            throw new BusinessException(CommonErrorCode.E_200003);
        }
        // 校验应用名称
        String appName = appDTO.getAppName();
        if(isExistAppName(appName)){
            throw new BusinessException(CommonErrorCode.E_200004);
        }
        // 生成应用ID
        String appid = UUID.randomUUID().toString();
        App app = AppConvert.INSTANCE.dto2app(appDTO);
        app.setAppId(appid);
        return AppConvert.INSTANCE.entity2dto(app);
    }

    private boolean isExistAppName(String appName){
        int count = appMapper.selectCount(new LambdaQueryWrapper<App>().eq(App::getAppName,appName));
        if(count > 0){
            return true;
        }
        return false;
    }
}
