package com.dunctebot.trackUuid;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import dev.arbjerg.lavalink.api.AudioPluginInfoModifier;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDPluginInfoModifier implements AudioPluginInfoModifier {
    @Nullable
    @Override
    public JsonObject modifyAudioTrackPluginInfo(@NotNull AudioTrack track) {
        if (track.getUserData() == null) {
            final var pluginData = createPluginData();

            track.setUserData(pluginData);
        }

        return track.getUserData(PluginJSONData.class).toJson();
    }

    private PluginJSONData createPluginData() {
        return new PluginJSONData(getUniqueId());
    }

    private String getUniqueId() {
        return UUID.randomUUID().toString();
    }
}
