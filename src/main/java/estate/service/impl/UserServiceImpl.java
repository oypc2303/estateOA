package estate.service.impl;

import estate.common.util.Convert;
import estate.dao.PropertyDao;
import estate.dao.UserDao;
import estate.entity.database.AppUserEntity;
import estate.entity.database.OwnerEntity;
import estate.entity.database.TenantEntity;
import estate.entity.display.Owner;
import estate.entity.display.Tenant;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.BaseService;
import estate.service.PropertyService;
import estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-16.
 */
@Service("userService")
public class UserServiceImpl implements UserService,BaseService
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyDao propertyDao;

    public Integer save(Object object)
    {
        return null;
    }

    public Object get(Integer id)
    {
        return null;
    }

    public void delete(Object object)
    {

    }

    public boolean add(AppUserEntity userEntity)
    {
        return false;
    }

    public boolean delete(String userID)
    {
        return false;
    }



    public TableData getOwnerList(TableFilter tableFilter)
    {
        TableData tableData=userDao.getOwnerList(tableFilter);
        ArrayList<OwnerEntity> entities= (ArrayList<OwnerEntity>) tableData.getJsonString();
        ArrayList<Owner> owners=new ArrayList<Owner>();
        for (OwnerEntity ownerEntity:entities)
        {
            Owner owner=new Owner();
            owner.setName(ownerEntity.getName());
            owner.setPhone(ownerEntity.getPhone());
            owner.setSex(Convert.num2sex(ownerEntity.getSex()));
            owner.setIdentityType(Convert.num2idtype(ownerEntity.getIdentityType()));
            owner.setIdentityCode(ownerEntity.getIdentityCode());
            owner.setAuthenticationTime(Convert.num2time(ownerEntity.getAuthenticationTime()));
            owner.setBirthday(Convert.num2time(ownerEntity.getBirthday()));
            owner.setPropertyIdList(ownerEntity.getPropertyIdList());
            owner.setVehicleIdIst(ownerEntity.getVehicleIdIst());
            owner.setUrgentName(ownerEntity.getUrgentName());
            owner.setUrgentPhone(ownerEntity.getUrgentPhone());

            owner.setPropertyEntities(propertyService.getPropertiesByString(ownerEntity.getPropertyIdList()));
            owners.add(owner);
        }
        tableData.setJsonString(owners);
        return tableData;
    }

    public TableData getTenantList(TableFilter tableFilter)
    {
        TableData tableData=userDao.getTenantList(tableFilter);
        ArrayList<TenantEntity> entities = (ArrayList<TenantEntity>) tableData.getJsonString();
        ArrayList<Tenant> tenans=new ArrayList<Tenant>();

        for(TenantEntity tenantEntity:entities)
        {
            Tenant tenant=new Tenant();

            tenant.setBirthday(Convert.num2time(tenantEntity.getBirthday()));
            tenant.setSex(Convert.num2sex(tenantEntity.getSex()));
            tenant.setName(tenantEntity.getName());
            tenant.setAuthenticationTime(Convert.num2time(tenantEntity.getAuthenticationTime()));
            tenant.setStartTime(Convert.num2time(tenantEntity.getStartTime()));
            tenant.setEndTime(Convert.num2time(tenantEntity.getEndTime()));
            tenant.setIdentityType(Convert.num2idtype(tenantEntity.getIdentityType()));
            tenant.setIdentityCode(tenantEntity.getIdentityCode());
            tenant.setPhone(tenantEntity.getPhone());
            tenant.setUrgentName(tenantEntity.getUrgentName());
            tenant.setUrgentPhone(tenantEntity.getUrgentPhone());
            tenant.setProperty(propertyService.get(tenantEntity.getPropertyId()));

            tenans.add(tenant);
        }
        tableData.setJsonString(tenans);
        return tableData;
    }

    public TableData getAuthenticatedUserList(TableFilter tableFilter)
    {
        return null;
    }
}