import java.util.*;

class GenerateParentheses {

  public static List<String> generateValidParentheses(int num) {
    //List<String> result = new ArrayList<String>();
      boolean hasNotReachedMax = true;
      LinkedList<String> queue = new LinkedList<>();
      queue.add(0,"(");
      Map<Integer,Integer[]> openingBracketCount  = new HashMap<>();
      openingBracketCount.put(0,new Integer[] {1,0});

      while(hasNotReachedMax){
        int queueSize =queue.size();
        int tindex=queueSize;
        hasNotReachedMax = false;
          for(int i= 0 ;i<queueSize;i++){
               Integer[] count = openingBracketCount.getOrDefault(i,new Integer[]{0,0});
               if(count[0]<num){
                 String st= queue.get(i);
                 if(st.endsWith("(")){
                   //close bracket
                     System.out.println("current : "+st +" Adding : "+st+")");
                   queue.offer(st+")");
                   Integer []temp = new Integer[] {count[0],count[1]+1};
                   openingBracketCount.put(tindex++,temp);
                     queue.remove(i);
                     System.out.println("current : "+st +" Adding : "+st+"(");
                   queue.add(i,st+"(");
                   count[0]++;
                   openingBracketCount.put(i,count);
                   hasNotReachedMax = true;
                  
                 }else{
                   //open brackete
                     queue.remove(i);
                     System.out.println("current : "+st +" Adding : "+st+"(");

                     queue.add(i,st+"(");
                   count[0]++;
                     openingBracketCount.put(i,count);
                    hasNotReachedMax = true;
                 }
               }else if(count[1]<num){
                 String st= queue.remove(i);
                   System.out.println("current : "+st +" Adding : "+st+")");

                   queue.add(i,st+")");
                   count[1]++;openingBracketCount.put(i,count);
                    hasNotReachedMax = true;
               }
          }
//          System.out.println(queue);

      }
    return queue;
  }

  public static void main(String[] args) {
    List<String> result = null;//GenerateParentheses.generateValidParentheses(2);
//    System.out.println("All combinations of balanced parentheses are: " + result);

    result = GenerateParentheses.generateValidParentheses(10);
    System.out.println("All combinations of balanced parentheses are: " + result);
  }
}
