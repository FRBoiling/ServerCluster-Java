 //------------------------------------------------------------------------------
 // <auto-generated>
 //     This code was generated by a tool.(The author is Boiling)
 //     Changes to this file may cause incorrect behavior and will be lost if the code is regenerated.
 // </auto-generated>
 //------------------------------------------------------------------------------
package protocol.zone.manager;
import protocol.msgId.Id;
public class Z2MIdGenerater{
     public static void GenerateId(){
          Id.getInst().SetMessage(protocol.zone.manager.Z2M.MSG_Z2M_HEARTBEAT.class, 0x430001);
     }
}