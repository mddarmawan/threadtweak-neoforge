package io.github.mddarmawan.threadtweak;

import java.util.Properties;

import io.github.mddarmawan.threadtweak.config.ThreadTweakConfig;

public final class ThreadTweakConfigHolder {
    private static volatile ThreadTweakConfig instance;

    private ThreadTweakConfigHolder() {
    }

    public static ThreadTweakConfig get() {
        ThreadTweakConfig local = instance;
        if (local == null) {
            synchronized (ThreadTweakConfigHolder.class) {
                local = instance;
                if (local == null) {
                    local = load();
                    instance = local;
                }
            }
        }
        return local;
    }

    private static ThreadTweakConfig load() {
        ThreadTweakConfig config = new ThreadTweakConfig();
        java.io.File file = new java.io.File("config", ThreadTweak.MOD_ID + ".properties");
        if (file.isFile()) {
            Properties properties = new Properties();
            try (java.io.FileReader reader = new java.io.FileReader(file)) {
                properties.load(reader);
                config.read(properties);
            } catch (Exception e) {
                ThreadTweak.LOGGER.warn("Could not read {}, using defaults", file, e);
            }
        }
        config.validate();
        try {
            file.getParentFile().mkdirs();
            Properties properties = new Properties();
            config.write(properties);
            try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
                properties.store(writer, "ThreadTweak configuration");
            }
        } catch (Exception e) {
            ThreadTweak.LOGGER.warn("Could not write {}", file, e);
        }
        ThreadTweak.LOGGER.info("ThreadTweak config loaded");
        return config;
    }
}
