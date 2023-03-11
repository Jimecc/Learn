package com.jim.shanjupay.merchant.convert;

import com.jim.shanjupay.merchant.vo.MerchantDateVO;
import com.shanjupay.merchant.dto.MerchantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Jim
 * @Description 商户申请的VO与DTO转换
 * @createTime 2023年03月10日
 */
@Mapper
public interface MerchantDetailConvert {
    MerchantDetailConvert INSTANCE = Mappers.getMapper(MerchantDetailConvert.class);

    MerchantDateVO dto2vo(MerchantDTO merchantDTO);

    MerchantDTO vo2dto(MerchantDateVO merchantDateVO);


}
