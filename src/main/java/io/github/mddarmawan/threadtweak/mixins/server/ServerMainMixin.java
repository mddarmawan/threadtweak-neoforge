/*
 * NeoForge port of ThreadTweak by getchoo (https://modrinth.com/mod/threadtweak), MIT licensed.
 */
package io.github.mddarmawan.threadtweak.mixins.server;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.mddarmawan.threadtweak.ThreadTweakConfigHolder;
import net.minecraft.server.Main;

@Mixin(Main.class)
public class ServerMainMixin {
    @Inject(method = "main", at = @At("HEAD"), remap = false)
    private static void threadtweak$setGamePriority(String[] args, CallbackInfo ci) {
        Thread.currentThread().setPriority(ThreadTweakConfigHolder.get().game);
    }
}
