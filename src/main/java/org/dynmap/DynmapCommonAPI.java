package org.dynmap;

import org.dynmap.markers.MarkerAPI;

/**
 * This is the interface representing the published API for the Dynmap plugin, common for all Dynmap
 * implementations (not Bukkit specific).  
 */
public interface DynmapCommonAPI {
    /**
     * This method can return null if the 'markers' component has not been configured - 
     * a warning message will be issued to the server.log in this event.
     * 
     * @return MarkerAPI, or null if not configured
     */
    public MarkerAPI getMarkerAPI();
    /**
     * Test if the marker API has been initialized yet
     *
     * @return true if it has been initialized
     */
    public boolean markerAPIInitialized();
    /**
     * Send generic message to all web users
     * @param sender - label for sender of message ("Message from <plugin>:") - if null, no from notice
     * @param msg - message to be sent
     */
    public boolean sendBroadcastToWeb(String sender, String msg);
    /**
     * Trigger update on tiles associated with given locations.  The volume is the rectangular prism ("cuboid") 
     * with the two locations on opposite corners, (minx, miny, minz) and (maxx, maxy, maxz).
     * 
     * @param wid - world ID
     * @param minx - minimum x of volume
     * @param miny - minimum y of volume
     * @param minz - minimum z of volume
     * @param maxx - maximum x of volume
     * @param maxy - maximum y of volume
     * @param maxz - maximum z of volume
     * 
     * @return number of tiles queued to be rerendered
     */
    public int triggerRenderOfVolume(String wid, int minx, int miny, int minz, int maxx, int maxy, int maxz);
    /**
     * Trigger update on tiles associated with given block location.
     *  
     * @param wid - world ID
     * @param x - x coordinate of block
     * @param y - y coordinate of block
     * @param z - z coordinate of block
     * 
     * @return number of tiles queued to be rerendered
     */
    public int triggerRenderOfBlock(String wid, int x, int y, int z);
    /*
     * Pause full/radius render processing
     * @param dopause - true to pause, false to unpause
     */
    public void setPauseFullRadiusRenders(boolean dopause);
    /*
     * Test if full renders are paused
     */
    public boolean getPauseFullRadiusRenders();
    /*
     * Pause update render processing
     * @param dopause - true to pause, false to unpause
     */
    public void setPauseUpdateRenders(boolean dopause);
    /*
     * Test if update renders are paused
     */
    public boolean getPauseUpdateRenders();
    /**
     * Set player visibility
     * @param player - player ID
     * @param is_visible - true if visible, false if hidden
     */
    public void setPlayerVisiblity(String player, boolean is_visible);
    /**
     * Test if player is visible
     * @param player - player ID
     * 
     * @return true if visible, false if not
     */
    public boolean getPlayerVisbility(String player);
    /**
     * Post message from player to web
     * @param playerid - player ID
     * @param playerdisplay - player display name
     * @param message - message text
     */
    public void postPlayerMessageToWeb(String playerid, String playerdisplay, String message);
    /**
     * Post join/quit message for player to web
     * @param playerid - player ID
     * @param playerdisplay - player display name
     * @param isjoin - if true, join message; if false, quit message
     */
    public void postPlayerJoinQuitToWeb(String playerid, String playerdisplay, boolean isjoin);
    /**
     * Get version of dynmap core
     * @return version - format is "major.minor-build" or "major.minor.patch-build"
     */
    public String getDynmapCoreVersion();
}
