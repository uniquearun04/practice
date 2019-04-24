package com.flipkart;


/*
Part I
======

Invoices
--------
Time, Name, Amount
0, "Alice", 200
1, "Bob", 100

Messages
--------
Time, Messag
-10, "Upcoming"
0, "New"
20, "Reminder"
30, "Due"

Output
--------
-10: [Upcoming] Invoice for Alice for 200 dollars
-9: [Upcoming] Invoice for Bob for 100 dollars
0: [New] Invoice for Alice for 200 dollars
1: [New] Invoice for Bob for 100 dollars
20: [Reminder] Invoice for Alice for 200 dollars
21: [Reminder] Invoice for Bob for 100 dollars
30: [Due] Invoice for Alice for 200 dollars
31: [Due] Invoice for Bob for 100 dollars



Payments
--------
-9, "Alice", 100
1, "Alice", 50
0, "Bob", 100

Output
------
-10: [Upcoming] Invoice for Alice for 200 dollars
-9: [Upcoming] Invoice for Bob for 100 dollars
0: [New] Invoice for Alice for 100 dollars
20: [Reminder ] Invoice for Alice for 50 dollars
30: [Due] Invoice for Alice for 50 dollars

 */

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class Test {

    public static void main(String ...args) {

        Test test = new Test();
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(new Invoice(0, "Alice", 200.0));
        invoiceList.add(new Invoice(1, "Bob", 100.0));

        List<Message> messagesList = new ArrayList<>();
        messagesList.add(new Message(-10, "Upcoming"));
        messagesList.add(new Message(0, "New"));
        messagesList.add(new Message(20, "Reminder"));
        messagesList.add(new Message(30, "Due"));

        List<MailMessage> mailMessageList = test.getMailMessages(invoiceList, messagesList);
        test.print(mailMessageList);

    }

    public void print(List<MailMessage> mailMessageList)  {
        if(nonNull(mailMessageList)) {
            mailMessageList.forEach(mailMessage -> System.out.println(mailMessage.message));
        }
    }

    public List<MailMessage> getMailMessages(List<Invoice> invoiceList, List<Message> messageList) {
        List<MailMessage> mailMessageList = new ArrayList<>();

        if(nonNull(invoiceList) && nonNull(messageList)) {
            for (int i = 0; i < messageList.size(); i++) {
                Message message = messageList.get(i);

                for (int j = 0; j < invoiceList.size(); j++) {
                    Invoice invoice = invoiceList.get(j);
                    MailMessage mailMessage = new MailMessage(message, invoice);
                    mailMessageList.add(mailMessage);
                }
            }
        }
        return mailMessageList;
    }

    private static class MailMessage {
        private String message;
        public MailMessage(Message message, Invoice invoice) {
            Integer num = message.time + invoice.time;
            StringBuilder sb = new StringBuilder();
            sb.append(num).append(": ");
            sb.append("[").append(message.message).append("] ");
            sb.append("Invoice for ").append(invoice.name).append(" for ").append(invoice.amount).append(" dollars");
            this.message = sb.toString();
        }
    }

    private static class Message {

        private Integer time;
        private String message;

        public Message(Integer time, String message) {
            this.time = time;
            this.message = message;
        }

    }


    private static class Invoice {

        private Integer time;
        private String name;
        private Double amount;

        public Invoice(Integer time, String name, Double amount) {
            this.time = time;
            this.name = name;
            this.amount = amount;
        }

    }

}



