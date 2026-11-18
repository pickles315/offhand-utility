# Offhand Utility

A Fabric mod for Minecraft Java Edition 26.2.

When your main-hand item is not the correct tool for a block, Offhand Utility uses a suitable offhand tool for mining speed and server-side block breaking. Your inventory slots are not swapped.

## Build

The GitHub Actions workflow builds the mod automatically on pushes to `main`, pull requests, and manual workflow dispatches.

After a successful run, open **Actions**, select **Build Fabric Mod**, and download the `offhand-utility-fabric-26.2` artifact. The JAR inside goes in your Minecraft `mods` folder.

## Requirements

- Minecraft Java Edition 26.2
- Fabric Loader 0.19.3 or newer
- Fabric API for Minecraft 26.2
- Java 25

## Current scope

The initial implementation focuses on block mining with a suitable offhand tool. It is an early build and still needs in-game testing, especially for block drops, durability, and multiplayer behavior.
