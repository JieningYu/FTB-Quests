package dev.ftb.mods.ftbquests.net;

import dev.ftb.mods.ftbquests.FTBQuests;
import me.shedaniel.architectury.networking.NetworkManager;
import me.shedaniel.architectury.networking.simple.BaseS2CMessage;
import me.shedaniel.architectury.networking.simple.MessageType;
import net.minecraft.network.FriendlyByteBuf;

/**
 * @author LatvianModder
 */
public class ChangeChapterGroupResponseMessage extends BaseS2CMessage {
	private final long id;
	private final long group;

	public ChangeChapterGroupResponseMessage(FriendlyByteBuf buffer) {
		id = buffer.readLong();
		group = buffer.readLong();
	}

	public ChangeChapterGroupResponseMessage(long i, long g) {
		id = i;
		group = g;
	}

	@Override
	public MessageType getType() {
		return FTBQuestsNetHandler.CHANGE_CHAPTER_GROUP_RESPONSE;
	}

	@Override
	public void write(FriendlyByteBuf buffer) {
		buffer.writeLong(id);
		buffer.writeLong(group);
	}

	@Override
	public void handle(NetworkManager.PacketContext context) {
		FTBQuests.NET_PROXY.changeChapterGroup(id, group);
	}
}