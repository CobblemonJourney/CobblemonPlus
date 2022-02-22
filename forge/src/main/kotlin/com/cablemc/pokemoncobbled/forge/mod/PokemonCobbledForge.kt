package com.cablemc.pokemoncobbled.forge.mod

import com.cablemc.pokemoncobbled.common.CobbledEntities.POKEMON_TYPE
import com.cablemc.pokemoncobbled.common.CobbledNetwork
import com.cablemc.pokemoncobbled.common.PokemonCobbled
import com.cablemc.pokemoncobbled.common.PokemonCobbled.LOGGER
import com.cablemc.pokemoncobbled.common.PokemonCobbledModImplementation
import com.cablemc.pokemoncobbled.common.api.events.CobbledEvents
import com.cablemc.pokemoncobbled.common.api.reactive.Observable.Companion.filter
import com.cablemc.pokemoncobbled.common.api.reactive.Observable.Companion.takeFirst
import com.cablemc.pokemoncobbled.common.client.PokemonCobbledClient
import com.cablemc.pokemoncobbled.common.net.serverhandling.ServerPacketRegistrar
import com.cablemc.pokemoncobbled.common.util.ifClient
import com.cablemc.pokemoncobbled.forge.mod.config.CobbledConfig
import com.cablemc.pokemoncobbled.forge.mod.net.CobbledForgeNetworkDelegate
import dev.architectury.platform.forge.EventBuses
import net.minecraftforge.client.event.ModelBakeEvent
import net.minecraftforge.common.ForgeMod
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

object PokemonCobbledForge : PokemonCobbledModImplementation {
    init {
        with(FMLJavaModLoadingContext.get().modEventBus) {
            EventBuses.registerModEventBus(PokemonCobbled.MODID, this)

            CobbledEvents.ENTITY_ATTRIBUTE_EVENT.pipe(filter { it.entityType == POKEMON_TYPE }, takeFirst())
                .subscribe {
                    it.attributeSupplier
                        .add(ForgeMod.ENTITY_GRAVITY.get())
                        .add(ForgeMod.NAMETAG_DISTANCE.get())
                        .add(ForgeMod.SWIM_SPEED.get())
                        .add(ForgeMod.REACH_DISTANCE.get())
                }

            addListener(this@PokemonCobbledForge::initialize)
            addListener(this@PokemonCobbledForge::onBake)
//            addListener(this@PokemonCobbledForge::onEntityAttributeCreation)
            CobbledNetwork.networkDelegate = CobbledForgeNetworkDelegate

            PokemonCobbled.preinitialize(this@PokemonCobbledForge)
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CobbledConfig.spec)
    }

    fun initialize(event: FMLCommonSetupEvent) {
        LOGGER.info("Initializing...")

        PokemonCobbled.initialize()

        event.enqueueWork {
            ifClient { PokemonCobbledClient.initialize() }
            ServerPacketRegistrar.registerHandlers()
            CobbledNetwork.register()
        }

        MinecraftForge.EVENT_BUS.register(this)
    }

    fun onBake(event: ModelBakeEvent) {
        PokemonCobbledClient.reloadCodedAssets()
    }

    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        PokemonCobbled.onServerStarted(event.server)
    }
}