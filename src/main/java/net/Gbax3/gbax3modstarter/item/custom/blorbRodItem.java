package net.Gbax3.gbax3modstarter.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.ObjectUtils;

public class blorbRodItem extends Item {
    public blorbRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        double x = pContext.getClickedPos().getX();
        double y = pContext.getClickedPos().getY();
        double z = pContext.getClickedPos().getZ();
        if(!pContext.getLevel().isRaining()){
            pContext.getLevel().explode(null, x, y, z, 5, Level.ExplosionInteraction.TNT);
            pContext.getPlayer().sendSystemMessage(Component.literal("KABOOOM!!!!"));
        } else {
            pContext.getPlayer().sendSystemMessage(Component.literal(":("));
        }


        return InteractionResult.SUCCESS;
    }
}
