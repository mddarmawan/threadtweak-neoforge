# ThreadTweak (NeoForge)

Improves and tweaks Minecraft CPU scheduling so the game thread and background workers get the priorities you want.

A NeoForge port of [ThreadTweak by getchoo](https://modrinth.com/mod/threadtweak) (MIT), which only supports Fabric.

- **Target:** Minecraft 26.2 / NeoForge 26.2.0.88 / Java 25
- **Source:** https://github.com/mddarmawan/threadtweak-neoforge

## Configuration

On first launch, `config/threadtweak.properties` is created with the thread priorities (1 = lowest, 10 = highest):

```
priority.game=5
priority.integratedServer=5
priority.bootstrap=1
priority.main=1
priority.io=1
```

## Build

Requires JDK 25 (NeoForge 26.x). Gradle can auto-provision it via the toolchain resolver.

```
./gradlew build
```

Jar output: `build/libs/threadtweak-1.0.0.jar`.

## Install

1. Install NeoForge for Minecraft 26.2 (easiest via [Prism Launcher](https://prismlauncher.org/)).
2. Drop `threadtweak-1.0.0.jar` into the instance's `mods/` folder.

## Credits

Original mod by **getchoo**, **UltimateBoomer** and **fantahund** ([ThreadTweak](https://modrinth.com/mod/threadtweak), MIT).

## License

MIT, inherited from the upstream original.
