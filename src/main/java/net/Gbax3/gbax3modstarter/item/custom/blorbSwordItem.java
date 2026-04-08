package net.Gbax3.gbax3modstarter.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class blorbSwordItem extends SwordItem {
    public blorbSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        double x = pContext.getClickedPos().getX();
        double y = pContext.getClickedPos().getY();
        double z = pContext.getClickedPos().getZ();
        LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, pContext.getLevel());
        lightning.setVisualOnly(false);
        lightning.setDamage(5f);
        lightning.moveTo(pContext.getClickedPos(), 0, 0);
        pContext.getLevel().addFreshEntity(lightning);
        pContext.getLevel().explode(null, x, y, z, 9, Level.ExplosionInteraction.TNT);
        pContext.getPlayer().sendSystemMessage(Component.literal("ZAP!!"));

        return InteractionResult.SUCCESS;
    }
}
