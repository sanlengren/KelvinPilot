package com.kelvin.testbase;

public class TestGitBehavior {
	
	public void testcase1(){
		//Case - 1
		//A 本地创建分支，提交了多次，但是没有push,想看本地记录。提交后，是否也能看到这些记录？
		// first do add
		// change and add again?
		// try do add 3rd time, commit the 2nd time, pull, see what would be in the log
		
		//Case - 2
		//A创建一个分支，B和A一起在这个分支上面干活？
		//Team里面可以用switch 去做checkout
		//然后我在这个branch commit
		  
//<<<<<<< HEAD
//		//Case - 3
//		//I commit in master, then there will be conflict with commit in branch, merge to expose conflict
//=======
//		//Case-3 
//		// test stash
//		
////		Case 4
//		//制造一个冲突，我再test_stash分支录入了一句话
//>>>>>>> test_stash
		
		// reproduct the conflict, fix and commit!
		
		
		// test after set rule on github, request approve/review

		// first test not sucess, expect push fail
		// maybe because I am admin and do push, escape from rule setting. rule apply to admin and try again
//I want to test pull request and merge!
		// test reject and submit again
	}
	


}
