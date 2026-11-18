package dev.offhandutility.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMiningMixin {
    @Inject(method = "getDestroySpeed", at = @At("HEAD"), cancellable = true)
    private void offhandUtility$useOffhandMiningSpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
        Player player = (Player) (Object) this;
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();

        if (!main.isCorrectToolForDrops(state) && off.isCorrectToolForDrops(state)) {
            cir.setReturnValue(off.getDestroySpeed(state));
        }
    }
}
