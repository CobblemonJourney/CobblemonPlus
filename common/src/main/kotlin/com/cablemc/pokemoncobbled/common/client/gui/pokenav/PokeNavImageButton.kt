package com.cablemc.pokemoncobbled.common.client.gui.pokenav

import com.cablemc.pokemoncobbled.common.client.CobbledResources
import com.cablemc.pokemoncobbled.common.api.gui.ColourLibrary
import com.cablemc.pokemoncobbled.common.api.gui.blitk
import com.cablemc.pokemoncobbled.common.api.gui.drawCenteredText
import com.mojang.blaze3d.vertex.MatrixStack
import net.minecraft.client.gui.components.ImageButton
import net.minecraft.text.Text
import net.minecraft.util.Identifier

class PokeNavImageButton(
    val posX: Int, val posY: Int,
    pX: Int, pY: Int,
    pWidth: Int, pHeight: Int,
    pXTexStart: Int, pYTexStart: Int, pYDiffText: Int,
    private val resourceLocation: Identifier, pTextureWidth: Int, pTextureHeight: Int,
    onPress: OnPress,
    private val text: Text
): ImageButton(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffText, resourceLocation, pTextureWidth, pTextureHeight, onPress) {
    override fun renderButton(pMatrixStack: MatrixStack, pMouseX: Int, pMouseY: Int, pPartialTicks: Float) {
        // Render Button Image
        blitk(
            poseStack = pMatrixStack,
            texture = resourceLocation,
            x = x, y = y + 0.25,
            width = width, height = height
        )

        pMatrixStack.push()
        val scale = 0.5F
        pMatrixStack.scale(scale, scale, scale)
        // Draw Text
        drawCenteredText(
            poseStack = pMatrixStack,
            font = CobbledResources.NOTO_SANS_BOLD,
            text = text,
            x = (x + width / 2) / scale, y = (y + height + 3) / scale,
            colour = ColourLibrary.WHITE, shadow = false
        )

        pMatrixStack.pop()
    }
}