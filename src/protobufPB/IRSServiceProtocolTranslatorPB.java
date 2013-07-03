/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package protobufPB;

import IRS.IRS;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import generatedProtos.IRSServiceProtos.checkTaxRequestProto;
import generatedProtos.IRSServiceProtos.checkTaxResponseProto;

/**
 *
 * @author DX
 */
public class IRSServiceProtocolTranslatorPB implements IRSServiceProtocolPB{
    
    IRS irs;
    
    public IRSServiceProtocolTranslatorPB(IRS irs){
        this.irs=irs;
    }

    @Override
    public checkTaxResponseProto checkTax(RpcController controller, checkTaxRequestProto request) throws ServiceException {
        checkTaxResponseProto response=checkTaxResponseProto.newBuilder().setResultCode(0).setTax(irs.getTax(request.getID())).build();
        return response;
    }
    
}
