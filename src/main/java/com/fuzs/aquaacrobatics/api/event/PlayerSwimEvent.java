package com.fuzs.aquaacrobatics.api.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * 玩家游泳相关事件
 */
public class PlayerSwimEvent extends PlayerEvent {

    public PlayerSwimEvent(EntityPlayer player) {
        super(player);
    }

    /**
     * 当玩家开始游泳时触发
     * 取消此事件将阻止玩家进入游泳状态
     */
    @Cancelable
    public static class Start extends PlayerSwimEvent {
        public Start(EntityPlayer player) {
            super(player);
        }
    }

    /**
     * 当玩家停止游泳时触发
     */
    public static class Stop extends PlayerSwimEvent {
        public Stop(EntityPlayer player) {
            super(player);
        }
    }

    /**
     * 当玩家游泳状态更新时触发
     * 每刻都会调用
     */
    public static class Update extends PlayerSwimEvent {
        public Update(EntityPlayer player) {
            super(player);
        }
    }
}
