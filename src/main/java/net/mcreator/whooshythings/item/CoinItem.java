
package net.mcreator.whooshythings.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.whooshythings.itemgroup.WhooshyThingsItemGroup;
import net.mcreator.whooshythings.WhooshyThingsModElements;

@WhooshyThingsModElements.ModElement.Tag
public class CoinItem extends WhooshyThingsModElements.ModElement {
	@ObjectHolder("whooshy_things:coin")
	public static final Item block = null;
	public CoinItem(WhooshyThingsModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(WhooshyThingsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("coin");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}
	}
}
