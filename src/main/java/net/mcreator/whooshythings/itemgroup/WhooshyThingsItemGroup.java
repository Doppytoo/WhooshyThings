
package net.mcreator.whooshythings.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.whooshythings.item.CoinItem;
import net.mcreator.whooshythings.WhooshyThingsModElements;

@WhooshyThingsModElements.ModElement.Tag
public class WhooshyThingsItemGroup extends WhooshyThingsModElements.ModElement {
	public WhooshyThingsItemGroup(WhooshyThingsModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwhooshy_things") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CoinItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
