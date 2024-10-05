package kamkeel.kingdomregions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kamkeel.kingdomregions.Network.PacketDispatcher;
import kamkeel.kingdomregions.Network.SyncPlayerPropsRegions;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWanderMap extends Item {
   public ItemWanderMap() {
      this.setMaxStackSize(1);
      this.setCreativeTab(CreativeTabs.tabTools);
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister iconRegister) {
      this.itemIcon = iconRegister.registerIcon("kingdomregions:runestone");
   }

   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if (!p_77659_2_.isRemote) {
         PacketDispatcher.sendTo(new SyncPlayerPropsRegions(p_77659_3_), (EntityPlayerMP)p_77659_3_);
         p_77659_3_.openGui(KingdomRegions.instance, 55, p_77659_3_.worldObj, (int)p_77659_3_.posX, (int)p_77659_3_.posY, (int)p_77659_3_.posZ);
      }

      return p_77659_1_;
   }
}
