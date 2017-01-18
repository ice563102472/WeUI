package com.linda.rpc.webui.pojo;

import com.linda.common.mybatis.generator.annotation.Column;
import com.linda.common.mybatis.generator.annotation.Index;
import com.linda.common.mybatis.generator.annotation.PrimaryKey;
import com.linda.common.mybatis.generator.annotation.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/12/15.
 */
@Data
@Table(name="app_info",autoGeneratePrimaryKey = true)
public class AppInfo {

    /**
     * id
     */
    @PrimaryKey(column = "id")
    private long id;

    /**
     * 应用名称
     */
    @Index(name = "AppName")
    @Column(column = "app_name")
    private String name;

    /**
     * 应用描述
     */
    @Column(column = "app_desc")
    private String desc;

    /**
     * 应用owner
     */
    @Column(column="app_owner")
    private String owner;

    /**
     * 应用owner email
     */
    @Column(column = "app_owner_email")
    private String email;

    //作为dto使用
    private List<HostInfo> hosts = new ArrayList<HostInfo>();
    //作为DTO使用
    private List<ServiceInfo> services = new ArrayList<ServiceInfo>();


}
