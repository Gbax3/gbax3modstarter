package net.Gbax3.gbax3modstarter.block;

import net.Gbax3.gbax3modstarter.gbax3modstarter;
import net.Gbax3.gbax3modstarter.item.modItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, gbax3modstarter.MODID);



    public static final RegistryObject<Block> BLORB = registerBlock("blorb",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> BLORE = registerBlock("blore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .sound(SoundType.SLIME_BLOCK).strength(0.5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(20,50)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> blockToRegister = BLOCKS.register(name, block);
        registerBlockItem(name, blockToRegister);
        return blockToRegister;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
