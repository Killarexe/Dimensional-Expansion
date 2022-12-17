/*
 * Copyright 2017 John Grosh (john.a.grosh@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.killarexe.dimensional_expansion.client.integration.discord.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * An encapsulation of all data needed to properly construct a JSON RichPresence payload.
 *
 * <p>These can be built using {@link RichPresence.Builder}.
 *
 * @author John Grosh (john.a.grosh@gmail.com)
 */
public class RichPresence
{
    private final String state;
    private final String details;
    private final long startTimestamp;
    private final long endTimestamp;
    private final String largeImageKey;
    private final String largeImageText;
    private final String smallImageKey;
    private final String smallImageText;
    private final String partyId;
    private final int partySize;
    private final int partyMax;
    private final String matchSecret;
    private final String joinSecret;
    private final String spectateSecret;
    private final String button1Text;
    private final String button1Url;
    private final String button2Text;
    private final String button2Url;
    @SuppressWarnings("unused")
	private final boolean instance;

    public RichPresence(String state, String details, long startTimestamp, long endTimestamp,
			String largeImageKey, String largeImageText, String smallImageKey, String smallImageText, String partyId,
			int partySize, int partyMax, String matchSecret, String joinSecret, String spectateSecret,
			String button1Text, String button1Url, String button2Text, String button2Url, boolean instance) {
		super();
		this.state = state;
		this.details = details;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
		this.largeImageKey = largeImageKey;
		this.largeImageText = largeImageText;
		this.smallImageKey = smallImageKey;
		this.smallImageText = smallImageText;
		this.partyId = partyId;
		this.partySize = partySize;
		this.partyMax = partyMax;
		this.matchSecret = matchSecret;
		this.joinSecret = joinSecret;
		this.spectateSecret = spectateSecret;
		this.button1Text = button1Text;
		this.button1Url = button1Url;
		this.button2Text = button2Text;
		this.button2Url = button2Url;
		this.instance = instance;
	}

	/**
     * Constructs a {@link JSONObject} representing a payload to send to discord
     * to update a user's Rich Presence.
     *
     * <p>This is purely internal, and should not ever need to be called outside of
     * the library.
     *
     * @return A JSONObject payload for updating a user's Rich Presence.
     */
    public JsonObject toJson()
    {
        JsonObject value = new JsonObject();
        JsonObject party = new JsonObject();
        JsonArray buttons = new JsonArray();
        JsonObject assets = new JsonObject();
        JsonObject secrets = new JsonObject();
        JsonObject button1 = new JsonObject();
        JsonObject button2 = new JsonObject();
        JsonArray partyState = new JsonArray();
        JsonObject timestamps = new JsonObject();
        
        if(partyId != null) {
        	partyState.add(partySize);
            partyState.add(partyMax);
	        party.addProperty("id", partyId);
	        party.add("size", partyState);
	        value.add("party", party);
        }
        
        assets.addProperty("large_image", largeImageKey);
        assets.addProperty("large_text", largeImageText);
        if(smallImageKey != null && smallImageText != null) {
	        assets.addProperty("small_image", smallImageKey);
	        assets.addProperty("small_text", smallImageText);
        }
        
        if(joinSecret != null && spectateSecret != null && matchSecret != null) {
	        secrets.addProperty("join", joinSecret == null ? "" : joinSecret);
	        secrets.addProperty("spectate", spectateSecret == null ? "" : spectateSecret);
	        secrets.addProperty("match", matchSecret == null ? "" : matchSecret);
	        value.add("secrets", secrets);
        }
        
        if(button1Text != null && button1Url != null) {
	        button1.addProperty("label", button1Text);
	        button1.addProperty("url", button1Url);
	        buttons.add(button1);
        }
        
        if(button2Text != null && button2Url != null) {
	        button2.addProperty("label", button2Text);
	        button2.addProperty("url", button2Url);
	        buttons.add(button2);
        }
        if(!buttons.isEmpty()) {
        	value.add("buttons", buttons);
        }
        
        if(startTimestamp > 0) {
	        timestamps.addProperty("start", startTimestamp);
	        timestamps.addProperty("end", endTimestamp);
	        value.add("timestamps", timestamps);
        }
        
        value.addProperty("state", state);
        value.addProperty("details", details);
        value.add("assets", assets);
        return value;
    }

    /**
     * A chain builder for a {@link RichPresence} object.
     *
     * <p>An accurate description of each field and it's functions can be found
     * <a href="https://discordapp.com/developers/docs/rich-presence/how-to#updating-presence-update-presence-payload-fields">here</a>
     */
    public static class Builder
    {
        private String state;
        private String details;
        private long startTimestamp;
        private long endTimestamp;
        private String largeImageKey;
        private String largeImageText;
        private String smallImageKey;
        private String smallImageText;
        private String partyId;
        private int partySize;
        private int partyMax;
        private String matchSecret;
        private String joinSecret;
        private String spectateSecret;
        private String button1Text;
        private String button1Url;
        private String button2Text;
        private String button2Url;
        private boolean instance;

        /**
         * Builds the {@link RichPresence} from the current state of this builder.
         *
         * @return The RichPresence built.
         */
        public RichPresence build()
        {
            return new RichPresence(state, details, startTimestamp, endTimestamp, 
                    largeImageKey, largeImageText, smallImageKey, smallImageText, 
                    partyId, partySize, partyMax, matchSecret, joinSecret, 
                    spectateSecret, button1Text, button1Url, button2Text, button2Url, instance);
        }

