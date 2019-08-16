package com.wuqy.vdslearn.repository;/**
 * @author ：wuqy
 * @date ：Created in 2019/8/16 8:43
 * @description：
 * @modified By：
 * @version：1.0
 */

import com.tydic.uda.core.Condition;
import com.tydic.uda.service.S;
import com.wuqy.vdslearn.entity.SysSync;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wuqy
 * @date ：Created in 2019/8/16 8:43
 * @description：
 * @modified By：
 * @version：1.0
 */
@Repository
public class SysSyncDao {

    /**
     * 条件查询 查询单个对象
     * @param parmeMap
     * @return
     */
    public SysSync query(final Map<String, Object> parmeMap) {
        return S.get(SysSync.class).queryFirst(Condition.build("querySysSync").filter(parmeMap));
    }

    /**
     * 查询 多个对象
     *
     * @return List
     */
    public List<SysSync> queryList() {
        return S.get(SysSync.class).query(Condition.build("queryList"));
    }

    /**
     * 添加单个对象
     *
     * @return List
     */
    public Serializable add(final SysSync sysSync) {
        return S.get(SysSync.class).create(sysSync);
    }

    /**
     * 更新个对象
     *  配置文件中 <trim prefix="set" suffixOverrides=",">等价于<set>标签 ，set 元素会动态前置 SET 关键字，同时也会消除无关的逗号
     * @return List
     */
    public int update(final SysSync sysSync) {
        return S.get(SysSync.class).update(sysSync);
    }

    /**
     * 批量新增对象
     * @return List
     */
    public int pBatch(final List<SysSync> sysSync) {
        return S.get(SysSync.class).pBatch(Condition.empty(),sysSync);
    }

    /**
     * 物理删除
     * @param serializable
     * @return
     */
    public int delete(Serializable serializable){

        return   S.get(SysSync.class).remove(serializable);
    }

    public int logicDelete(Serializable serializable){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", serializable);
        return  S.get(SysSync.class).update(Condition.build("logicDelete").filter(filter));
    }
}
