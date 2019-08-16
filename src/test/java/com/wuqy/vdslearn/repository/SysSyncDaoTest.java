package com.wuqy.vdslearn.repository;

import com.wuqy.vdslearn.entity.SysSync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wuqy
 * @date ：Created in 2019/8/16 8:54
 * @description：
 * @modified By：
 * @version：1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysSyncDaoTest {

    @Resource
    private SysSyncDao sysSyncDao;

    @Test
    public void query() {
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("syncType", "ecs");
        SysSync query = sysSyncDao.query(filter);
    }

    @Test
    public void queryList() {
        List<SysSync> sysSyncs = sysSyncDao.queryList();
    }

    @Test
    public void add() {
        SysSync sysSync = new SysSync();
        sysSync.setStart(1);
        sysSync.setEnd(2);
        sysSync.setTotal(10);
        sysSync.setOperateTime(new Date());
        sysSync.setSyncStartTime(new Date());
        sysSync.setSyncEndTime(new Date());
        sysSync.setSyncType("ecs");
        Serializable add = sysSyncDao.add(sysSync);

    }

    @Test
    public void update() {
        SysSync sysSync = new SysSync();
        sysSync.setId(57);
        sysSync.setStart(177);
        int update = sysSyncDao.update(sysSync);
    }

    @Test
    public void pBatch() {
        List<SysSync> list = new ArrayList<>();
        SysSync sysSync = new SysSync();
        sysSync.setStart(1);
        sysSync.setEnd(2);
        sysSync.setTotal(10);
        sysSync.setOperateTime(new Date());
        sysSync.setSyncStartTime(new Date());
        sysSync.setSyncEndTime(new Date());
        sysSync.setSyncType("ecs");
        SysSync sysSync1 = new SysSync();
        sysSync1.setStart(11);
        sysSync1.setEnd(21);
        sysSync1.setTotal(101);
        sysSync1.setOperateTime(new Date());
        sysSync1.setSyncStartTime(new Date());
        sysSync1.setSyncEndTime(new Date());
        sysSync1.setSyncType("ecs");
        list.add(sysSync);
        list.add(sysSync1);
        sysSyncDao.pBatch(list);
    }
    @Test
    public void delete(){
        int delete = sysSyncDao.delete(59);
    }

    @Test
    public void logicDelete(){
        sysSyncDao.logicDelete(58);
    }

}
