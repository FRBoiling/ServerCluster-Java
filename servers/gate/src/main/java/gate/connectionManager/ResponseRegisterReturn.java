package gate.connectionManager;

import com.google.protobuf.InvalidProtocolBufferException;
import constant.RegisterResult;
import core.base.common.AbstractSession;
import core.base.model.ServerTag;
import core.base.model.ServerType;
import core.base.sequence.IResponseHandler;
import core.network.codec.Packet;
import gate.GateService;
import gate.global.GlobalServerSessionMng;
import gate.manager.ManagerServerSessionMng;
import gate.zone.ZoneServerSessionMng;
import lombok.extern.slf4j.Slf4j;
import protocol.server.register.ServerRegister;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Boiling
 * Date: 2018-06-07
 * Time: 16:42
 */
@Slf4j
public class ResponseRegisterReturn implements IResponseHandler {
    @Override
    public void onResponse(Packet packet, AbstractSession session) throws InvalidProtocolBufferException {
        ServerRegister.MSG_Server_Register_Return msg = ServerRegister.MSG_Server_Register_Return.parseFrom(packet.getMsg());

        //注册反馈 MSG_Server_Register_Return
        ServerType serverType = ServerType.values()[msg.getTag().getServerType()];
        int areaId = msg.getTag().getAreaId();
        int subId = msg.getTag().getSubId();

        ServerTag tag = new ServerTag();
        tag.setTag(serverType, areaId, subId);
        session.setTag(tag);

        if (msg.getResult() == RegisterResult.SUCCESS.ordinal()) {
            RegisterResult registerResult = RegisterResult.FAIL;
            switch (serverType) {
                case Global:
                    registerResult = GlobalServerSessionMng.getInstance().register(session);
                    break;
                case Zone:
                    registerResult = ZoneServerSessionMng.getInstance().register(session);
                    break;
                case Manager:
                    registerResult = ManagerServerSessionMng.getInstance().register(session);
                    break;
                default:
                    break;
            }

            switch (registerResult) {
                case SUCCESS:
                    //TODO:这里添加具体注册逻辑
                    break;
                case REPEATED_REGISTER:
                case FAIL:
                default:
                    log.error("SERIOUS ERROR: get registerHandler result from {} success ,but registerHandler here fail :{} ", tag.toString(),registerResult.toString() );
                    GateService.context.stop();
                    break;
            }
        } else {
            log.error("SERIOUS ERROR: registerHandler result from {} fail :{}", tag.toString(), RegisterResult.values()[msg.getResult()]);
            switch (serverType) {
                case Global:
                case Zone:
                case Manager:
                    GateService.context.stop();
                    break;
                default:
                    break;
            }
        }
    }
}
