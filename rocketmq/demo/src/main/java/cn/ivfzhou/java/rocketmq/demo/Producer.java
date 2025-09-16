package cn.ivfzhou.java.rocketmq.demo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class Producer {

    public static void main(String[] args) throws InterruptedException, RemotingException, UnsupportedEncodingException, MQClientException, MQBrokerException {
        sendSync();
    }

    static void sendSync() throws MQClientException, MQBrokerException, RemotingException, InterruptedException, UnsupportedEncodingException {
        DefaultMQProducer producer = new DefaultMQProducer("default");
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        for (int i = 0; i < 5; i++) {
            Message message = new Message("topic", "tag1", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            System.out.println(result);
        }
        producer.shutdown();
    }

    static void sendAsync() throws MQClientException, RemotingException, InterruptedException, UnsupportedEncodingException {
        DefaultMQProducer producer = new DefaultMQProducer("default");
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 5; i++) {
            Message message = new Message("topic", "tag", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("SendResult:" + sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("onException:" + throwable);
                }
            });
        }
        //producer.shutdown();
    }

    static void sendOneway() throws MQClientException, RemotingException, InterruptedException, UnsupportedEncodingException {
        DefaultMQProducer producer = new DefaultMQProducer("default");
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 5; i++) {
            Message message = new Message("topic", "tag", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(message);
        }
        producer.shutdown();
    }

    static void sendOrder() throws MQClientException, RemotingException, InterruptedException, UnsupportedEncodingException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("default");
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        for (int i = 0; i < 5; i++) {
            Message message = new Message("topic", "tag", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    int index = (Integer) o;
                    return list.get(index);
                }
            }, 1);
            System.out.println(result);
        }
        producer.shutdown();
    }

    static void sendDelay() throws MQClientException, RemotingException, InterruptedException, UnsupportedEncodingException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("default");
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        for (int i = 0; i < 5; i++) {
            Message message = new Message("topic", "tag", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            message.setDelayTimeLevel(2);
            SendResult result = producer.send(message);
            System.out.println(result);
        }
        producer.shutdown();
    }

    static void sendBatch() throws MQClientException, RemotingException, InterruptedException, UnsupportedEncodingException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("default");
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        String topic = "topic";
        List<Message> msgs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Message message = new Message(topic, "tag", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            msgs.add(message);
        }
        SendResult result = producer.send(msgs);
        System.out.println(result);
        producer.shutdown();
    }

    static void sendTransaction() throws MQClientException, UnsupportedEncodingException {
        TransactionMQProducer producer = new TransactionMQProducer("default");
        producer.setTransactionListener(new TransactionListener() {
            private final ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                Integer i = (Integer) o;
                localTrans.put(message.getTransactionId(), i);
                return LocalTransactionState.UNKNOW;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                Integer status = localTrans.get(messageExt.getTransactionId());
                if (null != status) {
                    switch (status) {
                        case 0:
                            return LocalTransactionState.UNKNOW;
                        case 1:
                            return LocalTransactionState.COMMIT_MESSAGE;
                        case 2:
                            return LocalTransactionState.ROLLBACK_MESSAGE;
                        default:
                            return LocalTransactionState.COMMIT_MESSAGE;
                    }
                }
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        for (
                int i = 0;
                i < 5; i++) {
            Message message = new Message("topic", "tag", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            TransactionSendResult result = producer.sendMessageInTransaction(message, i);
            System.out.println(result);
        }
        //producer.shutdown();
    }

    static void sendUserProp() throws MQClientException, MQBrokerException, RemotingException, InterruptedException, UnsupportedEncodingException {
        DefaultMQProducer producer = new DefaultMQProducer("default");
        producer.setNamesrvAddr("192.168.14.199:19876;192.168.14.199:29876");
        producer.start();
        for (int i = 0; i < 5; i++) {
            Message message = new Message("topic", "tag", "key", ("body" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            message.putUserProperty("name", "value" + i);
            SendResult result = producer.send(message);
            System.out.println(result);
        }
        producer.shutdown();
    }

}
