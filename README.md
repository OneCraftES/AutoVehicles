# AutoVehicles
This is a fork for [AutoMinecart by Tisleo](). It was made to add new functionality regarding boats so players can travel easily trough premade areas in OneCraft.

In our implementation, we use [ExtraContexts](https://github.com/LuckPerms/ExtraContexts) plugin with [LuckPerms](https://github.com/LuckPerms/LuckPerms) to allow the permission `autominecart.use` only in concrete regions of [WorldGuard](https://github.com/EngineHub/WorldGuard).

The fork was updated to the [Paper 1.21.3 API](https://papermc.io/), and is compatible with Spigot servers from 1.21.3 onwards due to how boats are managed in the newest versions of Minecraft. If you want similar features for older versions of Minecraft, you should use/fork [this commit](https://github.com/OneCraftES/AutoVehicles/commit/970385b7da12a8c68885cfc181949c6d1b84edd3) to allow compatibility from version 1.18 to 1.21.1.

### **Features**
- Allows players to right-click a rail (excluding Activator Rails), different types of ice or the blocks under blocks of water with an empty hand and get teleported into an automatically-spawned minecart or boat.
- Minecarts and boats will automatically be deleted once a player gets out
- Add/remove disabled worlds in the `config.yml` file
- Use the permission `autominecart.use` to allow non-OP players to use the plugin
- Use the `/togglecart` command to toggle the functionality on or off for yourself
- **Note:** due to how Minecraft handles powered rails, if travelling over one, *it must be powered on*. Additionally, having too many corner rails close together may cause the vehicle to fly off-track due to speed.

### **Installation**
1. Build the source package using Maven 
2. Take the `.jar` file from the target directory
3. Add the `.jar` file to your server's `plugins` folder
4. Reload/restart your server
5. Enjoy!

### **Help**
This fork comes "as-it-is" without warranties of any type. Since its primary use is its implementation in the OneCraft server, fixes and new features will come as needed by the implementation in the production server.
