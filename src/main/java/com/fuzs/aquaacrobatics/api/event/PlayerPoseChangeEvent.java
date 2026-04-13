package com.fuzs.aquaacrobatics.api.event;

import com.fuzs.aquaacrobatics.entity.Pose;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * 玩家姿势改变事件
 */
@Cancelable
public class PlayerPoseChangeEvent extends PlayerEvent {

    private final Pose oldPose;
    private Pose newPose;

    public PlayerPoseChangeEvent(EntityPlayer player, Pose oldPose, Pose newPose) {
        super(player);
        this.oldPose = oldPose;
        this.newPose = newPose;
    }

    /**
     * 获取之前的姿势
     * @return 旧姿势
     */
    public Pose getOldPose() {
        return oldPose;
    }

    /**
     * 获取新姿势
     * @return 新姿势
     */
    public Pose getNewPose() {
        return newPose;
    }

    /**
     * 设置新姿势
     * @param newPose 要设置的新姿势
     */
    public void setNewPose(Pose newPose) {
        this.newPose = newPose;
    }
}
