package com.wanart.core.network.codec;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import protocol.msgId.Id;
import protocol.server.client.S2C;

import java.util.List;

/**
 * 数据包编码器
 * @author boiling
 */
public class PacketEncoder extends MessageToMessageEncoder<MessageLiteOrBuilder> {
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageLiteOrBuilder msg, List out) throws Exception {
        Packet packet = new Packet();
        int msgId = Id.getInst().getMessageId(S2C.CSLoginReq.class);

        packet.setMsgId(msgId);
        if (msg instanceof MessageLite) {
            packet.msg = ((MessageLite) msg).toByteArray();
            return;
        }
        if (msg instanceof MessageLite.Builder) {
            packet.msg = ((MessageLite.Builder) msg).build().toByteArray();
        }
       out.add(packet);
    }
}