/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package protobufPB;

import IRS.Bank;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import generatedProtos.BankServiceProtos.depositRequestProto;
import generatedProtos.BankServiceProtos.inquryRequestProto;
import generatedProtos.BankServiceProtos.inquryResponseProto;
import generatedProtos.BankServiceProtos.operationResponseProto;
import generatedProtos.BankServiceProtos.registerRequestProto;
import generatedProtos.BankServiceProtos.transferRequestProto;

/**
 *
 * @author DX
 */
public class BankServiceProtocolTranslatorPB implements BankServiceProtocolPB{

    @Override
    public operationResponseProto register(RpcController controller, registerRequestProto request) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public operationResponseProto deposit(RpcController controller, depositRequestProto request) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public operationResponseProto transfer(RpcController controller, transferRequestProto request) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public inquryResponseProto inqury(RpcController controller, inquryRequestProto request) throws ServiceException {
        Bank bank=(Bank) new Object();
        long check=bank.getCheckAccountAmount(request.getId());
        long deposit=bank.getDepositAccountAmount(request.getId());
        inquryResponseProto response=inquryResponseProto.newBuilder().setCheckAccount(check).setId(request.getId()).setDepositAccount(deposit).build();
        /*while(true){
            if(request.getId()>100000) {
                break;
            }
            //System.out.println("Still running~~~~");
        }*/
        return response;
    }
    
}
