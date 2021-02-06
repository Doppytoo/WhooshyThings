package net.mcreator.whooshythings.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.whooshythings.item.CoinItem;
import net.mcreator.whooshythings.WhooshyThingsModVariables;
import net.mcreator.whooshythings.WhooshyThingsModElements;

import java.util.function.Supplier;
import java.util.Map;

@WhooshyThingsModElements.ModElement.Tag
public class Withdraw1000Procedure extends WhooshyThingsModElements.ModElement {
	public Withdraw1000Procedure(WhooshyThingsModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Withdraw1000!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WhooshyThingsModVariables.PlayerVariables())).Balance) >= 64)) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(CoinItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayerEntity) {
									Container _current = ((ServerPlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
											if (stack != null)
												return stack.getCount();
										}
									}
								}
								return 0;
							}
						}.getAmount((int) (1))) + 64));
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			{
				double _setval = (double) (((entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WhooshyThingsModVariables.PlayerVariables())).Balance) - 64);
				entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
