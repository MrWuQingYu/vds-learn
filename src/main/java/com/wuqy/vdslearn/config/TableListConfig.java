package com.wuqy.vdslearn.config;/**
 * @author ：wuqy
 * @date ：Created in 2019/8/15 14:29
 * @description：
 * @modified By：
 * @version：1.0
 */

import com.tydic.vds.spring.CommonPartition;
import com.tydic.vds.spring.CommonTable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：wuqy
 * @date ：Created in 2019/8/15 14:29
 * @description：
 * @modified By：
 * @version：1.0
 */
@Configuration
public class TableListConfig {
    @Bean("sys_sync")
    public CommonTable sysSync(CommonPartition commonPartition) {
            CommonTable commonTable = new CommonTable();
        commonTable.setSchema("henandatareport");
        commonTable.setName("sys_sync");
        commonTable.setPartition(commonPartition);
        return commonTable;
    }

    @Bean("sys_sync_log")
    public CommonTable sysSyncLog(CommonPartition commonPartition) {
        CommonTable commonTable = new CommonTable();
        commonTable.setSchema("henandatareport");
        commonTable.setName("sys_sync_log");
        commonTable.setPartition(commonPartition);
        return commonTable;
    }
}
