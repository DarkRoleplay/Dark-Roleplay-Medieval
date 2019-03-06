package net.dark_roleplay.medieval.one_twelve.objects.other;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;

import net.minecraft.nbt.NBTTagCompound;

public class ImageConversion {

	public static NBTTagCompound imgToNBT(BufferedImage img){
		NBTTagCompound imgNBT = new NBTTagCompound();

		int[] imageBytes = ((DataBufferInt) img.getData().getDataBuffer()).getData();

		imgNBT.setInt("width", img.getWidth());
		imgNBT.setInt("height", img.getHeight());
		imgNBT.setIntArray("imgBuf", imageBytes);

		return imgNBT;
	}

	public static BufferedImage imgFromNBT(NBTTagCompound imgNBT){
		if(!imgNBT.hasKey("width") || !imgNBT.hasKey("height") || !imgNBT.hasKey("imgBuf")){
			return null;
		}

		int width = imgNBT.getInt("width");
		int height = imgNBT.getInt("height");
		int[] imgBuf = imgNBT.getIntArray("imgBuf");

		if(imgBuf == null)
			return null;

		return intArToBuf(width, height, imgBuf);
	}

	public static BufferedImage intArToBuf(int width, int height, int[] imageBuf){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		image.setData(Raster.createRaster(image.getSampleModel(), new DataBufferInt(imageBuf, imageBuf.length), new Point()));
		return image;
	}

	public static int[] bufToIntAr(BufferedImage img){
		return ((DataBufferInt) img.getData().getDataBuffer()).getData();
	}
}
