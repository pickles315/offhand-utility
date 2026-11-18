package dev.offhandutility.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeMixin {
    @Redirect(
        method = "destroyBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerPlayer;getMainHandItem()Lnet/minecraft/world/item/ItemStack;"
        )
    )
    private ItemStack offhandUtility$useOffhandForBlockBreak(ServerPlayer player, BlockPos pos) {
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();
        BlockState state = player.level().getBlockState(pos);

        if (!main.isCorrectToolForDrops(state) && off.isCorrectToolForDrops(state)) {
            return off;
        }

        return main;
    }
}
