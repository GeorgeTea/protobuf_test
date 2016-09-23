package com.kingdee.bos.ebservice.prototest;

import com.google.protobuf.InvalidProtocolBufferException;
import com.kingdee.bos.ebservice.prototest.UserProtos.User;
import com.kingdee.bos.ebservice.prototest.UserProtos.User.Builder;

public class UserProtosTest {

	private static byte[] encode(UserProtos.User user){
		return user.toByteArray();
	}
	
	private static User decode(byte[] body) throws InvalidProtocolBufferException{
		return User.parseFrom(body);
	}
	
	private static User createUser(){
		Builder builder = User.newBuilder();
		builder.setName("George");
		builder.setId(1234);
		builder.setEmail("g@gmail.com");
		return builder.build();
	}
	
	public static void main(String[] args) throws InvalidProtocolBufferException {
		User user = createUser();
		System.out.println("Before encode:" + user.toString());
		User user2 = decode(encode(user));
		System.out.println("After decode:" + user2.toString());
		System.out.println("Assert equal:" + user2.equals(user));
	}
	
}
