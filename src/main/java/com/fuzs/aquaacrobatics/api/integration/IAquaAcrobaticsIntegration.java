package com.fuzs.aquaacrobatics.api.integration;

import com.fuzs.aquaacrobatics.entity.EntitySize;
import com.fuzs.aquaacrobatics.entity.Pose;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Aqua Acrobatics 集成接口
 * 其他模组可以实现此接口来与 Aqua Acrobatics 进行深度集成
 */
public interface IAquaAcrobaticsIntegration {

    /**
     * 获取此集成的模组ID
     * @return 模组ID
     */
    String getModId();

    /**
     * 检查此集成是否启用
     * @return 如果启用返回 true
     */
    boolean isEnabled();

    /**
     * 初始化集成
     * 在模组初始化阶段调用
     */
    void init();

    /**
     * 后初始化集成
     * 在模组后初始化阶段调用
     */
    default void postInit() {}

    /**
     * 获取玩家大小调整因子
     * 用于与其他改变玩家大小的模组兼容
     * @param player 玩家实体
     * @return 大小调整因子 (1.0 = 正常大小)
     */
    default float getSizeScaleFactor(EntityPlayer player) {
        return 1.0F;
    }

    /**
     * 获取眼睛高度调整因子
     * @param player 玩家实体
     * @return 眼睛高度调整因子 (1.0 = 正常高度)
     */
    default float getEyeHeightScaleFactor(EntityPlayer player) {
        return 1.0F;
    }

    /**
     * 检查是否应该阻止玩家游泳
     * @param player 玩家实体
     * @return 如果应该阻止返回 true
     */
    default boolean shouldPreventSwimming(EntityPlayer player) {
        return false;
    }

    /**
     * 检查是否应该阻止姿势改变
     * @param player 玩家实体
     * @param oldPose 旧姿势
     * @param newPose 新姿势
     * @return 如果应该阻止返回 true
     */
    default boolean shouldPreventPoseChange(EntityPlayer player, Pose oldPose, Pose newPose) {
        return false;
    }

    /**
     * 当玩家姿势改变时调用
     * @param player 玩家实体
     * @param oldPose 旧姿势
     * @param newPose 新姿势
     */
    default void onPlayerPoseChanged(EntityPlayer player, Pose oldPose, Pose newPose) {}

    /**
     * 当玩家大小改变时调用
     * @param player 玩家实体
     * @param oldSize 旧大小
     * @param newSize 新大小
     */
    default void onPlayerSizeChanged(EntityPlayer player, EntitySize oldSize, EntitySize newSize) {}
}
