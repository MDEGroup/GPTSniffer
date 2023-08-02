package net.mastermank.corridorsbackrooms.event;

import net.mastermank.corridorsbackrooms.CorridorsBackrooms;
import net.mastermank.corridorsbackrooms.entity.BackroomsEntityRegistry;
import net.mastermank.corridorsbackrooms.entity.custom.*;
import net.mastermank.corridorsbackrooms.sanity.PlayerSanity;
import net.mastermank.corridorsbackrooms.sanity.PlayerSanityProvider;
import net.mastermank.corridorsbackrooms.world.dimension.BackroomsLevels;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {

    @Mod.EventBusSubscriber(modid = CorridorsBackrooms.MOD_ID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = CorridorsBackrooms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(BackroomsEntityRegistry.SMILER.get(), SmilerEntity.setAttributes());
            event.put(BackroomsEntityRegistry.DECAYEDGLORY.get(), DecayedGloryEntity.setAttributes());
            event.put(BackroomsEntityRegistry.BASHER.get(), BasherEntity.setAttributes());
            event.put(BackroomsEntityRegistry.PARTYGOER.get(), PartygoerEntity.setAttributes());
            event.put(BackroomsEntityRegistry.HOUND.get(), HoundEntity.setAttributes());

            MinecraftForge.EVENT_BUS.register(ModEvents.class);
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerSanityProvider.PLAYER_SANITY).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerSanityProvider.PLAYER_SANITY).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerSanity.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerSanityProvider.PLAYER_SANITY).ifPresent(sanity -> {
                if (sanity.getSanity() > 0 && event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    sanity.subsanity(1);
                }
            });
        }
    }
    @SubscribeEvent
    public static void onPartygoerPlayerKill(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (!(event.getSource().getEntity() instanceof PartygoerEntity)) return;
            PartygoerEntity partygoer =
                    BackroomsEntityRegistry.PARTYGOER.get().create(event.getEntity().getLevel());
            EntityType.PLAYER.create(event.getEntity().getLevel());
            partygoer.setPos(player.getX(), player.getY(), player.getZ());
            event.getEntity().level.addFreshEntity(partygoer);
        }
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onSpecialSpawn(LivingSpawnEvent.SpecialSpawn event) {
        if (!event.getLevel().isClientSide() && (event.getEntity() instanceof Zombie && !(event.getSpawnReason() == MobSpawnType.SPAWN_EGG) && !(event.getSpawnReason() == MobSpawnType.COMMAND))) {
            if (event.getEntity().level.dimension().equals(BackroomsLevels.LEVEL0)) {
                event.getEntity().discard();
            }
        }
    }
}