        /**
         * Sets the state of the user's current party.
         *
         * @param state The state of the user's current party.
         *
         * @return This Builder.
         */
        public Builder setState(String state)
        {
            this.state = state;
            return this;
        }

        /**
         * Sets details of what the player is currently doing.
         *
         * @param details The details of what the player is currently doing.
         *
         * @return This Builder.
         */
        public Builder setDetails(String details)
        {
            this.details = details;
            return this;
        }

        /**
         * Sets the time that the player started a match or activity.
         *
         * @param startTimestamp The time the player started a match or activity.
         *
         * @return This Builder.
         */
        public Builder setStartTimestamp(long startTimestamp)
        {
            this.startTimestamp = startTimestamp;
            return this;
        }

        /**
         * Sets the time that the player's current activity will end.
         *
         * @param endTimestamp The time the player's activity will end.
         *
         * @return This Builder.
         */
        public Builder setEndTimestamp(long endTimestamp)
        {
            this.endTimestamp = endTimestamp;
            return this;
        }

        /**
         * Sets the key of the uploaded image for the large profile artwork, as well as
         * the text tooltip shown when a cursor hovers over it.
         *
         * <p>These can be configured in the <a href="https://discordapp.com/developers/applications/me">applications</a>
         * page on the discord website.
         *
         * @param largeImageKey A key to an image to display.
         * @param largeImageText Text displayed when a cursor hovers over the large image.
         *
         * @return This Builder.
         */
        public Builder setLargeImage(String largeImageKey, String largeImageText)
        {
            this.largeImageKey = largeImageKey;
            this.largeImageText = largeImageText;
            return this;
        }

        /**
         * Sets the key of the uploaded image for the large profile artwork.
         *
         * <p>These can be configured in the <a href="https://discordapp.com/developers/applications/me">applications</a>
         * page on the discord website.
         *
         * @param largeImageKey A key to an image to display.
         *
         * @return This Builder.
         */
        public Builder setLargeImage(String largeImageKey)
        {
            return setLargeImage(largeImageKey, null);
        }

        /**
         * Sets the key of the uploaded image for the small profile artwork, as well as
         * the text tooltip shown when a cursor hovers over it.
         *
         * <p>These can be configured in the <a href="https://discordapp.com/developers/applications/me">applications</a>
         * page on the discord website.
         *
         * @param smallImageKey A key to an image to display.
         * @param smallImageText Text displayed when a cursor hovers over the small image.
         *
         * @return This Builder.
         */
        public Builder setSmallImage(String smallImageKey, String smallImageText)
        {
            this.smallImageKey = smallImageKey;
            this.smallImageText = smallImageText;
            return this;
        }

        /**
         * Sets the key of the uploaded image for the small profile artwork.
         *
         * <p>These can be configured in the <a href="https://discordapp.com/developers/applications/me">applications</a>
         * page on the discord website.
         *
         * @param smallImageKey A key to an image to display.
         *
         * @return This Builder.
         */
        public Builder setSmallImage(String smallImageKey)
        {
            return setSmallImage(smallImageKey, null);
        }

        /**
         * Sets party configurations for a team, lobby, or other form of group.
         *
         * <p>The {@code partyId} is ID of the player's party.
         * <br>The {@code partySize} is the current size of the player's party.
         * <br>The {@code partyMax} is the maximum number of player's allowed in the party.
         *
         * @param partyId The ID of the player's party.
         * @param partySize The current size of the player's party.
         * @param partyMax The maximum number of player's allowed in the party.
         *
         * @return This Builder.
         */
        public Builder setParty(String partyId, int partySize, int partyMax)
        {
            this.partyId = partyId;
            this.partySize = partySize;
            this.partyMax = partyMax;
            return this;
        }

        /**
         * Sets the unique hashed string for Spectate and Join.
         *
         * @param matchSecret The unique hashed string for Spectate and Join.
         *
         * @return This Builder.
         */
        public Builder setMatchSecret(String matchSecret)
        {
            this.matchSecret = matchSecret;
            return this;
        }

        /**
         * Sets the unique hashed string for chat invitations and Ask to Join.
         *
         * @param joinSecret The unique hashed string for chat invitations and Ask to Join.
         *
         * @return This Builder.
         */
        public Builder setJoinSecret(String joinSecret)
        {
            this.joinSecret = joinSecret;
            return this;
        }

        /**
         * Sets the unique hashed string for Spectate button.
         *
         * @param spectateSecret The unique hashed string for Spectate button.
         *
         * @return This Builder.
         */
        public Builder setSpectateSecret(String spectateSecret)
        {
            this.spectateSecret = spectateSecret;
            return this;
        }
        
        public Builder setButton1(String text, String url) {
        	this.button1Text = text;
        	this.button1Url = url;
        	return this;
        }
        
        public Builder setButton2(String text, String url) {
        	this.button2Text = text;
        	this.button2Url = url;
        	return this;
        }

        /**
         * Marks the {@link #setMatchSecret(String) matchSecret} as a game
         * session with a specific beginning and end.
         *
         * @param instance Whether or not the {@code matchSecret} is a game
         *                 with a specific beginning and end.
         *
         * @return This Builder.
         */
        public Builder setInstance(boolean instance)
        {
            this.instance = instance;
            return this;
        }
    }
}