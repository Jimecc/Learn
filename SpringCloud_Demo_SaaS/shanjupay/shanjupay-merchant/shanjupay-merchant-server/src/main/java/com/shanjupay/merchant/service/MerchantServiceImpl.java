package com.shanjupay.merchant.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.common.domain.CommonErrorCode;
import com.shanjupay.common.util.PhoneUtil;
import com.shanjupay.common.util.StringUtil;
import com.shanjupay.merchant.api.MerchantService;
import com.shanjupay.merchant.convert.MerchantConvert;
import com.shanjupay.merchant.dto.MerchantDTO;
import com.shanjupay.merchant.entity.Merchant;
import com.shanjupay.merchant.mapper.MerchantMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jim
 * @Description
 * @createTime 2023年03月05日
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantMapper merchantMapper;


    @Override
    public MerchantDTO queryMerchantByID(Long id) {
        Merchant merchant =  merchantMapper.selectById(id);
        MerchantDTO merchantDTO = MerchantConvert.INSTANCE.entity2dto(merchant);
        return merchantDTO;
    }

    @Override
    public MerchantDTO createMerchant(MerchantDTO merchantDTO) throws BusinessException {
        // 传入对象为空
        if(merchantDTO == null){
            throw new BusinessException(CommonErrorCode.E_100108);
        }

        // 手机号为空
        if(StringUtil.isBlank(merchantDTO.getMobile())){
            throw new BusinessException(CommonErrorCode.E_200230);
        }

        // 手机号格式匹配
        if(!PhoneUtil.isMatches(merchantDTO.getMobile())){
            throw new BusinessException(CommonErrorCode.E_200224);
        }

        // 手机号是否已经被注册
        Integer count = merchantMapper.selectCount(new LambdaQueryWrapper<Merchant>().eq(Merchant::getMobile,merchantDTO.getMobile()));
        if(count>0){
            throw new BusinessException(CommonErrorCode.E_200203);
        }

        Merchant merchant = MerchantConvert.INSTANCE.dto2entity(merchantDTO);
        merchantMapper.insert(merchant);
        merchantDTO.setId(merchant.getId());
        return merchantDTO;
    }

    @Override
    @Transactional
    public void applyMerchant(Long merchantId, MerchantDTO merchantDTO) throws BusinessException {
        if(merchantId == null || merchantDTO == null){
            throw new BusinessException(CommonErrorCode.E_300009);
        }

        Merchant merchant = merchantMapper.selectById(merchantId);
        if(merchant == null){
            throw new BusinessException(CommonErrorCode.E_200002);
        }

        // dto 2 entity
        Merchant entity = MerchantConvert.INSTANCE.dto2entity(merchantDTO);
        // 将必要的参数设置到对象当中
        merchantDTO.setId(merchantId);
        merchantDTO.setMobile(entity.getMobile()); // 资质申请的时候不可以修改手机号
        merchantDTO.setAuditStatus("1");
        merchantDTO.setTenantId(entity.getTenantId());
        merchantMapper.updateById(entity);
    }
}
