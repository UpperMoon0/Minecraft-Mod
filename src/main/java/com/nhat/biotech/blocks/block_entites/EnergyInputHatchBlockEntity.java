package com.nhat.biotech.blocks.block_entites;

import com.nhat.biotech.view.io_hatches.energy.EnergyInputHatchMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class EnergyInputHatchBlockEntity extends EnergyHatchBlockEntity {
    public EnergyInputHatchBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.ENERGY_INPUT_HATCH.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menu.title.biotech.energy_input_hatch");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new EnergyInputHatchMenu(i, inventory, this);
    }
}
