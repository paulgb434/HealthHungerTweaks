package net.cerulan.healthhungertweaks.network;

import net.cerulan.healthhungertweaks.ModInfo;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class HealthHungerPacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MODID);
	
	public HealthHungerPacketHandler() {
		INSTANCE.registerMessage(MessageSyncHealthRegen.MessageSyncHealthRegenHandler.class, MessageSyncHealthRegen.class, 4, Side.CLIENT);
	}
}
