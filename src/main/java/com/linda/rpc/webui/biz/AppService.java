package com.linda.rpc.webui.biz;

import com.linda.rpc.webui.dao.AppInfoDao;
import com.linda.rpc.webui.pojo.AppInfo;
import com.linda.rpc.webui.pojo.ServiceInfo;
import com.linda.rpc.webui.utils.ConUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lin on 2016/12/16.
 */
@Service
public class AppService {

    @Resource
    private AppInfoDao appInfoDao;

    @Resource
    private ServiceInfoService serviceInfoService;

    public AppInfo getById(long id){
        return appInfoDao.getById(id);
    }

    public void updateApp(AppInfo app){
        appInfoDao.updateById(app);
    }

    public AppInfo getOrAddApp(String app){
        AppInfo info = appInfoDao.getByName(app);
        if(info!=null){
            return info;
        }else{
            info = ConUtils.buildApp(app);
            appInfoDao.addAppInfo(info);
            if(info.getId()>0){
                return info;
            }
            return null;
        }
    }

    public List<AppInfo> getAppList(){
        return appInfoDao.getList();
    }

    public List<AppInfo> getConsumerApps(long appId){
        List<AppInfo> consumerApps = appInfoDao.getConsumerApps(appId);
        //填充服务
        if(consumerApps!=null){
            for(AppInfo info:consumerApps){
                List<ServiceInfo> services = serviceInfoService.getListByProviderAndConsumerApp(appId, info.getId());
                info.setServices(services);
            }
        }
        return consumerApps;
    }

}
