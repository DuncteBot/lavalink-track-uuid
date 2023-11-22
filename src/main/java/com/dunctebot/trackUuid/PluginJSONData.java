package com.dunctebot.trackUuid;

import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

import java.util.Map;

public record PluginJSONData(String uuid) {
    public JsonObject toJson() {
        return new JsonObject(Map.of(
                "id", JsonElementKt.JsonPrimitive(uuid))
        );
    }
}
