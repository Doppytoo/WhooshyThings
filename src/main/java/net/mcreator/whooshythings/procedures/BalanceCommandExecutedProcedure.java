package net.mcreator.whooshythings.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.whooshythings.WhooshyThingsModVariables;
import net.mcreator.whooshythings.WhooshyThingsModElements;

import java.util.Map;
import java.util.HashMap;

@WhooshyThingsModElements.ModElement.Tag
public class BalanceCommandExecutedProcedure extends WhooshyThingsModElements.ModElement {
	public BalanceCommandExecutedProcedure(WhooshyThingsModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BalanceCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure BalanceCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BalanceCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BalanceCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BalanceCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BalanceCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("set"))) {
			{
				double _setval = (double) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()));
				entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("add"))) {
			{
				double _setval = (double) (((entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WhooshyThingsModVariables.PlayerVariables())).Balance) + new Object() {
							int convert(String s) {
								try {
									return Integer.parseInt(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("1");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())));
				entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("subtract"))) {
			{
				double _setval = (double) (((entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WhooshyThingsModVariables.PlayerVariables())).Balance) - new Object() {
							int convert(String s) {
								try {
									return Integer.parseInt(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("1");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())));
				entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Balance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("query"))) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						(("say Your balance is ") + "" + (((entity.getCapability(WhooshyThingsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new WhooshyThingsModVariables.PlayerVariables())).Balance))));
			}
		}
	}
}
