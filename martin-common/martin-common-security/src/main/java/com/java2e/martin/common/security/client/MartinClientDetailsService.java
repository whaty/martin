package com.java2e.martin.common.security.client;

import com.java2e.martin.common.core.constant.CacheConstants;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/8/27
 * @Describtion: MartinClientDetailsService
 */
public class MartinClientDetailsService extends JdbcClientDetailsService {
    public MartinClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    /**
     *
     * @param clientId
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.CLIENT_DETAILS_KEY, key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId) {
        return super.loadClientByClientId(clientId);
    }
}
