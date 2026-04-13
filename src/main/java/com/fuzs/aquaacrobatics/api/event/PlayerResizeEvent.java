package com.fuzs.aquaacrobatics.api.event;

import com.fuzs.aquaacrobatics.entity.EntitySize;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * 玩家大小调整事件
 */
public class PlayerResizeEvent extends PlayerEvent {

    private final EntitySize oldSize;
    private EntitySize newSize;

    public PlayerResizeEvent(EntityPlayer player, EntitySize oldSize, EntitySize newSize) {
        super(player);
        this.oldSize = oldSize;
        this.newSize = newSize;
    }

    /**
     * 获取之前的大小
     * @return 旧大小
     */
    public EntitySize getOldSize() {
        return oldSize;
    }

    /**
     * 获取新大小
     * @return 新大小
     */
    public EntitySize getNewSize() {
        return newSize;
    }

    /**
     * 设置新大小
     * @param newSize 要设置的新大小
     */
    public void setNewSize(EntitySize newSize) {
        this.newSize = newSize;
    }

    /**
     * 当玩家大小即将改变时触发
     * 取消此事件将阻止大小改变
     */
    @Cancelable
    public static class Pre extends PlayerResizeEvent {
        public Pre(EntityPlayer player, EntitySize oldSize, EntitySize newSize) {
            super(player, oldSize, newSize);
        }
    }

    /**
     * 当玩家大小改变后触发
     */
    public static class Post extends PlayerResizeEvent {
        public Post(EntityPlayer player, EntitySize oldSize, EntitySize newSize) {
            super(player, oldSize, newSize);
        }
    }
}
