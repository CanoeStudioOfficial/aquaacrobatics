package com.fuzs.aquaacrobatics.api;

import com.fuzs.aquaacrobatics.entity.EntitySize;
import com.fuzs.aquaacrobatics.entity.Pose;
import com.fuzs.aquaacrobatics.entity.player.IPlayerResizeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Loader;

/**
 * Aqua Acrobatics API - 为其他开发者提供的公共接口
 * 版本: 1.12.2
 */
public class AquaAcrobaticsAPI {

    private static final String MODID = "aquaacrobatics";
    private static Boolean isAquaAcrobaticsLoaded = null;

    /**
     * 检查 Aqua Acrobatics 是否已加载
     * @return 如果模组已加载返回 true
     */
    public static boolean isLoaded() {
        if (isAquaAcrobaticsLoaded == null) {
            isAquaAcrobaticsLoaded = Loader.isModLoaded(MODID);
        }
        return isAquaAcrobaticsLoaded;
    }

    /**
     * 获取玩家的 IPlayerResizeable 接口实例
     * @param player 玩家实体
     * @return IPlayerResizeable 实例，如果无法获取则返回 null
     */
    public static IPlayerResizeable getPlayerResizeable(EntityPlayer player) {
        if (!isLoaded() || player == null) {
            return null;
        }
        return (IPlayerResizeable) player;
    }

    /**
     * 检查玩家是否可以游泳
     * @param player 玩家实体
     * @return 如果可以游泳返回 true
     */
    public static boolean canPlayerSwim(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null && resizeable.canSwim();
    }

    /**
     * 检查玩家是否正在游泳
     * @param player 玩家实体
     * @return 如果正在游泳返回 true
     */
    public static boolean isPlayerSwimming(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null && resizeable.isSwimming();
    }

    /**
     * 检查玩家是否实际在游泳（视觉上也显示为游泳状态）
     * @param player 玩家实体
     * @return 如果实际在游泳返回 true
     */
    public static boolean isPlayerActuallySwimming(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null && resizeable.isActuallySwimming();
    }

    /**
     * 获取玩家的当前姿势
     * @param player 玩家实体
     * @return 当前姿势，如果无法获取则返回 Pose.STANDING
     */
    public static Pose getPlayerPose(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null ? resizeable.getPose() : Pose.STANDING;
    }

    /**
     * 设置玩家的姿势
     * @param player 玩家实体
     * @param pose 要设置的姿势
     */
    public static void setPlayerPose(EntityPlayer player, Pose pose) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        if (resizeable != null) {
            resizeable.setPose(pose);
        }
    }

    /**
     * 检查玩家的眼睛是否在水中
     * @param player 玩家实体
     * @return 如果眼睛在水中返回 true
     */
    public static boolean areEyesInWater(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null && resizeable.getEyesInWaterPlayer();
    }

    /**
     * 获取玩家的水下视野倍数
     * @param player 玩家实体
     * @return 水下视野倍数
     */
    public static float getWaterVision(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null ? resizeable.getWaterVision() : 0.0F;
    }

    /**
     * 获取指定姿势下的玩家大小
     * @param player 玩家实体
     * @param pose 姿势
     * @return EntitySize 实例，如果无法获取则返回 null
     */
    public static EntitySize getPlayerSize(EntityPlayer player, Pose pose) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null ? resizeable.getSize(pose) : null;
    }

    /**
     * 获取玩家当前宽度
     * @param player 玩家实体
     * @return 玩家宽度
     */
    public static float getPlayerWidth(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null ? resizeable.getWidth() : player.width;
    }

    /**
     * 获取玩家当前高度
     * @param player 玩家实体
     * @return 玩家高度
     */
    public static float getPlayerHeight(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null ? resizeable.getHeight() : player.height;
    }

    /**
     * 检查玩家是否允许调整大小
     * @param player 玩家实体
     * @return 如果允许调整大小返回 true
     */
    public static boolean isResizingAllowed(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null && resizeable.isResizingAllowed();
    }

    /**
     * 检查玩家是否实际在潜行
     * @param player 玩家实体
     * @return 如果实际在潜行返回 true
     */
    public static boolean isActuallySneaking(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null && resizeable.isActuallySneaking();
    }

    /**
     * 重新计算玩家大小
     * @param player 玩家实体
     */
    public static void recalculatePlayerSize(EntityPlayer player) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        if (resizeable != null) {
            resizeable.recalculateSize();
        }
    }

    /**
     * 获取游泳动画进度
     * @param player 玩家实体
     * @param partialTicks 部分刻
     * @return 游泳动画进度 (0.0F - 1.0F)
     */
    public static float getSwimAnimation(EntityPlayer player, float partialTicks) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null ? resizeable.getSwimAnimation(partialTicks) : 0.0F;
    }

    /**
     * 检查指定姿势是否可行（不会与方块碰撞）
     * @param player 玩家实体
     * @param pose 要检查的姿势
     * @return 如果姿势可行返回 true
     */
    public static boolean isPoseClear(EntityPlayer player, Pose pose) {
        IPlayerResizeable resizeable = getPlayerResizeable(player);
        return resizeable != null && resizeable.isPoseClear(pose);
    }
}
