package dev.offhandutility.mixin;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MultiPlayerGameMode.class)
public abstract class MultiPlayerGameModeMixin {
    @Redirect(
        method = {"destroyBlock", "startDestroyBlock"},
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/player/Player;getMainHandItem()Lnet/minecraft/world/item/ItemStack;"
        )
    )
    private ItemStack offhandUtility$useSuitableToolForBlock(Player player) {
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();
        MultiPlayerGameMode gameMode = (MultiPlayerGameMode) (Object) this;
        return main.isEmpty() ? off : main;
    }
}
