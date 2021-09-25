package jp.sophia;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public class PermissionController {
    LuckPerms api = LuckPermsProvider.get();

    /**
     *
     * @param user entity
     * @param permission permission strings
     */
    public void addPermission(User user, String permission) {
        //add some permissions here
        user.data().add(Node.builder(permission).build());

        api.getUserManager().saveUser(user);
    }

    /**
     *
     * @param uuid uniquer ID
     * @param permission permission strings
     */
    public void addPermissionWithUuid(UUID uuid, String permission) {
        api.getUserManager().modifyUser(uuid, user -> {
            user.data().add(Node.builder(permission).build());
        });
    }

    /**
     *
     * returns which group the player belongs
     *
     * @param player entity
     * @param possibleGroups collection of available groups
     * @return String
     */
    public static String getPlayerGroup(Player player, Collection<String> possibleGroups) {
        for (String group : possibleGroups) {
            if (player.hasPermission("group." + group)) {
                return group;
            }
        }
        return null;
    }
}
