package com.kelvin.how2jPractice.SimpleNetworkProgram.LocalChatRoomPrototype;

public class CreateInstance2 {
	
	public static void main(String[] args){
		ChatRoomMember member2 = new ChatRoomMember();
		member2.AssignParterServerSocketPort(4000);
		member2.Setup(6000, 7000);
		
	}
}
