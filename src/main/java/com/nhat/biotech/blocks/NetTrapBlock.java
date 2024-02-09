package com.nhat.biotech.blocks;

import com.nhat.biotech.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NetTrapBlock extends Block {
    public NetTrapBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion());
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Block.box(0,0,0,16,1,16);
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (!level.isClientSide) {
            if (entity instanceof Cow) {
                level.destroyBlock(blockPos, false);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!((Cow) entity).isBaby()) {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.COW.get()));
                    level.addFreshEntity(itemEntity);
                } else {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.BABY_COW.get()));
                    level.addFreshEntity(itemEntity);
                }
            }
            if (entity instanceof Chicken) {
                level.destroyBlock(blockPos, false);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!((Chicken) entity).isBaby()) {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.CHICKEN.get()));
                    level.addFreshEntity(itemEntity);
                } else {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.BABY_CHICKEN.get()));
                    level.addFreshEntity(itemEntity);
                }
            }
            if (entity instanceof Pig) {
                level.destroyBlock(blockPos, false);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!((Pig) entity).isBaby()) {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.PIG.get()));
                    level.addFreshEntity(itemEntity);
                } else {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.BABY_PIG.get()));
                    level.addFreshEntity(itemEntity);
                }
            }
            if (entity instanceof Sheep) {
                level.destroyBlock(blockPos, false);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!((Sheep) entity).isBaby()) {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.SHEEP.get()));
                    level.addFreshEntity(itemEntity);
                } else {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.BABY_SHEEP.get()));
                    level.addFreshEntity(itemEntity);
                }
            }
            if (entity instanceof Rabbit) {
                level.destroyBlock(blockPos, false);

                entity.remove(Entity.RemovalReason.KILLED);

                if (!((Rabbit) entity).isBaby()) {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.RABBIT.get()));
                    level.addFreshEntity(itemEntity);
                } else {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.BABY_RABBIT.get()));
                    level.addFreshEntity(itemEntity);
                }
            }
        }
    }
}
