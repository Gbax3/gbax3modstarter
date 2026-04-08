package net.Gbax3.gbax3modstarter.item;

import net.Gbax3.gbax3modstarter.gbax3modstarter;
import net.Gbax3.gbax3modstarter.item.custom.blorbRodItem;
import net.Gbax3.gbax3modstarter.item.custom.blorbSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Tiers.*;

public class modItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, gbax3modstarter.MODID);

    public static final RegistryObject<Item> ORB = ITEMS.register("orb",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOB = ITEMS.register("blob",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLORB_ROD = ITEMS.register("blorb_rod",
            () -> new blorbRodItem(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> BLORB_SWORD = ITEMS.register("blorb_sword",
            () -> new blorbSwordItem(DIAMOND, 10, 15, new Item.Properties().durability(5000)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
