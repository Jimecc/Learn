package com.jim.shanjupay.merchant.convert;

import com.jim.shanjupay.merchant.vo.MerchantDateVO;
import com.shanjupay.merchant.dto.MerchantDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-11T15:02:19+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class MerchantDetailConvertImpl implements MerchantDetailConvert {

    @Override
    public MerchantDateVO dto2vo(MerchantDTO merchantDTO) {
        if ( merchantDTO == null ) {
            return null;
        }

        MerchantDateVO merchantDateVO = new MerchantDateVO();

        return merchantDateVO;
    }

    @Override
    public MerchantDTO vo2dto(MerchantDateVO merchantDateVO) {
        if ( merchantDateVO == null ) {
            return null;
        }

        MerchantDTO merchantDTO = new MerchantDTO();

        return merchantDTO;
    }
}
