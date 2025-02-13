/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.network.negotiation;

import java.util.Optional;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.payload.ModdedNetworkQueryComponent;
import net.neoforged.neoforge.network.registration.PayloadRegistration;
import org.jetbrains.annotations.ApiStatus;

/**
 * Represents the input to the negotiation process for a single network payload type.
 *
 * @param id       The id of the payload type.
 * @param version  The version of the payload type.
 * @param flow     The flow of the payload type.
 * @param optional Whether the payload type is optional.
 */
@ApiStatus.Internal
public record NegotiableNetworkComponent(
        ResourceLocation id,
        String version,
        Optional<PacketFlow> flow,
        boolean optional) {
    public NegotiableNetworkComponent(PayloadRegistration<?> reg) {
        this(reg.id(), reg.version(), reg.flow(), reg.optional());
    }

    public NegotiableNetworkComponent(ModdedNetworkQueryComponent query) {
        this(query.id(), query.version(), query.flow(), query.optional());
    }
}
