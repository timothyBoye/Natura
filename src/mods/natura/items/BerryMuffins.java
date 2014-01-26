package mods.natura.items;

import java.util.List;

import mods.natura.common.NaturaTab;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import codechicken.nei.api.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BerryMuffins extends ItemFood {
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	public String[] textureNames = new String[] {"muffin_apple", "muffin_blueberry", "muffin_raspberry", "muffin_maloberry", "muffin_blackberry"};
	
	public BerryMuffins(int id) {
		super(id, 8, 10, false);
		setCreativeTab(NaturaTab.tab);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
        return (new StringBuilder()).append("item.berryMuffin.").append(textureNames[itemStack.getItemDamage()]).toString();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[textureNames.length];
		for (int i = 0; i<icons.length; i++) {
			icons[i] = register.registerIcon("natura" + ":" + textureNames[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < textureNames.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
	
}
