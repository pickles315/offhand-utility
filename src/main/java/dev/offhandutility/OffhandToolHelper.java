package dev.offhandutility;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

/** Selects the offhand only when it is a better tool for this block. */
public final class OffhandToolHelper {
    private OffhandToolHelper() {
    }

    public static boolean shouldUseOffhand(Player player, BlockState state) {
        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();

        if (offHand.isEmpty()) {
            return false;
        }

        if (state.requiresCorrectToolForDrops()) {
            return !mainHand.isCorrectToolForDrops(state)
                    && offHand.isCorrectToolForDrops(state);
        }

        return offHand.getDestroySpeed(state) > mainHand.getDestroySpeed(state);
    }
}
