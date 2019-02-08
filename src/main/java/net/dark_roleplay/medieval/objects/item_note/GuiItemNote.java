package net.dark_roleplay.medieval.objects.item_note;

import java.io.IOException;
import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.core_modules.guis.api.components.Component;
import net.dark_roleplay.core_modules.guis.api.components.DRPGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;

public class GuiItemNote extends DRPGuiScreen{

	public GuiItemNote() {
		TextArea area = new TextArea(4, null);

		area.setPos(150, 100);
		area.setSize(150, 48);
		this.addComponent(area);
	}

	@Override
	public void drawBackground(int mouseX, int mouseY, float partialTicks) {
		super.drawBackground(mouseX, mouseY, partialTicks);
	}

	@Override
	public void drawForeground(int mouseX, int mouseY, float partialTicks) {}


	public static class TextArea extends Component {
		int lineCount = 0;

		int cursorPosition = 0, cursorX = 0, cursorY = 0;
		float cursorDisplayTick = 0;

		int selectionX = 0, selectionY = 0;

		String text = "This is a little bit, longer testing text,\n I wanna see. How it behaves";

		public TextArea(int lines, @Nullable String text) {
			if(text != null)
				this.text = text;

			this.lineCount = lines;
		}

		@Override
		public ResourceLocation getTexture() {
			return null;
		}

		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			FontRenderer font = Minecraft.getMinecraft().fontRenderer;

			Gui.drawRect(this.posX, this.posY, this.posX + super.width, this.posY + super.height, 0xFFFFFFCC);

			List<String> splittedText = font.listFormattedStringToWidth(this.text, this.width - 4);

			int cursorY = 0;
			int remainingCursorPos = this.cursorPosition;

			for(int i = 0; i < splittedText.size(); i++) {
				String line = splittedText.get(i);
				font.drawString(line, this.posX + 2, this.posY + 2 + i * 10, 0x0);

				if(remainingCursorPos >= 0)
				if(line.length() < remainingCursorPos) {
					remainingCursorPos -= line.length() + 1;
					cursorY += 1;

				}else {
					int cursorX = font.getStringWidth(line.substring(0, remainingCursorPos));
					if(this.cursorDisplayTick <= 15) {
						font.drawString(line.length() == remainingCursorPos ? "_" : "|", this.posX + cursorX + 2, this.posY + 2 + i * 10, 0xFFFF0000);
					}
					remainingCursorPos = -1;
				}
			}

			this.cursorDisplayTick += partialTicks;
			if(this.cursorDisplayTick > 30)
				this.cursorDisplayTick = 0;
		}

		@Override
		public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
			FontRenderer font = Minecraft.getMinecraft().fontRenderer;

//			int height = mouseY - this.posY - 2;
//			this.selectedLine = Math.min((int) (height / 10F), this.lines);

			return true;
		}

		@Override
		public void keyTyped(char typedChar, int keyCode) throws IOException {
			String editedText = this.text;

			System.out.println(keyCode);

			switch(keyCode) {
				case 14:
					if(this.cursorPosition <= 0) break;
					this.text = this.text.substring(0, this.cursorPosition -1) + this.text.substring(this.cursorPosition, this.text.length());
					this.cursorPosition -= 1;
					break;
				case 211:
					if(this.cursorPosition >= this.text.length()) break;
					this.text = this.text.substring(0, this.cursorPosition) + this.text.substring(this.cursorPosition + 1, this.text.length());
				case 200:
					this.moveCursorY(-1);
					break;
				case 208:
					this.moveCursorY(1);
					break;
				case 205:
					this.moveCursor(+1);
					break;
				case 203:
					this.moveCursor(-1);
					break;
				case 28:
					this.addChar('\n');
					break;
				default:

					this.addChar(typedChar);
					break;
			}
		}

		private void moveCursor(int amount) {
			this.cursorPosition = Math.min(Math.max(this.cursorPosition + amount, 0), this.text.length());
			this.cursorDisplayTick = 0;
		}

		private void moveCursorY(int amount) {
			FontRenderer font = Minecraft.getMinecraft().fontRenderer;
			this.cursorDisplayTick = 0;

			List<String> splittedText = font.listFormattedStringToWidth(this.text, this.width - 4);

			int cursorY = 0;
			int remainingCursorPos = this.cursorPosition;

			for(int i = 0; i < splittedText.size(); i++) {
				String line = splittedText.get(i);

				if(remainingCursorPos >= 0)
				if(line.length() < remainingCursorPos) {
					remainingCursorPos -= line.length() + 1;
					cursorY += 1;
				}else {
					//Found currentPos;
					if(amount <= 0) {
						if(i >= 1)
							this.cursorPosition -= remainingCursorPos + 1;
					}else {
						if(i < splittedText.size())
							this.cursorPosition += line.length() - remainingCursorPos - 1;
					}
				}
			}
		}

		private void addChar(char typedChar) {
			FontRenderer font = Minecraft.getMinecraft().fontRenderer;
			//TODO do length, checks

			if(ChatAllowedCharacters.isAllowedCharacter(typedChar) || typedChar == '\n') {
				this.text = this.text.substring(0, this.cursorPosition) + typedChar + this.text.substring(this.cursorPosition, this.text.length());
				this.cursorPosition += 1;
			}
		}

		private void addText(String text) {
			for(int i = 0; i < text.length(); i++) {
				this.addChar(text.charAt(i));
			}
		}
	}
}
