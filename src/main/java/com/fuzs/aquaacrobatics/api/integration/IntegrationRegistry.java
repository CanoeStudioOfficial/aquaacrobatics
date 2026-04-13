package com.fuzs.aquaacrobatics.api.integration;

import com.fuzs.aquaacrobatics.AquaAcrobatics;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集成注册表
 * 用于注册和管理第三方模组集成
 */
public class IntegrationRegistry {

    private static final List<IAquaAcrobaticsIntegration> INTEGRATIONS = new ArrayList<>();

    /**
     * 注册一个集成
     * @param integration 要注册的集成
     * @return 如果注册成功返回 true
     */
    public static boolean registerIntegration(IAquaAcrobaticsIntegration integration) {
        if (integration == null) {
            AquaAcrobatics.LOGGER.warn("Attempted to register null integration");
            return false;
        }

        String modId = integration.getModId();
        if (modId == null || modId.isEmpty()) {
            AquaAcrobatics.LOGGER.warn("Attempted to register integration with null or empty mod ID");
            return false;
        }

        if (!Loader.isModLoaded(modId)) {
            AquaAcrobatics.LOGGER.debug("Skipping integration for mod '{}' as it is not loaded", modId);
            return false;
        }

        if (!integration.isEnabled()) {
            AquaAcrobatics.LOGGER.debug("Integration for mod '{}' is disabled", modId);
            return false;
        }

        INTEGRATIONS.add(integration);
        AquaAcrobatics.LOGGER.info("Registered Aqua Acrobatics integration for mod: {}", modId);
        return true;
    }

    /**
     * 获取所有已注册的集成
     * @return 不可修改的集成列表
     */
    public static List<IAquaAcrobaticsIntegration> getIntegrations() {
        return Collections.unmodifiableList(INTEGRATIONS);
    }

    /**
     * 初始化所有已注册的集成
     */
    public static void initIntegrations() {
        for (IAquaAcrobaticsIntegration integration : INTEGRATIONS) {
            try {
                integration.init();
            } catch (Exception e) {
                AquaAcrobatics.LOGGER.error("Failed to initialize integration for mod: {}", integration.getModId(), e);
            }
        }
    }

    /**
     * 后初始化所有已注册的集成
     */
    public static void postInitIntegrations() {
        for (IAquaAcrobaticsIntegration integration : INTEGRATIONS) {
            try {
                integration.postInit();
            } catch (Exception e) {
                AquaAcrobatics.LOGGER.error("Failed to post-initialize integration for mod: {}", integration.getModId(), e);
            }
        }
    }

    /**
     * 清除所有集成
     * 主要用于测试
     */
    public static void clearIntegrations() {
        INTEGRATIONS.clear();
    }
}
