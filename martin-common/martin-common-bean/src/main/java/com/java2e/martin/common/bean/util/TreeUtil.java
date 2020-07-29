package com.java2e.martin.common.bean.util;

import com.java2e.martin.common.bean.system.Menu;
import com.java2e.martin.common.bean.system.dto.BaseTreeNode;
import com.java2e.martin.common.bean.system.dto.MenuConverter;
import com.java2e.martin.common.bean.system.dto.MenuTreeNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/9/19
 * @describtion TreeUtil
 * @since 1.0
 * <p>
 * If a class is annotated with @UtilityClass, the following things happen to it:
 * It is marked final.
 * If any constructors are declared in it, an error is generated. Otherwise, a private no-args constructor is generated; it throws a UnsupportedOperationException.
 * All methods, inner classes, and fields in the class are marked static.
 * WARNING: Do not use non-star static imports to import these members; javac won't be able to figure it out. Use either: import static ThisType.*; or don't static-import.
 */

@UtilityClass
public class TreeUtil {
    /**
     * 递归获取所有路由信息
     *
     * @param treeNodes 所有路由
     * @param root      父节点
     * @param <T>
     * @return
     */
    public <T extends BaseTreeNode> List<T> buildRoutesByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findRoutes(treeNode, treeNodes,treeNode.getParentKeys()));
            }

        }
        return trees;
    }

    /**
     * 通过sysMenu集合创建树形路由
     *
     * @param menus
     * @param root
     * @return
     */
    public List<MenuTreeNode> buildRoutesByRecursive(List<Menu> menus, int root) {
        List<MenuTreeNode> menuTreeNodes = MenuConverter.INSTANCE.po2dto(menus);
        return TreeUtil.buildRoutesByRecursive(menuTreeNodes, root);
    }

    /**
     * 递归查找子路由
     *
     * @param treeNodes
     * @return
     */
    public <T extends BaseTreeNode> T findRoutes(T treeNode, List<T> treeNodes,String[] parentKeys) {
        for (T it : treeNodes) {
            ArrayList<String> parentKeysList = new ArrayList<>();
            if (treeNode.getId() == it.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.addChildren(findRoutes(it, treeNodes,treeNode.getParentKeys()));
            }
            if (parentKeys != null) {
                parentKeysList.addAll(Arrays.asList(parentKeys));
            }
            parentKeysList.add(treeNode.getParentKey());
            treeNode.setParentKeys(parentKeysList.toArray(new String[parentKeysList.size()]));
        }
        return treeNode;
    }

}
