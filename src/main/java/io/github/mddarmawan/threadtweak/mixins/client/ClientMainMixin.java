/*
 * NeoForge port of ThreadTweak by getchoo (https://modrinth.com/mod/threadtweak), MIT licensed.
 */
package io.github.mddarmawan.threadtweak.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.mddarmawan.threadtweak.ThreadTweakConfigHolder;
import net.minecraft.client.main.Main;

@Mixin(Main.class)
public class ClientMainMixin {
    @Inject(method = "main", at = @At("HEAD"), remap = false)
    private static void threadtweak$setGamePriority(String[] args, CallbackInfo ci) {
        Thread.currentThread().setPriority(ThreadTweakConfigHolder.get().game);
    }
}
