# Offhand Utility

Offhand Utility is a Fabric mod for Minecraft Java Edition 26.2.

When the item in your main hand is not an effective tool for a block, the mod can use a better tool from your offhand for mining speed, tool checks, drops, and durability. Your inventory slots are not swapped.

## Build

GitHub Actions builds the mod automatically when commits are pushed to `main`, when a pull request is opened, or when the workflow is manually run.

1. Open the **Actions** tab.
2. Select **Build Fabric Mod**.
3. Open a successful run and download the `offhand-utility-fabric-26.2` artifact.
4. Put the JAR from the ZIP into your Minecraft `mods` folder.

## Requirements

- Minecraft Java Edition 26.2
- Fabric Loader 0.19.3 or newer
- Fabric API for Minecraft 26.2
- Java 25

## Current implementation

The first release focuses on block mining. It chooses the offhand when it is the correct tool for blocks that require one, or when it has a higher block-breaking speed for blocks that do not require a specific tool. It keeps the items in their original slots.

This is an early build. It still needs an in-game check for the offhand swing animation, adventure-mode restrictions, and compatibility with other mods.

