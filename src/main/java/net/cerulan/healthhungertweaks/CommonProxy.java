package net.cerulan.healthhungertweaks;

import net.cerulan.healthhungertweaks.capability.healthregen.HealthRegenCapabilityHandler;
import net.cerulan.healthhungertweaks.handler.HealthHungerHandler;
import net.cerulan.healthhungertweaks.network.HealthHungerPacketHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy {

	public HealthHungerPacketHandler packetHandler;
	
	protected HealthHungerHandler handler; 
	
	public void init() {
		handler =  new HealthHungerHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		packetHandler = new HealthHungerPacketHandler();
		
		HealthRegenCapabilityHandler healthRegenCapHand = new HealthRegenCapabilityHandler();
		healthRegenCapHand.register();
		MinecraftForge.EVENT_BUS.register(healthRegenCapHand);
	}

	/**
	 * Returns a side-appropriate EntityPlayer for use during message handling
	 */
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}

	/**
	 * Returns the current thread based on side during message handling, used
	 * for ensuring that the message is being handled by the main thread
	 */
	public IThreadListener getThreadFromContext(MessageContext ctx) {
		return ctx.getServerHandler().player.getServer();
	}
	
}
