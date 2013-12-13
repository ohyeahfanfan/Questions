package Stack;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");
        for(int i = 0; i < components.length; i++){
            if(components[i].equals("..")){
                if(!stack.empty()) stack.pop();   
            }else if(!components[i].equals(".") && !components[i].equals("")){
                stack.push(components[i]);
            }
        }
        StringBuffer rez = new StringBuffer();
        while(!stack.empty()){
            String str = stack.pop();
            rez.insert(0, str);
            rez.insert(0, "/");
        }
        return rez.length() == 0 ? "/" : rez.toString();
    }
	public static void main(String[] args) {
		SimplifyPath test = new SimplifyPath();
		System.out.println(test.simplifyPath("/a/./b/../../c/"));
		System.out.println(test.simplifyPath("/../"));
		System.out.println(test.simplifyPath("/home//foo/"));
		
	}
}
