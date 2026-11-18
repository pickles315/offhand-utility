# Offhand Utility

Offhand Utility is a Fabric mod for Minecraft Java Edition 26.2.

When your main hand holds something other than a suitable tool, the mod can use a suitable item from your offhand without swapping inventory slots:

- **Mining:** uses an effective pickaxe, axe, or shovel from the offhand for mining speed, correct-tool checks, drops, and durability.
- **Attacking:** uses an offhand sword for attacks when your main hand is not holding a sword.

## Build

GitHub Actions builds the mod automatically when commits are pushed to `main`, when a pull request is opened, or when the workflow is manually run.

1. Open the **Actions** tab.
2. Select **Build Fabric Mod**.
3. Open a successful run and download the `offhand-utility-fabric-26.2` artifact.
4. Put the JAR from the ZIP into your Minecraft `mods` folder.

## Requirements

- Minecraft Java Edition 26.2
- Fabric Loader 0.20.1 or newer
- Fabric API for Minecraft 26.2
- Java 25

## Notes

The mod keeps items in their original inventory slots. The offhand sword feature changes which stack is used for the player's attack calculations and item durability; the offhand swing animation and compatibility with other combat mods still need in-game verification.
