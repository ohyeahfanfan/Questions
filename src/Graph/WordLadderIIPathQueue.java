package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderIIPathQueue {

	/**
	 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

		Only one letter can be changed at a time
		Each intermediate word must exist in the dictionary
		For example,
		
		Given:
		start = "hit"
		end = "cog"
		dict = ["hot","dot","dog","lot","log"]
		
		Return
		
		  [
		    ["hit","hot","dot","dog","cog"],
		    ["hit","hot","lot","log","cog"]
		  ]
	 *  
	 *  Solution:
	 *  Compare to the WordLadder II
	 *  The queue stores the shortest paths 
	 *  from start to current level string in the dictionary
	 *  
	 *  Too slow to pass the large cases
	 *  
	 */
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Queue<ArrayList<String>> queue = new LinkedList<ArrayList<String>>();
		ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        Hashtable<String, Integer> wordShortestPath = new Hashtable<String, Integer>();
		int currentLevelSize = 1;
		ArrayList<String> list = new ArrayList<String>();
		int curDepth = 1;
		if(dict.contains(start)){
			wordShortestPath.put(end, curDepth);
		}
		list.add(start);
		queue.add(list);
		
		int shortestDepth = Integer.MAX_VALUE;
		//if current depth > shortLen, we don't need move forward.
		while(queue.size() != 0 && curDepth < shortestDepth){
			//System.out.println(queue.toString());
			curDepth++;
			while(currentLevelSize > 0){
				ArrayList<String> path = queue.poll();
				String word = path.get(path.size()-1);
                currentLevelSize--;
				ArrayList<String> neighbours = this.getNeighbours(word);
				for(String neighbour : neighbours){
					//!hey we find you
					if(neighbour.equals(end)){
						if(shortestDepth == Integer.MAX_VALUE){
							shortestDepth = curDepth;
						}
						ArrayList<String> newPath = new ArrayList<String>(path);
						newPath.add(end);
						queue.add(newPath);
					}else{
						//only put unvisited word to queue
						if(dict.contains(neighbour)){
							//either the word is not visited before or path doesn't contain it
							if(!wordShortestPath.containsKey(neighbour)||wordShortestPath.get(neighbour)==curDepth){
								wordShortestPath.put(neighbour, curDepth);
								ArrayList<String> newPath = new ArrayList<String>(path);
								newPath.add(neighbour);
								queue.add(newPath);
							}
						}
					}
				}
			}
			//current queue size will be next level size
			currentLevelSize = queue.size();
		}
		for(ArrayList<String> path : queue){
			//if the last word in the path is end, add it to paths
			if(path.get(path.size()-1).equals(end)){
				paths.add(path);
			}
		}
		return paths;
	}
	
	/*
	 * Get all possible one step transforms 
	 */
	public ArrayList<String> getNeighbours(String word){
		ArrayList<String> neighbors = new ArrayList<String>();
		char[] letters = word.toCharArray();
		for(int i = 0; i < word.length(); i++){
			char letter = letters[i];
			for(char c = 'a'; c <= 'z'; c++){
				if(c == letter) continue;
				letters[i] = c;
				neighbors.add(new String(letters));
				//!!!!
				letters[i] = letter;
			}
		}
		return neighbors;
	}
       
	public static void main(String[] args) {
		HashSet<String> dict =  new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		
		WordLadderIIPathQueue wl = new WordLadderIIPathQueue();
		//["hot","cog","dog","tot","hog","hop","pot","dot"]
		System.out.println(wl.findLadders("hot", "dog", dict));
		//"hot", "dog", ["hot","dog","dot"]
		/*HashSet<String> dict =  new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");
		WordLadderII wl = new WordLadderII();
		//["hot","cog","dog","tot","hog","hop","pot","dot"]
		System.out.println(wl.findLadders("hot", "dog", dict));*/
		//"red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]	
		/*HashSet<String> dict =  new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");
		WordLadderII wl = new WordLadderII(); 
		System.out.println(wl.findLadders("red", "tax", dict));*/
		/*String[] arr = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
		HashSet<String> dict =  new HashSet<String>();
		for(String word: arr){
			dict.add(word);
		}
		WordLadderII wl = new WordLadderII();
		ArrayList<ArrayList<String>> paths = wl.findLaddersFast("cet", "ism", dict);
		System.out.println("==========");
		System.out.println(paths);*/
	}

}
