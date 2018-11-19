package com.kelvin.how2jPractice.SimpleNetworkProgram.LocalChatRoomPrototype;

public class CreateInstance1 {
	
	public static void main(String[] args){
		ChatRoomMember member1 = new ChatRoomMember();
		
		member1.AssignParterServerSocketPort(6000);
		member1.Setup(4000, 5000);
	}
}
