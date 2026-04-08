package net.Gbax3.gbax3modstarter.item;

import net.Gbax3.gbax3modstarter.block.modBlocks;
import net.Gbax3.gbax3modstarter.gbax3modstarter;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;

public class creativeModeTabsTemplate {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS_TEMPLATE =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, gbax3modstarter.MODID);

    public static final RegistryObject<CreativeModeTab> TEMPLATE_TAB_NAME =
            CREATIVE_MODE_TABS_TEMPLATE.register("blorbin", () -> CreativeModeTab.builder().icon(() -> new ItemStack(modItems.ORB.get()))
                    .title(Component.translatable("creativetab.template_tab_name"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(modItems.ORB.get());
                        output.accept(modItems.BLOB.get());
                        output.accept(modItems.BLORB_ROD.get());
                        output.accept(modItems.BLORB_SWORD.get());
                        output.accept(modBlocks.BLORB.get());
                        output.accept(modBlocks.BLORE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS_TEMPLATE.register(eventBus);
    }
}
