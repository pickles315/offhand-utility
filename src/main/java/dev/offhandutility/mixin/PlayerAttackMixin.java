package dev.offhandutility.mixin;

import dev.offhandutility.OffhandToolHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class PlayerAttackMixin {
    @Redirect(
            method = "attack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Player;getMainHandItem()Lnet/minecraft/world/item/ItemStack;"
            )
    )
    private ItemStack offhandUtility$useOffhandSwordForAttack(Player player) {
        return OffhandToolHelper.shouldUseOffhandForAttack(player)
                ? player.getOffhandItem()
                : player.getMainHandItem();
    }
}
