package io.github.mddarmawan.threadtweak.config;

import java.util.Properties;

public class ThreadTweakConfig {
    public int game = 5;
    public int bootstrap = 1;
    public int main = 1;
    public int io = 1;
    public int integratedServer = 5;

    public void validate() {
        game = clamp(game);
        bootstrap = clamp(bootstrap);
        main = clamp(main);
        io = clamp(io);
        integratedServer = clamp(integratedServer);
    }

    private static int clamp(int value) {
        return Math.max(1, Math.min(10, value));
    }

    public void read(Properties properties) {
        game = Integer.parseInt(properties.getProperty("priority.game", "5"));
        bootstrap = Integer.parseInt(properties.getProperty("priority.bootstrap", "1"));
        main = Integer.parseInt(properties.getProperty("priority.main", "1"));
        io = Integer.parseInt(properties.getProperty("priority.io", "1"));
        integratedServer = Integer.parseInt(properties.getProperty("priority.integratedServer", "5"));
    }

    public void write(Properties properties) {
        properties.setProperty("priority.game", Integer.toString(game));
        properties.setProperty("priority.bootstrap", Integer.toString(bootstrap));
        properties.setProperty("priority.main", Integer.toString(main));
        properties.setProperty("priority.io", Integer.toString(io));
        properties.setProperty("priority.integratedServer", Integer.toString(integratedServer));
    }
}
