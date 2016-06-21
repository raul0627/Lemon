package com.hexin.Dto.Proto;

/**
 * Created by Administrator on 2016/1/16.
 */
public class TestMain {
    public static void main(String[] args) {
        // 通讯录
       /* TestProto.AddressBook.Builder bookBuilder = TestProto.AddressBook.newBuilder();
        List<TestProto.Person> persons = new ArrayList<TestProto.Person>();
        for(int i=0;i<5;i++) {
            // 联系人
            TestProto.Person.Builder personBuilder = TestProto.Person.newBuilder();
            // 名字
            personBuilder.setName("xuj" + i);
            // id
            personBuilder.setId(i);
            // Email
            if (i % 2 == 0) {
                personBuilder.setEmail("xujin" + i + "@myhexin.com");
            }
            for (int j=0;j<2;j++) {
                // 电话
                TestProto.Person.PhoneNumber.Builder phoneBuilder = TestProto.Person.PhoneNumber.newBuilder();
                // 号码
                phoneBuilder.setNumber(String.valueOf(j));
                // 类型
                phoneBuilder.setType(TestProto.Person.PhoneType.WORK);
                TestProto.Person.PhoneNumber phoneNumber = phoneBuilder.build();
                personBuilder.addPhone(phoneNumber);
            }
            TestProto.Person person = personBuilder.build();
            persons.add(person);
        }
        bookBuilder.addAllPerson(persons);
        TestProto.AddressBook book = bookBuilder.build();
        byte[] bookbuf = book.toByteArray();
        System.out.println("init end------------------");
        System.out.println("read start-----------------");

        try {
            TestProto.AddressBook readerBook = TestProto.AddressBook.parseFrom(bookbuf);
            List<TestProto.Person> personList = readerBook.getPersonList();
            for (TestProto.Person personCell : personList) {
                String name = personCell.getName();
                System.out.println("name : " + name);
                int id = personCell.getId();
                System.out.println("id : " + id);
                if (personCell.getEmail() != null) {
                    System.out.println("Email : " + personCell.getEmail());
                }
                if (personCell.getPhoneList() != null) {
                    for (TestProto.Person.PhoneNumber number : personCell.getPhoneList()) {
                        String num = number.getNumber();
                        System.out.println("number : " + num);
                        String type = number.getType().name();
                        System.out.println("numberType : " + type);
                        int value = number.getType().getNumber();
                        System.out.println("value : " + value);
                    }
                }
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }*/
    }
}
