 //------------------------------------------------------------------------------
 // <auto-generated>
 //     This code was generated by a tool.(The author is Boiling)
 //     Changes to this file may cause incorrect behavior and will be lost if the code is regenerated.
 // </auto-generated>
 //------------------------------------------------------------------------------
package protocol.zone.gate;
import protocol.msgId.Id;
public class Z2GIdGenerater{
     public static void GenerateId(){
          Id.getInst().SetMessage(protocol.zone.gate.Z2G.MSG_Z2G_HEARTBEAT.class, 0x410001);
     }
}
