package cyan.toolkit.widget.mapper;

import cyan.toolkit.widget.entity.RouteEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * <p>RouteMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:04 2021/6/8
 */
@Component
public interface RouteMapper extends Mapper<RouteEntity> {
    /**
     * 实体保存（存在更新不存在插入）
     * @param entity 实体
     * @return Integer SQL影响行数
     */
    Integer save(@Param("entity") RouteEntity entity);

    /**
     * 批量保存（存在更新不存在插入）
     * @param entityList 实体集合
     * @return Integer SQL影响行数
     */
    Integer saveAll(@Param("entityList") Collection<RouteEntity> entityList);

    /**
     * 实体单个删除
     * @param path 实体path集合
     * @return Integer SQL影响行数（成功为1）
     */
    Integer deleteById(@Param("path") String path);

    /**
     * 实体批量删除
     * @param pathList 实体path集合
     * @return Integer SQL影响行数
     */
    Integer deleteAll(@Param("pathList") Collection<String> pathList);

    /**
     * 通过id查询实体
     * @param path 实体path
     * @return T 查询的数据
     */
    RouteEntity findById(@Param("path") String path);

    /**
     * 实体批量查询
     * @param pathList 实体集合
     * @return List<T> 查询的数据集合
     */
    List<RouteEntity> findAll(@Param("pathList") Collection<String> pathList);

    /**
     * 通过filter查询条件查询
     * @param whereSql 过滤条件
     * @return List<T>
     */
    List<RouteEntity> findAllByWhere(@Param("whereSql") String whereSql);

    /**
     * 通过filter查询条件删除
     * @param whereSql 过滤条件
     */
    Integer deleteAllByWhere(@Param("whereSql") String whereSql);

    /**
     * 通过status实体批量查询
     * @return List<T> 查询的数据集合
     */
    List<RouteEntity> findAllByStatus();
    /**
     * 通过status实体批量修改
     * @return Integer SQL影响行数
     */
    Integer alertAllByStatus();
}
