package relation.relation;

import core.base.common.AbstractSession;
import core.base.model.ServerTag;
import core.base.model.ServerType;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import protocol.relation.relation.R2R;
import relation.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Boiling
 * Date: 2018-05-31
 * Time: 16:14
 */
@Slf4j
public class RelationServerSession extends AbstractSession {
    RelationServerSession(Channel channel) {
        super(channel);
        ServerTag tag = new ServerTag();
        tag.setTag(ServerType.Zone, 0, 0);
        setTag(tag);
    }

    public void onConnected() {
        super.onConnected();
        sendRegister(Context.tag,Context.getListenInfoList());
    }

    public void onDisConnected() {
        super.onDisConnected();
    }

    @Override
    public void sendHeartBeat() {
    }
}
