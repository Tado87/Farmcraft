package net.minecraft.src;

import java.util.Random;

public class BlockLoaf extends BlockCake {
	
    protected BlockLoaf(int i) {
        super(i, 121 + 48);
        setTickOnLoad(true);
        
        setHardness(0.5F);
        setStepSound(soundClothFootstep);
        setBlockName("loaf");
        disableStats();
        setRequiresSelfNotify();
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
        eatLoafSlice(world, i, j, k, entityplayer);
        return true;
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {
        eatLoafSlice(world, i, j, k, entityplayer);
    }

    private void eatLoafSlice(World world, int i, int j, int k, EntityPlayer entityplayer) {
        if (entityplayer.canEat(false)) {
            entityplayer.getFoodStats().addStats(4, 0.1F);
            int l = world.getBlockMetadata(i, j, k) + 1;
            if (l >= 6)
                world.setBlockWithNotify(i, j, k, 0);
            else {
                world.setBlockMetadataWithNotify(i, j, k, l);
                world.markBlockAsNeedsUpdate(i, j, k);
            }
        }
    }
}
