 package idv.steven.rv;
 
 import com.tibco.tibrv.Tibrv;
import com.tibco.tibrv.TibrvException;
import com.tibco.tibrv.TibrvListener;
import com.tibco.tibrv.TibrvMsg;
import com.tibco.tibrv.TibrvMsgCallback;
import com.tibco.tibrv.TibrvMsgField;
import com.tibco.tibrv.TibrvQueue;
import com.tibco.tibrv.TibrvRvdTransport;
import com.tibco.tibrv.TibrvTransport;
 
 public class Server implements TibrvMsgCallback {
     private TibrvTransport transport = null;
     
     private String service = null;
     private String network = null;
     private String daemon  = null;
     private String subject = null;
     
     private double server_timeout = 60;
        
     public void run(String[] args) {
         boolean eventReceived = false;
         
         int i = loadParameters(args);
         if (i > args.length-1) {
             usage();
             return;
         }
         
         try {
             Tibrv.open(Tibrv.IMPL_NATIVE);
             
             transport = new TibrvRvdTransport(service,network,daemon);
             subject = args[args.length-1];
             
             TibrvQueue queue = new TibrvQueue();
             queue.setPriority(10);
             queue.setName("MyQueue");
             queue.setLimitPolicy(TibrvQueue.DISCARD_LAST, 100, 1);
             
             new TibrvListener(queue, this, transport, subject, null);
             
             while (!eventReceived) {
                 eventReceived = queue.timedDispatch(server_timeout);
                 if (eventReceived) {
                     System.out.println("receive a message");
                 }
                 else {
                     System.out.println("timeout");
                 }
             }
         } catch (TibrvException | InterruptedException e) {
             e.printStackTrace();
         }
         finally {
             try {
                 Tibrv.close();
             } catch (TibrvException e) {
                 e.printStackTrace();
             }
         }
     }
     
     @Override
     public void onMsg(TibrvListener listener, TibrvMsg msg) {
    	 System.out.println("TibrvMsg's send subject: " + msg.getSendSubject());
    	 
         String replySubject = msg.getReplySubject();
         if (replySubject == null) {
             System.out.println("no reply subject,discard client's request");
             return;
         }
         
         System.out.println("TibrvMsg's reply subject: " + replySubject);
         System.out.println("TibrvListener's subject: " + listener.getSubject());
          
         try {
             TibrvMsgField field = msg.getField("sendData");
             String sendData = (String) field.data;
             System.out.println("sendData: " + sendData);
  
             TibrvMsg replyMsg = new TibrvMsg();
             replyMsg.setSendSubject(replySubject);
             replyMsg.update("replyData", "Nice to meet you.");
             transport.send(replyMsg);
         } catch (TibrvException e) {
             e.printStackTrace();
         }
     }
     
     int loadParameters(String[] args)
     {
         int i=0;
         while(i < args.length-1 && args[i].startsWith("-"))
         {
             if (args[i].equals("-service"))
             {
                 service = args[i+1];
                 i += 2;
             }
             else
             if (args[i].equals("-network"))
             {
                 network = args[i+1];
                 i += 2;
             }
             else
             if (args[i].equals("-daemon"))
             {
            	 daemon = args[i+1];
                 i += 2;
             }
             else
                 usage();
         }
         return i;
     }
     
     void usage()
     {
         System.err.println("Usage: java idv.steven.rv.Server [-service service] [-network network]");
         System.err.println("            [-daemon daemon] <subject>");
         System.exit(-1);
     }
 
     public static void main(String[] args) {
         new Server().run(args);
     }
 }
