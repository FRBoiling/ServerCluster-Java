 //------------------------------------------------------------------------------
 // <auto-generated>
 //     This code was generated by a tool.(The author is Boiling)
 //     Changes to this file may cause incorrect behavior and will be lost if the code is regenerated.
 // </auto-generated>
 //------------------------------------------------------------------------------
package protocol.server.client;
import protocol.msgId.Id;
public class S2CIdGenerater{
     public static void GenerateId(){
          Id.getInst().SetMessage(S2C.CSLoginInfo.class, 0x2100001);
          Id.getInst().SetMessage(S2C.CSLoginReq.class, 0x2100002);
          Id.getInst().SetMessage(S2C.CSLoginRes.class, 0x2100003);
     }
}
