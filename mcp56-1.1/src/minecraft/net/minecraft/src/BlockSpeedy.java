
package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockSpeedy extends Block
{
    private int data = 0;
    private int speed = 10;
    private static int texture = 202;
    private boolean slope = false;
	
    protected BlockSpeedy(int i) {
        super(i, texture, Material.sand);
        
        setBlockUnbreakable();
        setResistance(6000000F);
        setStepSound(soundStoneFootstep);
        setLightValue(1.0F);
        setBlockName("BlockSpeedy");
        //setRequiresSelfNotify();
    }

    
    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderType() {
        return 28;
    }

    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
    	
        data = world.getBlockMetadata(i, j, k);
        if (data == 0) {
        	
            if (isSpeedyAt(world, i, j -1, k +1)) {
            	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                slope = true;
            } else if (isSpeedyAt(world, i, j -1, k -1)) {
                setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                slope = true;
            } else {
            	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            	super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                slope = false;
            }
            
        } else if (data == 1) {

            if (isSpeedyAt(world, i +1, j -1, k)) {
                setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                slope = true;
            } else if (isSpeedyAt(world, i -1, j -1, k)) {
                setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                slope = true;
            } else {
            	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            	super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
                slope = false;
            }

        }

        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if (l == 0) world.setBlockMetadataWithNotify(i, j, k, 0);
        if (l == 1) world.setBlockMetadataWithNotify(i, j, k, 1);
        if (l == 2) world.setBlockMetadataWithNotify(i, j, k, 0);
        if (l == 3) world.setBlockMetadataWithNotify(i, j, k, 1);
    }
    


    public boolean isSpeedyAt(IBlockAccess iblockaccess, int i, int j, int k) {
        int l = iblockaccess.getBlockId(i, j, k);
        if (l == blockID) return true;
        return false;
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int meta) {
        if (meta == 0) 	return 202;
        else 			return (202-16);
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
    	if (!slope && data == 0) 	  entity.motionZ += 2*(entity.motionZ/Math.abs(entity.motionZ));
        else if (!slope && data == 1) entity.motionX += 2*(entity.motionX/Math.abs(entity.motionX));
    	if (entity.motionZ > speed) entity.motionZ = speed;
        if (entity.motionX > speed) entity.motionX = speed;
    	if (entity.motionZ < -speed) entity.motionZ = -speed;
        if (entity.motionX < -speed) entity.motionX = -speed;
    }
       
    

}