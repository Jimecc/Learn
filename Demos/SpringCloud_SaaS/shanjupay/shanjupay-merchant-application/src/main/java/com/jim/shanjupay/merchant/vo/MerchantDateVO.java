package com.jim.shanjupay.merchant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jim
 * @Description
 * @createTime 2023年03月09日
 */
@ApiModel("商户资质申请")
public class MerchantDateVO {

    /**
     * 主键
     */
    @ApiModelProperty("商户ID")
    private Long id;

    /**
     * 商户名称
     */
    @ApiModelProperty("商户名称")
    private String merchantName;

    /**
     * 企业编号
     */
    @ApiModelProperty("企业编号")
    private String merchantNo;

    /**
     * 企业地址
     */
    @ApiModelProperty("企业地址")
    private String merchantAddress;

    /**
     * 商户类型
     */
    @ApiModelProperty("商户类型")
    private String merchantType;

    /**
     * 营业执照（企业证明）
     */
    @ApiModelProperty("营业执照（企业证明）")
    private String businessLicensesImg;

    /**
     * 法人身份证正面照片
     */
    @ApiModelProperty("法人身份证正面照片")
    private String idCardFrontImg;

    /**
     * 法人身份证反面照片
     */
    @ApiModelProperty("法人身份证反面照片")
    private String idCardAfterImg;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    private String username;

    /**
     * 联系人地址
     */
    @ApiModelProperty("联系人地址")
    private String contactsAddress;

}
