package com.java2e.martin.common.bean.util;

import com.java2e.martin.common.bean.system.SysMenu;
import com.java2e.martin.common.bean.system.dto.BaseTreeNode;
import com.java2e.martin.common.bean.system.dto.MenuTreeNode;
import com.java2e.martin.common.bean.system.dto.SysMenuConverter;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangcan
 * @Version: 1.0
 * @Date: 2019/9/19
 * @Describtion: TreeUtil
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
     * 获取某个父节点下所有节点树
     *
     * @param treeNodes 所有节点
     * @param root      父节点
     * @param <T>
     * @return
     */
    public <T extends BaseTreeNode> List<T> build(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }


    /**
     * 递归获取某个父节点下所有节点树
     *
     * @param treeNodes 所有节点
     * @param root      父节点
     * @param <T>
     * @return
     */
    public <T extends BaseTreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 通过sysMenu集合创建树形节点
     *
     * @param menus
     * @param root
     * @return
     */
    public List<MenuTreeNode> buildByRecursive(List<SysMenu> menus, int root) {
        List<MenuTreeNode> menuTreeNodes = SysMenuConverter.INSTANCE.po2dto(menus);
        return TreeUtil.buildByRecursive(menuTreeNodes, root);
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public <T extends BaseTreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId() == it.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }


    /**
     * 通过sysMenu集合创建树形节点
     *
     * @param menus
     * @param root
     * @return
     */
    public List<MenuTreeNode> buildTree(List<SysMenu> menus, int root) {
        List<MenuTreeNode> menuTreeNodes = SysMenuConverter.INSTANCE.po2dto(menus);
        return TreeUtil.build(menuTreeNodes, root);
    }
}
