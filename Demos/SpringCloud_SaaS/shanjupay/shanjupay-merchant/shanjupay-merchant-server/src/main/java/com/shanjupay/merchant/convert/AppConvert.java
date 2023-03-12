package com.shanjupay.merchant.convert;

import com.shanjupay.merchant.dto.AppDTO;
import com.shanjupay.merchant.entity.App;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2023年03月11日
 */
@Mapper
public interface AppConvert {

    AppConvert INSTANCE = Mappers.getMapper(AppConvert.class);

    AppDTO entity2dto(App app);
    App dto2app(AppDTO appDTO);

    List<AppDTO> listentity2dto(List<App> app);
}
