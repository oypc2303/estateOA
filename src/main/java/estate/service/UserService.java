package estate.service;

import estate.entity.database.AppUserEntity;
import estate.entity.display.Owner;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.exception.UserTypeErrorException;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-4.
 * 用户服务
 */
public interface UserService
{

    TableData getOwnerList(TableFilter tableFilter);

    TableData getTenantList(TableFilter tableFilter);

    TableData getAuthenticatedUserList(TableFilter tableFilter);

    /**
     * 获取app用户列表,同时返回每个用户绑定的房产id(1,2,3)
     * @param tableFilter
     * @return
     */
    TableData getAppUserList(TableFilter tableFilter);

    TableData getList(TableFilter tableFilter,Object object);

    Owner getOnerInfoByID(Integer id);

    /**
     * 改变app用户的状态
     * @param appUserEntity
     */
    void changeAppUserStatus(AppUserEntity appUserEntity);

    /**
     * 通过用户的电话和类型获取用户信息
     * @param phone
     * @param type
     * @return
     */
    Object getUserInfoBYPhone(String phone,int type);

    /**
     * 根据用户的电话和类型删除用户,用户类型只能是app用户和业主
     * 删除app用户时会同时删除家庭成员和租客
     * @param phone
     * @param type 只能是app用户和业主
     */
    void deleteUserByPhone(String phone,int type);

    /**
     * 通过用户的电话和类型获取该用户绑定的所有物业实体信息
     * @param userType 只能是app用户和业主
     * @param phone
     * @return
     */
    Object getPropertiesByPhone(String phone,int userType);

    /**
     * 通过物业id和用户类型返回该物业对应的用户信息
     * @param id
     * @return
     */
    ArrayList<Object> getUserInfoByProperityID(Integer id,int userType) throws UserTypeErrorException;

    /**
     * 根据物业id绑定到该物业的家庭成员和租客信息,status为是
     * @param id
     * @param status
     * @return
     */
    ArrayList<AppUserEntity> getBindUserByPropertyID(Integer id, Byte status);

    /**
     * 一次性获取所有的app用户
     * @return
     */
    ArrayList<AppUserEntity> getAllAppUser();


}
