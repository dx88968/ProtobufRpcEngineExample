/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hadoopipcmini;

import Engine.ServerObjectContainer;
import com.google.protobuf.BlockingService;
import generatedProtos.BankServiceProtos;
import generatedProtos.BankServiceProtos.BankService;
import generatedProtos.IRSServiceProtos.IRSService;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import protobufPB.BankServiceProtocolPB;
import protobufPB.BankServiceProtocolTranslatorPB;
import protobufPB.IRSServiceProtocolPB;
import protobufPB.IRSServiceProtocolTranslatorPB;

/**
 *
 * @author DX
 */
public class HadoopIPCMini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            IRSServiceProtocolTranslatorPB IRSServiceProtocolTranslator=new IRSServiceProtocolTranslatorPB(IRS.IRS.getInstance());
            BlockingService irsService=IRSService.newReflectiveBlockingService(IRSServiceProtocolTranslator);
            
            BankServiceProtocolTranslatorPB bankservicetranslatorpb=new BankServiceProtocolTranslatorPB();
            BlockingService bankservice=BankService.newReflectiveBlockingService(bankservicetranslatorpb);
            
            InetSocketAddress ip=new InetSocketAddress("0.0.0.0",9007);
            ServerObjectContainer soc=new ServerObjectContainer(ip,3,3);
            soc.registerProtocolAndImpl(IRSServiceProtocolPB.class, irsService);
            soc.registerProtocolAndImpl(BankServiceProtocolPB.class, bankservice);
            soc.enable();
        } catch (IOException ex) {
            Logger.getLogger(HadoopIPCMini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
