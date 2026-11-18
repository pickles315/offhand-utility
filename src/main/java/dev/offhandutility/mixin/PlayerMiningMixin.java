package dev.offhandutility.mixin;

import dev.offhandutility.OffhandToolHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMiningMixin {
    @Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
    private void offhandUtility$useOffhandMiningSpeed(
            BlockState state,
            CallbackInfoReturnable<Float> cir
    ) {
        Player player = (Player) (Object) this;
        if (!OffhandToolHelper.shouldUseOffhand(player, state)) {
            return;
        }

        float mainSpeed = player.getMainHandItem().getDestroySpeed(state);
        float offhandSpeed = player.getOffhandItem().getDestroySpeed(state);
        if (mainSpeed > 0.0F) {
            cir.setReturnValue(cir.getReturnValue() * (offhandSpeed / mainSpeed));
        }
    }

    @Inject(method = "hasCorrectToolForDrops", at = @At("RETURN"), cancellable = true)
    private void offhandUtility$useOffhandForDrops(
            BlockState state,
            CallbackInfoReturnable<Boolean> cir
    ) {
        Player player = (Player) (Object) this;
        if (OffhandToolHelper.shouldUseOffhand(player, state)) {
            cir.setReturnValue(true);
        }
    }
}
