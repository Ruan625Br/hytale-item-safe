package sample

import io.github.ruan625br.hytale.item.safe.generated.Assets
import io.github.ruan625br.hytale.item.safe.annotations.HytaleItem
import io.github.ruan625br.hytale.item.safe.dsl.builders.hytaleItem
import io.github.ruan625br.hytale.item.safe.dsl.registry.ResourceRegistry

@HytaleItem(id = "My_New_block", "Blocks")
object MyNewBlock : ResourceRegistry {
    override val definition = hytaleItem {
        name("My Button A")
        icon(Assets.Icons.Blocks.GameBoy_Button_A)
        category("Furniture.Benches")

        iconProperties(
            scale = 0.595,
            tx = 0.1,
            ty = -19.1,
            rx = 22.5,
            ry = 45.0,
            rz = 22.5
        )

        interactions {
            primary("Block_Primary")
            secondary("Block_Secondary")
        }

        blockType {
            material = "Solid"
            drawType = "Model"
            group = "Cloth"

            particleSetId = "Dust"

            customModel = Assets.Items.Models.GameBoy_Button_A
            texture(Assets.Items.Texture.GameBoy_Button_A_Texture)

            soundSetId = "Cloth"
            particleColor = "#f5f5f5"
        }
        playerAnimation("Block")

        tag("Type", "Cloth")
        soundSet("ISS_Items_Cloth")
    }
}
