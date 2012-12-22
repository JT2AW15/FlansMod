package co.uk.flansmods.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPart extends Item
{
	public ItemPart(int i, PartType type1)
	{
		super(i);
		type = type1;
		setIconIndex(type.iconIndex);
		setMaxStackSize(type.stackSize);
		if (type.category == 9)
		{
			setMaxDamage(type.fuel);
			setHasSubtypes(true);
		}
		type.item = this;
		setCreativeTab(FlansMod.tabFlanParts);
	}

	public String getTextureFile()
	{
		return "/spriteSheets/parts.png";
	}

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
    	return type.colour;
    }

	public PartType type;
}