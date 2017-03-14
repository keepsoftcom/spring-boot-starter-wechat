package com.github.wechat.autoconfigure;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring-boot AutoConfiguration
 *
 * @author liaowu
 */
@Configuration
@ConditionalOnClass(WxMpService.class)
@EnableConfigurationProperties(WechatMpProperties.class)
public class WechatMpAutoConfiguration {
    @Autowired
    private WechatMpProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WxMpConfigStorage configStorage() {
        WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId(this.properties.getAppId());
        configStorage.setSecret(this.properties.getSecret());
        configStorage.setToken(this.properties.getToken());
        configStorage.setAesKey(this.properties.getAesKey());
        configStorage.setPartnerId(this.properties.getPartnerId());
        configStorage.setPartnerKey(this.properties.getPartnerKey());
        return configStorage;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxMpService wxMpService(WxMpConfigStorage configStorage) {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);
        return wxMpService;
    }

}
