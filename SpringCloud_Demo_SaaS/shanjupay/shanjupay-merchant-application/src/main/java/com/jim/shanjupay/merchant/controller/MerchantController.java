package com.jim.shanjupay.merchant.controller;

import com.jim.shanjupay.merchant.common.util.SecurityUtil;
import com.jim.shanjupay.merchant.convert.MerchantConvert;
import com.jim.shanjupay.merchant.convert.MerchantDetailConvert;
import com.jim.shanjupay.merchant.service.FileService;
import com.jim.shanjupay.merchant.service.SmsService;
import com.jim.shanjupay.merchant.vo.MerchantDateVO;
import com.jim.shanjupay.merchant.vo.MerchantRegisterVO;
import com.shanjupay.merchant.api.MerchantService;
import com.shanjupay.merchant.dto.MerchantDTO;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author Jim
 * @Description
 * @createTime 2023年03月05日
 */

@RestController
public class MerchantController {

    @Autowired
    FileService fileService;

    @Autowired
    SmsService smsService;

    @Reference
    MerchantService merchantService;

    @ApiOperation("根据ID查询商户信息")
    @GetMapping("/merchant/{id}")
    public MerchantDTO queryMerchantByID(@PathVariable Long id){
        MerchantDTO merchantDTO = merchantService.queryMerchantByID(id);
        return merchantDTO;
    }

    @ApiOperation("获取手机验证码")
    @GetMapping("/sms")
    @ApiImplicitParam(value="手机号",name="phone",required = true,dataType = "string",paramType = "query")
    public String getSmsCode(@RequestParam("phone") String phone){
        return smsService.sendMsg(phone);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @ApiOperation("商户注册")
    @ApiImplicitParam(value="商户注册信息",name="merchantRegisterVO",required = true,dataType = "MerchantRegisterVO",paramType = "body")
    @PostMapping("/merchants/register")
    public MerchantRegisterVO registerMerchant(@RequestBody MerchantRegisterVO merchantRegisterVO){
        smsService.checkVerifiyCode(merchantRegisterVO.getVerifiykey(),merchantRegisterVO.getVerifiyCode());
        MerchantDTO merchantDTO = MerchantConvert.INSTANCE.entity2dto(merchantRegisterVO);
        merchantService.createMerchant(merchantDTO);
        return merchantRegisterVO;
    }

    // 上传文件接口
    @ApiOperation("上传证件照")
    @PostMapping("/upload")
    public String upload(@ApiParam(value="证件照",required = true) @RequestParam("file") MultipartFile multipartFile) throws IOException {
        // 生成文件名称（要保证单一性）
        String originalFileName = multipartFile.getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf('.')-1);
        String filename = UUID.randomUUID()+suffix;
        String url = fileService.upload(multipartFile.getBytes(),filename);
        System.out.println(url);
        return url;
    }

    @ApiOperation("资质申请")
    @PostMapping("/my/merchants/save")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merchantInfo",value = "商户认证资料",required = true,dataType = "MerchantDateVO")
    })
    public void saveMerchant(@RequestBody MerchantDateVO merchantInfo){
        // 取出当前登录用户的ID
        Long merchantId = SecurityUtil.getMerchantId();
        MerchantDTO merchantDTO = MerchantDetailConvert.INSTANCE.vo2dto(merchantInfo);
        merchantService.applyMerchant(merchantId,merchantDTO);
    }

}
