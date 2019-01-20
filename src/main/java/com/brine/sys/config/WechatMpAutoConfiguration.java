package com.brine.sys.config;

import com.brine.sys.common.properties.WechatMpProperties;
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
 * @author: yanghm
 * @date: 2018/12/31 0031 上午 9:55
 */
@Configuration
@ConditionalOnClass(WxMpService.class)
@EnableConfigurationProperties(WechatMpProperties.class)
public class WechatMpAutoConfiguration {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private WechatMpProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage() {
        WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId(properties.getAppId());
        configStorage.setSecret(properties.getSecret());
        configStorage.setToken(properties.getToken());
        configStorage.setAesKey(properties.getAesKey());
        return configStorage;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxMpService wxMpService(WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage) {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        return wxMpService;
    }
}
