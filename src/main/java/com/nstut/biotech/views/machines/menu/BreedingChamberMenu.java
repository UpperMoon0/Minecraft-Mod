package com.nstut.biotech.views.machines.menu;

import com.nstut.biotech.machines.MachineRegistries;
import com.nstut.biotech.blocks.entites.machines.BreedingChamberBlockEntity;
import com.nstut.nstutlib.recipes.ModRecipeData;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BreedingChamberMenu extends MachineMenu {

    private final Level level;
    // Getters
    @Getter
    private final BreedingChamberBlockEntity blockEntity;
    private final BlockPos pos;

    @Setter
    @Getter
    private FluidStack fluidStored;
    @Setter
    @Getter
    private ModRecipeData recipe;

    // Setters
    @Setter
    private int energyCapacity;
    @Setter
    @Getter
    private int energyStored;
    @Setter
    @Getter
    private int energyConsumeRate;
    @Setter
    @Getter
    private int energyConsumed;
    @Setter
    @Getter
    private int recipeEnergyCost;
    @Setter
    private int fluidCapacity;
    private boolean isStructureValid;

    public int getEnergyCapacity() {
        return energyCapacity > 0? energyCapacity : 1;
    }

    public int getFluidCapacity() {
        return fluidCapacity > 0? fluidCapacity : 1;
    }

    public boolean getStructureValid() {
        return isStructureValid;
    }

    public void setStructureValid(boolean structureValid) {
        isStructureValid = structureValid;
    }

    public BreedingChamberMenu(int pContainerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(pContainerId, inventory, Objects.requireNonNull(inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos())));
    }

    public BreedingChamberMenu(int i, Inventory inventory, BlockEntity blockEntity) {
        super(MachineRegistries.BREEDING_CHAMBER.menu().get(), i);
        this.level = inventory.player.level();
        this.blockEntity = (BreedingChamberBlockEntity) blockEntity;
        this.pos = blockEntity.getBlockPos();
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(ContainerLevelAccess.create(level, pos), player, MachineRegistries.BREEDING_CHAMBER.block().get());
    }

    public boolean getIsOperating() {
        return recipe != null;
    }
}